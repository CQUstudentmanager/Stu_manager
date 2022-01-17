package com.cqu.stu_manager.controller;

import com.cqu.stu_manager.mapper.ClassMapper;
import com.cqu.stu_manager.pojo.Class;
import com.cqu.stu_manager.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class classcontroller {
    @Autowired
    ClassMapper classMapper;

    @PostMapping("/classlist")
    public List<Class> listclass()
    {
        List<Class>classList=classMapper.findAllClass();
        return classList;
    }

    @PostMapping("/updateclassinfo")
    public Result updateclassinfo(@RequestBody Class class_){
        int i=classMapper.updateClassinfo(class_);
        Result result=new Result();
        result.setMsg(i+"个班级已经修改完成");
        return result;


    }
    @PostMapping("/insertclass")
    public Result insertclass(@RequestBody Class class_){
        int i=classMapper.insertClass(class_);
        Result result=new Result();
        result.setMsg(class_.getClass_name()+"添加成功");
        return result;
    }

}
