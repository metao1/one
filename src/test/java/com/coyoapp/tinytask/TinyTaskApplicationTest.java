package com.coyoapp.tinytask;

import io.swagger.annotations.Authorization;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.BindingResult;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TinyTaskApplicationTest {

  private MockMvc mvc;

  @Autowired
  private ObjectMapper mapper;

  @Mock
  BindingResult bindingResult;

  @Autowired
  private WebApplicationContext wac;
  private String BASE_URL = "/api/";

  @Before
  public void setup() {
    this.bindingResult = Mockito.mock(BindingResult.class);
    this.mvc = MockMvcBuilders.webAppContextSetup(wac).build();
  }

  @Test
  public void getOneTask() throws Exception{
    this.mvc.perform(get(BASE_URL+ "task"))
      .andDo(print())
      .andDo(result -> {
        JavaType javaType = mapper.getTypeFactory().constructParametricType(ResponseMap.class, HouseDTO.class);
        ResponseMap<HouseDTO> map = mapper.readValue(result.getResponse().getContentAsString(), javaType);
        assertThat(map).isNotNull();
        assertThat(map.getResponse().getName()).isEqualTo(this.houseMap1.getName());      })
      .andExpect(status().isOk());

    this.mvc.perform(BASE_URL + "task/1");
  }

  @Test
  public void getAllTasks() throws Exception {
    this.mvc.perform(get(BASE_URL+ "task")
      .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
      .andDo(print())
      .andExpect(status().isOk());
  }
}
