package com.lazyallen.code.mybatisplus.mapper;

import com.lazyallen.code.mybatisplus.entity.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

	@Autowired
	private UserMapper userMapper;

	@Test
	public void testInsert() {
		System.out.println(("----- insert method test ------"));
		User user = new User();
		user.setName("test");
		user.setSex(Boolean.FALSE);
		userMapper.insert(user);
		Assert.assertNotNull(user.getCode());
		Assert.assertNotNull(user.getId());

	}

}