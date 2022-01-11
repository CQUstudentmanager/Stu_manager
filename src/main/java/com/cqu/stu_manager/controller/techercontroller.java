package com.cqu.stu_manager.controller;

import com.cqu.stu_manager.mapper.TeacherMapper;
import com.cqu.stu_manager.pojo.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class techercontroller {
    @Autowired
    TeacherMapper teacherMapper;
    @GetMapping("/techerlist")
    public List<Teacher> techerlist()
    {
        List<Teacher> teacherList=teacherMapper.findAllTeacher();
        return teacherList;
    }

    @GetMapping("/findTechaerById")
    public Teacher findTechaerById(){
        Teacher teacher=teacherMapper.findTechaerById(1);
        return teacher;
    }
}
