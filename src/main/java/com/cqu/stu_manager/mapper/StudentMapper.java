package com.cqu.stu_manager.mapper;

import com.cqu.stu_manager.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentMapper {
    List<Student> findAllStudent();
    Student findloginPassword(int userno);
    int upDatestudentinfo(Student student) ;
    Student findOneStudent(int stu_no);
    int upDatePassword(Student student);
}
