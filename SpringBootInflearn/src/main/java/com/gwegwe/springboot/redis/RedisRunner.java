package com.gwegwe.springboot.redis;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

@Component
public class RedisRunner implements ApplicationRunner {

  // 스프링에서 지원해주는 레디스 템플릿
  @Autowired
  StringRedisTemplate stringRedisTemplate;

  @Autowired
  RedisAccountRepository redisAccountRepository;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    ValueOperations<String, String> values = stringRedisTemplate.opsForValue();
    values.set("name", "biglight");

    RedisAccount account = new RedisAccount();
    account.setId("id");
    account.setName("name");

    redisAccountRepository.save(account);

    Optional<RedisAccount> byid = redisAccountRepository.findById("id");
    System.out.println(byid.get().getName());
  }
}
