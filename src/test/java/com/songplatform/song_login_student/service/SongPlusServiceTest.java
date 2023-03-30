package com.songplatform.song_login_student.service;

import com.songplatform.song_login_student.daomain.Song;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class SongPlusServiceTest {
    @Autowired
    private ISongPlusService iSongPlusService;
    @Test
    void testGetAll_after(){
        iSongPlusService.change_list();
    }
    //error
    @Test
    void testUpdate_audit(){
        iSongPlusService.modify_state(1,"未播放");
    }
    //error
    @Test
    void testUpdate_song_state(){
        List<Integer> idList=new ArrayList<>();
        idList.add(1);
        idList.add(2);
        idList.add(3);
        idList.add(4);
        System.out.println(idList);
        //iSongPlusService.modify_state();
        iSongPlusService.modify_state(idList,"未播放");
    }
    @Test
    void testDelete(){
        List<Integer> idList=new ArrayList<>();
        idList.add(1);
        idList.add(2);
        idList.add(3);
        idList.add(4);
        iSongPlusService.delete(idList);
    }
    @Test
    void testGet_name(){
        iSongPlusService.select_by_name("周");
    }
    @Test
    void testGet_vote(){
        iSongPlusService.select_vote("告白气球");
    }

}
