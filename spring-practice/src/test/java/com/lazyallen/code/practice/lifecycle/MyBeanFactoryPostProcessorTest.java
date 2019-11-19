package com.lazyallen.code.practice.lifecycle;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author allen
 * @Date 2019-11-19
 */

@RunWith(SpringRunner.class)
@SpringBootTest
class MyBeanFactoryPostProcessorTest {

	@Autowired
	MyBeanFactoryPostProcessor myBeanFactoryPostProcessor;

	@Autowired
	ApplicationContext applicationContext;

	@Test
	void postProcessBeanFactory() {
		ConfigurableListableBeanFactory configurableListableBeanFactory = (ConfigurableListableBeanFactory)applicationContext.getAutowireCapableBeanFactory();
		BeanDefinition appleBeanDefinition = configurableListableBeanFactory.getBeanDefinition("apple");
		System.out.println(appleBeanDefinition.getScope());
	}
}