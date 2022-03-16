package com.cqu.stu_manager.mapper;

import com.cqu.stu_manager.pojo.Plan;
import com.cqu.stu_manager.pojo.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PlanMapper {
    Plan  findMyPlan(Student student);
    int deletePlan(Plan plan);
    int insertPlan(Plan plan);

}
