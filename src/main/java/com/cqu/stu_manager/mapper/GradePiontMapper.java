package com.cqu.stu_manager.mapper;

import com.cqu.stu_manager.excel.pojo.GradePoint;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GradePiontMapper {
int insertGradePiontByExcel(GradePoint gradePoint);

    GradePoint findGradePointByStuno(String grade_point_stu_no);

    void updateGradePoint(GradePoint gradePoint);
}
