package com.songplatform.song_login_student.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.songplatform.song_login_student.daomain.Song;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SongServiceTest {

    @Autowired
    private ISongService iSongService;
    //pass
    @Test
    void testSave(){
        Song song=new Song();
        song.setSongName("暗恋是一个人的事");
        song.setSinger("宿阳羽");
        song.setPlatform("网易云");
        iSongService.save(song);
    }
    //pass
    @Test
    void testGetAll_before(){
        iSongService.limited_list();
    }
    //pass
    @Test
    void testGetAll_after(){
        iSongService.change_list();
    }
    //pass
    @Test
    void testGetAll_sort(){
        iSongService.sorted_list();
    }
    //error
    @Test
    void testUpdate(){
        iSongService.vote(3);
    }
    //pass
    @Test
    void testGetPage(){
        IPage<Song> page = new Page<Song>(1,5);
        iSongService.page(page);
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        System.out.println(page.getRecords());
    }
}
