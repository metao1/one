package com.metao.persoinfo;

import com.metao.persoinfo.dto.ObjectFactory;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.BindingResult;
import org.springframework.web.context.WebApplicationContext;

public abstract class BaseTest {

  protected MockMvc mvc;

  protected String BASE_URL = "/api/";

  @Autowired
  protected ObjectFactory objectFactory;

  @Mock
  protected BindingResult bindingResult;

  @Autowired
  protected WebApplicationContext wac;

  @Before
  public void setup() throws Exception{
    this.bindingResult = Mockito.mock(BindingResult.class);
    this.mvc = MockMvcBuilders.webAppContextSetup(wac).build();
    goSetup();
  }

  protected abstract void goSetup() throws Exception;
}
