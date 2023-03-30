package com.songplatform.song_login_student.service;

import com.songplatform.song_login_student.daomain.Student;
import com.songplatform.song_login_student.daomain.Teacher;
import com.songplatform.song_login_student.daomain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TeacherServiceTest {
    @Autowired
    private ITeacherService iTeacherService;
    @Test
    void testRegist(){
        Teacher teacher= new Teacher();
        teacher.setId("T125");
        teacher.setName("王珊");
        teacher.setPassword("780908");
        iTeacherService.regist(teacher);
    }

    @Test
    void testLogin(){
        Teacher teacher= new Teacher();
        teacher.setId("T124");
        teacher.setPassword("550504");
        iTeacherService.login(teacher);
    }
}
