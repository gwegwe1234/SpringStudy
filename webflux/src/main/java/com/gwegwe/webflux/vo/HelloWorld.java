package com.gwegwe.webflux.vo;

public class HelloWorld {
  private long id;
  private String title;
  private String message;

  public HelloWorld() {
  }

  public HelloWorld(long id, String title, String message) {
    this.id = id;
    this.title = title;
    this.message = message;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
