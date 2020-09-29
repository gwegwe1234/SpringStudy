package com.gwegwe.springboot.jpa;

import static org.assertj.core.api.Assertions.assertThat;

import javax.sql.DataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class JpaTest {

  @Autowired
  DataSource dataSource;

  @Autowired
  JdbcTemplate jdbcTemplate;

  @Autowired
  AccountRepository accountRepository;

  @Test
  public void di() {
    Account account = new Account();
    account.setUsername("name");

    Account account1 = accountRepository.save(account);

    assertThat(account1).isNotNull();
  }
}
