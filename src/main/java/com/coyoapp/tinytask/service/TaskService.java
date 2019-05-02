package com.coyoapp.tinytask.service;

import com.coyoapp.tinytask.dto.ResponseMap;
import com.coyoapp.tinytask.dto.TaskDTO;
import com.coyoapp.tinytask.entity.Task;

import java.util.List;

public interface TaskService {

  public ResponseMap<TaskDTO> saveOrUpdateTask(TaskDTO task);

  public ResponseMap<TaskDTO> getTask(String id);

  public void removeTask(String id);

  public ResponseMap<List<TaskDTO>> getTasks();

  public boolean isTaskExist(TaskDTO task);


}
