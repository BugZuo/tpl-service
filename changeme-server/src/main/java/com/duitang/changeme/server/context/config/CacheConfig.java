package com.duitang.changeme.server.context.config;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.command.KestrelCommandFactory;
import net.rubyeye.xmemcached.utils.AddrUtil;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;

/**
 * Created by alex on 13/10/15.
 */
@Configuration
public class CacheConfig {

  @Value("${redis.cache.host}")
  private String cacheHost;
  @Value("${redis.cache.port}")
  private int cachePort;
  @Value("${memcache.rs1.url}")
  private String memcacheUrl;

  private int cacheDB = 0;


  private static JedisPoolConfig createPoolConfig() {
    JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
    jedisPoolConfig.setMaxTotal(50);
    jedisPoolConfig.setMaxIdle(20);
    jedisPoolConfig.setMaxWaitMillis(3000);
//        for twemproxy
    jedisPoolConfig.setTestOnBorrow(false);
//        for twemproxy
    jedisPoolConfig.setTestWhileIdle(false);
    return jedisPoolConfig;
  }

  @Bean
  public JedisConnectionFactory cacheFactory() {
    JedisConnectionFactory fact = new JedisConnectionFactory(createPoolConfig());
    fact.setUsePool(true);
    fact.setHostName(cacheHost);
    fact.setPort(cachePort);
    fact.setDatabase(cacheDB);
    return fact;
  }

  @Bean
  public StringRedisTemplate redisCache() {
    return new StringRedisTemplate(cacheFactory());
  }

  @Bean(destroyMethod = "shutdown")
  public MemcachedClient memCache() throws IOException {
    MemcachedClientBuilder builder = new XMemcachedClientBuilder(AddrUtil.getAddresses(memcacheUrl),
        new int[]{1});
    builder.setCommandFactory(new KestrelCommandFactory());
    return builder.build();
  }
}
