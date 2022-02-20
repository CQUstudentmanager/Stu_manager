package com.cqu.stu_manager.utils;

import com.cqu.stu_manager.mapper.ClassMapper;
import com.cqu.stu_manager.mapper.StudentMapper;
import com.cqu.stu_manager.mapper.TeacherMapper;
import com.cqu.stu_manager.pojo.Class;
import com.cqu.stu_manager.pojo.Student;
import com.cqu.stu_manager.pojo.Teacher;
import com.cqu.stu_manager.pojo.TypeAndCount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class InfoForTeacher {
    @Autowired
    TeacherMapper teacherMapper;
    @Autowired
    ClassMapper classMapper;
    @Autowired
    StudentMapper studentMapper;
    public InfoForTeacher(TeacherMapper teacherMapper, ClassMapper classMapper,StudentMapper studentMapper)
    {
        super();
        this.studentMapper=studentMapper;
        this.classMapper=classMapper;
        this.teacherMapper=teacherMapper;
    }

    public List<Class> findRightClass(Integer teacherNo) {
        Teacher teacher = new Teacher();
        teacher = teacherMapper.findOneTeacher(teacherNo);
        if (teacher == null) {
            return null;
        } else {
            List<Class> classList = new ArrayList<>();
            List<Class> right_classlist = new ArrayList<>();
            classList = classMapper.findAllClass();
            String teaidenty;
            String headmasteridenty="2";
            teaidenty = teacher.getT_identity().toString();
            if(teaidenty.equals(headmasteridenty)){
                List <String> stringList=classMapper.findClassByTeacher(teacherNo.toString());
                for (int i=0;i<stringList.size();i++){
                    Class class_=new Class();
                    class_.setClass_name(stringList.get(i));
                    right_classlist.add(class_);
                }


            }else {
            for (int i = 0; i < classList.size(); i++) {
                if (classList.get(i).getClass_name().substring(0, 2).equals(teaidenty)) {
                    right_classlist.add(classList.get(i));
                }

            }
        }

       return right_classlist; }

    }
    public List<TypeAndCount>  findStudentCount(List<Class> right_classlist){
        List<TypeAndCount> stu_count=new ArrayList<>();

        for (int i=0;i<right_classlist.size();i++) {
            TypeAndCount typeAndCount=new TypeAndCount();
            List<Student> studentList=new ArrayList<>();
            String temp="";
            temp=right_classlist.get(i).getClass_name();
            studentList=studentMapper.findStudentsByClass(right_classlist.get(i).getClass_name());
            temp=temp+"班:";
            typeAndCount.setEle_type(temp);
            typeAndCount.setEle_count(studentList.size());
            stu_count.add(typeAndCount);

        }return stu_count;
    }


}
