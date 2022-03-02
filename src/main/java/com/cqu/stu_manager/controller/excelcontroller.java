package com.cqu.stu_manager.controller;

import com.cqu.stu_manager.excel.*;
import com.cqu.stu_manager.mapper.*;
import com.cqu.stu_manager.pojo.Class;
import com.cqu.stu_manager.pojo.ExcelStuList;
import com.cqu.stu_manager.pojo.Student;
import com.cqu.stu_manager.pojo.Teacher;
import com.cqu.stu_manager.utils.InfoForTeacher;
import com.cqu.stu_manager.utils.Result;
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
    @PostMapping("getStudentBedroomInfo")
    public Result getStudentBedroomInfo(@RequestBody Teacher teacher){
        BedroomExcel bedroomExcel=new BedroomExcel(accommodationMapper,studentMapper,familyMapper);
        InfoForTeacher infoForTeacher=new InfoForTeacher(teacherMapper,classMapper,studentMapper);
        List<Class> right_class=new ArrayList<>();
        right_class=infoForTeacher.findRightClass(teacher.getT_no());
        List<Student> studentList=new ArrayList<>();
        List<Student> right_studentlist=new ArrayList<>();
        studentList=studentMapper.findAllStudent();
        for (int i=0;i<studentList.size();i++){
            for (int j=0;j<right_class.size();j++){
                if (studentList.get(i).getStu_class().equals(right_class.get(j).getClass_name())){
                    right_studentlist.add(studentList.get(i));
                }
            }
        }
        Result result=new Result();
        result.setData(bedroomExcel.allStuBedroomInfo_writ(right_studentlist));
        return result;


    }
    @PostMapping("/getHuxiInfo")
    public Result  getHuxiInfo(@RequestBody Teacher teacher){
        ClassCountForHuxiExcel classCountForHuxiExcel=new
                ClassCountForHuxiExcel(accommodationMapper,teacherMapper,classMapper,studentMapper);

        Result result=new Result();
        result.setData(classCountForHuxiExcel.ClassCountForHuxiExcel_write(teacher.getT_no()));
        return result;

    }


    @PostMapping("/getStudentExcelInfoByHeadMaster")
    public Result  getStudentExcelInfoByHeadMaster(@RequestBody Teacher teacher){
        List<String> class_name= classMapper.findClassByTeacher(teacher.getT_no().toString());
        List<Student> studentList=new ArrayList<>();
        StudentListHeadmasterExcel studentListHeadmasterExcel=new StudentListHeadmasterExcel(studentMapper,collegeEntranceExaminationMapper,familyMapper,accommodationMapper);
        List<String> addresslist=new ArrayList<>();
        for(int i=0;i<class_name.size();i++){
           addresslist.add(studentListHeadmasterExcel.StudentListHeadmasterExcel_Write(class_name.get(i))) ;
        }
        Result result=new Result();
        result.setData(addresslist);
        return result;

    }
    @PostMapping("/getStudentExcelInfoByGuidanceCounselor")
    public Result getStudentExcelInfoByGuidanceCounselor(@RequestBody Teacher teacher){
        StudentListGuidanceCounselorExcel
                studentListGuidanceCounselorExcel=
                new StudentListGuidanceCounselorExcel(studentMapper,collegeEntranceExaminationMapper,familyMapper,accommodationMapper,teacherMapper,classMapper);
        Result result=new Result<>();
         result.setData(studentListGuidanceCounselorExcel.StudentListGuidanceCounselorExcel_Write(teacher.getT_no()));
         return  result;
    }
    @PostMapping("/getAllStudentInfoByTemplateForGrant")
    public Result getAllStudentInfoByTemplateForGrant(@RequestBody Teacher teacher){
        NationalGrantsExcel nationalGrantsExcel=new NationalGrantsExcel(studentMapper);
        List<Student> studentList=new ArrayList<>();
        InfoForTeacher infoForTeacher=new InfoForTeacher(teacherMapper,classMapper,studentMapper);
        List<Class> RIGHTCLASS=infoForTeacher.findRightClass(teacher.getT_no());
        studentList=studentMapper.findAllStudent();
        List<Student>right_studentlist=new ArrayList<>();
        for (int i=0;i<studentList.size();i++){
                for(int j=0;j<RIGHTCLASS.size();j++){
                    if(studentList.get(i).getStu_class().equals(RIGHTCLASS.get(j).getClass_name())){
                        Student student=new Student();
                        student=studentList.get(i);
                        right_studentlist.add(student);
                    }
                }
        }
        Result result=new Result();
        result.setData(nationalGrantsExcel.write_National_grants_excel(right_studentlist));
        return result;
    }
    @PostMapping("/getSomeStudentInfoByTemplateForGrant")
    public Result  getSomeStudentInfoByTemplateForGrant(@RequestBody ExcelStuList stuList){
        List<Student> studentList2=new ArrayList<>();

        for(int i:stuList.getStuList()){
            Student student=new Student();
            student.setStu_no(i);
            studentList2.add(student);
        }
        NationalGrantsExcel nationalGrantsExcel=new NationalGrantsExcel(studentMapper);
        Result result=new Result();
        result.setData(nationalGrantsExcel.write_National_grants_excel(studentList2));
        return result;
    }
    @PostMapping("/getAllStudentInfoByTemplateForSchoolars")
    public Result getAllStudentInfoByTemplateForSchoolars(@RequestBody Teacher teacher){
        NationalScholarshipExcel nationalScholarshipExcel=new NationalScholarshipExcel(studentMapper);
        InfoForTeacher infoForTeacher=new InfoForTeacher(teacherMapper,classMapper,studentMapper);
        List<Class> right_class=new ArrayList<>();
        right_class=infoForTeacher.findRightClass(teacher.getT_no());
        List<Student> studentList=new ArrayList<>();
        List<Student> right_studentlist=new ArrayList<>();
        studentList=studentMapper.findAllStudent();
        for (int i=0;i<studentList.size();i++){
            for (int j=0;j<right_class.size();j++){
                if(studentList.get(i).getStu_class().equals(right_class.get(j).getClass_name())){
                    right_studentlist.add(studentList.get(i));
                }
            }
        }
        Result result=new Result();
        result.setData(nationalScholarshipExcel.write_National_scholarship_excel(right_studentlist));
        return result;
    }
    @PostMapping("/getSomeStudentInfoByTemplateForSchoolars")
    public Result getSomeStudentInfoByTemplateForSchoolars(@RequestBody ExcelStuList stuList){
        NationalScholarshipExcel nationalScholarshipExcel=new NationalScholarshipExcel(studentMapper);
       List<Student> studentList=new ArrayList<>();
        for(int i:stuList.getStuList()){
            Student student=new Student();
            student.setStu_no(i);
            studentList.add(student);
        }
        Result result=new Result();
        result.setData(nationalScholarshipExcel.write_National_scholarship_excel(studentList));
        return result;
    }
    @PostMapping("/getAllStudentInfoByTemplateForSchoolarsB")
    public Result getAllStudentInfoByTemplateForSchoolarsB(@RequestBody Teacher teacher){
        NationalScholarshipExcel nationalScholarshipExcel=new NationalScholarshipExcel(studentMapper);
        List<Class> right_class=new ArrayList<>();
        InfoForTeacher infoForTeacher=new InfoForTeacher(teacherMapper,classMapper,studentMapper);
        right_class=infoForTeacher.findRightClass(teacher.getT_no());
        List<Student> studentList=new ArrayList<>();
        List<Student> right_studentlist=new ArrayList<>();
        for (int i=0;i<studentList.size();i++){
            for(int j=0;j<right_class.size();j++){
                if(studentList.get(i).getStu_class().equals(right_class.get(i).getClass_name())){
                    right_studentlist.add(studentList.get(i));
                }
            }
        }
        Result result=new Result();
        result.setData(nationalScholarshipExcel.write_National_scholarship_excel_forSelf_Improvement(right_studentlist));
        return result;
    }
    @PostMapping("/getSomeStudentInfoByTemplateForSchoolarsB")
    public Result getSomeStudentInfoByTemplateForSchoolarsB(@RequestBody ExcelStuList stuList){
        NationalScholarshipExcel nationalScholarshipExcel=new NationalScholarshipExcel(studentMapper);
        List<Student> studentList=new ArrayList<>();
        for(int i:stuList.getStuList()){
            Student student=new Student();
            student.setStu_no(i);
            studentList.add(student);
        }
        Result result=new Result();
        result.setData(nationalScholarshipExcel.write_National_scholarship_excel_forSelf_Improvement(studentList));
        return result;
    }

}
