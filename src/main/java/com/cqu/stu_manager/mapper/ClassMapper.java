package com.cqu.stu_manager.mapper;

import com.cqu.stu_manager.pojo.Class;
import com.cqu.stu_manager.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface ClassMapper {
    List<Class> findAllClass();//找到所有班级的信息
    int updateClassinfo(Class class_) ;
    int insertClass(Class class_);
    List<String> findClassByTeacher(String teacherID);

    int  setclassmaster(int class_id, Integer t_no);
}
