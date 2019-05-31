package com.metao.persoinfo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.metao.persoinfo.dto.*;
import com.metao.persoinfo.service.impl.TaskService;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.internal.util.collections.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@FixMethodOrder(MethodSorters.JVM)
@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskTest extends BaseTest {

  private static TaskDTO taskDTO;

  @Autowired
  private ObjectFactory objectFactory;

  @Autowired
  private TaskService taskService;

  @Test
  public void getAllTasks() throws Exception {
    this.mvc.perform(get(BASE_URL + USER_NAME)
      .header("Authorization", "Bearer " + JWT)
      .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
      .andExpect(status().is2xxSuccessful())
      .andDo(print())
      .andExpect(jsonPath("$.message").exists())
      .andExpect(jsonPath("$.message").isString())
      .andExpect(jsonPath("$.message").value("tasks"))
      .andExpect(jsonPath("$.response").exists())
      .andDo(result -> {
        ResponseMap<List<TaskDTO>> json = objectFactory.fromJson(new TypeReference<ResponseMap<List<TaskDTO>>>() {
        }, result.getResponse().getContentAsString());
        assertThat(json).isNotNull();
        assertThat(json.getResponse().size()).isGreaterThanOrEqualTo(0);
      });
  }

  public void goSetup() throws Exception {
    BASE_URL += "task/";
    if (taskDTO == null) {
      this.mvc.perform(get(BASE_URL + USER_NAME)
        .header("Authorization", "Bearer " + JWT)
        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andExpect(status().is2xxSuccessful())
        .andDo(print())
        .andExpect(jsonPath("$.message").exists())
        .andExpect(jsonPath("$.message").isString())
        .andExpect(jsonPath("$.message").value("tasks"))
        .andExpect(jsonPath("$.response").exists())
        .andDo(result -> {
          ResponseMap<List<TaskDTO>> json = objectFactory
            .fromJson(new TypeReference<ResponseMap<List<TaskDTO>>>() {
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
    this.mvc.perform(get(BASE_URL + USER_NAME + "/" + taskDTO.getId())
      .header("Authorization", "Bearer " + JWT)
      .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
      .andExpect(status().isOk())
      .andDo(print())
      .andExpect(jsonPath("$.message").exists())
      .andExpect(jsonPath("$.message").isString())
      .andExpect(jsonPath("$.message").value("task"))
      .andExpect(jsonPath("$.response").exists())
      .andDo(task -> {
        ResponseMap<TaskDTO> dtoResponseMap = objectFactory.fromJson(new TypeReference<ResponseMap<TaskDTO>>() {
        }, task.getResponse().getContentAsString());
        assertThat(dtoResponseMap.getResponse()).isEqualTo(taskDTO);
      });
  }

  @Test
  public void updateTaskTest() throws Exception {
    TaskDTO taskDTO = new TaskDTO();
    taskDTO.setId(UUID.randomUUID().toString());
    taskDTO.setTitle("Task Title");
    taskDTO.setDeleted(false);
    taskDTO.setCompleted(false);
    Calendar calendar = Calendar.getInstance(TimeZone.getDefault(), Locale.GERMANY);
    taskDTO.setStartDate(new Date());
    Calendar.getInstance(TimeZone.getDefault(), Locale.GERMANY);
    calendar.setTime(taskDTO.getStartDate());
    calendar.add(Calendar.DAY_OF_MONTH, 1);
    taskDTO.setDueDate(calendar.getTime());
    taskDTO.setImportant(false);
    taskDTO.setTags(Sets.newSet(new TagDTO(UUID.randomUUID().toString(), "tag", "tag", "#323232")));
    String jsonBody = objectFactory.toJson(new TypeReference<TaskDTO>() {
    }, taskDTO);

    this.mvc.perform(post(BASE_URL + USER_NAME)
      .header("Authorization", "Bearer " + JWT)
      .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
      .content(jsonBody))
      .andDo(print())
      .andExpect(status().is2xxSuccessful())
      .andExpect(jsonPath("$.message").exists())
      .andExpect(jsonPath("$.message").isString())
      .andExpect(jsonPath("$.message").value("task"))
      .andExpect(jsonPath("$.response").exists())
      .andDo(task -> {
        ResponseMap<TaskDTO> dtoResponseMap = objectFactory.fromJson(new TypeReference<ResponseMap<TaskDTO>>() {
        }, task.getResponse().getContentAsString());
        assertThat(dtoResponseMap.getResponse()).isEqualTo(taskDTO);
        TaskDTO savedTaskDTO = dtoResponseMap.getResponse();
        savedTaskDTO.setTitle("updated title");
        String newJsonBody = objectFactory.toJson(new TypeReference<TaskDTO>() {
        }, savedTaskDTO);
        this.mvc.perform(put(BASE_URL + USER_NAME + "/" + savedTaskDTO.getId())
          .header("Authorization", "Bearer " + JWT)
          .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
          .content(newJsonBody))
          .andDo(print())
          .andExpect(status().is2xxSuccessful())
          .andExpect(jsonPath("$.message").exists())
          .andExpect(jsonPath("$.message").isString())
          .andExpect(jsonPath("$.message").value("task"))
          .andExpect(jsonPath("$.response").exists())
          .andDo(updatedTask -> {
            ResponseMap<TaskDTO> updatedDtoResponseMap = objectFactory.fromJson(new TypeReference<ResponseMap<TaskDTO>>() {
            }, updatedTask.getResponse().getContentAsString());
            assertThat(updatedDtoResponseMap.getResponse().getTitle()).isEqualTo("updated title");
          });
      });
  }

  @Test
  public void saveTaskTest() throws Exception {
    TaskDTO taskDTO = new TaskDTO();
    taskDTO.setId(UUID.randomUUID().toString());
    taskDTO.setTitle("Task Title");
    taskDTO.setDeleted(false);
    taskDTO.setCompleted(false);
    taskDTO.setStartDate(new Date());
    Calendar calendar = Calendar.getInstance(TimeZone.getDefault(), Locale.GERMANY);
    calendar.add(Calendar.DAY_OF_MONTH, 4);
    taskDTO.setDueDate(calendar.getTime());
    taskDTO.setImportant(false);
    TagDTO tag = new TagDTO(UUID.randomUUID().toString(), "tag", "tag", "#323232");
    taskDTO.setTags(Sets.newSet(tag));
    String jsonBody = objectFactory.toJson(new TypeReference<TaskDTO>() {
    }, taskDTO);
    this.mvc.perform(post(BASE_URL + USER_NAME)
      .header("Authorization", "Bearer " + JWT)
      .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
      .content(jsonBody))
      .andDo(print())
      .andExpect(status().is2xxSuccessful())
      .andExpect(jsonPath("$.message").exists())
      .andExpect(jsonPath("$.message").isString())
      .andExpect(jsonPath("$.message").value("task"))
      .andExpect(jsonPath("$.response").exists())
      .andDo(task -> {
        ResponseMap<TaskDTO> dtoResponseMap = objectFactory.fromJson(new TypeReference<ResponseMap<TaskDTO>>() {
        }, task.getResponse().getContentAsString());
        assertThat(dtoResponseMap.getResponse()).isEqualTo(taskDTO);
        assertThat(dtoResponseMap.getResponse().getTitle()).isEqualTo("Task Title");
        assertThat(dtoResponseMap.getResponse().getTags()).contains(tag);
        assertThat(dtoResponseMap.getResponse().getStartDate())
          .isBefore(dtoResponseMap.getResponse().getDueDate());
      });
  }

  @Test
  public void saveTaskDueDateWrongFailedTest() throws Exception {
    TaskDTO taskDTO = new TaskDTO();
    taskDTO.setId(UUID.randomUUID().toString());
    taskDTO.setTitle("Task Title");
    taskDTO.setDeleted(false);
    taskDTO.setCompleted(false);
    taskDTO.setDueDate(new Date());
    Calendar calendar = Calendar.getInstance(TimeZone.getDefault(), Locale.GERMANY);
    calendar.add(Calendar.DAY_OF_MONTH, 4);
    taskDTO.setStartDate(calendar.getTime());
    taskDTO.setImportant(false);
    TagDTO tag = new TagDTO(UUID.randomUUID().toString(), "tag", "tag", "#323232");
    taskDTO.setTags(Sets.newSet(tag));
    String jsonBody = objectFactory.toJson(new TypeReference<TaskDTO>() {
    }, taskDTO);
    this.mvc.perform(post(BASE_URL + USER_NAME)
      .header("Authorization", "Bearer " + JWT)
      .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
      .content(jsonBody))
      .andDo(print())
      .andExpect(status().isInternalServerError())
      .andExpect(result -> {
        ApiError dtoResponseMap = objectFactory.fromJson(new TypeReference<ApiError>() {
        }, result.getResponse().getContentAsString());
        assertThat(dtoResponseMap).isNotNull();
        assertThat(dtoResponseMap.getMessage()).isNotNull();
        assertThat(dtoResponseMap.getStatus()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
        assertThat(dtoResponseMap.getMessage()).isEqualTo("The due date should be after started date");
      });
  }

  @Test
  public void saveTaskWithDuplicatesTagsTest() throws Exception {
    TaskDTO taskDTO = new TaskDTO();
    taskDTO.setId(UUID.randomUUID().toString());
    taskDTO.setTitle("Task Title");
    taskDTO.setDeleted(false);
    taskDTO.setCompleted(false);
    taskDTO.setStartDate(new Date());
    Calendar calendar = Calendar.getInstance(TimeZone.getDefault(), Locale.GERMANY);
    calendar.add(Calendar.DAY_OF_MONTH, 4);
    taskDTO.setDueDate(calendar.getTime());
    taskDTO.setImportant(false);
    TagDTO tag = new TagDTO(UUID.randomUUID().toString(), "tag", "tag", "#323232");
    TagDTO tag2 = new TagDTO(UUID.randomUUID().toString(), "tag", "tag", "#323232");
    taskDTO.setTags(Sets.newSet(tag, tag2));
    String jsonBody = objectFactory.toJson(new TypeReference<TaskDTO>() {
    }, taskDTO);
    this.mvc.perform(post(BASE_URL + USER_NAME)
      .header("Authorization", "Bearer " + JWT)
      .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
      .content(jsonBody))
      .andDo(print())
      .andExpect(status().is2xxSuccessful())
      .andExpect(jsonPath("$.message").exists())
      .andExpect(jsonPath("$.message").isString())
      .andExpect(jsonPath("$.message").value("task"))
      .andExpect(jsonPath("$.response").exists())
      .andDo(task -> {
        ResponseMap<TaskDTO> dtoResponseMap = objectFactory.fromJson(new TypeReference<ResponseMap<TaskDTO>>() {
        }, task.getResponse().getContentAsString());
        assertThat(dtoResponseMap.getResponse()).isEqualTo(taskDTO);
        assertThat(dtoResponseMap.getResponse().getTitle()).isEqualTo("Task Title");
        assertThat(dtoResponseMap.getResponse().getTags()).contains(tag);
        assertEquals(1, dtoResponseMap.getResponse().getTags().size());
        assertThat(dtoResponseMap.getResponse().getStartDate())
          .isBefore(dtoResponseMap.getResponse().getDueDate());
      });
  }

  @Test
  public void deleteTaskTest() throws Exception {
    this.mvc.perform(delete(BASE_URL + USER_NAME + "/" + taskDTO.getId())
      .header("Authorization", "Bearer " + JWT)
      .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
      .andDo(print())
      .andExpect(status().is2xxSuccessful());
  }

  @Test
  public void deleteTaskFailedTest() throws Exception {
    this.mvc.perform(delete(BASE_URL + USER_NAME + "/" + 12333L)
      .header("Authorization", "Bearer " + JWT)
      .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
      .andDo(print())
      .andExpect(status().isNotFound())
      .andExpect(result -> {
        ApiError dtoResponseMap = objectFactory.fromJson(new TypeReference<ApiError>() {
        }, result.getResponse().getContentAsString());
        assertThat(dtoResponseMap).isNotNull();
        assertThat(dtoResponseMap.getMessage()).isNotNull();
        assertThat(dtoResponseMap.getStatus()).isEqualTo(HttpStatus.NOT_FOUND);
        assertThat(dtoResponseMap.getMessage()).isEqualTo(String.format("the expected %d task not found", 12333L));
      });
  }
}
