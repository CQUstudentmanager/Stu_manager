package com.cqu.stu_manager.excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.annotation.ExcelProperty;
import com.cqu.stu_manager.excel.pojo.Bedroom;
import com.cqu.stu_manager.excel.pojo.Nationalgrants;
import com.cqu.stu_manager.mapper.AccommodationMapper;
import com.cqu.stu_manager.mapper.FamilyMapper;
import com.cqu.stu_manager.mapper.StudentMapper;
import com.cqu.stu_manager.pojo.Accommodation;
import com.cqu.stu_manager.pojo.Family;
import com.cqu.stu_manager.pojo.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.burningwave.core.assembler.StaticComponentContainer;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.*;

public class BedroomExcel {
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    AccommodationMapper accommodationMapper;
    @Autowired
    FamilyMapper familyMapper;
    public BedroomExcel(AccommodationMapper accommodationMapper, StudentMapper studentMapper, FamilyMapper familyMapper){
 super();
 this.accommodationMapper=accommodationMapper;
 this.studentMapper=studentMapper;
 this.familyMapper=familyMapper;
    }
    public void allStuBedroomInfo_writ(){
        StaticComponentContainer.Modules.exportAllToAll();
        List<Bedroom> bedrooms=new ArrayList<>();
        List<Student> studentList=new ArrayList<>();
        studentList=studentMapper.findAllStudent();
        List<Student> order_studentlist=new ArrayList<>();
        for(Student student:studentList){
            Bedroom bedroom=new Bedroom();
            bedroom.setBedroom_stuno(student.getStu_no().toString());
            bedroom.setBedroom_stu_class(student.getStu_class());
            bedroom.setBedroom_stuname(student.getStu_name());
            if(student.getStu_gender()==1){
                bedroom.setBedroom_stu_gender("男");
            }else bedroom.setBedroom_stu_gender("女");
            bedroom.setBedroom_stu_ethnic(student.getStu_ethnic());
            bedroom.setBedroom_stu_tel(student.getStu_telephone());
            bedroom.setBedroom_stu_province(student.getStu_origin());
            Accommodation accommodation=new Accommodation();
            accommodation=accommodationMapper.findStuAccommodation(student.getStu_no().toString());

            if(accommodation!=null) {
                bedroom.setBedroom_buildingandroom(accommodation.getAccommodation_information_building()+accommodation.getAccommodation_information_room_no());
                if(accommodation.getAccommodation_information_ismain()!=null&&accommodation.getAccommodation_information_ismain().equals("是"))
                { bedroom.setBedroom_ps("寝室长");}else bedroom.setBedroom_ps("");
            }else bedroom.setBedroom_buildingandroom("");
            Family family=new Family();
            family=familyMapper.findMainmenber(student.getStu_no().toString());
            if(family!=null){
                bedroom.setFamily_tel(family.getFamily_tel());
            }else bedroom.setFamily_tel("");

            bedrooms.add(bedroom);
        }
        bedrooms.sort(Comparator.comparing(Bedroom::getBedroom_buildingandroom));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String format = sdf.format(new Date());
        //System.out.println(format+"sdsddddddddddddddddddddddddddddddddddddddddddddddddddddd");
        String Path="C:\\Users\\lenovo\\IdeaProjects\\Stu_manager\\";
        String FileName=Path+"寝室基本信息"+format+".xls";
        EasyExcel.write(FileName, Bedroom.class).sheet("助学金信息表").doWrite(bedrooms);

    }



}
