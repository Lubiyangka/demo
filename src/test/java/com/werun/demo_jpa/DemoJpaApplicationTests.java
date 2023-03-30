package com.werun.demo_jpa;

import com.werun.demo_jpa.dao.UserRepository;
import com.werun.demo_jpa.daomain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


@SpringBootTest
class DemoJpaApplicationTests {

    @Autowired
    private UserRepository userRepository;
    @Test
    public void ATest(){
        User user=new User();
        user.setId(4);
        user.setType("男");
        user.setName("王莽");
        userRepository.save(user);
    }
    @Test
    public void BTest(){
        Pageable pageable =PageRequest.of(0,5);
        Page<User> users= userRepository.getUserPage(1,pageable);
        System.out.println(users.getTotalElements());
    }



}
