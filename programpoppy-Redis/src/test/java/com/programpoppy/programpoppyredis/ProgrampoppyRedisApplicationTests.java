package com.programpoppy.programpoppyredis;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class ProgrampoppyRedisApplicationTests {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    void contextLoads()  {
        redisTemplate.opsForValue().set("name", "test");
        String name = redisTemplate.opsForValue().get("name");
        System.out.println(name);
    }

}
