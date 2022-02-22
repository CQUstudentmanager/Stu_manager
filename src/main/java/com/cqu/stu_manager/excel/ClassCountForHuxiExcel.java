package com.cqu.stu_manager.excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.cqu.stu_manager.excel.pojo.BedroomForHuxi;
import com.cqu.stu_manager.excel.pojo.ClassCountForHuxi;
import com.cqu.stu_manager.excel.pojo.Nationalgrants;
import com.cqu.stu_manager.mapper.AccommodationMapper;
import com.cqu.stu_manager.mapper.ClassMapper;
import com.cqu.stu_manager.mapper.StudentMapper;
import com.cqu.stu_manager.mapper.TeacherMapper;
import com.cqu.stu_manager.pojo.Accommodation;
import com.cqu.stu_manager.pojo.Class;
import com.cqu.stu_manager.pojo.Student;
import com.cqu.stu_manager.pojo.TypeAndCount;
import com.cqu.stu_manager.utils.InfoForTeacher;
import org.burningwave.core.assembler.StaticComponentContainer;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClassCountForHuxiExcel {
    @Autowired
    TeacherMapper teacherMapper;
    @Autowired
    ClassMapper classMapper;
    @Autowired
    AccommodationMapper accommodationMapper;
    @Autowired
    StudentMapper studentMapper;
    public ClassCountForHuxiExcel(AccommodationMapper accommodationMapper,TeacherMapper teacherMapper,ClassMapper classMapper,StudentMapper studentMapper){
        super();
        this.classMapper=classMapper;
        this.studentMapper=studentMapper;
        this.teacherMapper=teacherMapper;
        this.accommodationMapper=accommodationMapper;

    }

    public String ClassCountForHuxiExcel_write(Integer teacherNo){
        StaticComponentContainer.Modules.exportAllToAll();
        InfoForTeacher infoForTeacher=new InfoForTeacher(teacherMapper,classMapper,studentMapper);
        List<Class> rightClass;

            rightClass=    infoForTeacher.findRightClass(teacherNo);
            List<ClassCountForHuxi> classCountForHuxis = new ArrayList<>();
        List<BedroomForHuxi> bedroomForHuxis1=new ArrayList<>();
            for (int i=0;i<rightClass.size();i++){
                ClassCountForHuxi classCountForHuxi=new ClassCountForHuxi();
                List<Student> studentList;
                studentList=studentMapper.findStudentsByClass(rightClass.get(i).getClass_name());
                Integer count=0;
                count=studentList.size();
                classCountForHuxi.setHuxi_studentcount(count.toString());
                classCountForHuxi.setHuxi_class(rightClass.get(i).getClass_name());
                Integer count_boy=0;
                Integer count_girl=0;
                Integer count_down=0;

                for(int j=0;j<studentList.size();j++){
                    BedroomForHuxi bedroomForHuxi= new BedroomForHuxi();

                    if(studentList.get(j).getStu_gender().equals(1)){
                        count_boy++;
                    }else count_girl++;
                   String S="" ;String s_grade="";
                   S=studentList.get(j).getStu_no().toString().substring(2,4);
                   s_grade=rightClass.get(i).getClass_name().substring(0,2);
                    if(!S.equals(s_grade))
                        count_down++;
                    classCountForHuxi.setHuxi_major(studentList.get(j).getStu_major());
                    bedroomForHuxi.setName(studentList.get(j).getStu_name());
                    if(studentList.get(j).getStu_gender().equals(1))
                        bedroomForHuxi.setGender("男");
                    else bedroomForHuxi.setGender("女");
                    bedroomForHuxi.setMajor(studentList.get(j).getStu_major());
                    bedroomForHuxi.setGrade("20"+studentList.get(j).getStu_class().substring(0,2)+"级");
                    Accommodation accommodation=new Accommodation();
                    accommodation=accommodationMapper.findStuAccommodation(studentList.get(j).getStu_no().toString());
                    if(accommodation!=null){
                        bedroomForHuxi.setBuilding(accommodation.getAccommodation_information_building());
                        bedroomForHuxi.setRoom(accommodation.getAccommodation_information_room_no());
                    }
                    bedroomForHuxis1.add(bedroomForHuxi);
                }
                classCountForHuxi.setHuxi_boys(count_boy.toString());
                classCountForHuxi.setHuxi_girls(count_girl.toString());
                classCountForHuxi.setHuxi_down(count_down.toString());
                classCountForHuxi.setHuxi_exchange("");
                classCountForHuxis.add(classCountForHuxi);



            }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String format = sdf.format(new Date());
        System.out.println(format+"sdsddddddddddddddddddddddddddddddddddddddddddddddddddddd");
        String Path="C:\\Users\\lenovo\\IdeaProjects\\Stu_manager\\";
        String FileName=Path+"学院年级人数统计表"+format+".xls";
        String FileName2=Path+"学生详细名单"+format+".xls";
        ExcelWriter excelWriter=EasyExcel.write(FileName,ClassCountForHuxi.class).build();
        WriteSheet writeSheet1 = EasyExcel.writerSheet(0, "学院年级人数统计表").build();
        excelWriter.write(classCountForHuxis,writeSheet1);
        excelWriter.finish();
        EasyExcel.write(FileName2, BedroomForHuxi.class).sheet("详细名单").doWrite(bedroomForHuxis1);

        return "ok";

    }


}
