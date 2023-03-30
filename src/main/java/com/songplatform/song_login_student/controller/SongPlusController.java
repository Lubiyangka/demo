package com.songplatform.song_login_student.controller;

import com.songplatform.song_login_student.controller.utils.R;
import com.songplatform.song_login_student.service.ISongPlusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/songs_plus")
public class SongPlusController {
    @Autowired
    private ISongPlusService iSongPlusService;


    //查看投票结果
    @GetMapping("/after")
    public R getAll_after(){
        return new R(true,iSongPlusService.change_list());
    }


    //审核
    @PutMapping("/audit/{id}")
    public R update_audit(@PathVariable Integer id){
        return new R(iSongPlusService.modify_state(id,"未播放"));
    }
    @PutMapping("/audit/batch")
    public R update_audit(@RequestParam(value = "id") List<Integer> id){
        return new R(iSongPlusService.modify_state(id,"未播放"));
    }


    //修改歌曲状态
    @PutMapping("/state/{id}")
    public R update_song_state(@PathVariable Integer id){
        return new R(iSongPlusService.modify_state(id,"已播放"));
    }
    @PutMapping("/state/batch")
    public R update_song_state(@RequestParam(value = "id") List<Integer> id){
        return new R(iSongPlusService.modify_state(id,"已播放"));
    }


    //删除
    @DeleteMapping("/delete/{id}")
    public R delete(@PathVariable Integer id){
        return new R(iSongPlusService.delete(id));
    }


    //模糊查询（依赖歌曲名，歌手，播放平台）
    @GetMapping("/query")
    public R get_name(@RequestBody String name){
        return new R(true,iSongPlusService.select_by_name(name));
    }


    //查询歌曲
    @GetMapping("/query_vote")
    public R get_vote(@RequestBody String song_name){
        return new R(true,iSongPlusService.select_vote(song_name));
    }

}
