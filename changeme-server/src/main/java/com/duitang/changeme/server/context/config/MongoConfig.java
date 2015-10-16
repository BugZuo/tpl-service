package com.duitang.changeme.server.context.config;

import com.google.common.collect.Lists;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.net.UnknownHostException;
import java.util.List;

/**
 * Created by alex on 13/10/15.
 */
@Configuration
public class MongoConfig {
  @Value("#{'${mongo.rs1.url}'.split(',')}")
  private List<String> mongors1Urls;

  @Value("${mongo.rs2.url}")
  private List<String> mongors2Url;
  private static int port = 27017;


  @Bean
  public Mongo rs1Mongo() throws UnknownHostException {
    List<ServerAddress> serverAddress = Lists.newArrayList();
    for (String mongors1Url : mongors1Urls) {
      serverAddress.add(new ServerAddress(mongors1Url, port));
    }
    return new MongoClient(serverAddress);
  }

  @Bean
  public MongoTemplate wordDB() throws UnknownHostException {
    return new MongoTemplate(rs1Mongo(), "wordDB");
  }

  @Bean
  public MongoTemplate wechatDB() throws UnknownHostException {
    return new MongoTemplate(rs1Mongo(), "wechat_token");
  }
}
