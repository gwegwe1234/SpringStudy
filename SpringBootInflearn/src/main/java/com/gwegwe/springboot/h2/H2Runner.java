package com.gwegwe.springboot.h2;

import java.sql.Connection;
import java.sql.Statement;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class H2Runner implements ApplicationRunner {

  @Autowired
  DataSource dataSource;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    Connection connection = dataSource.getConnection();
    connection.getMetaData().getURL();
    connection.getMetaData().getUserName();

    System.out.println(connection.getMetaData().getURL() + " " + connection.getMetaData().getUserName());

    Statement statement = connection.createStatement();
    statement.executeUpdate("CREATE TABLE USER(ID INTEGER NOT NULL, name VARCHAR)");
  }
}
