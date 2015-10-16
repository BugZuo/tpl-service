package com.duitang.changeme.server.like.dao;

import com.google.common.collect.Maps;

import com.duitang.changeme.server.like.domain.LikeDO;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.HashMap;

import javax.annotation.Resource;

/**
 * Created by alex on 13/10/15.
 */
@Component
public class LikeDAO {

  @Resource
  private SqlSession writeTpl;

  @Resource
  private SqlSession readTpl;

  @Resource
  private TransactionTemplate transactionTpl;

  public LikeDO findById(int id) {
    return (LikeDO) readTpl.selectOne("like.findById", id);
  }

  public int updateUserIdById(final int id, final int userId) {
    return transactionTpl.execute(new TransactionCallback<Integer>() {
      @Override
      public Integer doInTransaction(TransactionStatus status) {
        HashMap<String, Object> param = Maps.newHashMap();
        param.put("id", id);
        param.put("userId", userId);
        int updateById = writeTpl.update("like.updateById", param);
//                Assert.isNull(param);
        return updateById;
      }
    });
  }
}
