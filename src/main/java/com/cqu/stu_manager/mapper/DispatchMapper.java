package com.cqu.stu_manager.mapper;

import com.cqu.stu_manager.pojo.Dispatch;
import com.cqu.stu_manager.pojo.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DispatchMapper {
    List<Dispatch> findAllDispatch();
    int insertDispatchByStudent(Dispatch dispatch);
    List<Dispatch> findDispatchByStuno(Student student);
}
