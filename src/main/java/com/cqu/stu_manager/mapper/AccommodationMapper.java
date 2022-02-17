package com.cqu.stu_manager.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AccommodationMapper {
    List<AccommodationMapper> findAllAccommodation();
}
