package com.coyoapp.tinytask.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Task")
public class Task{

  @Id
  @ApiModelProperty(notes = "The database generated task ID")
  @Column(name="task_id")
  private String id;
  @ApiModelProperty(notes = "The task title", required = true)
  private String title;
  @ApiModelProperty(notes = "The task notes", required = false)
  private String notes;
  @ApiModelProperty(notes = "The task description", required = true)
  private Boolean completed;
  private Boolean starred;
  private Boolean important;
  private Boolean deleted;

  @ManyToMany(fetch = FetchType.LAZY,
    cascade = {
      CascadeType.PERSIST,
      CascadeType.MERGE
    })
  @JoinTable(name = "task_tags",
    joinColumns = { @JoinColumn(name = "task_id") },
    inverseJoinColumns = { @JoinColumn(name = "tag_id") })
  @JsonIgnoreProperties("tasks")
  private Set<Tag> tags = new HashSet<>();

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Boolean getCompleted() {
    return completed;
  }

  public void setCompleted(Boolean completed) {
    this.completed = completed;
  }

  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  public Boolean getStarred() {
    return starred;
  }

  public void setStarred(Boolean starred) {
    this.starred = starred;
  }

  public Boolean getImportant() {
    return important;
  }

  public void setImportant(Boolean important) {
    this.important = important;
  }

  public Boolean getDeleted() {
    return deleted;
  }

  public void setDeleted(Boolean deleted) {
    this.deleted = deleted;
  }

  public Set<Tag> getTags() {
    return tags;
  }

  public void setTags(Set<Tag> tags) {
    this.tags = tags;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Task other = (Task) obj;
    if (title == null) {
      if (other.title != null)
        return false;
    } else if (!title.equals(other.title))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Task [id=" + id + ", title=" + title + ", completed=" + completed + "]";
  }


}
