package com.cqu.stu_manager.controller;

import com.alibaba.druid.sql.visitor.functions.If;
import com.cqu.stu_manager.excel.StudentListHeadmasterExcel;
import com.cqu.stu_manager.mapper.*;
import com.cqu.stu_manager.pojo.*;
import com.cqu.stu_manager.service.MailService;
import com.cqu.stu_manager.utils.DocUtil;
import com.cqu.stu_manager.utils.RedisUtil;
import com.cqu.stu_manager.utils.Result;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

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
    @Autowired
    ClassMapper classMapper;
    @Autowired
    CollegeEntranceExaminationMapper collegeEntranceExaminationMapper;
    @Autowired
    FamilyMapper familyMapper;
    @Autowired
    AccommodationMapper accommodationMapper;

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
@Autowired
    MailService mailService;

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
        Msg msg = new Msg(msgReceiver.getMsg_sender()+"-"+format,msgReceiver.getMsg_content(),msgReceiver.getMsg_sender(),msgReceiver.getMsg_deadline(),msgReceiver.getMsg_releasetime(),"",0,0,0,0);
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
            List<String>EmailList=new ArrayList<>();
            for(int no:msgReceiver.getStuList()){
                receive.setReceiver(no);
                receive.setReceive_no(no + "-" + format);
                receiveMapper.addReceiver(receive);
                Student student=new Student();
                student=studentMapper.findOneStudent(no);
                if(student.getStu_email()==null||student.getStu_email().length()!=0){
                    mailService.send(student.getStu_email(),"大数据与软件学院信息系统新消息通知","老师发布了任务消息，请点击10.236.11.68:9876查看");
                }

            }
            result.setMsg("消息成功发送到指定学生");
        }
        //没有发送消息的对象
        else{
            result.setMsg("请选择发送消息对象");
        }
        return result;
    }



    @PostMapping("Tea/findAllStatus")
    @ResponseBody
    public Result findAllRead(@RequestBody Teacher teacher){
        Result result = new Result();
        Teacher teacher1 = teacherMapper.findOneTeacher(teacher.getT_no());
        if(teacher1 == null){
            result.setMsg("无当前教师信息");
            return result;
        }
        //先找到该老师所发布的所有消息的msg_no
        List<Msg> allMsg = msgMapper.findAllMsg(teacher);
        if(allMsg.isEmpty()){
            result.setMsg("当前教师未发布信息");
            return result;
        }
        for(Msg msg:allMsg){
            //对于每一个消息，找到已读的所有学生
            List<Receive> receiveList = receiveMapper.findAlreadyReady(msg.getMsg_no());//找到已经读了的
            List<Receive> receiveList1 = receiveMapper.findNotRead(msg.getMsg_no());
            List<Receive> receiveList2 = receiveMapper.findHaveDone(msg.getMsg_no());
            msg.setDone(receiveList2.size());
            msg.setRead(receiveList.size());
            msg.setAll(receiveList1.size()+receiveList.size());
        }
        result.setMsg("当前老师发布的所有消息的阅读情况如下：");
        Collections.sort(allMsg, new Comparator<Msg>() {
            @Override
            public int compare(Msg o1, Msg o2) {
                return o2.getMsg_releasetime().compareTo(o1.getMsg_releasetime());
            }
        });
        result.setData(allMsg);
        return result;
    }
    @Autowired
    RedisUtil redisUtil;
    @PostMapping("Tea/findWhoReadOneMsg")
    @ResponseBody
    public Result findWhoReadOneMsg(@RequestBody Msg msg){
        Result result = new Result<>();
        List<Receive> receiveList = receiveMapper.findAll(msg.getMsg_no());
        if(receiveList  == null || receiveList.size() == 0){
            result.setMsg("当前消息不存在");
            return result;
        }
        for(Receive r:receiveList){
            Student student = studentMapper.findOneStudent(r.getReceiver());
            r.setStuClass(student.getStu_class());
            r.setStuName(student.getStu_name());
        }
        result.setData(receiveList);
        result.setMsg("当前消息的阅读情况如下");
        return result;
    }
    @PostMapping("/updateMsg")
    public Result updateMsg(@RequestBody Msg msg)
    {
        Result result=new Result();
        Integer count=0;
        count=msgMapper.updateMsg(msg);
        if(count==0){
            result.setMsg("消息未变更");
        }else {
            result.setMsg("修改成功");
        }
        return  result;
    }
    @PostMapping("/deleteMsg")
    public Result deleteMsg(@RequestBody Msg msg){
        Result result=new Result();
        if(msgMapper.deleteMsg(msg.getMsg_no())!=0&&receiveMapper.deleteByMsgNo(msg.getMsg_no())!=0){
            result.setMsg("消息删除成功");
        }else {result.setMsg("出现未知错误");}
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
    @PostMapping("/Tea/writeplanning")
    public Result writeplanning(@RequestBody DevelopmentPlanning developmentPlanning){
        Result result=new Result();
        String path="D:\\nginx-1.18.0\\html\\Word\\";
        String filename=developmentPlanning.getDevelopment_planning_stu_name()+"发展规划书.doc";
        try {
            Map<String, Object> dataMap = new HashMap<>();
            dataMap.put("stu_name", developmentPlanning.getDevelopment_planning_stu_name());
            dataMap.put("stu_no", developmentPlanning.getDevelopment_planning_stu_no());
            dataMap.put("stu_class", developmentPlanning.getDevelopment_planning_stu_class());
            dataMap.put("stu_room", developmentPlanning.getDevelopment_planning_room());
            dataMap.put("stu_gpa", developmentPlanning.getDevelopment_planning_gpa());
            dataMap.put("nopass_point", developmentPlanning.getDevelopment_planning_nopass_point());
            dataMap.put("wish", developmentPlanning.getDevelopment_planning_wish());
            dataMap.put("planone", developmentPlanning.getDevelopment_planning_planone());
            dataMap.put("plantwo", developmentPlanning.getDevelopment_planning_plantwo());
            dataMap.put("summary", developmentPlanning.getDevelopment_planning_summary());
            dataMap.put("howtonextyear", developmentPlanning.getDevelopment_planning_howtonextyear());
            dataMap.put("year", developmentPlanning.getYear());
            Integer nextyear=0;
            nextyear=(Integer.parseInt(developmentPlanning.getYear())+1);
            dataMap.put("nextyear", nextyear.toString());
            dataMap.put("howtonexttwoyear",developmentPlanning.getDevelopment_planning_howtonext2year());
            dataMap.put("thisyearplan", developmentPlanning.getDevelopment_planning_thisyearplan());
            dataMap.put("successful_experience", developmentPlanning.getDevelopment_planning_successful_experience());
            dataMap.put("details", developmentPlanning.getDevelopment_planning_details());
            dataMap.put("familymean", developmentPlanning.getDevelopment_planning_familymean());

            DocUtil.saveWord(path+filename, dataMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
        result.setMsg("生成成功");
        result.setData(filename);
        return result;

    }

}
