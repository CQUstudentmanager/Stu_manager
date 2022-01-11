package com.cqu.stu_manager.controller;

import com.cqu.stu_manager.mapper.StudentMapper;
import com.cqu.stu_manager.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class studentcontroller {
    @Autowired
    StudentMapper studentMapper;
    @GetMapping("/STUDENTLIST")

    public List<Student> students(){
        List<Student> studentlist=studentMapper.findAllStudent();
        return studentlist;
    }
    @GetMapping("/updatestudent")
    public String updatestudent(){
        Student student=new Student(1231234, " ","张三",0,"1","1995-12-26","汉族","四川成都",522321,"党员","2021",1,135959002,122706559,"ch@163","重庆大学","WU");
        int i= studentMapper.upDatestudentinfo(student);
        return "ok";
    }
}
