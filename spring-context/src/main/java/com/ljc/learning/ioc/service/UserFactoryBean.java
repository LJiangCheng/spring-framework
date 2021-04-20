package com.ljc.learning.ioc.service;

import com.ljc.learning.ioc.bean.User;
import org.springframework.beans.factory.SmartFactoryBean;
import org.springframework.stereotype.Component;

@Component
public class UserFactoryBean implements SmartFactoryBean<User> {

	@Override
	public User getObject() throws Exception {
		return new User("FactoryUser", 11);
	}

	@Override
	public Class<?> getObjectType() {
		return User.class;
	}

	@Override
	public boolean isEagerInit() {
		return true;
	}
}
