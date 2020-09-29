package com.gwegwe.springboot.redis;

import org.springframework.data.repository.CrudRepository;

public interface RedisAccountRepository extends CrudRepository<RedisAccount, String> {

  // CRUD Repository를 사용해 Redis 작동
}
