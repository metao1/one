package com.coyoapp.tinytask.config;

import com.coyoapp.tinytask.dto.DtoFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SuppressWarnings("unused")
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
  public DtoFactory dtoFactory() {
    return new DtoFactory(getModelMapper(), getObjectMapper());
  }
}
