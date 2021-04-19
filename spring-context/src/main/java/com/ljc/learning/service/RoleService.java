package com.ljc.learning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

	@Autowired
    private UserService userService;

    public RoleService(/*UserService userService*/) {
        System.out.println("role construct");
        /*this.userService = userService;*/
    }

    public void say() {
        System.out.println("role say");
        userService.say();
    }
}
