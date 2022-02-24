package com.cqu.stu_manager.mapper;

import com.cqu.stu_manager.pojo.Accommodation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AccommodationMapper {
    List<Accommodation> findAllAccommodation();
    Accommodation findStuAccommodation(String stuno);//根据学号单独查找住宿信息
    int updateAccommodationInfo(Accommodation accommodation);//更新宿舍信息
}
