package com.coyoapp.tinytask.dto;

import javax.xml.bind.annotation.XmlRootElement;

import com.google.common.base.Objects;
import lombok.Getter;

@XmlRootElement
@Getter
public class TaskDTO {
  public String id;
  public String title;
  public String notes;
  public Boolean completed;
  public Boolean starred;
  public Boolean important;
  public Boolean deleted;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    TaskDTO taskDTO = (TaskDTO) o;
    return Objects.equal(id, taskDTO.id);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id);
  }
}
