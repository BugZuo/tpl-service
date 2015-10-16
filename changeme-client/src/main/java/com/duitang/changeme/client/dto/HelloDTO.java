package com.duitang.changeme.client.dto;

import java.io.Serializable;

/**
 * Created by alex on 29/9/15.
 */
public class HelloDTO implements Serializable {
  private static final long serialVersionUID = -3932624205012731108L;
  String content;

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }
}
