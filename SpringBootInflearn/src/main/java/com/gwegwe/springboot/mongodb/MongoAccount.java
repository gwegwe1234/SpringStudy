package com.gwegwe.springboot.mongodb;

import javax.persistence.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "accounts")
public class MongoAccount {

  @Id
  private String id;

  private String name;
}
