package com.songplatform.song_login_student.controller;

import com.songplatform.song_login_student.controller.utils.R;
import com.songplatform.song_login_student.daomain.Song;
import com.songplatform.song_login_student.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/songs")
public class SongController {
    @Autowired
    private ISongService iSongService;
    //添加歌曲
    @PostMapping("/save")
    public R save (@RequestBody Song song){
        return new R(iSongService.save(song));
    }
    //查看可投票结果
    @GetMapping("/before")
    public R getAll_before(){
        return new R(true,iSongService.limited_list());
    }
    //查看投票结果
    @GetMapping("/after")
    public R getAll_after(){
        return new R(true,iSongService.change_list());
    }
    //查看投票结果（排序）
    @GetMapping("/sort")
    public R getAll_sort(){
        return new R(true,iSongService.sorted_list());
    }
    //投票
    @PutMapping("{id}")
    public R update(@PathVariable Integer id){
        return new R(iSongService.vote(id));

    }
    //展示分页
    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage,@PathVariable int pageSize){
        return new R(true,iSongService.getPage(currentPage,pageSize));
    }

}
