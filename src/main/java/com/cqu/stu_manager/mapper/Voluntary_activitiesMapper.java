package com.cqu.stu_manager.mapper;

import com.cqu.stu_manager.pojo.Student;
import com.cqu.stu_manager.pojo.Voluntary_activities;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface Voluntary_activitiesMapper {
    List<Voluntary_activities> findAllVoluntary_activities();
    int insertVoluntary_activitiesByStudent(Voluntary_activities voluntary_activities);
    int updateVoluntary_activitiesByStudent(Voluntary_activities voluntary_activities);
    List<Voluntary_activities> findVoluntary_activitiesByStuno(Student student);
    int deleteActivity(Voluntary_activities activity);//删除志愿活动信息
    int pass_activity(Voluntary_activities activity);
    int refuse_activity(Voluntary_activities activity);
}
