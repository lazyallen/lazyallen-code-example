package com.lazyallen.code.practice.bean;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author allen
 * @Date 2019-11-20
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class InitSequenceBeanTest {

	@Autowired
	InitSequenceBean initSequenceBean;

	@Test
	void test(){
		System.out.println("test");
	}



}