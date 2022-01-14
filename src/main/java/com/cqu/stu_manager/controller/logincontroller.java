package com.cqu.stu_manager.controller;


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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class logincontroller {
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    TeacherMapper teacherMapper;

    @ResponseBody
    @PostMapping("/login")
    public Result login(@RequestBody User user){
        Subject subject= SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(user.getUser_id().toString(),user.getUser_password());
        Result result=new Result();
//        result.setData(token);
//        return result;
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
                }
                else{
                    result.setMsg("账号或密码错误");
                }
            }
            else if(user.getUser_type() == 0){
                Teacher teacher = teacherMapper.findTeacherById(user.getUser_id());
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
