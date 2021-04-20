package com.ljc.learning.ioc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
    private RoleService roleService;

    public UserService(/*RoleService roleService*/) {
        System.out.println("user construct");
        /*this.roleService = roleService;*/
    }

	/*@PostConstruct
	private void post() {
		roleService.say();
	}*/

    public void toSay() {
        roleService.say();
    }
    public void say() {
        System.out.println("user say");
    }
}
