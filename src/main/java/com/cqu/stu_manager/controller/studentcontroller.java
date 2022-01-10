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
}
