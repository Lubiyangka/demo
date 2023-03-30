package com.songplatform.song_login_student.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.songplatform.song_login_student.dao.SongDao;
import com.songplatform.song_login_student.daomain.Song;
import com.songplatform.song_login_student.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SongServiceImpl extends ServiceImpl<SongDao, Song> implements ISongService {
    @Autowired
    private SongDao songDao;

    @Override
    public boolean vote(Integer id) {
        UpdateWrapper<Song> updateWrapper=new UpdateWrapper<>();
        updateWrapper.eq("id",id);
        Song song=songDao.selectOne(updateWrapper);
        updateWrapper.set("song_vote",song.getSongVote()+1);
        return songDao.update(null,updateWrapper)>0;
    }

    @Override
    public List<Song> limited_list() {
        QueryWrapper<Song> wrapper=new QueryWrapper<>();
        wrapper.eq("song_time","未播放")
                .eq("song_delete",0);
        return songDao.selectList(wrapper);
    }

    @Override
    public List<Song> sorted_list() {
        QueryWrapper<Song> wrapper=new QueryWrapper<>();
        wrapper.orderByDesc("song_vote")
                .ne("song_time","未审核")
                .eq("song_delete",0);
        return songDao.selectList(wrapper);
    }

    @Override
    public List<Song> change_list() {
        QueryWrapper<Song> wrapper=new QueryWrapper<>();
        wrapper.ne("song_time","未审核")
                .eq("song_delete",0);
        return songDao.selectList(wrapper);
    }

    @Override
    public IPage<Song> getPage(int currentPage, int pageSize) {
        IPage page =new Page(currentPage,pageSize);
        songDao.selectPage(page,null);
        return null;
    }

}
