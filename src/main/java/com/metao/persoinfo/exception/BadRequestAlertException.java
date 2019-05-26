package com.metao.persoinfo.exception;

import com.metao.persoinfo.util.ErrorConstants;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@Getter
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestAlertException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  private final String entityName;

  private final String errorKey;

  public BadRequestAlertException(String defaultMessage, String entityName, String errorKey) {
    this(ErrorConstants.DEFAULT_TYPE, defaultMessage, entityName, errorKey);
  }

  public BadRequestAlertException(URI type, String defaultMessage, String entityName, String errorKey) {
    super(defaultMessage);
    this.entityName = entityName;
    this.errorKey = errorKey;
  }

  public String getEntityName() {
    return entityName;
  }

  public String getErrorKey() {
    return errorKey;
  }

  private static Map<String, Object> getAlertParameters(String entityName, String errorKey) {
    Map<String, Object> parameters = new HashMap<>();
    parameters.put("message", "error." + errorKey);
    parameters.put("params", entityName);
    return parameters;
  }
}