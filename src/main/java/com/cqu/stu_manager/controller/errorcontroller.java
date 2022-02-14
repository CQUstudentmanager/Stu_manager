package com.cqu.stu_manager.controller;

import com.cqu.stu_manager.utils.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class errorcontroller {
    @PostMapping("/Unauthorizeerror")
    public Result error(){
        Result result=new Result();
        result.setMsg("你正在尝试非法操作，系统将记录，请规范使用");
        return result;
    }
    @GetMapping("/Unauthorizeerror")
    public Result error1(){
        Result result=new Result();
        result.setMsg("你正在尝试非法操作，系统将记录，请规范使用");
        return result;
    }
}
