package com.metao.persoinfo;

import com.metao.persoinfo.dto.ResponseMap;
import com.metao.persoinfo.dto.TaskDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@FixMethodOrder(MethodSorters.JVM)
@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskTest extends BaseTest {

  private static TaskDTO taskDTO;

  @Test
  public void getAllTasks() throws Exception {
    this.mvc.perform(get(BASE_URL)
      .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
      .andExpect(status().is2xxSuccessful())
      .andDo(print())
      .andExpect(jsonPath("$.message").exists())
      .andExpect(jsonPath("$.message").isString())
      .andExpect(jsonPath("$.message").value("tasks"))
      .andExpect(jsonPath("$.response").exists())
      .andDo(result -> {
        ResponseMap<List<TaskDTO>> json = objectFactory.fromJSON(new TypeReference<ResponseMap<List<TaskDTO>>>() {
        }, result.getResponse().getContentAsString());
        assertThat(json).isNotNull();
        assertThat(json.getResponse().size()).isGreaterThanOrEqualTo(0);
      });
  }

  public void goSetup() throws Exception {
    BASE_URL += "task/";
    if (taskDTO == null) {
      this.mvc.perform(get(BASE_URL)
        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andExpect(status().is2xxSuccessful())
        .andDo(print())
        .andExpect(jsonPath("$.message").exists())
        .andExpect(jsonPath("$.message").isString())
        .andExpect(jsonPath("$.message").value("tasks"))
        .andExpect(jsonPath("$.response").exists())
        .andDo(result -> {
          ResponseMap<List<TaskDTO>> json = objectFactory
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
  public void getOneTask() throws Exception {
    this.mvc.perform(get(BASE_URL + taskDTO.getId())
      .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
      .andExpect(status().isOk())
      .andDo(print())
      .andExpect(jsonPath("$.message").exists())
      .andExpect(jsonPath("$.message").isString())
      .andExpect(jsonPath("$.message").value("task"))
      .andExpect(jsonPath("$.response").exists())
      .andDo(task -> {
        ResponseMap<TaskDTO> dtoResponseMap = objectFactory.fromJSON(new TypeReference<ResponseMap<TaskDTO>>() {
        }, task.getResponse().getContentAsString());
        assertThat(dtoResponseMap.getResponse()).isEqualTo(taskDTO);
      });
  }

  @Test
  public void deleteTaskTest() throws Exception {
    this.mvc.perform(delete(BASE_URL + taskDTO.getId())
      .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
      .andDo(print())
      .andExpect(status().is2xxSuccessful());
  }

  @Test
  public void deleteTaskFailedTest() throws Exception {
    this.mvc.perform(delete(BASE_URL + taskDTO.getId())
      .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
      .andDo(print())
      .andExpect(status().isNotFound());
  }

}
