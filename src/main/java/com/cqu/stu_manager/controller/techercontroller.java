package com.cqu.stu_manager.controller;

import com.cqu.stu_manager.mapper.MsgMapper;
import com.cqu.stu_manager.mapper.ReceiveMapper;
import com.cqu.stu_manager.mapper.StudentMapper;
import com.cqu.stu_manager.mapper.TeacherMapper;
import com.cqu.stu_manager.pojo.*;
import com.cqu.stu_manager.utils.Result;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class techercontroller {
    @Autowired
    TeacherMapper teacherMapper;
    @Autowired
    MsgMapper msgMapper;
    @Autowired
    ReceiveMapper receiveMapper;
    @Autowired
    StudentMapper studentMapper;

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
    public Result sendMsg(@RequestBody MsgReceiver msgReceiver){
        Result result = new Result();
        //判断当前老师是否存在
        Teacher teacher = teacherMapper.findOneTeacher(msgReceiver.getMsg_sender());
        if(teacher == null){
            result.setMsg("未找到当前老师信息");
            return result;
        }
        //将消息的no改为老师的no加上当前时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(new Date());
        Msg msg = new Msg(msgReceiver.getMsg_sender()+"-"+format,msgReceiver.getMsg_content(),msgReceiver.getMsg_sender());
        //用于后面存放学生接收情况到数据库
        Receive receive = new Receive();
        receive.setMsg_no2(msg.getMsg_no());
        receive.setStatus(0);
        //判定消息接收对象
        if(msgReceiver.getMsg_content()==null){
            result.setMsg("请输入消息内容");
        }
        //发送消息到全体学生
        else if(msgReceiver.getIsAllStudent()==1){
            msgMapper.addMsg(msg);
            List<Student> studentList= studentMapper.findAllStudent();
            for(Student student: studentList){
                receive.setReceiver(student.getStu_no());
                receive.setReceive_no(student.getStu_no() + "-" + format);
                receiveMapper.addReceiver(receive);
            }
            result.setMsg("消息成功发送到全部学生");
        }
        //发送消息到指定班级
        else if(!msgReceiver.getMsg_class().isEmpty()){
            msgMapper.addMsg(msg);
            for(String c:msgReceiver.getMsg_class()){
                //先找到一个班级里面所有的学生
                List<Student> studentList2 = studentMapper.findStudentsByClass(c);
                //再向每个学生发送消息
                for(Student student:studentList2){
                    receive.setReceiver(student.getStu_no());
                    receive.setReceive_no(student.getStu_no() + "-" + format);
                    receiveMapper.addReceiver(receive);
                }
            }
            result.setMsg("消息成功发送到指定班级");
        }
        //发送消息到指定对象
        else if(msgReceiver.getStuList().length != 0){
            msgMapper.addMsg(msg);
            for(int no:msgReceiver.getStuList()){
                receive.setReceiver(no);
                receive.setReceive_no(no + "-" + format);
                receiveMapper.addReceiver(receive);
            }
            result.setMsg("消息成功发送到指定学生");
        }
        //没有发送消息的对象
        else{
            result.setMsg("请选择发送消息对象");
        }
        return result;
    }



    @PostMapping("Tea/findAlreadyRead")
    @ResponseBody
    public Result findAlreadyRead(@RequestBody Teacher teacher){
        Result result = new Result();
        Teacher teacher1 = teacherMapper.findOneTeacher(teacher.getT_no());
        if(teacher1 == null){
            result.setMsg("无当前教师信息");
        }
        Map<Msg,String> listMap = new HashMap<>();
        //先找到该老师所发布的所有消息的msg_no
        List<String> allMsgNo = msgMapper.findAllMsg(teacher);
        for(String msgno:allMsgNo){
            //对于每一个消息，找到已读的所有学生
            int number1 = receiveMapper.findAlreadyReady(msgno);//找到已经读了的
            int number2 = receiveMapper.findNotRead(msgno);//找到未读的
            listMap.put(msgMapper.findOneMsg(msgno),number1 + "已读," + number2 +"未读。");
        }
        result.setMsg("当前老师发布的所有消息的阅读情况如下：");
        result.setData(listMap);
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
