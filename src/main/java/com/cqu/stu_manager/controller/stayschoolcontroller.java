package com.cqu.stu_manager.controller;

import com.cqu.stu_manager.mapper.ClassMapper;
import com.cqu.stu_manager.mapper.StayschoolMapper;
import com.cqu.stu_manager.mapper.StudentMapper;
import com.cqu.stu_manager.mapper.TeacherMapper;
import com.cqu.stu_manager.pojo.Class;
import com.cqu.stu_manager.pojo.Stayschool;
import com.cqu.stu_manager.pojo.Student;
import com.cqu.stu_manager.utils.InfoForTeacher;
import com.cqu.stu_manager.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class stayschoolcontroller {
    @Autowired
    StayschoolMapper stayschoolMapper;
    @Autowired
    ClassMapper classMapper;
    @Autowired
    TeacherMapper teacherMapper;
    @Autowired
    StudentMapper studentMapper;

    @PostMapping("/find_stayschool_info")
    public List<Stayschool> find_stayschool_info(@RequestBody Stayschool stayschool){
        //判断的是时间   如2022年暑假
       List<Stayschool> stayschools=new ArrayList<>();
       stayschools=stayschoolMapper.findAllStayschoolInfo(stayschool);
       InfoForTeacher infoForTeacher=new InfoForTeacher(teacherMapper,classMapper,studentMapper);
       List<Class> rightclass=new ArrayList<>();
       List<Stayschool> right_stayinfo=new ArrayList<>();
       rightclass=infoForTeacher.findRightClass(Integer.parseInt(stayschool.getTeacherNo()));
       if(rightclass!=null){
       for (int i = 0; i < rightclass.size(); i++) {
            for (int j = 0; j < stayschools.size(); j++) {
                if(rightclass.get(i).getClass_name().equals(stayschools.get(j).getStay_school_info_stuclass())){
                    right_stayinfo.add(stayschools.get(j));
                }
            }
        }}
return right_stayinfo;
    }
    @PostMapping("upload_stayschool_info")
    public Result
    upload_stayschool_info(@RequestBody Stayschool stayschool){
        List<Stayschool> stayschools=new ArrayList<>();
        Result result=new Result();
        stayschools=stayschoolMapper.findAllStayschoolInfo2();
        for(int i=0;i<stayschools.size();i++){
            stayschools.get(i).setStay_school_info_no("");
            if(stayschools.get(i).getStay_school_info_reason()!=null){
            if(stayschools.get(i).getStay_school_info_reason().equals(stayschool.getStay_school_info_reason())){
                result.setMsg("系统监测到你上传了”理由“相同的信息，为确保重复上传，请修改下“理由”");
                return result;
            }}
        }
        if(stayschool.getStay_school_info_no().length()==0){
            String str=stayschool.getStay_school_info_stu_no();
            SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
            String format = sdf.format(new Date());
            stayschool.setStay_school_info_no(str+format);
            result.setMsg(stayschoolMapper.addStayschoolInfoByStu(stayschool)+"条信息已上传");
            return  result;
        }else {
            result.setMsg(stayschoolMapper.updateStayschoolInfo(stayschool)+"条消息已修改");
            return result;
        }
    }
}
