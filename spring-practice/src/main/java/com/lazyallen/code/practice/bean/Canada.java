package com.lazyallen.code.practice.bean;

import lombok.Data;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

/**
 *
 * @author allen
 * @Date 2019-11-19
 */
@Data
@Component
public class Canada implements BeanNameAware {
	private String name;

	private String beanName;
	@Override
	public void setBeanName(String s) {
		this.beanName = s;
	}
}
