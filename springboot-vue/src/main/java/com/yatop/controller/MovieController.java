package com.yatop.controller;

import com.yatop.modal.Movie;
import com.yatop.util.ResponseMessage;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movie")
@CrossOrigin("*")
public class MovieController {

    @GetMapping
    public ResponseMessage getMovie(){
        List<Movie> list = new ArrayList<Movie>();
        for(int i=0;i<16;i++){
            list.add(new Movie(""+i+"",""+(90+i)+"","2018-09-01","郭德纲"));
        }
        return ResponseMessage.success(list);
    }

    @PostMapping("/newMovie")
    public ResponseMessage newMovie(@RequestBody Movie movie){
        //模拟保存
        return ResponseMessage.success("保存成功");
    }

    /**
     * 修改回显
     * @param id
     * @return
     */
    @GetMapping("/editMovie/{id}")
    public ResponseMessage editMovie(@PathVariable String id){
        //模拟找到了id 电影对象
        return ResponseMessage.success(new Movie("1","91","2018-09-01","郭德纲"));
    }

    /**
     * 修改保存
     * @param movie
     * @return
     */
    @PutMapping("/editMovie")
    public ResponseMessage edit(@RequestBody Movie movie){
        //模拟修改成功
        return ResponseMessage.success("修改成功");
    }

    @PostMapping("/delete/{id}")
    public ResponseMessage delete(@PathVariable String id){
        //模拟删除成功
        return ResponseMessage.success("删除成功");
    }
}
