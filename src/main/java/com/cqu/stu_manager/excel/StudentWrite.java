package com.cqu.stu_manager.excel;

import com.alibaba.excel.EasyExcel;
import com.cqu.stu_manager.mapper.StudentMapper;
import com.cqu.stu_manager.pojo.Student;
import org.burningwave.core.assembler.StaticComponentContainer;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentWrite {
    @Autowired
    StudentMapper studentMapper;

    public StudentWrite(StudentMapper studentMapper){
        super();
        this.studentMapper=studentMapper;

    }
    public void studentinfo_out(){
        StaticComponentContainer.Modules.exportAllToAll();
        List<Student> studentList=new ArrayList<>();
        studentList=studentMapper.findAllStudent();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String format = sdf.format(new Date());
        System.out.println(format+"sdsddddddddddddddddddddddddddddddddddddddddddddddddddddd");
        String Path="C:\\Users\\lenovo\\IdeaProjects\\Stu_manager\\";
        String FileName=Path+"学生信息表"+format+".xls";
        EasyExcel.write(FileName,Student.class).sheet("学生信息表").doWrite(studentList);
    }
}
