package com.metao.persoinfo;

import com.metao.persoinfo.properties.PersoInfoProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({PersoInfoProperties.class})
public class PersoInfoApplication {

  public static void main(String[] args) {
    SpringApplication.run(PersoInfoApplication.class, args);
  }

}
