package com.cqu.stu_manager.excel;

import com.alibaba.excel.EasyExcel;
import com.cqu.stu_manager.excel.pojo.Nationalscholarship;
import com.cqu.stu_manager.mapper.StudentMapper;
import com.cqu.stu_manager.pojo.Student;
import org.burningwave.core.assembler.StaticComponentContainer;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NationalScholarshipExcel {
    @Autowired
    StudentMapper studentMapper;
    public NationalScholarshipExcel(StudentMapper studentMapper){
        super();
        this.studentMapper=studentMapper;

    }
    public String write_National_scholarship_excel(List<Student> studentList2){
        StaticComponentContainer.Modules.exportAllToAll();
        List<Student> studentList=new ArrayList<>();
        if (studentList2.size()==0){
            studentList=studentMapper.findAllStudent();
        }else {
            for (int i=0;i<studentList2.size();i++){
                Student student=new Student();
                student=studentMapper.findOneStudent(studentList2.get(i).getStu_no());
                studentList.add(student);
            }
        }

        List<Nationalscholarship> nationalscholarship_s =new ArrayList<>();
        for(int i=0;i<studentList.size();i++){
            Nationalscholarship nationalscholarship_ =new Nationalscholarship();
            nationalscholarship_.setStu_name(studentList.get(i).getStu_name());
            nationalscholarship_.setStu_id(studentList.get(i).getStu_id());
            nationalscholarship_.setStu_dept("大数据与软件学院");
            nationalscholarship_.setStu_major(studentList.get(i).getStu_major());
            nationalscholarship_.setStu_no(studentList.get(i).getStu_no());
            nationalscholarship_.setStu_ethnic(studentList.get(i).getStu_ethnic());
            nationalscholarship_.setStu_birthday(studentList.get(i).getStu_birthday());
            nationalscholarship_.setExcel_no(i+1);
            nationalscholarship_.setStu_join_time(studentList.get(i).getStu_join_time());
            if(studentList.get(i).getStu_gender().equals(1)){
                nationalscholarship_.setStu_gender("男");
            }else nationalscholarship_.setStu_gender("女");
            nationalscholarship_s.add(nationalscholarship_);

        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String format = sdf.format(new Date());
        System.out.println(format+"sdsddddddddddddddddddddddddddddddddddddddddddddddddddddd");
        String Path="D:\\";
        String FileName=Path+"奖学金信息表"+format+".xls";
        EasyExcel.write(FileName, Nationalscholarship.class).sheet("奖学金信息表").doWrite(nationalscholarship_s);
        return FileName;
    }
    public String write_National_scholarship_excel_forSelf_Improvement(List<Student> studentList2){
        StaticComponentContainer.Modules.exportAllToAll();

        List<Student> studentList=new ArrayList<>();
        if (studentList2.size()==0){
            studentList=studentMapper.findAllStudent();
        }else {
            for (int i=0;i<studentList2.size();i++){
                Student student=new Student();
                student=studentMapper.findOneStudent(studentList2.get(i).getStu_no());
                studentList.add(student);
            }
        }

        List<Nationalscholarship> nationalscholarship_s =new ArrayList<>();
        for(int i=0;i<studentList.size();i++){
            Nationalscholarship nationalscholarship_ =new Nationalscholarship();
            nationalscholarship_.setStu_name(studentList.get(i).getStu_name());
            nationalscholarship_.setStu_id(studentList.get(i).getStu_id());
            nationalscholarship_.setStu_dept("大数据与软件学院");
            nationalscholarship_.setStu_major(studentList.get(i).getStu_major());
            nationalscholarship_.setStu_no(studentList.get(i).getStu_no());
            nationalscholarship_.setStu_ethnic(studentList.get(i).getStu_ethnic());
            nationalscholarship_.setStu_birthday(studentList.get(i).getStu_birthday());
            nationalscholarship_.setExcel_no(i+1);

            if(studentList.get(i).getStu_gender().equals(1)){
                nationalscholarship_.setStu_gender("男");
            }else nationalscholarship_.setStu_gender("女");
            nationalscholarship_s.add(nationalscholarship_);

        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String format = sdf.format(new Date());
        System.out.println(format+"sdsddddddddddddddddddddddddddddddddddddddddddddddddddddd");
        String Path="D:\\";
        String FileName=Path+"励志奖学金信息表"+format+".xls";
        EasyExcel.write(FileName, Nationalscholarship.class).sheet("励志奖学金信息表").doWrite(nationalscholarship_s);
        return FileName;
    }
}
