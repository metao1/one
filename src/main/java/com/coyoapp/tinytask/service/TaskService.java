package com.coyoapp.tinytask.service;

import com.coyoapp.tinytask.entity.Task;

import java.util.List;

public interface TaskService {

  public Task saveOrUpdateTask(Task task);

  public Task getTask(String id);

  public void removeTask(String id);

  public List<Task> getTasks();

  public boolean isTaskExist(Task task);


}
