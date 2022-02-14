package com.cqu.stu_manager.mapper;

import com.cqu.stu_manager.pojo.Paper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface PaperMapper {
    List<Paper> findAllStuPaper();

}
