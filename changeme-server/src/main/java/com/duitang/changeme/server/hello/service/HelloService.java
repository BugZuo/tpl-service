package com.duitang.changeme.server.hello.service;

import com.duitang.changeme.client.dto.HelloDTO;
import com.duitang.changeme.client.service.IHelloService;
import com.duitang.changeme.server.context.annotation.KarmaService;

/**
 * Hello com.duitang.changeme.client.service implementation Created by alex on 29/9/15.
 */

@KarmaService(value = "helloService")
public class HelloService implements IHelloService {
  @Override
  public HelloDTO sayHello() {
    HelloDTO helloDTO = new HelloDTO();
    helloDTO.setContent("hello world");
    return helloDTO;
  }
}
