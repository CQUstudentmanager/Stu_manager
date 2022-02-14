package com.cqu.stu_manager.mapper;

import com.cqu.stu_manager.pojo.Voluntary_activities;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface Voluntary_activitiesMapper {
    List<Voluntary_activities> findAllVoluntary_activities();
}
