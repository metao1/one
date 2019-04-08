package com.coyoapp.tinytask.controller;

import com.coyoapp.tinytask.entity.Task;
import com.coyoapp.tinytask.service.TaskService;
import com.coyoapp.tinytask.util.CustomErrorType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Api(description = "Operations pertaining to tasks in Task Management System")
public class TaskController {

  @Autowired
  private TaskService taskService;

  @PostMapping(value = "/task")
  @ApiOperation(value = "Create a new task")
  public ResponseEntity<?> createTask(@RequestBody Task task) {

    if (taskService.isTaskExist(task)) {
      return new ResponseEntity<>(new CustomErrorType("Unable to create task. "
        + "A task with name " + task.getTitle() + " already exist"), HttpStatus.CONFLICT);
    }
    taskService.saveOrUpdateTask(task);
    return new ResponseEntity<>(task, HttpStatus.CREATED);
  }

  @GetMapping(value = "/task")
  @ApiOperation(value = "View a list of available tasks")
  public ResponseEntity<List<Task>> getTasks() {

    List<Task> tasks = taskService.getTasks();
    if (tasks.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(tasks, HttpStatus.OK);

  }

  @GetMapping(value = "/task/{id}")
  @ApiOperation(value = "Get a task")
  public ResponseEntity<?> getTask(@PathVariable("id") String id) {
    Task task = taskService.getTask(id);
    if (task == null) {
      return new ResponseEntity<>(new CustomErrorType("Task with id " + id
        + " not found"), HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(task, HttpStatus.OK);
  }

  @PutMapping(value = "/task/{id}")
  @ApiOperation(value = "Update a task")
  public ResponseEntity<?> updateTask(@PathVariable("id") String id, @RequestBody Task task) {

    Task currentTask = taskService.getTask(id);
    if (currentTask == null) {
      return new ResponseEntity<>(new CustomErrorType("Unable to update. User with id "
        + id + " not found"), HttpStatus.NOT_FOUND);
    }
    currentTask.setTitle(task.getTitle());
    currentTask.setCompleted(task.getCompleted());
    taskService.saveOrUpdateTask(currentTask);
    return new ResponseEntity<Task>(currentTask, HttpStatus.OK);
  }

  @DeleteMapping(value = "/task/{id}")
  @ApiOperation(value = "Delete a task")
  public ResponseEntity<?> deleteTask(@PathVariable("id") String id) {

    Task task = taskService.getTask(id);
    if (task == null) {
      return new ResponseEntity<>(new CustomErrorType("Unable to delete. "
        + "User with id " + id + " not found"), HttpStatus.NOT_FOUND);
    }
    taskService.removeTask(id);
    return new ResponseEntity<Task>(HttpStatus.NO_CONTENT);
  }

}
