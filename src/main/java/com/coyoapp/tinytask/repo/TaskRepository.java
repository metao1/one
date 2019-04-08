package com.coyoapp.tinytask.repo;

import com.coyoapp.tinytask.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, String> {

	Task findByTitle(String title);

}
