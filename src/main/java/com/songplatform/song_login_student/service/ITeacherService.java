package com.songplatform.song_login_student.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.songplatform.song_login_student.daomain.Teacher;

public interface ITeacherService extends IService<Teacher> {
    boolean regist(Teacher teacher);

    boolean login(Teacher teacher);
}
