package com.cqu.stu_manager.controller;


import com.cqu.stu_manager.excel.StudentRead;
import com.cqu.stu_manager.mapper.StudentMapper;
import com.cqu.stu_manager.mapper.TeacherMapper;
import com.cqu.stu_manager.pojo.Student;
import com.cqu.stu_manager.pojo.Teacher;
import com.cqu.stu_manager.pojo.User;
import com.cqu.stu_manager.utils.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class logincontroller {
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    TeacherMapper teacherMapper;
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

    @ResponseBody
    @PostMapping("/login")
    public Result login(@RequestBody User user){
        Subject subject= SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(user.getUser_id().toString(),user.getUser_password());
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
                    //StudentRead studentRead=new StudentRead(studentMapper);
                    //studentRead.simpleRead();
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
