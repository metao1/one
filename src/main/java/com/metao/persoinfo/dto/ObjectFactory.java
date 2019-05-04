package com.metao.persoinfo.dto;

import com.metao.persoinfo.entity.Filter;
import com.metao.persoinfo.entity.Task;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;

public class ObjectFactory {

  private final ObjectMapper mapper;
  private final ModelMapper modelMapper;

  public ObjectFactory(ModelMapper modelMapper, ObjectMapper mapper) {
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
   * @param filter: Filter
   * @return Task
   */
  public FilterDTO buildFilter(Filter filter) {
    return modelMapper.map(filter, FilterDTO.class);
  }

  /**
   * Builds TaskDTO from Task
   *
   * @param filterDTO: FilterDTO
   * @return TaskDTO
   */
  public Filter buildFilter(FilterDTO filterDTO) {
    return modelMapper.map(filterDTO, Filter.class);
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
      mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
      data = mapper.reader().forType(type).readValue(jsonPacket);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return data;
  }
}
