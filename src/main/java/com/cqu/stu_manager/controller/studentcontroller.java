package com.cqu.stu_manager.controller;

import com.cqu.stu_manager.mapper.StudentMapper;
import com.cqu.stu_manager.pojo.Student;
import com.cqu.stu_manager.utils.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
        Student student=new Student(1231234, " ","张三",0,"1","1995-12-26","汉族","四川成都","522321","党员","2021",1,"135959002","122706559","ch@163","重庆大学","WU");
        int i= studentMapper.upDatestudentinfo(student);
        return "ok";
    }
    @ResponseBody
    @PostMapping("/login2")
    public Result logintest(@RequestBody Student student){
        Subject subject= SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(student.getStu_no().toString(),student.getStu_password());
        Result result=new Result();
//        result.setData(token);
//        return result;

        try{
            subject.login(token);
            result.setData( studentMapper.findloginPassword(student.getStu_no()));
            return result;
        }catch (UnknownAccountException e){
            result.setData("用户授权失败，请重新登陆");
            return result;
            //用户名密码错误
        }catch (IncorrectCredentialsException e)
        {
            result.setData("用户授权失败，请重新登陆");
            return result;
            //密码错误
        }



    }

    @ResponseBody
    @PostMapping("/login")
    public  Result lonin(@RequestBody Student student){
        Result result=new Result();
        Student student1=studentMapper.findloginPassword(student.getStu_no());
        if(student1==null){
        Result failresult = new Result();
        failresult.setMsg("登陆失败，用户不存在请联系管理员");
        return failresult;
        }
        else if (student1.getStu_no().equals(student.getStu_no()) && student1.getStu_password().equals(student.getStu_password()))
            {
                result.setData(student1);
                return result;
            }
        else if(!student1.getStu_password().equals(student.getStu_password()))
            {
                Result failresult = new Result();
                failresult.setMsg("登陆失败，用户名或密码错误");
                return failresult;
            }
        else {
            Result result1=new Result();
            result1.setMsg("未知错误");
            return result1;
    }

        }
}


