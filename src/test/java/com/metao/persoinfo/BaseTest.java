package com.metao.persoinfo;

import com.metao.persoinfo.dto.LoginVM;
import com.metao.persoinfo.dto.ObjectFactory;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.BindingResult;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.Filter;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public abstract class BaseTest {

  protected MockMvc mvc;

  protected String JWT;

  protected String BASE_URL = "/api/";

  protected String USER_NAME = "mal@gmail.com";

  @Autowired
  protected ObjectFactory objectFactory;

  @Autowired
  private Filter springSecurityFilterChain;

  @Mock
  protected BindingResult bindingResult;

  @Autowired
  protected WebApplicationContext wac;

  @Before
  public void setup() throws Exception {
    this.bindingResult = Mockito.mock(BindingResult.class);
    this.mvc = MockMvcBuilders.webAppContextSetup(wac)
      .addFilter(springSecurityFilterChain)
      .build();
    login();
    goSetup();
  }

  private void login() throws Exception {
    LoginVM login = new LoginVM();
    login.setUsername(USER_NAME);
    login.setPassword("mehrdad");
    this.mvc.perform(post("/api/authenticate")
      .contentType(TestUtil.APPLICATION_JSON_UTF8)
      .content(TestUtil.convertObjectToJsonBytes(login)))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.id_token").isString())
      .andExpect(jsonPath("$.id_token").isNotEmpty())
      .andDo(result -> {
        String jwtToken = result.getResponse().getContentAsString();
        System.out.println("token is:" + jwtToken);
        this.JWT = jwtToken.substring(jwtToken.indexOf(":") + 2, jwtToken.length() - 2);
        System.out.println("Storing JWT token:" + JWT);
      });
  }

  protected abstract void goSetup() throws Exception;
}
