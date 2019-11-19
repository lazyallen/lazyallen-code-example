package com.lazyallen.code.practice.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * 在容器实例化之前，可以去修改Bean的定义类 BeanDefinition
 * @author allen
 * @Date 2019-11-19
 */
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
		System.out.println("MyBeanFactoryPostProcessor postProcessBeanFactory");
		BeanDefinition appleBeanDefinition = configurableListableBeanFactory.getBeanDefinition("apple");
		appleBeanDefinition.setScope("prototype");
		System.out.println(appleBeanDefinition.getPropertyValues().toString());
	}
}
