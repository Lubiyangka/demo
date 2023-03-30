package com.songplatform.song_login_student.service;

import com.songplatform.song_login_student.daomain.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentServiceTest {
    @Autowired
    private IStudentService iStudentService;
    @Test
    void testRegist(){
        Student student=new Student();
        student.setId("hit128");
        student.setName("小夫");
        student.setPassword("030101");
        student.setClassNumber("B1");
        iStudentService.regist(student);
    }
    @Test
    void testLogin(){
        Student student=new Student();
        student.setId("hit125");
        //student.setName("静香");
        student.setPassword("030625");
        //student.setClassNumber("B3");
        iStudentService.login(student);
    }
}
