package com.cqu.stu_manager.controller;

import com.cqu.stu_manager.excel.StudentListHeadmasterExcel;
import com.cqu.stu_manager.mapper.*;
import com.cqu.stu_manager.pojo.Student;
import com.cqu.stu_manager.pojo.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@RestController
public class excelcontroller {
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
    @PostMapping("/getStudentExcelInfoByTeacher")
    public String getStudentExcelInfoByTeacher(@RequestBody Teacher teacher){
        String class_name= classMapper.findClassByTeacher(teacher.getT_no().toString());
        List<Student> studentList=new ArrayList<>();
        StudentListHeadmasterExcel studentListHeadmasterExcel=new StudentListHeadmasterExcel(studentMapper,collegeEntranceExaminationMapper,familyMapper,accommodationMapper);
        return studentListHeadmasterExcel.StudentListHeadmasterExcel_Write(class_name);

    }

}
