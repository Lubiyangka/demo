package com.songplatform.song_login_student.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.songplatform.song_login_student.daomain.Song;

import java.util.List;

public interface ISongService extends IService<Song> {

    boolean vote(Integer id);
    List<Song> limited_list();

    List<Song> sorted_list();
    List<Song> change_list();

    IPage<Song> getPage(int currentPage,int pageSize);
}
