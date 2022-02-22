package com.cqu.stu_manager;

import com.cqu.stu_manager.excel.BedroomExcel;
import com.cqu.stu_manager.excel.ClassCountForHuxiExcel;
import com.cqu.stu_manager.excel.pojo.Bedroom;
import com.cqu.stu_manager.mapper.*;
import com.cqu.stu_manager.pojo.Class;
import com.cqu.stu_manager.pojo.Stayschool;
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
@Autowired
StayschoolMapper stayschoolMapper;

    @SneakyThrows
    @Test
    void contextLoads() {
        ClassCountForHuxiExcel classCountForHuxiExcel=new ClassCountForHuxiExcel(accommodationMapper,teacherMapper,classMapper,studentMapper);
        classCountForHuxiExcel.ClassCountForHuxiExcel_write(2);
//        Stayschool stayschool=new Stayschool();
//        stayschool.setStay_school_info_begin("232");
//        stayschoolMapper.addStayschoolInfoByStu(stayschool);

    }
}
