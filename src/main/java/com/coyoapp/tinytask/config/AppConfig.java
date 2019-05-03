package com.coyoapp.tinytask.config;

import com.coyoapp.tinytask.dto.TaskFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

  @Bean
  public ObjectMapper getObjectMapper() {
    return new ObjectMapper();
  }

  @Bean
  public ModelMapper getModelMapper() {
    return new ModelMapper();
  }

  @Bean
  public TaskFactory dtoFactory() {
    return new TaskFactory(getModelMapper(), getObjectMapper());
  }
}
