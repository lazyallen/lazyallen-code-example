package com.lazyallen.code.practice.factory;

import com.lazyallen.code.practice.bean.Dog;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @author allen
 * @Date 2019-11-20
 */
@Component
public class DogFactoryBean implements FactoryBean<Dog> {
	@Override
	public boolean isSingleton() {
		return true;
	}

	@Override
	public Dog getObject() throws Exception {
		return new Dog();
	}

	@Override
	public Class<?> getObjectType() {
		return Dog.class;
	}
}
