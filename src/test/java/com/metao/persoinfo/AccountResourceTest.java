package com.metao.persoinfo;

import com.metao.persoinfo.controller.AccountController;
import com.metao.persoinfo.dto.ManagedUserDTO;
import com.metao.persoinfo.dto.PasswordChangeDTO;
import com.metao.persoinfo.dto.UserDTO;
import com.metao.persoinfo.entity.Authority;
import com.metao.persoinfo.entity.UserEntity;
import com.metao.persoinfo.repository.AuthorityRepository;
import com.metao.persoinfo.repository.UserRepository;
import com.metao.persoinfo.service.impl.UserService;
import com.metao.persoinfo.util.AuthoritiesConstants;
import com.metao.persoinfo.util.Constants;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link AccountController} REST controller.
 */
@SpringBootTest
@AutoConfigureMockMvc
@Ignore
public class AccountResourceTest {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private AuthorityRepository authorityRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Mock
  private UserService mockUserService;


  @Autowired
  private MockMvc restMvc;

  @Test
  public void testNonAuthenticatedUser() throws Exception {
    restMvc.perform(get("/api/authenticate")
      .accept(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk())
      .andExpect(content().string(""));
  }

  @Test
  public void testAuthenticatedUser() throws Exception {
    restMvc.perform(get("/api/authenticate")
      .with(request -> {
        request.setRemoteUser("test");
        return request;
      })
      .accept(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk())
      .andExpect(content().string("test"));
  }

  @Test
  public void testGetExistingAccount() throws Exception {
    Set<Authority> authorities = new HashSet<>();
    Authority authority = new Authority();
    authority.setName(AuthoritiesConstants.ADMIN);
    authorities.add(authority);

    UserEntity userEntity = new UserEntity();

    userEntity.setName("test");
    userEntity.setEmail("john.doe@jhipster.com");
    userEntity.setImageUrl("http://placehold.it/50x50");
    userEntity.setLangKey("en");
    userEntity.setAuthorities(authorities);
    when(mockUserService.getUserWithAuthorities()).thenReturn(Optional.of(userEntity));

    restMvc.perform(get("/api/account")
      .accept(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk())
      .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
      .andExpect(jsonPath("$.name").value("test"))
      .andExpect(jsonPath("$.email").value("john.doe@jhipster.com"))
      .andExpect(jsonPath("$.imageUrl").value("http://placehold.it/50x50"))
      .andExpect(jsonPath("$.langKey").value("en"))
      .andExpect(jsonPath("$.authorities").value(AuthoritiesConstants.ADMIN));
  }

  @Test
  public void testGetUnknownAccount() throws Exception {
    when(mockUserService.getUserWithAuthorities()).thenReturn(Optional.empty());
    restMvc.perform(get("/api/account")
      .accept(MediaType.APPLICATION_PROBLEM_JSON))
      .andExpect(status().isNotFound());
  }

  @Test
  @Transactional
  public void testRegisterValid() throws Exception {
    ManagedUserDTO validUser = new ManagedUserDTO();
    validUser.setName("test-register-valid");
    validUser.setId(10000L);
    validUser.setPassword("password");
    validUser.setEmail("test-register-valid@example.com");
    validUser.setImageUrl("http://placehold.it/50x50");
    validUser.setLangKey(Constants.DEFAULT_LANGUAGE);
    validUser.setAuthorities(Collections.singleton(AuthoritiesConstants.USER));
    assertThat(userRepository.findOneByEmail("test-register-valid@example.com").isPresent()).isFalse();

    restMvc.perform(
      post("/api/register")
        .contentType(TestUtil.APPLICATION_JSON_UTF8)
        .content(TestUtil.convertObjectToJsonBytes(validUser)))
      .andExpect(status().isCreated());

    assertThat(userRepository.findOneByEmail(validUser.getEmail()).isPresent()).isTrue();
  }

  @Test
  @Transactional
  public void testRegisterInvalidLogin() throws Exception {
    ManagedUserDTO invalidUser = new ManagedUserDTO();
    invalidUser.setName("funky-log!n");
    invalidUser.setPassword("password");

    invalidUser.setEmail("!funky");// <-- invalid
    invalidUser.setActivated(true);
    invalidUser.setImageUrl("http://placehold.it/50x50");
    invalidUser.setLangKey(Constants.DEFAULT_LANGUAGE);
    invalidUser.setAuthorities(Collections.singleton(AuthoritiesConstants.USER));

    restMvc.perform(
      post("/api/register")
        .contentType(TestUtil.APPLICATION_JSON_UTF8)
        .content(TestUtil.convertObjectToJsonBytes(invalidUser)))
      .andExpect(status().isBadRequest());

    Optional<UserEntity> user = userRepository.findOneByEmailIgnoreCase("funky@example.com");
    assertThat(user.isPresent()).isFalse();
  }

  @Test
  @Transactional
  public void testRegisterInvalidEmail() throws Exception {
    ManagedUserDTO invalidUser = new ManagedUserDTO();
    invalidUser.setName("bob");

    invalidUser.setPassword("password");
    invalidUser.setEmail("invalid");// <-- invalid
    invalidUser.setActivated(true);
    invalidUser.setImageUrl("http://placehold.it/50x50");
    invalidUser.setLangKey(Constants.DEFAULT_LANGUAGE);
    invalidUser.setAuthorities(Collections.singleton(AuthoritiesConstants.USER));

    restMvc.perform(
      post("/api/register")
        .contentType(TestUtil.APPLICATION_JSON_UTF8)
        .content(TestUtil.convertObjectToJsonBytes(invalidUser)))
      .andExpect(status().isBadRequest());

    Optional<UserEntity> user = userRepository.findOneByEmail("invalid");
    assertThat(user.isPresent()).isFalse();
  }

  @Test
  @Transactional
  public void testRegisterInvalidPassword() throws Exception {
    ManagedUserDTO invalidUser = new ManagedUserDTO();
    invalidUser.setName("bob");

    invalidUser.setPassword("123");// password with only 3 digits
    invalidUser.setEmail("bob@example.com");
    invalidUser.setActivated(true);
    invalidUser.setImageUrl("http://placehold.it/50x50");
    invalidUser.setLangKey(Constants.DEFAULT_LANGUAGE);
    invalidUser.setAuthorities(Collections.singleton(AuthoritiesConstants.USER));

    restMvc.perform(
      post("/api/register")
        .contentType(TestUtil.APPLICATION_JSON_UTF8)
        .content(TestUtil.convertObjectToJsonBytes(invalidUser)))
      .andExpect(status().isBadRequest());

    Optional<UserEntity> user = userRepository.findOneByEmail("bob@example.com");
    assertThat(user.isPresent()).isFalse();
  }

  @Test
  @Transactional
  public void testRegisterNullPassword() throws Exception {
    ManagedUserDTO invalidUser = new ManagedUserDTO();

    invalidUser.setName("bob");
    invalidUser.setPassword(null);// invalid null password
    invalidUser.setEmail("bob@example.com");
    invalidUser.setActivated(true);
    invalidUser.setImageUrl("http://placehold.it/50x50");
    invalidUser.setLangKey(Constants.DEFAULT_LANGUAGE);
    invalidUser.setAuthorities(Collections.singleton(AuthoritiesConstants.USER));

    restMvc.perform(
      post("/api/register")
        .contentType(TestUtil.APPLICATION_JSON_UTF8)
        .content(TestUtil.convertObjectToJsonBytes(invalidUser)))
      .andExpect(status().isUnauthorized());

    Optional<UserEntity> user = userRepository.findOneByEmail("bob@example.com");
    assertThat(user.isPresent()).isFalse();
  }

  @Test
  @Transactional
  public void testRegisterDuplicateLogin() throws Exception {
    // First registration
    ManagedUserDTO firstUser = new ManagedUserDTO();
    firstUser.setName("alice");

    firstUser.setPassword("password");
    firstUser.setEmail("alice@example.com");
    firstUser.setImageUrl("http://placehold.it/50x50");
    firstUser.setLangKey(Constants.DEFAULT_LANGUAGE);
    firstUser.setAuthorities(Collections.singleton(AuthoritiesConstants.USER));

    // Duplicate login, different email
    ManagedUserDTO secondUser = new ManagedUserDTO();
    secondUser.setName(firstUser.getName());
    secondUser.setPassword(firstUser.getPassword());
    secondUser.setEmail("alice2@example.com");
    secondUser.setImageUrl(firstUser.getImageUrl());
    secondUser.setLangKey(firstUser.getLangKey());
    secondUser.setCreatedDate(firstUser.getCreatedDate());
    secondUser.setLastModifiedBy(firstUser.getLastModifiedBy());
    secondUser.setLastModifiedDate(firstUser.getLastModifiedDate());
    secondUser.setAuthorities(new HashSet<>(firstUser.getAuthorities()));

    // First user
    restMvc.perform(
      post("/api/register")
        .contentType(TestUtil.APPLICATION_JSON_UTF8)
        .content(TestUtil.convertObjectToJsonBytes(firstUser)))
      .andExpect(status().isCreated());

    // Second (non activated) user
    restMvc.perform(
      post("/api/register")
        .contentType(TestUtil.APPLICATION_JSON_UTF8)
        .content(TestUtil.convertObjectToJsonBytes(secondUser)))
      .andExpect(status().isCreated());

    Optional<UserEntity> testUser = userRepository.findOneByEmailIgnoreCase("alice2@example.com");
    assertThat(testUser.isPresent()).isTrue();
    testUser.get().setActivated(true);
    userRepository.save(testUser.get());

    // Second (already activated) user
    restMvc.perform(
      post("/api/register")
        .contentType(TestUtil.APPLICATION_JSON_UTF8)
        .content(TestUtil.convertObjectToJsonBytes(secondUser)))
      .andExpect(status().is4xxClientError());
  }

  @Test
  @Transactional
  public void testRegisterDuplicateEmail() throws Exception {
    // First user
    ManagedUserDTO firstUser = new ManagedUserDTO();
    firstUser.setName("test-register-duplicate-email");

    firstUser.setPassword("password");
    firstUser.setEmail("test-register-duplicate-email@example.com");
    firstUser.setImageUrl("http://placehold.it/50x50");
    firstUser.setLangKey(Constants.DEFAULT_LANGUAGE);
    firstUser.setAuthorities(Collections.singleton(AuthoritiesConstants.USER));

    // Register first user
    restMvc.perform(
      post("/api/register")
        .contentType(TestUtil.APPLICATION_JSON_UTF8)
        .content(TestUtil.convertObjectToJsonBytes(firstUser)))
      .andExpect(status().isCreated());

    Optional<UserEntity> testUser1 = userRepository.findOneByEmail("test-register-duplicate-email@example.com");
    assertThat(testUser1.isPresent()).isTrue();

    // Duplicate email, different login
    ManagedUserDTO secondUser = new ManagedUserDTO();
    secondUser.setName("test-register-duplicate-email-2");
    secondUser.setPassword(firstUser.getPassword());
    secondUser.setEmail(firstUser.getEmail());
    secondUser.setImageUrl(firstUser.getImageUrl());
    secondUser.setLangKey(firstUser.getLangKey());
    secondUser.setAuthorities(new HashSet<>(firstUser.getAuthorities()));

    // Register second (non activated) user
    restMvc.perform(
      post("/api/register")
        .contentType(TestUtil.APPLICATION_JSON_UTF8)
        .content(TestUtil.convertObjectToJsonBytes(secondUser)))
      .andExpect(status().isBadRequest());

    /*Optional<User> testUser2 = userRepository.findOneByEmail(firstUser.getEmail());
    assertThat(testUser2.isPresent()).isFalse();

    Optional<User> testUser3 = userRepository.findOneByEmail(firstUser.getEmail());
    assertThat(testUser3.isPresent()).isTrue();

    // Duplicate email - with uppercase email address
    ManagedUserDTO userWithUpperCaseEmail = new ManagedUserDTO();
    userWithUpperCaseEmail.setId(firstUser.getId());
    userWithUpperCaseEmail.setName("test-register-duplicate-email-3");
    userWithUpperCaseEmail.setPassword(firstUser.getPassword());
    userWithUpperCaseEmail.setEmail("TEST-register-duplicate-email@example.com");
    userWithUpperCaseEmail.setImageUrl(firstUser.getImageUrl());
    userWithUpperCaseEmail.setLangKey(firstUser.getLangKey());
    userWithUpperCaseEmail.setAuthorities(new HashSet<>(firstUser.getAuthorities()));

    // Register third (not activated) user
    restMvc.perform(
      post("/api/register")
        .contentType(TestUtil.APPLICATION_JSON_UTF8)
        .content(TestUtil.convertObjectToJsonBytes(userWithUpperCaseEmail)))
      .andExpect(status().isCreated());

    Optional<User> testUser4 = userRepository.findOneByEmail("TEST-register-duplicate-email@example.com");
    assertThat(testUser4.isPresent());
    assertThat(testUser4.isPresent()).isTrue();
    assertThat(testUser4.get().getEmail()).isEqualTo("test-register-duplicate-email@example.com");

    testUser4.get().setActivated(true);
    userService.updateUser((new UserDTO(testUser4.get())));

    // Register 4th (already activated) user
    restMvc.perform(
      post("/api/register")
        .contentType(TestUtil.APPLICATION_JSON_UTF8)
        .content(TestUtil.convertObjectToJsonBytes(secondUser)))
      .andExpect(status().is4xxClientError());*/
  }

  @Test
  @Transactional
  public void testRegisterAdminIsIgnored() throws Exception {
    ManagedUserDTO validUser = new ManagedUserDTO();

    validUser.setName("badguy");
    validUser.setPassword("password");
    validUser.setEmail("badguy@example.com");
    validUser.setActivated(true);
    validUser.setImageUrl("http://placehold.it/50x50");
    validUser.setLangKey(Constants.DEFAULT_LANGUAGE);
    validUser.setAuthorities(Collections.singleton(AuthoritiesConstants.ADMIN));

    restMvc.perform(
      post("/api/register")
        .contentType(TestUtil.APPLICATION_JSON_UTF8)
        .content(TestUtil.convertObjectToJsonBytes(validUser)))
      .andExpect(status().isCreated());

    Optional<UserEntity> userDup = userRepository.findOneByEmail("badguy@example.com");
    assertThat(userDup.isPresent()).isTrue();
    assertThat(userDup.get().getAuthorities()).hasSize(1)
      .containsExactly(authorityRepository.findById(AuthoritiesConstants.USER).get());
  }
/*
  @Test
  @Transactional
  public void testActivateAccount() throws Exception {
    final String activationKey = "some activation key";
    User user = new User();
    user.setName("activate-account");

    user.setEmail("activate-account@example.com");
    user.setPassword(RandomStringUtils.random(60));
    user.setActivated(false);
    user.setActivationKey(activationKey);

    userRepository.saveAndFlush(user);

    restMvc.perform(get("/api/activate?key={activationKey}", activationKey))
      .andExpect(status().isOk());

    user = userRepository.findOneByEmail(user.getEmail()).orElse(null);
    assertThat(user.getActivated()).isTrue();
  }*/

 /* @Test
  @Transactional
  public void testActivateAccountWithWrongKey() throws Exception {
    restMvc.perform(get("/api/activate?key=wrongActivationKey"))
      .andExpect(status().isInternalServerError());
  }*/

  /*@Test
  @Transactional
  public void testSaveAccount() throws Exception {
    User user = new User();

    user.setName("save-account");
    user.setEmail("save-account@example.com");
    user.setPassword(RandomStringUtils.random(60));
    user.setActivated(true);

    userRepository.saveAndFlush(user);

    UserDTO userDTO = new UserDTO();
    userDTO.setName("not-used");
    userDTO.setEmail("save-account@example.com");
    userDTO.setActivated(false);
    userDTO.setImageUrl("http://placehold.it/50x50");
    userDTO.setLangKey(Constants.DEFAULT_LANGUAGE);
    userDTO.setAuthorities(Collections.singleton(AuthoritiesConstants.ADMIN));

    restMvc.perform(post("/api/account")
        .contentType(TestUtil.APPLICATION_JSON_UTF8)
        .content(TestUtil.convertObjectToJsonBytes(userDTO)))
      .andExpect(status().isOk());

    User updatedUser = userRepository.findOneByEmail(user.getEmail()).orElse(null);
    assertThat(updatedUser.getEmail()).isEqualTo(userDTO.getEmail());
    assertThat(updatedUser.getLangKey()).isEqualTo(userDTO.getLangKey());
    assertThat(updatedUser.getPassword()).isEqualTo(user.getPassword());
    assertThat(updatedUser.getImageUrl()).isEqualTo(userDTO.getImageUrl());
    assertThat(updatedUser.getActivated()).isEqualTo(true);
    assertThat(updatedUser.getAuthorities()).isEmpty();
  }
*/
  @Test
  @Transactional
  public void testSaveInvalidEmail() throws Exception {
    UserEntity userEntity = new UserEntity();

    userEntity.setEmail("save-invalid-email");
    userEntity.setEmail("save-invalid-email@example.com");
    userEntity.setPassword(RandomStringUtils.random(60));
    userEntity.setActivated(true);

    userRepository.saveAndFlush(userEntity);

    UserDTO userDTO = new UserDTO();
    userDTO.setEmail("not-used");
    userDTO.setEmail("invalid email");
    userDTO.setActivated(false);
    userDTO.setImageUrl("http://placehold.it/50x50");
    userDTO.setLangKey(Constants.DEFAULT_LANGUAGE);
    userDTO.setAuthorities(Collections.singleton(AuthoritiesConstants.ADMIN));

    restMvc.perform(
      post("/api/account")
        .contentType(TestUtil.APPLICATION_JSON_UTF8)
        .content(TestUtil.convertObjectToJsonBytes(userDTO)))
      .andExpect(status().isBadRequest());

    assertThat(userRepository.findOneByEmailIgnoreCase("invalid email")).isNotPresent();
  }

  @Test
  @Transactional
  public void testSaveExistingEmail() throws Exception {
    UserEntity userEntity = new UserEntity();

    userEntity.setName("save-existing-email");
    userEntity.setEmail("save-existing-email@example.com");
    userEntity.setPassword(RandomStringUtils.random(60));
    userEntity.setActivated(true);

    userRepository.saveAndFlush(userEntity);

    UserEntity anotherUserEntity = new UserEntity();

    anotherUserEntity.setName("save-existing-email2");
    anotherUserEntity.setEmail("save-existing-email2@example.com");
    anotherUserEntity.setPassword(RandomStringUtils.random(60));
    anotherUserEntity.setActivated(true);

    userRepository.saveAndFlush(anotherUserEntity);

    UserDTO userDTO = new UserDTO();

    userDTO.setName("not-used");
    userDTO.setEmail("save-existing-email2@example.com");
    userDTO.setActivated(false);
    userDTO.setImageUrl("http://placehold.it/50x50");
    userDTO.setLangKey(Constants.DEFAULT_LANGUAGE);
    userDTO.setAuthorities(Collections.singleton(AuthoritiesConstants.ADMIN));

    restMvc.perform(post("/api/account")
      .contentType(TestUtil.APPLICATION_JSON_UTF8)
      .content(TestUtil.convertObjectToJsonBytes(userDTO)))
      .andExpect(status().isOk());

    UserEntity updatedUserEntity = userRepository.findOneByEmail("save-existing-email@example.com").orElse(null);
    assertThat(updatedUserEntity.getEmail()).isEqualTo("save-existing-email@example.com");
  }

  @Test
  @Transactional
  public void testSaveExistingEmailAndLogin() throws Exception {
    UserEntity userEntity = new UserEntity();

    userEntity.setName("save-existing-email-and-login");
    userEntity.setEmail("save-existing-email-and-login@example.com");
    userEntity.setPassword(RandomStringUtils.random(60));
    userEntity.setActivated(true);

    userRepository.saveAndFlush(userEntity);

    UserDTO userDTO = new UserDTO();
    userDTO.setEmail("not-used");

    userDTO.setEmail("save-existing-email-and-login@example.com");
    userDTO.setActivated(false);
    userDTO.setImageUrl("http://placehold.it/50x50");
    userDTO.setLangKey(Constants.DEFAULT_LANGUAGE);
    userDTO.setAuthorities(Collections.singleton(AuthoritiesConstants.ADMIN));

    restMvc.perform(
      post("/api/account")
        .contentType(TestUtil.APPLICATION_JSON_UTF8)
        .content(TestUtil.convertObjectToJsonBytes(userDTO)))
      .andExpect(status().isOk());

    UserEntity updatedUserEntity = userRepository.findOneByEmail("save-existing-email-and-login@example.com").orElse(null);
    assertThat(updatedUserEntity.getEmail()).isEqualTo("save-existing-email-and-login@example.com");
  }

  @Test
  @Transactional
  public void testChangePasswordWrongExistingPassword() throws Exception {
    UserEntity userEntity = new UserEntity();
    String currentPassword = RandomStringUtils.random(60);
    userEntity.setPassword(passwordEncoder.encode(currentPassword));

    userEntity.setName("change-password-wrong-existing-password");
    userEntity.setEmail("change-password-wrong-existing-password@example.com");
    userRepository.saveAndFlush(userEntity);

    restMvc.perform(post("/api/account/change-password")
      .contentType(TestUtil.APPLICATION_JSON_UTF8)
      .content(TestUtil.convertObjectToJsonBytes(new PasswordChangeDTO("1" + currentPassword, "new password"))))
      .andExpect(status().isBadRequest());

    UserEntity updatedUserEntity = userRepository.findOneByEmail("change-password-wrong-existing-password@example.com").orElse(null);
    assertThat(passwordEncoder.matches("new password", updatedUserEntity.getPassword())).isFalse();
    assertThat(passwordEncoder.matches(currentPassword, updatedUserEntity.getPassword())).isTrue();
  }

  @Test
  @Transactional
  public void testChangePassword() throws Exception {
    UserEntity userEntity = new UserEntity();
    String currentPassword = RandomStringUtils.random(60);
    userEntity.setPassword(passwordEncoder.encode(currentPassword));

    userEntity.setName("change-password");
    userEntity.setEmail("change-password@example.com");
    userRepository.saveAndFlush(userEntity);

    restMvc.perform(post("/api/account/change-password")
      .contentType(TestUtil.APPLICATION_JSON_UTF8)
      .content(TestUtil.convertObjectToJsonBytes(new PasswordChangeDTO(currentPassword, "new password"))))
      .andExpect(status().isOk());

    UserEntity updatedUserEntity = userRepository.findOneByEmail("change-password@example.com").orElse(null);
    assertThat(passwordEncoder.matches("new password", updatedUserEntity.getPassword())).isTrue();
  }

  @Test
  @Transactional
  public void testChangePasswordTooSmall() throws Exception {
    UserEntity userEntity = new UserEntity();
    String currentPassword = RandomStringUtils.random(60);
    userEntity.setPassword(passwordEncoder.encode(currentPassword));

    userEntity.setName("change-password-too-small");
    userEntity.setEmail("change-password-too-small@example.com");
    userRepository.saveAndFlush(userEntity);

    String newPassword = RandomStringUtils.random(ManagedUserDTO.PASSWORD_MIN_LENGTH);

    restMvc.perform(post("/api/account/change-password")
      .contentType(TestUtil.APPLICATION_JSON_UTF8)
      .content(TestUtil.convertObjectToJsonBytes(new PasswordChangeDTO(currentPassword, newPassword))))
      .andExpect(status().isBadRequest());

    UserEntity updatedUserEntity = userRepository.findOneByEmail("change-password-too-small@example.com").orElse(null);
    assertThat(updatedUserEntity.getPassword()).isEqualTo(userEntity.getPassword());
  }

  @Test
  @Transactional
  public void testChangePasswordTooLong() throws Exception {
    UserEntity userEntity = new UserEntity();
    String currentPassword = RandomStringUtils.random(60);
    userEntity.setPassword(passwordEncoder.encode(currentPassword));

    userEntity.setName("change-password-too-long");
    userEntity.setEmail("change-password-too-long@example.com");
    userRepository.saveAndFlush(userEntity);

    String newPassword = RandomStringUtils.random(ManagedUserDTO.PASSWORD_MAX_LENGTH + 1);

    restMvc.perform(post("/api/account/change-password")
      .contentType(TestUtil.APPLICATION_JSON_UTF8)
      .content(TestUtil.convertObjectToJsonBytes(new PasswordChangeDTO(currentPassword, newPassword))))
      .andExpect(status().isBadRequest());

    UserEntity updatedUserEntity = userRepository.findOneByEmail("change-password-too-long@example.com").orElse(null);
    assertThat(updatedUserEntity.getPassword()).isEqualTo(userEntity.getPassword());
  }

  @Test
  @Transactional
  public void testChangePasswordEmpty() throws Exception {
    UserEntity userEntity = new UserEntity();
    String currentPassword = RandomStringUtils.random(60);
    userEntity.setPassword(passwordEncoder.encode(currentPassword));

    userEntity.setName("change-password-empty");
    userEntity.setEmail("change-password-empty@example.com");
    userRepository.saveAndFlush(userEntity);

    restMvc.perform(post("/api/account/change-password")
      .contentType(TestUtil.APPLICATION_JSON_UTF8)
      .content(TestUtil.convertObjectToJsonBytes(new PasswordChangeDTO(currentPassword, ""))))
      .andExpect(status().isBadRequest());

    UserEntity updatedUserEntity = userRepository.findOneByEmail("change-password-empty@example.com").orElse(null);
    assertThat(updatedUserEntity.getPassword()).isEqualTo(userEntity.getPassword());
  }

 /* @Test
  @Transactional
  public void testRequestPasswordReset() throws Exception {
    User user = new User();
    user.setPassword(RandomStringUtils.random(60));
    user.setActivated(true);

    user.setName("password-reset");
    user.setEmail("password-reset@example.com");
    userRepository.saveAndFlush(user);

    restMvc.perform(post("/api/account/reset-password/init")
      .content("password-reset@example.com"))
      .andExpect(status().isOk());
  }

  @Test
  @Transactional
  public void testRequestPasswordResetUpperCaseEmail() throws Exception {
    User user = new User();
    user.setPassword(RandomStringUtils.random(60));
    user.setActivated(true);

    user.setName("password-reset");
    user.setEmail("password-reset@example.com");
    userRepository.saveAndFlush(user);

    restMvc.perform(post("/api/account/reset-password/init")
      .content("password-reset@EXAMPLE.COM"))
      .andExpect(status().isOk());
  }

  @Test
  public void testRequestPasswordResetWrongEmail() throws Exception {
    restMvc.perform(
      post("/api/account/reset-password/init")
        .content("password-reset-wrong-email@example.com"))
      .andExpect(status().isBadRequest());
  }

  @Test
  @Transactional
  public void testFinishPasswordReset() throws Exception {
    User user = new User();

    user.setPassword(RandomStringUtils.random(60));
    user.setName("finish-password-reset");
    user.setEmail("finish-password-reset@example.com");
    user.setResetDate(Instant.now().plusSeconds(60));
    user.setResetKey("reset key");
    userRepository.saveAndFlush(user);

    KeyAndPasswordDTO keyAndPassword = new KeyAndPasswordDTO();
    keyAndPassword.setKey(user.getResetKey());
    keyAndPassword.setNewPassword("new password");

    restMvc.perform(
      post("/api/account/reset-password/finish")
        .contentType(TestUtil.APPLICATION_JSON_UTF8)
        .content(TestUtil.convertObjectToJsonBytes(keyAndPassword)))
      .andExpect(status().isOk());

    User updatedUser = userRepository.findOneByEmail(user.getEmail()).orElse(null);
    assertThat(passwordEncoder.matches(keyAndPassword.getNewPassword(), updatedUser.getPassword())).isTrue();
  }

  @Test
  @Transactional
  public void testFinishPasswordResetTooSmall() throws Exception {
    User user = new User();

    user.setPassword(RandomStringUtils.random(60));
    user.setName("finish-password-reset-too-small");
    user.setEmail("finish-password-reset-too-small@example.com");
    user.setResetDate(Instant.now().plusSeconds(60));
    user.setResetKey("reset key too small");
    userRepository.saveAndFlush(user);

    KeyAndPasswordDTO keyAndPassword = new KeyAndPasswordDTO();
    keyAndPassword.setKey(user.getResetKey());
    keyAndPassword.setNewPassword("foo");

    restMvc.perform(
      post("/api/account/reset-password/finish")
        .contentType(TestUtil.APPLICATION_JSON_UTF8)
        .content(TestUtil.convertObjectToJsonBytes(keyAndPassword)))
      .andExpect(status().isBadRequest());

    User updatedUser = userRepository.findOneByEmail(user.getEmail()).orElse(null);
    assertThat(passwordEncoder.matches(keyAndPassword.getNewPassword(), updatedUser.getPassword())).isFalse();
  }


  @Test
  @Transactional
  public void testFinishPasswordResetWrongKey() throws Exception {
    KeyAndPasswordDTO keyAndPassword = new KeyAndPasswordDTO();
    keyAndPassword.setKey("wrong reset key");
    keyAndPassword.setNewPassword("new password");

    restMvc.perform(
      post("/api/account/reset-password/finish")
        .contentType(TestUtil.APPLICATION_JSON_UTF8)
        .content(TestUtil.convertObjectToJsonBytes(keyAndPassword)))
      .andExpect(status().isInternalServerError());
  }*/
}
