package com.cqu.stu_manager.excel;

import com.alibaba.excel.EasyExcel;
import com.cqu.stu_manager.excel.pojo.FilePath;
import com.cqu.stu_manager.excel.pojo.StudentListGuidanceCounselor;
import com.cqu.stu_manager.excel.pojo.StudentListHeadmaster;
import com.cqu.stu_manager.mapper.*;
import com.cqu.stu_manager.pojo.*;
import com.cqu.stu_manager.pojo.Class;
import org.burningwave.core.assembler.StaticComponentContainer;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentListGuidanceCounselorExcel {
    @Autowired
    ClassMapper classMapper;
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    CollegeEntranceExaminationMapper collegeEntranceExaminationMapper;
    @Autowired
    FamilyMapper familyMapper;
    @Autowired
    AccommodationMapper accommodationMapper;
    @Autowired
    TeacherMapper teacherMapper;
    public StudentListGuidanceCounselorExcel(StudentMapper studentMapper ,CollegeEntranceExaminationMapper collegeEntranceExaminationMapper,FamilyMapper familyMapper,AccommodationMapper accommodationMapper,TeacherMapper teacherMapper,ClassMapper classMapper){
        super();
        this.studentMapper=studentMapper;
        this.collegeEntranceExaminationMapper=collegeEntranceExaminationMapper;
        this.familyMapper=familyMapper;
        this.accommodationMapper=accommodationMapper;
        this.teacherMapper=teacherMapper;
        this.classMapper=classMapper;

    }
    public String StudentListGuidanceCounselorExcel_Write(Integer teacherNo){
        Teacher teacher=new Teacher();
        teacher=teacherMapper.findOneTeacher(teacherNo);
        if(teacher==null){
            return "您的权限不足";
        }else {
            List<Class> classList=new ArrayList<>();
            List<Class> right_classlist=new ArrayList<>();
            classList=classMapper.findAllClass();
            String teaidenty;
            if(teacher.getT_identity().toString().length()==2){
            teaidenty=teacher.getT_identity().toString().substring(0,2);}
            else return "您的权限不足";

            for(int i=0;i<classList.size();i++){
                if(classList.get(i).getClass_name().substring(0,2).equals(teaidenty)){
                    right_classlist.add(classList.get(i));
                }

            }


        StaticComponentContainer.Modules.exportAllToAll();
            List <Student> studentList =new ArrayList<>();

            for (int i=0;i<right_classlist.size();i++){
                List<Student> tempList=new ArrayList<>();
                tempList=studentMapper.findStudentsByClass(right_classlist.get(i).getClass_name());
                studentList.addAll(tempList);
            }
            List<StudentListGuidanceCounselor> studentListGuidanceCounselors=new ArrayList<>();
            for (int i=0;i<studentList.size();i++){
                StudentListHeadmaster studentListHeadmaster=new StudentListHeadmaster();
                StudentListGuidanceCounselor studentListGuidanceCounselor=new StudentListGuidanceCounselor();
                studentListGuidanceCounselor.setExcel_no(i+1);
                studentListGuidanceCounselor.setStu_no(studentList.get(i).getStu_no().toString());
                studentListGuidanceCounselor.setStu_name(studentList.get(i).getStu_name());
                studentListGuidanceCounselor.setStu_class(studentList.get(i).getStu_class());
                if(studentList.get(i).getStu_gender().equals(1)){
                    studentListGuidanceCounselor.setStu_gender("男");
                }else studentListGuidanceCounselor.setStu_gender("女");
                studentListGuidanceCounselor.setStu_ethnic(studentList.get(i).getStu_ethnic());
                studentListGuidanceCounselor.setStu_origin(studentList.get(i).getStu_origin());
                studentListGuidanceCounselor.setStu_tel(studentList.get(i).getStu_telephone());
                studentListGuidanceCounselor.setStu_id(studentList.get(i).getStu_id());
                studentListGuidanceCounselor.setStu_qq(studentList.get(i).getStu_qq());
                studentListGuidanceCounselor.setStu_email(studentList.get(i).getStu_email());
                studentListGuidanceCounselor.setStu_adress(studentList.get(i).getStu_address());
                Family family=new Family();
                family=familyMapper.findMainmenber(studentList.get(i).getStu_no().toString());
                if(family==null){
                    studentListGuidanceCounselor.setStu_family_tel("");
                }else studentListGuidanceCounselor.setStu_family_tel(family.getFamily_tel());
                studentListGuidanceCounselor.setStu_politicalface(studentList.get(i).getStu_politicalface());
                Accommodation accommodation=new Accommodation();
                accommodation=accommodationMapper.findStuAccommodation(studentList.get(i).getStu_no().toString());
                if(accommodation==null){
                    studentListGuidanceCounselor.setStu_accommodation_information_building("");
                    studentListGuidanceCounselor.setStu_accommodation_information_room_no("");
                    studentListGuidanceCounselor.setStu_accommodation_information_bed("");
                }else {
                    studentListGuidanceCounselor.setStu_accommodation_information_building(accommodation.getAccommodation_information_building());
                    studentListGuidanceCounselor.setStu_accommodation_information_room_no(accommodation.getAccommodation_information_room_no());
                    studentListGuidanceCounselor.setStu_accommodation_information_bed(accommodation.getAccommodation_information_bed());
                }

                CollegeEntranceExamination collegeEntranceExamination=new CollegeEntranceExamination();
                collegeEntranceExamination=collegeEntranceExaminationMapper.findStudentCollegeEntranceExamination(studentList.get(i).getStu_no().toString());
                if(collegeEntranceExamination==null){
                    studentListGuidanceCounselor.setStu_college_entrance_examination_type("");
                    studentListGuidanceCounselor.setStu_highschool_name("");
                }else {
                    studentListGuidanceCounselor.setStu_college_entrance_examination_type(collegeEntranceExamination.getCollege_entrance_examination_type());
                    studentListGuidanceCounselor.setStu_highschool_name(collegeEntranceExamination.getCollege_entrance_examination_highschool_name());
                }

                studentListGuidanceCounselors.add(studentListGuidanceCounselor);

            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            String format = sdf.format(new Date());
            FilePath filePath=new FilePath();
            String FileName=filePath.getPath()+teaidenty+"级"+"本科生名单（辅导员）"+format+".xls";
            EasyExcel.write(FileName, StudentListGuidanceCounselor.class).sheet("本科生名单").doWrite(studentListGuidanceCounselors);
        return FileName;}
    }
}
