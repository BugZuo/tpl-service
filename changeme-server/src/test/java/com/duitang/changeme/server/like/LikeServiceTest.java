package com.duitang.changeme.server.like;

import com.duitang.changeme.client.dto.LikeDTO;
import com.duitang.changeme.client.service.ILikeService;
import com.duitang.changeme.server.BaseTest;

import org.junit.Assert;
import org.junit.Test;

import javax.annotation.Resource;

public class LikeServiceTest extends BaseTest {

  @Resource
  private ILikeService likeService;

  @Test
  public void testFindOne() throws Exception {
    LikeDTO one = likeService.findOne();
    Assert.assertTrue(one != null);
  }
}