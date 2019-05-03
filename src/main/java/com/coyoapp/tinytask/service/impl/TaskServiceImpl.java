package com.coyoapp.tinytask.service.impl;

import com.coyoapp.tinytask.dto.TaskFactory;
import com.coyoapp.tinytask.dto.TaskDTO;
import com.coyoapp.tinytask.entity.Task;
import com.coyoapp.tinytask.exception.TaskNotFoundException;
import com.coyoapp.tinytask.repo.TaskRepository;
import com.coyoapp.tinytask.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class TaskServiceImpl implements TaskService {

  @Autowired
  private TaskRepository taskRepository;

  @Autowired
  private TaskFactory taskFactory;

  @Override
  public TaskDTO saveOrUpdateTask(TaskDTO taskDTO) {
    Task task = taskFactory.buildTask(taskDTO);
    Task savedTask = taskRepository.save(task);
    return taskFactory.buildTask(savedTask);
  }

  @Override
  public TaskDTO getTask(String id) {
    return taskRepository.findById(id)
      .map(task -> taskFactory.buildTask(task))
      .orElseThrow(() -> new TaskNotFoundException(
        String.format("the expected %s task", id)));
  }

  @Override
  public void removeTask(String id) {
    taskRepository.deleteById(id);
  }

  @Override
  public List<TaskDTO> getTasks() {
    List<Task> taskList = taskRepository.findAll();
    List<TaskDTO> taskDTOList = new ArrayList<>();
    taskList
      .stream()
      .filter(Objects::nonNull)
      .filter(s -> s.getId() != null)
      .forEach(task -> {
        TaskDTO taskDTO = taskFactory.buildTask(task);
        taskDTOList.add(taskDTO);
      });
    return taskDTOList;
  }

  @Override
  public boolean isTaskExist(TaskDTO task) {
    return taskRepository.findByTitle(task.getId()) != null;
  }

}
