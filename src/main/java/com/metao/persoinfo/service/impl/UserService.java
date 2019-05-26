package com.metao.persoinfo.service.impl;

import com.metao.persoinfo.dto.UserDTO;
import com.metao.persoinfo.entity.Authority;
import com.metao.persoinfo.entity.User;
import com.metao.persoinfo.exception.InvalidPasswordException;
import com.metao.persoinfo.exception.LoginAlreadyUsedException;
import com.metao.persoinfo.repository.AuthorityRepository;
import com.metao.persoinfo.repository.UserRepository;
import com.metao.persoinfo.util.AuthoritiesConstants;
import com.metao.persoinfo.util.Constants;
import com.metao.persoinfo.util.RandomUtil;
import com.metao.persoinfo.util.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.CacheManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Service class for managing users.
 */
@Service
@Transactional
public class UserService {

  private final Logger log = LoggerFactory.getLogger(UserService.class);

  private final UserRepository userRepository;

  private final PasswordEncoder passwordEncoder;

  private final AuthorityRepository authorityRepository;

  private final CacheManager cacheManager;

  public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthorityRepository authorityRepository, CacheManager cacheManager) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
    this.authorityRepository = authorityRepository;
    this.cacheManager = cacheManager;
  }

  public Optional<User> activateRegistration(String key) {
    log.debug("Activating user for activation key {}", key);
    return userRepository.findOneByActivationKey(key)
      .map(user -> {
        // activate given user for the registration key.
        user.setActivated(true);
        user.setActivationKey(null);
        this.clearUserCaches(user);
        log.debug("Activated user: {}", user);
        return user;
      });
  }

  public Optional<User> completePasswordReset(String newPassword, String key) {
    log.debug("Reset user password for reset key {}", key);
    return userRepository.findOneByResetKey(key)
      .filter(user -> user.getResetDate().isAfter(Instant.now().minusSeconds(86400)))
      .map(user -> {
        user.setPassword(passwordEncoder.encode(newPassword));
        user.setResetKey(null);
        user.setResetDate(null);
        this.clearUserCaches(user);
        return user;
      });
  }

  public Optional<User> requestPasswordReset(String mail) {
    return userRepository.findOneByEmailIgnoreCase(mail)
      .filter(User::getActivated)
      .map(user -> {
        user.setResetKey(RandomUtil.generateResetKey());
        user.setResetDate(Instant.now());
        this.clearUserCaches(user);
        return user;
      });
  }

  public User registerUser(UserDTO userDTO, String password) {
    userRepository.findOneByEmailIgnoreCase(userDTO.getEmail().toLowerCase()).ifPresent(existingUser -> {
      throw new LoginAlreadyUsedException();
    });
    User newUser = new User();
    String encryptedPassword = passwordEncoder.encode(password);
    newUser.setEmail(userDTO.getEmail().toLowerCase());
    // new user gets initially a generated password
    newUser.setPassword(encryptedPassword);
    newUser.setName(userDTO.getName());
    newUser.setImageUrl(userDTO.getImageUrl());
    newUser.setLangKey(userDTO.getLangKey());
    // new user is not active
    newUser.setActivated(false);
    // new user gets registration key
    newUser.setActivationKey(RandomUtil.generateActivationKey());
    Set<Authority> authorities = new HashSet<>();
    authorityRepository.findById(AuthoritiesConstants.USER).ifPresent(authorities::add);
    newUser.setAuthorities(authorities);
    userRepository.save(newUser);
    this.clearUserCaches(newUser);
    log.debug("Created Information for User: {}", newUser);
    return newUser;
  }

  private boolean removeNonActivatedUser(User existingUser) {
    if (existingUser.getActivated()) {
      return false;
    }
    userRepository.delete(existingUser);
    userRepository.flush();
    this.clearUserCaches(existingUser);
    return true;
  }

  public User createUser(UserDTO userDTO) {
    User user = new User();

    user.setEmail(userDTO.getEmail().toLowerCase());
    user.setName(userDTO.getName());
    user.setEmail(userDTO.getEmail().toLowerCase());
    user.setImageUrl(userDTO.getImageUrl());
    if (userDTO.getLangKey() == null) {
      user.setLangKey(Constants.DEFAULT_LANGUAGE); // default language
    } else {
      user.setLangKey(userDTO.getLangKey());
    }
    String encryptedPassword = passwordEncoder.encode(RandomUtil.generatePassword());
    user.setPassword(encryptedPassword);
    user.setResetKey(RandomUtil.generateResetKey());
    user.setResetDate(Instant.now());
    user.setActivated(true);
    if (userDTO.getAuthorities() != null) {
      Set<Authority> authorities = userDTO.getAuthorities().stream()
        .map(authorityRepository::findById)
        .filter(Optional::isPresent)
        .map(Optional::get)
        .collect(Collectors.toSet());
      user.setAuthorities(authorities);
    }
    userRepository.save(user);
    this.clearUserCaches(user);
    log.debug("Created Information for User: {}", user);
    return user;
  }

  /**
   * Update basic information (first name, last name, email, language) for the current user.
   *
   * @param name first name of user.
   * @param email     email id of user.
   * @param langKey   language key.
   * @param imageUrl  image URL of user.
   */
  public void updateUser(String name, String email, String langKey, String imageUrl) {
    SecurityUtils.getCurrentUserLogin()
      .flatMap(userRepository::findOneByEmail)
      .ifPresent(user -> {
        user.setName(name);
        user.setEmail(email.toLowerCase());
        user.setLangKey(langKey);
        user.setImageUrl(imageUrl);
        this.clearUserCaches(user);
        log.debug("Changed Information for User: {}", user);
      });
  }

  /**
   * Update all information for a specific user, and return the modified user.
   *
   * @param userDTO user to update.
   * @return updated user.
   */
  public Optional<UserDTO> updateUser(UserDTO userDTO) {
    return Optional.of(userRepository
      .findById(userDTO.getId()))
      .filter(Optional::isPresent)
      .map(Optional::get)
      .map(user -> {
        this.clearUserCaches(user);
        user.setEmail(userDTO.getEmail().toLowerCase());
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail().toLowerCase());
        user.setImageUrl(userDTO.getImageUrl());
        user.setActivated(userDTO.isActivated());
        user.setLangKey(userDTO.getLangKey());
        Set<Authority> managedAuthorities = user.getAuthorities();
        managedAuthorities.clear();
        userDTO.getAuthorities().stream()
          .map(authorityRepository::findById)
          .filter(Optional::isPresent)
          .map(Optional::get)
          .forEach(managedAuthorities::add);
        this.clearUserCaches(user);
        log.debug("Changed Information for User: {}", user);
        return user;
      })
      .map(UserDTO::new);
  }

  public void deleteUser(String login) {
    userRepository.findOneByEmail(login).ifPresent(user -> {
      userRepository.delete(user);
      this.clearUserCaches(user);
      log.debug("Deleted User: {}", user);
    });
  }

  public void changePassword(String currentClearTextPassword, String newPassword) {
    SecurityUtils.getCurrentUserLogin()
      .flatMap(userRepository::findOneByEmail)
      .ifPresent(user -> {
        String currentEncryptedPassword = user.getPassword();
        if (!passwordEncoder.matches(currentClearTextPassword, currentEncryptedPassword)) {
          throw new InvalidPasswordException();
        }
        String encryptedPassword = passwordEncoder.encode(newPassword);
        user.setPassword(encryptedPassword);
        this.clearUserCaches(user);
        log.debug("Changed password for User: {}", user);
      });
  }

  @Transactional(readOnly = true)
  public Page<UserDTO> getAllManagedUsers(Pageable pageable) {
    return userRepository.findAllByEmailNot(pageable, Constants.ANONYMOUS_USER).map(UserDTO::new);
  }

  @Transactional(readOnly = true)
  public Optional<User> getUserWithAuthoritiesByLoginEmail(String login) {
    return userRepository.findOneWithAuthoritiesByEmail(login);
  }

  @Transactional(readOnly = true)
  public Optional<User> getUserWithAuthorities(String id) {
    return userRepository.findOneWithAuthoritiesById(id);
  }

  @Transactional(readOnly = true)
  public Optional<User> getUserWithAuthorities() {
    return SecurityUtils.getCurrentUserLogin().flatMap(userRepository::findOneWithAuthoritiesByEmail);
  }

  /**
   * Not activated users should be automatically deleted after 3 days.
   * <p>
   * This is scheduled to get fired everyday, at 01:00 (am).
   */
  @Scheduled(cron = "0 0 1 * * ?")
  public void removeNotActivatedUsers() {
    userRepository
      .findAllByActivatedIsFalseAndCreatedDateBefore(Instant.now().minus(3, ChronoUnit.DAYS))
      .forEach(user -> {
        log.debug("Deleting not activated user {}", user.getEmail());
        userRepository.delete(user);
        this.clearUserCaches(user);
      });
  }

  /**
   * Gets a list of all the authorities.
   *
   * @return a list of all the authorities.
   */
  public List<String> getAuthorities() {
    return authorityRepository.findAll().stream().map(Authority::getName).collect(Collectors.toList());
  }

  private void clearUserCaches(User user) {
    Objects.requireNonNull(cacheManager.getCache(UserRepository.USERS_BY_EMAIL_CACHE)).evict(user.getEmail());
  }
}