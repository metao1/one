package com.metao.persoinfo.config;

import com.metao.persoinfo.dto.FilterDTO;
import com.metao.persoinfo.dto.ObjectFactory;
import com.metao.persoinfo.entity.Tag;
import com.metao.persoinfo.entity.Task;
import com.metao.persoinfo.repository.FilterRepository;
import com.metao.persoinfo.repository.TagRepository;
import com.metao.persoinfo.repository.TaskRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.*;

@Configuration
public class DBInitializeConfig {

  @Autowired
  private TaskRepository taskRepository;

  @Autowired
  private TagRepository tagRepository;

  @Autowired
  private FilterRepository filterRepository;

  @Autowired
  ObjectFactory objectFactory;

  @PostConstruct
  public void initialize() {
    Set<Tag> tags = new HashSet<>();
    Tag tag1 = new Tag();
    tag1.setTitle("Backend");
    tag1.setId(UUID.randomUUID().toString());
    tag1.setColor("#3c3c3c");
    tag1.setHandle("backend");
    tags.add(tag1);
    Tag tag2 = new Tag();
    tag2.setTitle("Frontend");
    tag2.setId(UUID.randomUUID().toString());
    tag2.setColor("#723f32");
    tag2.setHandle("frontend");
    tags.add(tag2);

    tagRepository.save(tag2);

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

    String filters = "[{\"id\":\"0\",\"handle\":\"starred\",\"title\":\"Starred\",\"icon\":\"star\"},{\"id\":\"1\",\"handle\":\"important\",\"title\":\"Priority\",\"icon\":\"error\"},{\"id\":\"2\",\"handle\":\"dueDate\",\"title\":\"Sheduled\",\"icon\":\"schedule\"},{\"id\":\"3\",\"handle\":\"today\",\"title\":\"Today\",\"icon\":\"today\"},{\"id\":\"4\",\"handle\":\"completed\",\"title\":\"Done\",\"icon\":\"check\"},{\"id\":\"5\",\"handle\":\"deleted\",\"title\":\"Deleted\",\"icon\":\"delete\"}]";

    List<FilterDTO> filterList = objectFactory.fromJSON(new TypeReference<List<FilterDTO>>() {
    }, filters);

    assert filterList != null;

    for (FilterDTO filter : filterList) {
      filterRepository.save(objectFactory.buildFilter(filter));
    }
  }
}


