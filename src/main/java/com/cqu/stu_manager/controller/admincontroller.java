package com.cqu.stu_manager.controller;

import com.cqu.stu_manager.mapper.ClassMapper;
import com.cqu.stu_manager.mapper.StudentMapper;
import com.cqu.stu_manager.mapper.TeacherMapper;
import com.cqu.stu_manager.pojo.Admin;
import com.cqu.stu_manager.pojo.Class;
import com.cqu.stu_manager.pojo.Student;
import com.cqu.stu_manager.pojo.Teacher;
import com.cqu.stu_manager.service.MailService;
import com.cqu.stu_manager.utils.Result;
import org.apache.poi.ss.formula.functions.T;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class admincontroller {
    @Autowired
    MailService mailService;
    @PostMapping("/admin_login")
    @ResponseBody
    public Result admin_login(@RequestBody Admin admin){
        Subject subject= SecurityUtils.getSubject();
        System.out.println(admin);
        UsernamePasswordToken token=new UsernamePasswordToken(admin.getAdmin_username(), admin.getAdmin_password());
                Result result=new Result<>();
        try {
            subject.login(token);
            }catch (UnknownAccountException e){
            result.setMsg("账号或密码错误1");
            return result;
            //用户名密码错误
            }catch (IncorrectCredentialsException e)
            {
            result.setMsg("账号或密码错误2");
            return result;
            //密码错误
        }
            result.setMsg("登录成功");
       // mailService.send("122706559@qq.com","管理员登录了"," hello CY");
            return result;
    }
    @Autowired
    TeacherMapper teacherMapper;
    @PostMapping("/admin/add_teacher")
    public Result admin_add_teacher(@RequestBody Teacher teacher){
        Result result=new Result();
        result.setMsg(teacherMapper.addteacherByAdmin(teacher)+"位老师添加成功");
        return result;
    }
    @PostMapping("/admin/delete_teacher")
    public Result admin_delete_teacher(@RequestBody Teacher teacher){
        Result result=new Result();
        teacherMapper.deleteTeacherByAdmin(teacher.getT_no());
        result.setMsg("删除成功");
        return result;
    }
    @PostMapping("/admin/update_teacher")
    public Result ademin_update_teacher(@RequestBody Teacher teacher){
        Result result=new Result();
        teacherMapper.upDateTeacher(teacher);
        result.setMsg("修改成功");
        return result;
    }
    @PostMapping("/admin/findall_teacher")
    public Result findall_teacher(){
        List<Teacher> teacherList=new ArrayList<>();
        teacherList=teacherMapper.findAllTeacher();
        Result result=new Result();
        result.setData(teacherList);
        return result;
    }
    @Autowired
    ClassMapper classMapper;
    @PostMapping("/admin/distribution_master")
    public Result distribution_teacher( @RequestBody Class class_){
        classMapper.setclassmaster(class_.getClass_id(),class_.getClass_teacherid());
        Result result=new Result();
        result.setMsg("修改成功");
        return  result;
    }
    @PostMapping("/admin/distribution_instructor")
    public Result distribution_instructor(@RequestBody Teacher teacher){
        Result result=new Result();
        teacherMapper.upDateTeacher(teacher);
        result.setMsg("修改成功");
        return result;
    }
    @Autowired
    StudentMapper studentMapper;
    @PostMapping("admin/reset_student_password")
        public Result reset_student_password(@RequestBody Student student){
        student.setStu_password(student.getStu_no().toString());
        studentMapper.upDatePassword(student);
        Result result=new Result();
        result.setMsg("重置密码成功");
        return  result;
    }
}
