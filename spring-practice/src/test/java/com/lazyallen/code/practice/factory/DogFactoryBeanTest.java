package com.lazyallen.code.practice.factory;

import com.lazyallen.code.practice.bean.Dog;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author allen
 * @Date 2019-11-20
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class DogFactoryBeanTest {

	@Autowired
	Dog dog;

	@Autowired
	DogFactoryBean dogFactoryBean;

	@Autowired
	ApplicationContext applicationContext;

	@Test
	void test() throws Exception {
		DogFactoryBean dogFactoryBean1 = (DogFactoryBean)applicationContext.getBean("&dogFactoryBean");
		System.out.println(dogFactoryBean1);
		//会new 一个新的bean
		Dog dogFromFactory = dogFactoryBean1.getObject();
		System.out.println(dogFactoryBean1.equals(dogFactoryBean));
		System.out.println(dogFromFactory.equals(dog));

		Dog dog2 = (Dog)applicationContext.getBean("dogFactoryBean");
		System.out.println(dog2.equals(dog));

		System.out.println("dogFactoryBean:---"+dogFactoryBean);
		System.out.println("dogFactoryBeanFromApplicationContext:---"+dogFactoryBean1);
		System.out.println("dog:---"+dog.toString());
		System.out.println("dogFromDogFactoryBean:---"+dogFromFactory.toString());
		System.out.println("dogFromApplicationContext:---"+dog2.toString());
	}

}