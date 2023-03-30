package com.songplatform.song_login_student.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.songplatform.song_login_student.dao.TeacherDao;
import com.songplatform.song_login_student.daomain.Teacher;
import com.songplatform.song_login_student.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherDao, Teacher> implements ITeacherService {

    @Autowired
    private TeacherDao teacherDao;
    @Override
    public boolean regist(Teacher teacher) {
        //检查工号是否重复
        QueryWrapper<Teacher> wrapper=new QueryWrapper<>();
        wrapper.eq("id",teacher.getId());
        Teacher one = super.getOne(wrapper);
        if(one != null){
            throw new RuntimeException("已注册");
        }
        //注册
        return teacherDao.insert(teacher)>0;
    }

    @Override
    public boolean login(Teacher teacher) {
        QueryWrapper<Teacher> wrapper=new QueryWrapper<>();
        wrapper.eq("id",teacher.getId());
        Teacher one_id=super.getOne(wrapper);
        if(one_id == null){
            throw new RuntimeException("无注册信息");
        }
        else {
            wrapper.eq("password",teacher.getPassword());
            Teacher one_pw=super.getOne(wrapper);
            if(one_pw == null){
                throw  new RuntimeException("密码错误");
            }
        }
        return true;
    }
}
