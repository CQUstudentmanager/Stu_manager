package com.cqu.stu_manager.mapper;

import com.cqu.stu_manager.pojo.CollegeEntranceExamination;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CollegeEntranceExaminationMapper

{
    CollegeEntranceExamination findStudentCollegeEntranceExamination(String stuno);
}
