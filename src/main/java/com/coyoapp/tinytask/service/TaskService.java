package com.coyoapp.tinytask.service;

import com.coyoapp.tinytask.dto.TaskDTO;

import java.util.List;

public interface TaskService {

  public TaskDTO saveOrUpdateTask(TaskDTO task);

  public TaskDTO getTask(String id);

  public void removeTask(String id);

  public List<TaskDTO> getTasks();

  public boolean isTaskExist(TaskDTO task);


}
