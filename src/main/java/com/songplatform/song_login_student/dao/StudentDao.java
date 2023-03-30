package com.songplatform.song_login_student.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.songplatform.song_login_student.daomain.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentDao extends BaseMapper<Student> {
//    @Select("select * from user_student_loginbook where id = #{id}")
//    Student getById(String id);
}
