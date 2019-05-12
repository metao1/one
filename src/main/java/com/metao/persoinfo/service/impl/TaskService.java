package com.metao.persoinfo.service.impl;

import com.google.common.collect.Sets;
import com.metao.persoinfo.dto.ObjectFactory;
import com.metao.persoinfo.dto.TagDTO;
import com.metao.persoinfo.dto.TaskDTO;
import com.metao.persoinfo.entity.Task;
import com.metao.persoinfo.exception.NotFoundException;
import com.metao.persoinfo.exception.TaskException;
import com.metao.persoinfo.repository.TaskRepository;
import com.metao.persoinfo.service.GeneralService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TaskService implements GeneralService<TaskDTO> {

  private final TaskRepository taskRepository;

  private final ObjectFactory objectFactory;

  public TaskService(TaskRepository taskRepository, ObjectFactory objectFactory) {
    this.taskRepository = taskRepository;
    this.objectFactory = objectFactory;
  }

  @Override
  public TaskDTO saveOrUpdateModel(TaskDTO object) {
    if (object.getDueDate().after(object.getStartDate())) {
      if (object.getTags() != null) {//remove duplicates
        Set<TagDTO> tagDTOSet = new HashSet<>(object.getTags());
        if (tagDTOSet.size() > 0) {
          object.setTags(Sets.newConcurrentHashSet(tagDTOSet));
        }
      }
      Task task = objectFactory.buildTask(object);
      Task savedTask = taskRepository.save(task);
      return objectFactory.buildTask(savedTask);
    }
    throw new TaskException("The due date should be after started date");
  }

  @Override
  public TaskDTO getModel(String id) {
    return taskRepository.findById(id)
      .map(objectFactory::buildTask)
      .orElseThrow(() -> new NotFoundException(
        String.format("the expected %s task not found", id)));
  }

  @Override
  public void removeModel(String id) {
    taskRepository.deleteById(id);
  }

  @Override
  public List<TaskDTO> getModels() {
    List<Task> taskList = taskRepository.findAll();
    List<TaskDTO> taskDTOList = new ArrayList<>();
    taskList
      .stream()
      .filter(Objects::nonNull)
      .filter(s -> s.getId() != null)
      .forEach(task -> {
        TaskDTO taskDTO = objectFactory.buildTask(task);
        taskDTOList.add(taskDTO);
      });
    return taskDTOList;
  }

  @Override
  public boolean isModelExist(TaskDTO object) {
    return taskRepository.findById(object.getId()).isPresent();
  }

}
