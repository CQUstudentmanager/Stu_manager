package com.cqu.stu_manager.mapper;

import com.cqu.stu_manager.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentMapper {
    List<Student> findAllStudent();//找到所有的学生
    int upDateStudentInfo(Student student) ;//更新学生信息
    Student findOneStudent(int stu_no);//根据stu_no找对应的学生
    int upDatePassword(Student student);//更新密码
    List<Student> findStudentsByNO(String stu_name);//将stu_name当作stu_no进行模糊查询
    List<Student> findStudentsByName(String stu_name);//根据stu_name进行模糊查询
}
