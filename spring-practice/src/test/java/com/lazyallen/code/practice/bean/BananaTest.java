package com.lazyallen.code.practice.bean;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author allen
 * @Date 2019-11-19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class BananaTest {

	@Autowired
	Banana banana;

	@Test
	void test(){
		BeanFactory beanFactory = banana.getBeanFactory();
		Banana banana1 = (Banana)beanFactory.getBean("banana");
		System.out.println(banana1.equals(banana));
	}

}