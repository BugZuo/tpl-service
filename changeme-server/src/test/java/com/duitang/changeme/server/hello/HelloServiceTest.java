package com.duitang.changeme.server.hello;

import com.duitang.changeme.client.service.IHelloService;
import com.duitang.changeme.server.BaseTest;

import org.junit.Test;

import javax.annotation.Resource;

public class HelloServiceTest extends BaseTest {

  @Resource
  private IHelloService helloService;

  @Test
  public void testSayHello() throws Exception {
    helloService.sayHello();
  }
}