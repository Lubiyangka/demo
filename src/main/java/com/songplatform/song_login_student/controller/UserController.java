package com.songplatform.song_login_student.controller;

import com.songplatform.song_login_student.controller.utils.R;
import com.songplatform.song_login_student.daomain.Student;
import com.songplatform.song_login_student.daomain.Teacher;
import com.songplatform.song_login_student.daomain.User;
import com.songplatform.song_login_student.service.IStudentService;
import com.songplatform.song_login_student.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private ITeacherService iTeacherService;
    @Autowired
    private IStudentService iStudentService;
    @PostMapping("/regist/student")
    public R regist(@RequestBody Student student){
        if (student.getClass()==Student.class){
            return new R(iStudentService.regist(student));
        }
        else{
            throw new RuntimeException("注册类型错误");
        }
    }
    @PostMapping("/regist/teacher")
    public R regist(@RequestBody Teacher teacher){
        if (teacher.getClass()==Teacher.class){
            return new R(iTeacherService.regist(teacher));
        }
        else{
            throw new RuntimeException("注册类型错误");
        }
    }
    @PostMapping("/login/student")
    public R login(@RequestBody Student student){
        if (student.getClass()==Student.class){
            return new R(iStudentService.login(student));
        }
        else{
            throw new RuntimeException("登录类型错误");
        }
    }
    @PostMapping("/login/teacher")
    public R login(@RequestBody Teacher teacher){
        if (teacher.getClass()==Teacher.class){
            return new R(iTeacherService.login(teacher));
        }
        else{
            throw new RuntimeException("登录类型错误");
        }
    }
}
