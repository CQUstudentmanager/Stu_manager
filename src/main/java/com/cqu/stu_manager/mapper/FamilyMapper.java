package com.cqu.stu_manager.mapper;

import com.cqu.stu_manager.pojo.Family;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FamilyMapper {
    Family findMainmenber(String stuno);
}