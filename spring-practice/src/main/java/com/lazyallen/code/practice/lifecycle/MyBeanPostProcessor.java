package com.lazyallen.code.practice.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 在实例化Bean之前，可以设置Bean实例化的前置方法和后置方法
 * @author allen
 * @Date 2019-11-19
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("MyBeanPostProcessor postProcessBeforeInitialization beanName"+beanName+" bean "+ bean.toString());
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("MyBeanPostProcessor postProcessAfterInitialization beanName"+beanName + "bean "+ bean.toString());
		return bean;
	}
}
