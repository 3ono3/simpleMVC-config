package com.oa.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
/**
 * @author GuoJingyuan
 * @date 2019/8/27
 */
public class RedisTest {

    private RedisTemplate redisTemplate;
    @Before
    public void loadProperties() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/redis.xml");
        redisTemplate = (RedisTemplate) applicationContext.getBean("redisTemplate");
    }
    @Test
    public void testRedis() {

        ValueOperations<String, String> h = redisTemplate.opsForValue();
        h.set("hh","hh");
        System.out.println(redisTemplate.hasKey("hh"));
        redisTemplate.delete("hh");

    }
}
