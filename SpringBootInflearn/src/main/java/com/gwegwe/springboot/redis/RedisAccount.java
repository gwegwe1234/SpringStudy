package com.gwegwe.springboot.redis;

import javax.persistence.Id;
import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

@Data
@RedisHash("accounts")
public class RedisAccount {

  @Id
  private String id;

  private String name;
}
