package com.lazyallen.code.practice.bean;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author allen
 * @Date 2019-11-25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class AuthorServerTest {

	@Autowired
	private AuthorServer authorServer;

	@Test
	void testAutoConfig(){
		System.out.println(authorServer.getAuthor());
	}

}