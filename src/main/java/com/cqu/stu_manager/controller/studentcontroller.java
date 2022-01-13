package com.cqu.stu_manager.controller;

import com.cqu.stu_manager.mapper.StudentMapper;
import com.cqu.stu_manager.pojo.Student;
import com.cqu.stu_manager.pojo.upDatePassword;
import com.cqu.stu_manager.utils.Result;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController//表示返回json文件类型
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
        Student student=new Student(1231234, " ","李四",0,"1","1995-12-26","汉族","四川成都","522321","党员","2021",1,"135959002","122706559","ch@163","重庆大学","WU");
        int i= studentMapper.upDatestudentinfo(student);
        return "ok";
    }

    @ResponseBody
    @GetMapping ("/login")
    public  Result lonin(@RequestBody Student student)
    /*public  Result lonin(@RequestParam(defaultValue = "000") int your_no,@RequestParam(defaultValue = "000") String your_string)*/
        /*Student student = new Student();
        student.setStu_no(your_no);
        student.setStu_password(your_string);*/
        {
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


        @PostMapping("/updatepassword")
        @ResponseBody
        public Result updatePassword(@RequestBody upDatePassword your_up){
            Result myresult = new Result();
            Student student = studentMapper.findOneStudent(your_up.getStu_no());
            if(student == null){
                myresult.setMsg("用户不存在");
                return myresult;
            }
            else if(your_up.getOld_password().equals(student.getStu_password()))
            {
                Student student1 = new Student();
                student1.setStu_no(your_up.getStu_no());
                student1.setStu_password(your_up.getNew_password());
                studentMapper.upDatePassword(student1);
                myresult.setData(student1);
                myresult.setMsg("密码修改成功成功");
                return myresult;
            }
            else{
                myresult.setMsg("密码修改失败");
                return myresult;
            }

        }

}


