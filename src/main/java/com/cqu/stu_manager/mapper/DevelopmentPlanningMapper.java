package com.cqu.stu_manager.mapper;

import com.cqu.stu_manager.pojo.DevelopmentPlanning;
import com.cqu.stu_manager.pojo.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DevelopmentPlanningMapper {
    List<DevelopmentPlanning> findAllDevelopment();
    List<DevelopmentPlanning> findPlanByStuNo(String stu_no);//找到对应学生的发展规划
    int insertPlan(DevelopmentPlanning plan);//插入发展规划
    int updatePlan(DevelopmentPlanning plan);//更新发展规划
    int passPlan(DevelopmentPlanning plan);//计划审核通过
    int rejectPlan(DevelopmentPlanning plan);//计划审核未通过
    int passPlan2(DevelopmentPlanning plan);//家长审核通过
    int rejectPlan2(DevelopmentPlanning plan);//家长审核未通过
}
