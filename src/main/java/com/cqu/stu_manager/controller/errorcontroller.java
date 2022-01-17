package com.cqu.stu_manager.controller;

import com.cqu.stu_manager.utils.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class errorcontroller {
    @PostMapping("/error")
    public Result error(){
        Result result=new Result();
        result.setMsg("你正在尝试非法操作，系统将记录在案，请规范使用");
        return result;
    }
}
