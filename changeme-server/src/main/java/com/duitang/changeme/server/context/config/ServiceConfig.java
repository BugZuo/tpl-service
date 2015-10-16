package com.duitang.changeme.server.context.config;

import com.duitang.service.karma.support.NodeRegister;
import com.duitang.service.karma.support.ServicesExporter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 服务暴露与节点注册 Created by alex on 29/9/15.
 */

@Configuration
public class ServiceConfig {

  @Value("${server.servicePort}")
  private int servicePort;
  @Value("${server.name}")
  private String appName;
  @Value("${server.maxQueueLatency}")
  private int maxQueueLatency;

  @Bean(destroyMethod = "halt")
  public ServicesExporter servicesExporter() {
    final ServicesExporter servicesExporter = new ServicesExporter();
    servicesExporter.setPort(servicePort);
    servicesExporter.setMaxQueuingLatency(maxQueueLatency);
    return servicesExporter;
  }

  @Bean(initMethod = "init")
  public NodeRegister nodeRegister() {
    NodeRegister nodeRegister = new NodeRegister();
    nodeRegister.setAppName(appName);
    nodeRegister.setServicesExporter(servicesExporter());
    return nodeRegister;
  }

  @Bean
  public AppEventListener applicationListenerBean() {
    return new AppEventListener();
  }
}
