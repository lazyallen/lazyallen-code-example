package com.lazyallen.code.practice.lifecycle;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author allen
 * @Date 2019-11-19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class MyBeanPostProcessorTest {

	@Autowired
	ApplicationContext applicationContext;

	@Autowired
	MyBeanPostProcessor myBeanPostProcessor;


	@Test
	void test(){
		applicationContext.getBean("apple");
	}

}