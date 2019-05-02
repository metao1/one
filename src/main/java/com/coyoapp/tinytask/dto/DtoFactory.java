package com.coyoapp.tinytask.dto;

import com.coyoapp.tinytask.entity.Task;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;

public class DtoFactory {

  private final ObjectMapper mapper;
  private final ModelMapper modelMapper;

  public DtoFactory(ModelMapper modelMapper, ObjectMapper mapper) {
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


}
