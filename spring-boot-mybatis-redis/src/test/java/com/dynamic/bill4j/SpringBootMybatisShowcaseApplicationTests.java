package com.dynamic.bill4j;

import com.dynamic.bill4j.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.Serializable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMybatisShowcaseApplicationTests {

	private static final Logger logger = LoggerFactory.getLogger(SpringBootMybatisShowcaseApplicationTests.class);

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Autowired
	private RedisTemplate<String, Serializable> redisCacheTemplate;


	@Test
	public void get() {
		// TODO 测试线程安全
		ExecutorService executorService = Executors.newFixedThreadPool(1000);
		IntStream.range(0, 1000).forEach(i ->
				executorService.execute(() -> stringRedisTemplate.opsForValue().increment("kk", 1))
		);
		stringRedisTemplate.opsForValue().set("k1", "v1");
		final String k1 = stringRedisTemplate.opsForValue().get("k1");
		logger.info("[字符缓存结果] - [{}]", k1);
		// TODO 以下只演示整合，具体Redis命令可以参考官方文档，Spring Data Redis 只是改了个名字而已，Redis支持的命令它都支持
		String key = "bill:user:1";
		User user = new User();
		user.setPhoneNumber("12343434");
		user.setId(123);
		user.setEmail("1324*123");
		user.setAge(23);
		user.setUsername("bill");
		redisCacheTemplate.opsForValue().set(key, user);
		// TODO 对应 String（字符串）
		final User user2 = (User) redisCacheTemplate.opsForValue().get(key);
		logger.info("[对象缓存结果] - [{}]", user2);
	}

}
