package com.gwegwe.springboot.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public class MongoRunner implements ApplicationRunner {

  @Autowired
  MongoTemplate mongoTemplate;

  @Autowired
  MongoRepository mongoRepository;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    MongoAccount mongoAccount = new MongoAccount();
    mongoAccount.setId("id22");
    mongoAccount.setName("name");

    mongoTemplate.insert(mongoAccount);

//    결과 :
//    > db.accounts.find()
//    { "_id" : "id", "name" : "name", "_class" : "com.gwegwe.springboot.mongodb.MongoAccount" }

    MongoAccount mongoAccount1 = new MongoAccount();
    mongoAccount1.setId("mongo");
    mongoAccount1.setName("mongo2");
    mongoRepository.insert(mongoAccount1);

  }
}
