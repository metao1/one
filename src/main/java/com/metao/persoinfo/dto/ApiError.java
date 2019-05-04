package com.metao.persoinfo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;
import org.springframework.http.HttpStatus;

import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Getter
@XmlRootElement
public class ApiError {

  @JsonProperty
  private HttpStatus status;
  @JsonFormat(shape = JsonFormat.Shape.NUMBER)
  private Date timestamp;
  @Length(min = 0, max = 50)
  private String message;
  private String debugMessage;

  private ApiError() {
    timestamp = new Date();
  }

  public ApiError(HttpStatus status) {
    this();
    this.status = status;
  }

  public ApiError(HttpStatus status, String ex) {
    this();
    this.status = status;
    this.message = ex;
  }

  public ApiError(HttpStatus status, String message, Throwable ex) {
    this();
    this.status = status;
    this.message = message;
    this.debugMessage = ex.getLocalizedMessage();
  }
}
