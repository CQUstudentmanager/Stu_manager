package com.cqu.stu_manager.controller;

import com.cqu.stu_manager.mapper.TeacherMapper;
import com.cqu.stu_manager.pojo.Teacher;
import com.cqu.stu_manager.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class techercontroller {
    @Autowired
    TeacherMapper teacherMapper;

    @PostMapping ("/techerlist")
    public List<Teacher> techerlist()
    {
        List<Teacher> teacherList=teacherMapper.findAllTeacher();
        return teacherList;
    }

    @PostMapping("/findTechaerById")
    @ResponseBody
    public Result findTechaerById(@RequestBody Teacher your_t){
        Result result = new Result();
        Teacher teacher = teacherMapper.findTeacherById(your_t.getT_no());
        if(teacher == null){
            result.setMsg("无当前教师信息");
        }
        else{
            result.setData(teacher);
            result.setMsg("成功找到当前教师信息");
        }
        return result;
       }

    @PostMapping("/upDateTeacherInfo")
    @ResponseBody
    public Result upDateTeacherInfo(@RequestBody Teacher your_t){
        Result result = new Result();
        Teacher teacher1 = teacherMapper.findTeacherById(your_t.getT_no());
        if(teacher1 == null){
            result.setMsg("当前教师信息不存在");
        }
        else {
            if((!your_t.getT_name().equals("String")) && (!your_t.getT_name().equals(teacher1.getT_name()))){
                teacher1.setT_name(your_t.getT_name());
            }
            if((!your_t.getT_telephone().equals("String")) && (!your_t.getT_telephone().equals(teacher1.getT_telephone()))){
                teacher1.setT_telephone(your_t.getT_telephone());
            }
            if((!your_t.getT_officeroom().equals("String")) && (!your_t.getT_officeroom().equals(teacher1.getT_officeroom()))){
                teacher1.setT_officeroom(your_t.getT_officeroom());
            }
            if(your_t.getT_identity()!=0 && your_t.getT_identity()!= teacher1.getT_identity()){
                teacher1.setT_identity(your_t.getT_identity());
            }
            teacherMapper.upDateTeacherInfo(teacher1);
            result.setData(teacher1);
            result.setMsg("教师信息更改成功");
        }
        return result;
    }
}
