package com.coyoapp.tinytask.dto;

import com.coyoapp.tinytask.entity.Task;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;

public class TaskFactory {

  private final ObjectMapper mapper;
  private final ModelMapper modelMapper;

  public TaskFactory(ModelMapper modelMapper, ObjectMapper mapper) {
    this.mapper = mapper;
    this.modelMapper = modelMapper;
  }

  /**
   * Builds TaskDTO from Task
   *
   * @param task: Task
   * @return TaskDTO
   */
  public TaskDTO buildTask(Task task) {
    return modelMapper.map(task, TaskDTO.class);
  }

  /**
   * Builds Task from TaskDTO
   *
   * @param taskDto: TaskDTO
   * @return Task
   */
  public Task buildTask(TaskDTO taskDto) {
    return modelMapper.map(taskDto, Task.class);
  }


  public <T> T fromJSON(final TypeReference<T> type, final String jsonPacket) {
    T data = null;
    try {
      data = new ObjectMapper().readValue(jsonPacket, type);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return data;
  }
}
