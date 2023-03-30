package com.songplatform.song_login_student.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.songplatform.song_login_student.dao.StudentDao;
import com.songplatform.song_login_student.daomain.Student;
import com.songplatform.song_login_student.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentDao, Student> implements IStudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public boolean regist(Student student) {
        //检查学号是否重复
        QueryWrapper<Student> wrapper=new QueryWrapper<>();
        wrapper.eq("id", student.getId());
        Student one = super.getOne(wrapper);
        if(one != null){
            throw new RuntimeException("已注册");
        }
        //注册
        return studentDao.insert(student)>0;
    }

    @Override
    public boolean login(Student student) {
        QueryWrapper<Student> wrapper=new QueryWrapper<>();
        wrapper.eq("id", student.getId());
        //wrapper.eq("password",student.getPassword());
        Student one_id=super.getOne(wrapper);
        if(one_id == null){
            throw new RuntimeException("无注册信息");
        }
        else {
            wrapper.eq("password", student.getPassword());
            Student one_pw=super.getOne(wrapper);
            if(one_pw == null){
                throw  new RuntimeException("密码错误");
            }
        }
        return true;
    }
}
