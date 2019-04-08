package com.coyoapp.tinytask.config;

import com.coyoapp.tinytask.entity.Tag;
import com.coyoapp.tinytask.entity.Task;
import com.coyoapp.tinytask.repo.TagRepository;
import com.coyoapp.tinytask.repo.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Configuration
public class DBInitializeConfig {

  @Autowired
  private TaskRepository taskRepository;

  @Autowired
  private TagRepository tagRepository;

  @PostConstruct
  public void initialize() {
    Set<Tag> tags = new HashSet<>();
    Tag tag1 = new Tag();
    tag1.setId(UUID.randomUUID().toString());
    tag1.setColor("#3c3c3c");
    tag1.setHandle("frontend");
    tags.add(tag1);
    Task task = new Task();

    task.setId(UUID.randomUUID().toString());
    task.setTitle("Task one");
    task.setNotes("The task one notes");
    task.setDeleted(false);
    task.setStarred(false);
    task.setImportant(false);
    task.setTags(tags);
    task.setCompleted(false);

    tag1.getTasks().add(task);
    taskRepository.save(task);

  }
}
