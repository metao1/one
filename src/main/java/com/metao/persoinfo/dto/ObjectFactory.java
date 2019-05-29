package com.metao.persoinfo.dto;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.metao.persoinfo.entity.Filter;
import com.metao.persoinfo.entity.Tag;
import com.metao.persoinfo.entity.Task;
import com.metao.persoinfo.entity.User;
import org.modelmapper.ModelMapper;

public class ObjectFactory {

  private final ObjectMapper mapper;
  private final ModelMapper modelMapper;

  public ObjectFactory(ModelMapper modelMapper, ObjectMapper mapper) {
    this.mapper = mapper;
    this.modelMapper = modelMapper;
  }

  /**
   * Builds Tag from TagDTO
   *
   * @param tag: Tag
   * @return TagDTO
   */
  public TagDTO buildTag(Tag tag) {
    return modelMapper.map(tag, TagDTO.class);
  }

  /**
   * Builds TagDTO from Tag
   *
   * @param tagDTO: TagDTO
   * @return Tag
   */
  public Tag buildTag(TagDTO tagDTO) {
    return modelMapper.map(tagDTO, Tag.class);
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
   * Builds User from UserDTO
   */

  public User buildUser(UserDTO userDTO) {
    return modelMapper.map(userDTO, User.class);
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
   * Builds FilterDTO from Filter
   *
   * @param filterDTO: FilterDTO
   * @return Filter
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

  public <T> String toJson(final TypeReference<T> type, Object object) {
    String data = null;
    try {
      mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
      data = mapper.writer().forType(type).writeValueAsString(object);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return data;
  }

  public <T> T fromJson(final TypeReference<T> type, final String jsonPacket) {
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
