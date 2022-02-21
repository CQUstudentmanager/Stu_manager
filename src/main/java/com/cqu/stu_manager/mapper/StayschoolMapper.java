package com.cqu.stu_manager.mapper;

import com.cqu.stu_manager.pojo.Stayschool;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StayschoolMapper {
    int addStayschoolInfoByStu(Stayschool stayschool);
    List<Stayschool> findAllStayschoolInfo2();
    List<Stayschool> findAllStayschoolInfo(Stayschool nowTime);
    int updateStayschoolInfo(Stayschool stayschool);
}
