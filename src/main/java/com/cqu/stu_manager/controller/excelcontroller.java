package com.cqu.stu_manager.controller;

import com.cqu.stu_manager.excel.NationalGrantsExcel;
import com.cqu.stu_manager.excel.NationalScholarshipExcel;
import com.cqu.stu_manager.excel.StudentListGuidanceCounselorExcel;
import com.cqu.stu_manager.excel.StudentListHeadmasterExcel;
import com.cqu.stu_manager.mapper.*;
import com.cqu.stu_manager.pojo.ExcelStuList;
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
    @PostMapping("/getStudentExcelInfoByHeadMaster")
    public List<String> getStudentExcelInfoByHeadMaster(@RequestBody Teacher teacher){
        List<String> class_name= classMapper.findClassByTeacher(teacher.getT_no().toString());
        List<Student> studentList=new ArrayList<>();
        StudentListHeadmasterExcel studentListHeadmasterExcel=new StudentListHeadmasterExcel(studentMapper,collegeEntranceExaminationMapper,familyMapper,accommodationMapper);
        List<String> addresslist=new ArrayList<>();
        for(int i=0;i<class_name.size();i++){
           addresslist.add(studentListHeadmasterExcel.StudentListHeadmasterExcel_Write(class_name.get(i))) ;
        }
        return addresslist;

    }
    @PostMapping("/getStudentExcelInfoByGuidanceCounselor")
    public String getStudentExcelInfoByGuidanceCounselor(@RequestBody Teacher teacher){
        StudentListGuidanceCounselorExcel
                studentListGuidanceCounselorExcel=
                new StudentListGuidanceCounselorExcel(studentMapper,collegeEntranceExaminationMapper,familyMapper,accommodationMapper,teacherMapper,classMapper);
    return     studentListGuidanceCounselorExcel.StudentListGuidanceCounselorExcel_Write(teacher.getT_no());
    }
    @PostMapping("/getAllStudentInfoByTemplateForGrant")
    public String getAllStudentInfoByTemplateForGrant(){
        NationalGrantsExcel nationalGrantsExcel=new NationalGrantsExcel(studentMapper);
        List<Student> studentList=new ArrayList<>();
        return nationalGrantsExcel.write_National_grants_excel(studentList);
    }
    @PostMapping("/getSomeStudentInfoByTemplateForGrant")
    public String getSomeStudentInfoByTemplateForGrant(@RequestBody ExcelStuList stuList){
        List<Student> studentList2=new ArrayList<>();

        for(int i:stuList.getStuList()){
            Student student=new Student();
            student.setStu_no(i);
            studentList2.add(student);
        }
        NationalGrantsExcel nationalGrantsExcel=new NationalGrantsExcel(studentMapper);
        return nationalGrantsExcel.write_National_grants_excel(studentList2);
    }
    @PostMapping("/getAllStudentInfoByTemplateForSchoolars")
    public String getAllStudentInfoByTemplateForSchoolars(){
        NationalScholarshipExcel nationalScholarshipExcel=new NationalScholarshipExcel(studentMapper);
        List<Student> studentList=new ArrayList<>();
        return nationalScholarshipExcel.write_National_scholarship_excel(studentList);
    }
    @PostMapping("/getSomeStudentInfoByTemplateForSchoolars")
    public String getSomeStudentInfoByTemplateForSchoolars(@RequestBody ExcelStuList stuList){
        NationalScholarshipExcel nationalScholarshipExcel=new NationalScholarshipExcel(studentMapper);
       List<Student> studentList=new ArrayList<>();
        for(int i:stuList.getStuList()){
            Student student=new Student();
            student.setStu_no(i);
            studentList.add(student);
        }
        return nationalScholarshipExcel.write_National_scholarship_excel(studentList);
    }
    @PostMapping("/getAllStudentInfoByTemplateForSchoolarsB")
    public String getAllStudentInfoByTemplateForSchoolarsB(){
        NationalScholarshipExcel nationalScholarshipExcel=new NationalScholarshipExcel(studentMapper);
        List<Student> studentList=new ArrayList<>();
        return nationalScholarshipExcel.write_National_scholarship_excel_forSelf_Improvement(studentList);
    }
    @PostMapping("/getSomeStudentInfoByTemplateForSchoolarsB")
    public String getSomeStudentInfoByTemplateForSchoolarsB(@RequestBody ExcelStuList stuList){
        NationalScholarshipExcel nationalScholarshipExcel=new NationalScholarshipExcel(studentMapper);
        List<Student> studentList=new ArrayList<>();
        for(int i:stuList.getStuList()){
            Student student=new Student();
            student.setStu_no(i);
            studentList.add(student);
        }
        return nationalScholarshipExcel.write_National_scholarship_excel_forSelf_Improvement(studentList);
    }

}
