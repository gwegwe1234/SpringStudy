package com.gwegwe.springboot.user;

import lombok.Data;

public class User {

  private String username;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }
}
