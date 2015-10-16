package com.duitang.changeme.server.word.dao;

import com.duitang.changeme.server.word.domain.WordDO;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by alex on 13/10/15.
 */
@Component
public class WordDAO {
  @Resource(name = "wordDB")
  private MongoTemplate wordDB;

  public WordDO findOneByKw(String key) {
    Query query = new Query(Criteria.where("kw").is(key));
    return wordDB.findOne(query, WordDO.class);
  }
}
