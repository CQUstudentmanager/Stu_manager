package com.cqu.stu_manager.mapper;

import com.cqu.stu_manager.pojo.Family;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FamilyMapper {
    Family findMainmember(String stuno);
    List<Family> findAllMembers(String stuno);//找到所有家庭成员
    int updateFamilyInfo(Family family);

    int  addFamilyInfo(Family family);
}
