package com.duitang.changeme.server.word.domain;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by alex on 13/10/15.
 */
@Document(collection = "word")
public class WordDO {
  private ObjectId id;
  private String kw;

  public ObjectId getId() {
    return id;
  }

  public void setId(ObjectId id) {
    this.id = id;
  }

  public String getKw() {
    return kw;
  }

  public void setKw(String kw) {
    this.kw = kw;
  }
}
