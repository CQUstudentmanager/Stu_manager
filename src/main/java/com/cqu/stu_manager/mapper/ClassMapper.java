package com.cqu.stu_manager.mapper;

import com.cqu.stu_manager.pojo.Class;
import com.cqu.stu_manager.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface ClassMapper {
    List<Class> findAllClass();

    int updateClassinfo(Class class_) ;
    int insertClass(Class class_);

}
