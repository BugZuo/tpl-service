package com.duitang.changeme.server.context.config;

import com.duitang.service.karma.message.StdMessageManager;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by alex on 13/10/15.
 */
@Configuration
public class MsgConfig {
  @Bean(initMethod = "init")
  public StdMessageManager stdMessageManager() {
    return new StdMessageManager();
  }
}
