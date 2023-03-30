package com.werun.demo_jpa.dao;


import com.werun.demo_jpa.daomain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;

import java.util.List;


public interface UserRepository extends JpaRepository<User,Integer> {
//    @Query(value = "select * from six where id = ?1",nativeQuery = true)
    Page<User> getUserPage(Integer id, Pageable pageable);
//    List<User> findByName(String name);
//    List<User> findByNameAndType(String type,String name);
    User findByEmailAddress(String emailAddress);
    Page<User> findByLastname(String lastname,Pageable pageable);
    Slice<User> findByLastname_1(String lastname, Pageable pageable);
}
