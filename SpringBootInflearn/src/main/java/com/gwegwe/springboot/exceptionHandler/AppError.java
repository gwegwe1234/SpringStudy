package com.gwegwe.springboot.exceptionHandler;

public class AppError {

  String reason;
  String message;

  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
