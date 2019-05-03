package com.coyoapp.tinytask;

import com.coyoapp.tinytask.dto.ResponseMap;
import com.coyoapp.tinytask.dto.TaskDTO;
import com.coyoapp.tinytask.dto.TaskFactory;
import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.BindingResult;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class TinyTaskApplicationTest {

  private MockMvc mvc;

  @Autowired
  private TaskFactory taskFactory;

  @Mock
  BindingResult bindingResult;

  @Autowired
  private WebApplicationContext wac;
  private String BASE_URL = "/api/";
  private static TaskDTO taskDTO;

  @Before
  public void setup() throws Exception {
    this.bindingResult = Mockito.mock(BindingResult.class);
    this.mvc = MockMvcBuilders.webAppContextSetup(wac).build();
    if (taskDTO == null) {
      this.mvc.perform(get(BASE_URL + "task")
        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andExpect(status().is2xxSuccessful())
        .andDo(print())
        .andExpect(jsonPath("$.message").exists())
        .andExpect(jsonPath("$.message").isString())
        .andExpect(jsonPath("$.message").value("tasks"))
        .andExpect(jsonPath("$.response").exists())
        .andDo(result -> {
          ResponseMap<List<TaskDTO>> json = taskFactory
            .fromJSON(new TypeReference<ResponseMap<List<TaskDTO>>>() {
            }, result.getResponse().getContentAsString());
          assertThat(json).isNotNull();
          assertThat(json.getResponse().size()).isGreaterThanOrEqualTo(0);
          List<TaskDTO> response = json.getResponse();
          taskDTO = response.get(0);
        });
    }
  }


  @Test
  public void _getOneTask() throws Exception {

    this.mvc.perform(get(BASE_URL + "task/" + taskDTO.getId())
      .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
      .andExpect(status().isOk())
      .andDo(print())
      .andExpect(jsonPath("$.message").exists())
      .andExpect(jsonPath("$.message").isString())
      .andExpect(jsonPath("$.message").value("task"))
      .andExpect(jsonPath("$.response").exists())
      .andDo(task -> {
        ResponseMap<TaskDTO> dtoResponseMap = taskFactory.fromJSON(new TypeReference<ResponseMap<TaskDTO>>() {
        }, task.getResponse().getContentAsString());
        assertThat(dtoResponseMap.getResponse()).isEqualTo(taskDTO);
      });
  }

  @Test
  public void deleteTaskTest() throws Exception {
    this.mvc.perform(delete(BASE_URL + "task/" + taskDTO.getId())
      .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
      .andExpect(status().isNotFound())
      .andDo(print());
  }


  @Test
  public void deleteTaskFailedTest() throws Exception {
    this.mvc.perform(delete(BASE_URL + "task/" + taskDTO.getId())
      .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
      .andExpect(status().is2xxSuccessful())
      .andDo(print());
  }

  @Test
  public void _getAllTasks() throws Exception {
    this.mvc.perform(get(BASE_URL + "task")
      .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
      .andExpect(status().is2xxSuccessful())
      .andDo(print())
      .andExpect(jsonPath("$.message").exists())
      .andExpect(jsonPath("$.message").isString())
      .andExpect(jsonPath("$.message").value("tasks"))
      .andExpect(jsonPath("$.response").exists())
      .andDo(result -> {
        ResponseMap<List<TaskDTO>> json = taskFactory.fromJSON(new TypeReference<ResponseMap<List<TaskDTO>>>() {
        }, result.getResponse().getContentAsString());
        assertThat(json).isNotNull();
        assertThat(json.getResponse().size()).isGreaterThanOrEqualTo(0);
      });
  }
}
