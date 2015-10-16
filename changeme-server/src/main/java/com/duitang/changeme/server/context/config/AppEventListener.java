package com.duitang.changeme.server.context.config;

import com.google.common.collect.Lists;

import com.duitang.changeme.server.context.annotation.KarmaService;
import com.duitang.service.karma.support.ServicesExporter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * deal with com.duitang.changeme.client.service exporter and application event Created by alex on
 * 30/9/15.
 */
public class AppEventListener implements ApplicationListener {
  @Autowired
  ServicesExporter servicesExporter;
  private boolean inited = false;

  public void onApplicationEvent(ApplicationEvent applicationEvent) {
    if (applicationEvent instanceof ContextRefreshedEvent && !inited) {
      ApplicationContext context = (ApplicationContext) applicationEvent.getSource();
      Map<String, Object> beans = context.getBeansWithAnnotation(KarmaService.class);
      Collection<Object> values = beans.values();
      List<Object> services = Lists.newArrayList(values);
      servicesExporter.setServices(services);
      servicesExporter.init();
      inited = true;
    } else if (applicationEvent instanceof ContextClosedEvent) {
      System.out.println("Byebye");
    }
  }
}
