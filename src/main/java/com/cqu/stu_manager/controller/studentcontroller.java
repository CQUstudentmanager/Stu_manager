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


    @PostMapping("/STUDENTLIST")
    @ResponseBody
    public List<Student> students(){
        List<Student> studentlist=studentMapper.findAllStudent();
        return studentlist;
    }
    @PostMapping("/upDateStudent")
    @ResponseBody
    public Result upDateStudent(@RequestBody Student your_t){
        Result result = new Result();
        Student student = studentMapper.findOneStudent(your_t.getStu_no());
        if(student == null){
            result.setMsg("当前学生不存在");}
        else{
            if((!your_t.getStu_name().equals("String") ) && (!your_t.getStu_name().equals(student.getStu_name()))){
                student.setStu_name(your_t.getStu_name());
            }
            if((your_t.getStu_gender()!=0) && (!your_t.getStu_gender().equals(student.getStu_gender()))){
                student.setStu_gender(your_t.getStu_gender());
            }
            if((!your_t.getStu_class().equals("String")) && (!your_t.getStu_class().equals(student.getStu_class()))){
                student.setStu_class(your_t.getStu_class());
            }
            if((!your_t.getStu_birthday().equals("String")) && (!your_t.getStu_birthday().equals(student.getStu_birthday()))){
                student.setStu_birthday(your_t.getStu_birthday());
            }
            if((!your_t.getStu_ethnic().equals("String")) && (!your_t.getStu_ethnic().equals(student.getStu_ethnic()))){
                student.setStu_ethnic(your_t.getStu_ethnic());
            }
            if((!your_t.getStu_origin().equals("String")) && (!your_t.getStu_origin().equals(student.getStu_origin()))){
                student.setStu_origin(your_t.getStu_origin());
            }
            if((!your_t.getStu_id().equals("String")) && (!your_t.getStu_id().equals(student.getStu_id()))){
                student.setStu_id(your_t.getStu_id());
            }
            if((!your_t.getStu_politicalface().equals("String")) && (!your_t.getStu_politicalface().equals(student.getStu_politicalface()))){
                student.setStu_politicalface(your_t.getStu_politicalface());
            }
            if((!your_t.getStu_caucus_time().equals("String")) && (!your_t.getStu_caucus_time().equals(student.getStu_caucus_time()))){
                student.setStu_caucus_time(your_t.getStu_caucus_time());
            }
            if((your_t.getStu_isMacau() != 0) && (!your_t.getStu_isMacau().equals(student.getStu_isMacau()))){
                student.setStu_isMacau(your_t.getStu_isMacau());
            }
            if((!your_t.getStu_telephone().equals("String")) && (!your_t.getStu_telephone().equals(student.getStu_telephone()))){
                student.setStu_telephone(your_t.getStu_telephone());
            }
            if((!your_t.getStu_qq().equals("String")) && (!your_t.getStu_qq().equals(student.getStu_qq()))){
                student.setStu_qq(your_t.getStu_qq());
            }
            if((!your_t.getStu_address().equals("String")) && (!your_t.getStu_address().equals(student.getStu_address()))){
                student.setStu_address(your_t.getStu_address());
            }
            if((!your_t.getStu_email().equals("String")) && (!your_t.getStu_email().equals(student.getStu_email()))){
                student.setStu_email(your_t.getStu_email());
            }
            if((!your_t.getStu_photourl().equals("String")) && (!your_t.getStu_photourl().equals(student.getStu_photourl()))){
                student.setStu_photourl(your_t.getStu_photourl());
            }
            result.setMsg("信息修改成功");
            result.setData(student);

        }
        studentMapper.upDateStudentInfo(student);
        return result;
    }

    @ResponseBody
    @PostMapping ("/login")
    public  Result lonin(@RequestBody Student student)
        {
        Result result=new Result();
        Student student1=studentMapper.findOneStudent(student.getStu_no());
        if(student1==null){
        result.setMsg("登陆失败，用户不存在请联系管理员");
        }
        else if (student1.getStu_no().equals(student.getStu_no()) && student1.getStu_password().equals(student.getStu_password()))
            {
                result.setData(student1);
                result.setMsg("登录成功");
                return result;
            }
        else if(!student1.getStu_password().equals(student.getStu_password()))
            {
                result.setMsg("登陆失败，用户名或密码错误");
            }
        else {
            result.setMsg("未知错误");
             }
        return result;
        }


        @PostMapping("/updatepassword")
        @ResponseBody
        public Result updatePassword(@RequestBody upDatePassword your_up){
            Result result= new Result();
            Student student = studentMapper.findOneStudent(your_up.getStu_no());
            if(student == null){
                result.setMsg("用户不存在");
            }
            else if(your_up.getOld_password().equals(student.getStu_password()))
            {
                //确定student不为NULL而且旧密码输入正确，直接改成新密码就可以了
                student.setStu_password(your_up.getNew_password());
                studentMapper.upDatePassword(student);
                result.setData(student);
                result.setMsg("密码修改成功成功");
            }
            else{
                result.setMsg("密码修改失败");
            }
            return result;
        }

}


