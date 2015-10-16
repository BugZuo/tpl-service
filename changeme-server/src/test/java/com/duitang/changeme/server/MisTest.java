package com.duitang.changeme.server;

import com.duitang.service.karma.message.StdMessage;
import com.duitang.service.karma.message.StdMessageManager;

import net.rubyeye.xmemcached.MemcachedClient;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;

/**
 * Created by alex on 13/10/15.
 */
public class MisTest extends BaseTest {
  @Resource
  StdMessageManager stdMessageManager;

  @Resource
  private StringRedisTemplate redisCache;

  @Resource
  private MemcachedClient memCache;

  @Test
  public void testMsg() {
    StdMessage stdMessage = new StdMessage();
    stdMessageManager.send("hi", stdMessage);
  }

  @Test
  public void testRedis() {
    HashOperations<String, String, String> hashCli = redisCache.opsForHash();
    String value = "hello";
    String key = "key_by_yzr";
    String field = "field_by_yzr";
    hashCli.put(key, field, value);
    String s = hashCli.get(key, field);
    Assert.assertTrue(value.equals(s));
  }

  @Test
  public void testMemcahe() throws Exception {
    String key = "key_by_yzr";
    int value = 344;
    memCache.set(key, 5000, value);
    int got = memCache.get(key);
    Assert.assertEquals(value, got);
  }
}
