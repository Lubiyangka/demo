package com.songplatform.song_login_student.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.songplatform.song_login_student.daomain.Teacher;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TeacherDao extends BaseMapper<Teacher> {
}
