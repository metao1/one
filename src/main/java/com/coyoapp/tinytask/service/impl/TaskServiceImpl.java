package com.coyoapp.tinytask.service.impl;

import com.coyoapp.tinytask.dto.DtoFactory;
import com.coyoapp.tinytask.dto.ResponseMap;
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
  private DtoFactory dtoFactory;

  @Override
  public ResponseMap<TaskDTO> saveOrUpdateTask(TaskDTO taskDTO) {
    Task task = dtoFactory.buildTask(taskDTO);
    Task savedTask = taskRepository.save(task);
    return new ResponseMap<>(dtoFactory.buildTask(savedTask));
  }

  @Override
  public ResponseMap<TaskDTO> getTask(String id) {
    return taskRepository.findById(id)
      .map(task -> {
        ResponseMap<TaskDTO> map = new ResponseMap<>(dtoFactory.buildTask(task));
        map.message = "task";
        return map;
      })
      .orElseThrow(() -> new TaskNotFoundException(
        String.format("the expected %s task", id)));
  }

  @Override
  public void removeTask(String id) {
    taskRepository.deleteById(id);
  }

  @Override
  public ResponseMap<List<TaskDTO>> getTasks() {
    List<Task> taskList = taskRepository.findAll();
    List<TaskDTO> taskDTOList = new ArrayList<>();
    taskList
      .stream()
      .filter(Objects::nonNull)
      .forEach(task -> {
        TaskDTO taskDTO = dtoFactory.buildTask(task);
        taskDTOList.add(taskDTO);
      });
    ResponseMap<List<TaskDTO>> map = new ResponseMap<>(taskDTOList);
    map.message = "tasks";
    return map;
  }

  @Override
  public boolean isTaskExist(TaskDTO task) {
    return taskRepository.findByTitle(task.id) != null;
  }

}
