package com.coyoapp.tinytask.dto;

import javax.xml.bind.annotation.XmlRootElement;
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

}
