package com.lazyallen.code.practice.bean;

import lombok.Data;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * afterPropertiesSet。这个方法会在bean的所有提供的属性被设置之后，被BeanFactory调用，是spring保留的一个扩展点。
 * @author allen
 * @Date 2019-11-19
 */
@Data
@Component
public class Apple implements InitializingBean {

	String id;

	String name;

	@Value("1")
	public void setId(String id) {
		this.id = id;
	}

	@Value("apple")
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Apple Bean afterPropertiesSet");
	}
}
