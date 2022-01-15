package com.cqu.stu_manager.controller;

import com.cqu.stu_manager.mapper.MsgMapper;
import com.cqu.stu_manager.mapper.ReceiveMapper;
import com.cqu.stu_manager.mapper.TeacherMapper;
import com.cqu.stu_manager.pojo.*;
import com.cqu.stu_manager.utils.Result;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class techercontroller {
    @Autowired
    TeacherMapper teacherMapper;
    @Autowired
    MsgMapper msgMapper;

    @PostMapping ("Tea/techerlist")
    public List<Teacher> techerlist()
    {
        List<Teacher> teacherList=teacherMapper.findAllTeacher();
        return teacherList;
    }

    @PostMapping("Tea/findOneTeacher")
    @ResponseBody
    public Result findTechaerById(@RequestBody Teacher your_t){
        Result result = new Result();
        Teacher teacher = teacherMapper.findOneTeacher(your_t.getT_no());
        if(teacher == null){
            result.setMsg("无当前教师信息");
        }
        else{
            result.setData(teacher);
            result.setMsg("成功找到当前教师信息");
        }
        return result;
       }

    @PostMapping("Tea/upDateTeacher")
    @ResponseBody
    public Result upDateTeacher(@RequestBody Teacher your_t){
        Result result = new Result();
        Teacher teacher1 = teacherMapper.findOneTeacher(your_t.getT_no());
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
            teacherMapper.upDateTeacher(teacher1);
            result.setData(teacher1);
            result.setMsg("教师信息更改成功");
        }
        return result;
    }

    @ResponseBody
    @PostMapping("Tea/upDatePassword")
    public Result upDatePassword(@RequestBody upDatePassword your_p){
        Result result = new Result();
        Teacher teacher = teacherMapper.findOneTeacher(your_p.getNo());
        if(teacher == null){
            result.setMsg("当前教师信息不存在");
        }
        else if(teacher.getT_password().equals(your_p.getOld_password())){
            result.setMsg("密码修改成功");
            teacher.setT_password(your_p.getNew_password());
            teacherMapper.upDatePassword(teacher);
            result.setData(teacher);
        }else{
            result.setMsg("原密码输入错误");
        }
        return result;
    }


    @ResponseBody
    @PostMapping("Tea/send_msg")
    public Result sendMsg(@RequestBody Msg msg, @RequestBody MsgReceiver msgReceiver){
        Result result = new Result();
        if(msg==null){
            result.setMsg("当前消息为空");
        }
        else if(msgReceiver == null){
            result.setMsg("请选择消息接收对象");
        }
        else{
            msgMapper.addMsg(msg);
            result.setMsg("发送成功");
            result.setData(msg);
        }
        return result;
    }

    @ResponseBody
    @PostMapping("Tea/test")
    public Result test(@RequestParam(required = false) String string){
        Result result = new Result();
        if(string==null){
            result.setMsg("请输入信息");
        }
        else{
            result.setMsg("接收成功");
            result.setData(string);
        }
        return result;
    }
}
