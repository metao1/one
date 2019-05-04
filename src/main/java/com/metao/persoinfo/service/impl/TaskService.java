package com.metao.persoinfo.service.impl;

import com.metao.persoinfo.dto.ObjectFactory;
import com.metao.persoinfo.dto.TaskDTO;
import com.metao.persoinfo.entity.Task;
import com.metao.persoinfo.exception.NotFoundException;
import com.metao.persoinfo.repo.TaskRepository;
import com.metao.persoinfo.service.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class TaskService implements GeneralService<TaskDTO> {

  @Autowired
  private TaskRepository taskRepository;

  @Autowired
  private ObjectFactory objectFactory;

  @Override
  public TaskDTO saveOrUpdateModel(TaskDTO object) {
    Task task = objectFactory.buildTask(object);
    Task savedTask = taskRepository.save(task);
    return objectFactory.buildTask(savedTask);
  }

  @Override
  public TaskDTO getModel(String id) {
    return taskRepository.findById(id)
      .map(task -> objectFactory.buildTask(task))
      .orElseThrow(() -> new NotFoundException(
        String.format("the expected %s task", id)));
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
