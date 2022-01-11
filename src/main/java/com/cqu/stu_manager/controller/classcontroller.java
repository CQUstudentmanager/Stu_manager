package com.cqu.stu_manager.controller;

import com.cqu.stu_manager.mapper.ClassMapper;
import com.cqu.stu_manager.pojo.Class;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class classcontroller {
    @Autowired
    ClassMapper classMapper;
    @GetMapping("/CLASSLIST")
    public List<Class> listclass()
    {
        List<Class>classList=classMapper.findAllClass();
        return classList;
    }
    @GetMapping("/updateclassinfo")
    public String updateclassinfo(){
        Class class_=new Class(1,"ceshi",3);
        int i=classMapper.updateClassinfo(class_);

        return "ok";
    }
}
