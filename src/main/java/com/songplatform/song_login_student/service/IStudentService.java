package com.songplatform.song_login_student.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.songplatform.song_login_student.daomain.Student;

public interface IStudentService extends IService<Student> {

    boolean regist(Student student);

    boolean login(Student student);
}
