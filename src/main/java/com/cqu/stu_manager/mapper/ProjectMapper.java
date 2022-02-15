package com.cqu.stu_manager.mapper;

import com.cqu.stu_manager.pojo.Project;
import com.cqu.stu_manager.pojo.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProjectMapper {
    List<Project> findAllProject();
    int insertProjectByStudent(Project project);
    List<Project> findProjectByStuno(Student student);

}
