package com.ljc.learning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final RoleService roleService;

	@Autowired
    public UserService(RoleService roleService) {
        System.out.println("user construct");
        this.roleService = roleService;
    }

    public void toSay() {
        roleService.say();
    }
    public void say() {
        System.out.println("user say");
    }
}
