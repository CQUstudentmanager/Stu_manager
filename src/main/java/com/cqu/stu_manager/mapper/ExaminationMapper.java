package com.cqu.stu_manager.mapper;

import com.cqu.stu_manager.excel.pojo.Examination;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ExaminationMapper {
    int insertExaminationByExcel(Examination examination);
}
