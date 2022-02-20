package com.cqu.stu_manager;

import com.cqu.stu_manager.mapper.*;
import com.cqu.stu_manager.pojo.Class;
import com.cqu.stu_manager.utils.InfoForTeacher;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
class StuManagerApplicationTests {
@Autowired
    StudentMapper studentMapper;
@Autowired
    ReceiveMapper receiveMapper;
@Autowired
    ContestMapper contestMapper;
@Autowired
PaperMapper paperMapper;
@Autowired
PatentMapper patentMapper;
@Autowired
ProjectMapper projectMapper;
@Autowired
DispatchMapper dispatchMapper;
@Autowired
Voluntary_activitiesMapper voluntary_activitiesMapper;
@Autowired
AccommodationMapper accommodationMapper;
@Autowired
CollegeEntranceExaminationMapper collegeEntranceExaminationMapper;
@Autowired
TeacherMapper teacherMapper;
@Autowired
FamilyMapper familyMapper;
@Autowired
ClassMapper classMapper;

    @SneakyThrows
    @Test
    void contextLoads() {
        List<Class> right_class=new ArrayList<>();
        InfoForTeacher infoForTeacher=new InfoForTeacher(teacherMapper,classMapper,studentMapper);
        right_class=infoForTeacher.findRightClass(10000);
        System.out.println(infoForTeacher.findStudentCount(right_class));

    }
}
