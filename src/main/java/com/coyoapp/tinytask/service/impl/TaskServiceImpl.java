package com.coyoapp.tinytask.service.impl;

import com.coyoapp.tinytask.entity.Task;
import com.coyoapp.tinytask.repo.TaskRepository;
import com.coyoapp.tinytask.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskRepository taskRepository;
	
	@Override
	public Task saveOrUpdateTask(Task task) {
		return taskRepository.save(task);
	}

	@Override
	public Task getTask(String id) {
		return taskRepository.findById(id).get();
	}

	@Override
	public void removeTask(String id) {
		taskRepository.deleteById(id);
	}

	@Override
	public List<Task> getTasks() {
		return taskRepository.findAll();
	}

	@Override
	public boolean isTaskExist(Task task) {
		return taskRepository.findByTitle(task.getId()) != null;
	}
	
	
}
