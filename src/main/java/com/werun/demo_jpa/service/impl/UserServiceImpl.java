package com.werun.demo_jpa.service.impl;

import com.werun.demo_jpa.dao.UserRepository;
import com.werun.demo_jpa.daomain.User;
import com.werun.demo_jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    public void testJpa(){
        userRepository.deleteAll();
        userRepository.findAll();
        userRepository.findByEmailAddress("kk@qq.com");
        Page<User> users=userRepository.findByLastname("jk", PageRequest.of(1,20));
        Slice<User> users_1=userRepository.findByLastname_1("jk",PageRequest.of(1,20));

    }
}
