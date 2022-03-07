package com.cqu.stu_manager.controller;

import com.cqu.stu_manager.mapper.ClassMapper;
import com.cqu.stu_manager.mapper.StudentMapper;
import com.cqu.stu_manager.mapper.TeacherMapper;
import com.cqu.stu_manager.pojo.Class;
import com.cqu.stu_manager.pojo.Student;
import com.cqu.stu_manager.pojo.Teacher;
import com.cqu.stu_manager.pojo.TypeAndCount;
import com.cqu.stu_manager.utils.InfoForTeacher;
import com.cqu.stu_manager.utils.RedisUtil;
import com.cqu.stu_manager.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class echartscontroller {
    @Autowired
    ClassMapper classMapper;
    @Autowired
    TeacherMapper teacherMapper;
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    RedisUtil redisUtil;
    @PostMapping("/findParty_and_League")
    public Result findParty_and_League(@RequestBody Teacher teacher){
        InfoForTeacher infoForTeacher=new InfoForTeacher(teacherMapper,classMapper,studentMapper);
        List<Class> classList=new ArrayList<>();
        classList=infoForTeacher.findRightClass(teacher.getT_no());
        List<Student> studentList=infoForTeacher.findAllStudent(classList);
        Result result=new Result();
        Integer dangyuan=0;
        Integer tuanyuan =0;
        for (int i = 0; i < studentList.size(); i++) {
            if("中共党员".equals(studentList.get(i).getStu_politicalface())){
                dangyuan++;
            }else if("共青团员".equals(studentList.get(i).getStu_politicalface())){
                tuanyuan++;
            }else {

            }
        }
        List<TypeAndCount >typeAndCounts=new ArrayList<>();
        TypeAndCount typeAndCount=new TypeAndCount();
        typeAndCount.setEle_type("党员");
        typeAndCount.setEle_count(dangyuan);
        TypeAndCount typeAndCount1=new TypeAndCount();
        typeAndCount1.setEle_type("团员");
        typeAndCount1.setEle_count(tuanyuan);
        TypeAndCount typeAndCount2=new TypeAndCount();
        typeAndCount2.setEle_type("群众");
        typeAndCount2.setEle_count(studentList.size()-dangyuan-tuanyuan);
        typeAndCounts.add(typeAndCount);
        typeAndCounts.add(typeAndCount1);
        typeAndCounts.add(typeAndCount2);
        result.setData(typeAndCounts);
        redisUtil.set(teacher.getT_no()+"student",studentList,50);
        return  result;

    }
    @PostMapping("/findDemoted_student")
    public Result findDemoted_student(@RequestBody Teacher teacher){
        Result result=new Result();
        List<Student>studentList=new ArrayList<>();
        Integer Demoted_student=0;
        studentList= (List<Student>) redisUtil.get(teacher.getT_no()+"student",Student.class);
        for (int i = 0; i < studentList.size(); i++) {
                if(studentList.get(i).getStu_class()!=null&&!studentList.get(i).getStu_no().toString().substring(2,4).equals(studentList.get(i).getStu_class().substring(0,2))){
                    Demoted_student++;

                }else {

                }
        }
        TypeAndCount typeAndCount=new TypeAndCount();
        typeAndCount.setEle_count(Demoted_student);
        typeAndCount.setEle_type("降级生");
        TypeAndCount typeAndCount1=new TypeAndCount();
        typeAndCount1.setEle_type("正常");
        typeAndCount1.setEle_count(studentList.size()-Demoted_student);
        List<TypeAndCount>typeAndCountS=new ArrayList<>();
        typeAndCountS.add(typeAndCount1);
        typeAndCountS.add(typeAndCount);
        result.setData(typeAndCountS);
        return result;
    }
}
