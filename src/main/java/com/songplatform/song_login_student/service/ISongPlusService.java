package com.songplatform.song_login_student.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.songplatform.song_login_student.daomain.Song;

import java.util.List;

public interface ISongPlusService extends IService<Song> {
    boolean modify_state(Integer id,String state);
    boolean modify_state(List<Integer> id,String state);

    boolean delete(Integer id);
    boolean delete(List<Integer> ids);
    List<Song> select_by_name(String song_name);
    List<Song> change_list();
    Integer select_vote(String name);


}
