package com.gwegwe.springboot.mogodb;

import static org.assertj.core.api.Assertions.assertThat;

import com.gwegwe.springboot.mongodb.MongoAccount;
import com.gwegwe.springboot.mongodb.MongoAccountRepository;
import java.util.Optional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

// 몽고 디비 테스트.
// 슬라이싱 테스트 @DataMongoTest를 사용이 가능하다.
@RunWith(SpringRunner.class)
@DataMongoTest
public class MogoAccountRepositoryTest {

  @Autowired
  MongoAccountRepository mongoAccountRepository;

  @Test
  public void findById() {
    MongoAccount mongoAccount = new MongoAccount();
    mongoAccount.setId("id");
    mongoAccount.setName("name");

    mongoAccountRepository.save(mongoAccount);

    Optional<MongoAccount> byId = mongoAccountRepository.findById("id");
    assertThat(byId).isNotEmpty();
    assertThat(byId.get().getName()).isEqualTo("name");
  }

}
