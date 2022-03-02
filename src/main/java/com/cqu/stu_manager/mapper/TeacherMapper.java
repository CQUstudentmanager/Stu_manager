package com.cqu.stu_manager.mapper;

import com.cqu.stu_manager.pojo.Student;
import com.cqu.stu_manager.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface TeacherMapper {
    List<Teacher> findAllTeacher();
    Teacher findOneTeacher(int teacherId);
    int upDateTeacher(Teacher teacher);
    int upDatePassword(Teacher teacher);

    int addteacherByAdmin(Teacher teacher);

    int deleteTeacherByAdmin(Integer t_no);
}
