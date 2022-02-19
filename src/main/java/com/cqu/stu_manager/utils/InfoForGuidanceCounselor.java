package com.cqu.stu_manager.utils;

import com.cqu.stu_manager.mapper.ClassMapper;
import com.cqu.stu_manager.mapper.TeacherMapper;
import com.cqu.stu_manager.pojo.Class;
import com.cqu.stu_manager.pojo.Student;
import com.cqu.stu_manager.pojo.Teacher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class InfoForGuidanceCounselor {
    @Autowired
    TeacherMapper teacherMapper;
    @Autowired
    ClassMapper classMapper;
    public InfoForGuidanceCounselor(TeacherMapper teacherMapper, ClassMapper classMapper)
    {
        super();
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
            teaidenty = teacher.getT_identity().toString().substring(0, 2);

            for (int i = 0; i < classList.size(); i++) {
                if (classList.get(i).getClass_name().substring(0, 2).equals(teaidenty)) {
                    right_classlist.add(classList.get(i));
                }

            }

       return right_classlist; }

    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class EthnicAndCount<String,Integer>{
        private java.lang.String Ethnic;
        private java.lang.Integer Count;

    }

}
