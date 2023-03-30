package com.werun.demo_jpa.controller;

import com.werun.demo_jpa.controller.util.JpaUtil;
import com.werun.demo_jpa.dao.UserRepository;
import com.werun.demo_jpa.daomain.User;
import com.werun.demo_jpa.service.UserService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/a")
    public void delte(){
        userService.testJpa();
    }


}
