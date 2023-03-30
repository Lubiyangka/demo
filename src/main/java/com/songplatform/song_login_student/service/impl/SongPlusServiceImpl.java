package com.songplatform.song_login_student.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.songplatform.song_login_student.dao.SongDao;
import com.songplatform.song_login_student.daomain.Song;
import com.songplatform.song_login_student.service.ISongPlusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongPlusServiceImpl extends ServiceImpl<SongDao, Song> implements ISongPlusService {
    @Autowired
    private SongDao songDao;
    //修改歌曲状态
    @Override
    public boolean modify_state(Integer id,String state) {
        UpdateWrapper<Song> updateWrapper=new UpdateWrapper<>();
        updateWrapper.eq("id",id)
                .set("song_time",state);
        return songDao.update(null,updateWrapper)>0;
    }
    //批量修改歌曲状态
    @Override
    public boolean modify_state(List<Integer> ids,String state) {

        for (Integer id:ids) {
            UpdateWrapper<Song> updateWrapper=new UpdateWrapper<>();
            updateWrapper.eq("id",id)
                    .set("song_time",state);
            songDao.update(null,updateWrapper);
        }
        return true;
    }
    //假删除歌曲
    @Override
    public boolean delete(Integer id) {
        UpdateWrapper<Song> updateWrapper=new UpdateWrapper<>();
        updateWrapper.eq("id",id)
                .set("song_delete",1);
        return songDao.update(null,updateWrapper)>0;
    }
    //批量删除歌曲
    @Override
    public boolean delete(List<Integer> ids) {
        for (Integer id:ids) {
            UpdateWrapper<Song> updateWrapper=new UpdateWrapper<>();
            updateWrapper.eq("id",id)
                    .set("song_delete",1);
            songDao.update(null,updateWrapper);
        }
        return true;
    }
    //模糊查询
    @Override
    public List<Song> select_by_name(String name) {
        QueryWrapper<Song> queryWrapper =new QueryWrapper<>();
        queryWrapper.like("song_name",name).or()
                .like("singer",name).or()
                .like("platform",name);
        return songDao.selectList(queryWrapper);
    }
    //查看歌曲
    @Override
    public List<Song> change_list() {
        QueryWrapper<Song> wrapper=new QueryWrapper<>();
        wrapper.eq("song_delete",0);
        return songDao.selectList(wrapper);
    }
    //查询歌曲
    @Override
    public Integer select_vote(String song_name) {
        QueryWrapper<Song> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("song_name",song_name);
        Song song=songDao.selectOne(queryWrapper);
        return song.getSongVote();
    }

}
