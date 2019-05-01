package com.coyoapp.tinytask;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.BindingResult;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IndexControllerTest {

  private MockMvc mvc;

  @Mock
  BindingResult bindingResult;

  @Autowired
  private WebApplicationContext wac;

  @Before
  public void setup() {
    this.bindingResult = Mockito.mock(BindingResult.class);
    this.mvc = MockMvcBuilders.webAppContextSetup(wac).build();
  }

  @Test
  public void getAllTasks() throws Exception {
    this.mvc.perform(get("/api/task"))
      .andDo(print())
      .andExpect(status().isOk());
  }
}
