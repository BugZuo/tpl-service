package com.duitang.changeme.server.word;

import com.duitang.changeme.server.BaseTest;
import com.duitang.changeme.server.word.domain.WordDO;
import com.duitang.changeme.server.word.dao.WordDAO;

import org.junit.Assert;
import org.junit.Test;

import javax.annotation.Resource;

public class wordDAOTest extends BaseTest {
  @Resource
  private WordDAO wordDAO;

  @Test
  public void testFindOneByKw() throws Exception {
    WordDO word = wordDAO.findOneByKw("乳晕");
    Assert.assertTrue(word != null);
  }
}