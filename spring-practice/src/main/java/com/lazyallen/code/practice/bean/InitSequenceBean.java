package com.lazyallen.code.practice.bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Constructor >autowired > @PostConstruct > InitializingBean > init-method
 * @author allen
 * @Date 2019-11-20
 */
@Component
public class InitSequenceBean implements InitializingBean {

	public InitSequenceBean() {
		System.out.println("InitSequenceBean: constructor");
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("InitSequenceBean: postConstruct");
	}

//	public void initMethod() {
//		System.out.println("InitSequenceBean: init-method");
//	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("InitSequenceBean: afterPropertiesSet");
	}
}
