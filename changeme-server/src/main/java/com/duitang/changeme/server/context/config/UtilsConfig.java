package com.duitang.changeme.server.context.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by alex on 9/10/15.
 */
@Configuration
public class UtilsConfig {
  @Bean
  public ModelMapper modelMapper() {
    return new ModelMapper();
  }
}
