package com.in28minutes.spring.basics.componentscan;

import com.in28minutes.spring.basics.springin5steps.scope.JdbcConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ComponentDAO {

  @Autowired
  ComponentJdbcConnection componentJdbcConnection;

  public ComponentJdbcConnection getComponentJdbcConnection() {
    return componentJdbcConnection;
  }

  public void setComponentJdbcConnection(
      ComponentJdbcConnection componentJdbcConnection) {
    this.componentJdbcConnection = componentJdbcConnection;
  }
}
