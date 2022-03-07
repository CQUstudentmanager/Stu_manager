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
        Result result=new Result();
        List<TypeAndCount> typeAndCounts=new ArrayList<>();
        for (int i = 0; i < classList.size(); i++) {
            List<Student> students=new ArrayList<>();
            Integer dangyuan=0;
            Integer tuanyuan=0;
            Integer qunzhong=0;
            students=studentMapper.findStudentsByClass(classList.get(i).getClass_name());
            for (int j = 0; j < students.size(); j++) {
                if("中共党员".equals(students.get(j).getStu_politicalface())){
                    dangyuan++;
                }else if ("共青团员".equals(students.get(j).getStu_politicalface())){
                    tuanyuan++;
                }else {
                    qunzhong++;
                }

            }
            TypeAndCount typeAndCount=new TypeAndCount();
            typeAndCount.setEle_class(classList.get(i).getClass_name());
            typeAndCount.setEle_type("党员");
            typeAndCount.setEle_count(dangyuan);
            TypeAndCount typeAndCount1=new TypeAndCount();
            typeAndCount1.setEle_class(classList.get(i).getClass_name());
            typeAndCount1.setEle_type("团员");
            typeAndCount1.setEle_count(tuanyuan);
            TypeAndCount typeAndCount2=new TypeAndCount();
            typeAndCount2.setEle_class(classList.get(i).getClass_name());
            typeAndCount2.setEle_type("群众");
            typeAndCount2.setEle_count(qunzhong);
            typeAndCounts.add(typeAndCount);
            typeAndCounts.add(typeAndCount1);
            typeAndCounts.add(typeAndCount2);
        }
        redisUtil.set(teacher.getT_no()+"class",classList,50);
        result.setData(typeAndCounts);
        return  result;

    }

    @PostMapping("/findDemoted_student")
    public Result findDemoted_student(@RequestBody Teacher teacher){
        Result result=new Result();
        List<Student>studentList=new ArrayList<>();
        List<TypeAndCount> typeAndCounts=new ArrayList<>();
        List<Class> classList=new ArrayList<>();
        classList= (List<Class>) redisUtil.get(teacher.getT_no()+"class");
        for (int i = 0; i < classList.size(); i++) {
            List<Student> s=new ArrayList<>();
            Integer Demoted_student=0;
            s=studentMapper.findStudentsByClass(classList.get(i).getClass_name());
                for (int j = 0; j < s.size(); j++) {
                    if(!s.get(j).getStu_no().toString().substring(2,4).equals(s.get(j).getStu_class().substring(0,2))){
                        Demoted_student++;
                    }
                }
                TypeAndCount typeAndCount=new TypeAndCount();
                typeAndCount.setEle_class(classList.get(i).getClass_name());
                typeAndCount.setEle_type("降级生");
                typeAndCount.setEle_count(Demoted_student);
            TypeAndCount typeAndCount1=new TypeAndCount();
            typeAndCount1.setEle_class(classList.get(i).getClass_name());
            typeAndCount1.setEle_type("其他");
            typeAndCount1.setEle_count(s.size()-Demoted_student);
            typeAndCounts.add(typeAndCount);
            typeAndCounts.add(typeAndCount1);

        }
        result.setData(typeAndCounts);
        return result;
    }
}
