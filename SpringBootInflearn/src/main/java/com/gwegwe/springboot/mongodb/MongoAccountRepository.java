package com.gwegwe.springboot.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoAccountRepository extends MongoRepository<MongoAccount, String> {

}
