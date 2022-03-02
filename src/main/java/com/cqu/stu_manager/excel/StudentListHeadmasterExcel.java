package com.cqu.stu_manager.excel;

import com.alibaba.excel.EasyExcel;
import com.cqu.stu_manager.excel.pojo.FilePath;
import com.cqu.stu_manager.excel.pojo.Nationalscholarship;
import com.cqu.stu_manager.excel.pojo.StudentListHeadmaster;
import com.cqu.stu_manager.mapper.AccommodationMapper;
import com.cqu.stu_manager.mapper.CollegeEntranceExaminationMapper;
import com.cqu.stu_manager.mapper.FamilyMapper;
import com.cqu.stu_manager.mapper.StudentMapper;
import com.cqu.stu_manager.pojo.Accommodation;
import com.cqu.stu_manager.pojo.CollegeEntranceExamination;
import com.cqu.stu_manager.pojo.Family;
import com.cqu.stu_manager.pojo.Student;
import org.burningwave.core.assembler.StaticComponentContainer;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentListHeadmasterExcel {
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    CollegeEntranceExaminationMapper collegeEntranceExaminationMapper;
    @Autowired
    FamilyMapper familyMapper;
    @Autowired
    AccommodationMapper accommodationMapper;

    public StudentListHeadmasterExcel(StudentMapper studentMapper ,CollegeEntranceExaminationMapper collegeEntranceExaminationMapper,FamilyMapper familyMapper,AccommodationMapper accommodationMapper){
        super();
        this.studentMapper=studentMapper;
        this.collegeEntranceExaminationMapper=collegeEntranceExaminationMapper;
        this.familyMapper=familyMapper;
        this.accommodationMapper=accommodationMapper;

    }
    public String StudentListHeadmasterExcel_Write(String class_name){
        StaticComponentContainer.Modules.exportAllToAll();
        List <Student> studentList =new ArrayList<>();
        List<StudentListHeadmaster> studentListHeadmasterList=new ArrayList<>();
        studentList=studentMapper.findStudentsByClass(class_name);
        for (int i=0;i<studentList.size();i++){
            StudentListHeadmaster studentListHeadmaster=new StudentListHeadmaster();
            studentListHeadmaster.setExcel_no(i+1);
            studentListHeadmaster.setStu_no(studentList.get(i).getStu_no().toString());
            studentListHeadmaster.setStu_name(studentList.get(i).getStu_name());
            studentListHeadmaster.setStu_class(studentList.get(i).getStu_class());
            if(studentList.get(i).getStu_gender().equals(1)){
                studentListHeadmaster.setStu_gender("男");
            }else studentListHeadmaster.setStu_gender("女");
            studentListHeadmaster.setStu_ethnic(studentList.get(i).getStu_ethnic());
            studentListHeadmaster.setStu_origin(studentList.get(i).getStu_origin());
            studentListHeadmaster.setStu_tel(studentList.get(i).getStu_telephone());
            Family family=new Family();
            family=familyMapper.findMainmember(studentList.get(i).getStu_no().toString());
            if(family==null){
                studentListHeadmaster.setStu_family_tel("");
            }else studentListHeadmaster.setStu_family_tel(family.getFamily_tel());
            studentListHeadmaster.setStu_politicalface(studentList.get(i).getStu_politicalface());
            Accommodation accommodation=new Accommodation();
            accommodation=accommodationMapper.findStuAccommodation(studentList.get(i).getStu_no().toString());
            if(accommodation==null){
                studentListHeadmaster.setStu_accommodation_information_building("");
                studentListHeadmaster.setStu_accommodation_information_room_no("");
                studentListHeadmaster.setStu_accommodation_information_bed("");
            }else {
                studentListHeadmaster.setStu_accommodation_information_building(accommodation.getAccommodation_information_building());
                studentListHeadmaster.setStu_accommodation_information_room_no(accommodation.getAccommodation_information_room_no());
                studentListHeadmaster.setStu_accommodation_information_bed(accommodation.getAccommodation_information_bed());
            }

            CollegeEntranceExamination collegeEntranceExamination=new CollegeEntranceExamination();
            collegeEntranceExamination=collegeEntranceExaminationMapper.findStudentCollegeEntranceExamination(studentList.get(i).getStu_no().toString());
            if(collegeEntranceExamination==null){
                studentListHeadmaster.setStu_college_entrance_examination_type("");
                studentListHeadmaster.setStu_highschool_name("");
            }else {
                studentListHeadmaster.setStu_college_entrance_examination_type(collegeEntranceExamination.getCollege_entrance_examination_type());
                studentListHeadmaster.setStu_highschool_name(collegeEntranceExamination.getCollege_entrance_examination_highschool_name());
            }

            studentListHeadmasterList.add(studentListHeadmaster);

        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String format = sdf.format(new Date());
        System.out.println(format+"sdsddddddddddddddddddddddddddddddddddddddddddddddddddddd");
        FilePath filePath=new FilePath();
        String FileName=filePath.getPath()+"本科生名单（班主任）"+class_name+"班"+format+".xls";
        EasyExcel.write(FileName, StudentListHeadmaster.class).sheet("本科生名单").doWrite(studentListHeadmasterList);
        return "本科生名单（班主任）"+class_name+"班"+format+".xls";
    }
}
