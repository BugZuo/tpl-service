package com.duitang.changeme.client.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by alex on 9/10/15.
 */
public class LikeDTO implements Serializable {

  private static final long serialVersionUID = 3155212594511419696L;
  private Long id;
  private Long userId;
  private Long objectId;
  private Date createdDate;
  private Integer category;

  public Integer getCategory() {
    return category;
  }

  public void setCategory(Integer category) {
    this.category = category;
  }

  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getObjectId() {
    return objectId;
  }

  public void setObjectId(Long objectId) {
    this.objectId = objectId;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }
}
