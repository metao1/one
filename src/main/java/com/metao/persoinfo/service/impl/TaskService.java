package com.metao.persoinfo.service.impl;

import com.google.common.collect.Sets;
import com.metao.persoinfo.dto.ObjectFactory;
import com.metao.persoinfo.dto.TagDTO;
import com.metao.persoinfo.dto.TaskDTO;
import com.metao.persoinfo.entity.Task;
import com.metao.persoinfo.exception.InvalidLoginException;
import com.metao.persoinfo.exception.NotFoundException;
import com.metao.persoinfo.exception.TaskException;
import com.metao.persoinfo.repository.TaskRepository;
import com.metao.persoinfo.service.GeneralService;
import com.metao.persoinfo.util.SecurityUtils;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TaskService implements GeneralService<TaskDTO> {

  private final TaskRepository taskRepository;

  private final ObjectFactory objectFactory;

  private final TagService tagService;

  public TaskService(TaskRepository taskRepository, ObjectFactory objectFactory, TagService tagService) {
    this.taskRepository = taskRepository;
    this.objectFactory = objectFactory;
    this.tagService = tagService;
  }

  @Override
  public void saveOrUpdateModel(TaskDTO object) {
    if (object.getDueDate() != null &&
      object.getStartDate() != null &&
      object.getDueDate()
        .before(object.getStartDate())) {
      throw new TaskException("The due date should be after started date");
    }
    if (object.getTags() != null) {//remove duplicates
      Set<TagDTO> tagDTOSet = new HashSet<>(object.getTags());
      if (tagDTOSet.size() > 0) {
        object.getTags().forEach(tagDTO -> {
          if (!tagService.isModelExist(tagDTO)) {
            tagService.saveOrUpdateModel(tagDTO);
          }
        });
        object.setTags(Sets.newConcurrentHashSet(tagDTOSet));
      }
    }
    Optional<String> currentUserLogin = SecurityUtils.getCurrentUserLogin();
    if (currentUserLogin.isPresent()) {
      Task task = objectFactory.buildTask(object);
      task.setUsername(currentUserLogin.get());
      taskRepository.save(task);
    } else {
      throw new InvalidLoginException();
    }
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
  public List<TaskDTO> getModels(String username) {
    List<Task> taskList = taskRepository.findAll();
    return taskList
      .stream()
      .filter(Objects::nonNull)
      .filter(s -> s.getId() != null)
      .filter(s -> s.getUsername().equalsIgnoreCase(username))
      .map(objectFactory::buildTask).collect(Collectors.toList());
  }

  @Override
  public boolean isModelExist(TaskDTO object) {
    return taskRepository.findById(object.getId()).isPresent();
  }

}
