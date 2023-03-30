package com.songplatform.song_login_student.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.songplatform.song_login_student.daomain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao extends BaseMapper<User> {
}
