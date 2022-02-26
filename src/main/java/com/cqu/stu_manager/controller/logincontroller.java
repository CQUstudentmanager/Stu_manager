package com.cqu.stu_manager.controller;


import cn.hutool.log.Log;
import com.cqu.stu_manager.excel.StudentRead;
import com.cqu.stu_manager.mapper.StudentMapper;
import com.cqu.stu_manager.mapper.TeacherMapper;
import com.cqu.stu_manager.pojo.Student;
import com.cqu.stu_manager.pojo.Teacher;
import com.cqu.stu_manager.pojo.User;
import com.cqu.stu_manager.utils.RedisUtil;
import com.cqu.stu_manager.utils.Result;
import lombok.extern.log4j.Log4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class logincontroller {
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    TeacherMapper teacherMapper;
    @Autowired
    RedisUtil redisUtil;
    @PostMapping("/tologin")
    public Result tologin(){
        Result result=new Result();
        result.setMsg("当前无用户登陆，请跳转登陆页面");
        return result;
    }
    @GetMapping("/tologin")
    public Result tologin_GET(){
        Result result=new Result();
        result.setMsg("当前无用户登陆，请跳转登陆页面");
        return result;
    }
    @PostMapping("/logout")
    public Result logou(){
        Subject subject=SecurityUtils.getSubject();
        subject.logout();
        Result result=new Result();
        result.setMsg("注销成功");
        return result;
    }

    @PostMapping("/count")
    public Result count(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String format = sdf.format(new Date());
        String teachercount="";
        if(redisUtil.get("totalteachercount")!=null){
        teachercount=redisUtil.get("totalteachercount").toString();
        }else {teachercount="0";}
        String studentcount ="";
        if(redisUtil.get("totalstudentcount")!=null){
        studentcount=redisUtil.get("totalstudentcount").toString();
        }else {studentcount="0";}
        String todaystudent="";
        String todayteacher="";
        String format1="";
        format1=format+"todaystudentcount";
        if(redisUtil.get(format1)!=null) {
            todaystudent = redisUtil.get(format1).toString();
        }else {todaystudent="0";}
        String format2="";
        format2=format+"todayteachercount";
        if(redisUtil.get(format2)!=null) {
            todayteacher = redisUtil.get(format2).toString();
        }else {todayteacher="0";}
        List<String> list=new ArrayList<>();
        list.add(studentcount);
        list.add(teachercount);
        list.add(todaystudent);
        list.add(todayteacher);
        Result result=new Result();
        result.setData(list);
        return  result;
}
    @ResponseBody
    @PostMapping("/login")
    public Result login(@RequestBody User user){
        Subject subject= SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(user.getUser_id().toString(),user.getUser_password());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String format = sdf.format(new Date());

        Result result=new Result();
        try{
            subject.login(token);
            //1是学生，0是老师
            if(user.getUser_type() == 1)
            {
                Student student = studentMapper.findOneStudent(user.getUser_id());
                if(student == null){
                    result.setMsg("身份错误");
                    return result;
                }
                if(student.getStu_password().equals(user.getUser_password())){
                    result.setData(student);
                    result.setCode(1);
                    result.setMsg("登录成功");
                    format=format+"todaystudentcount";
                    if(redisUtil.hasKey(format)){
                        redisUtil.incr(format,1);
                    }else {
                        redisUtil.set(format,1);
                    }
                    redisUtil.incr("totalstudentcount",1);
//                    StudentRead studentRead=new StudentRead(studentMapper);
//                    studentRead.simpleRead();
                }
                else{
                    result.setMsg("账号或密码错误");
                }
            }
            else if(user.getUser_type() == 0){
                Teacher teacher = teacherMapper.findOneTeacher(user.getUser_id());
                if(teacher == null){
                    result.setMsg("身份错误");
                    return result;
                }
                if(teacher.getT_password().equals(user.getUser_password())){
                    result.setMsg("登录成功");
                    result.setCode(0);
                    result.setData(teacher);
                    format=format+"todayteachercount";
                    if(redisUtil.hasKey(format)){
                        redisUtil.incr(format,1);
                    }else {
                        redisUtil.set(format,1);
                    }
                    redisUtil.incr("totalteachercount",1);


                }
                else{
                    result.setMsg("账号或密码错误");
                }
            }
            return result;
        }catch (UnknownAccountException e){
            result.setMsg("账号或密码错误");
            return result;
            //用户名密码错误
        }catch (IncorrectCredentialsException e)
        {
            result.setMsg("账号或密码错误");
            return result;
            //密码错误
        }
    }


}
