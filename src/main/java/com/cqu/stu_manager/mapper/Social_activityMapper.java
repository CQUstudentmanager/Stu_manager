package com.cqu.stu_manager.mapper;

import com.cqu.stu_manager.pojo.Dispatch;
import com.cqu.stu_manager.pojo.Social_activity;
import com.cqu.stu_manager.pojo.Student;
import com.cqu.stu_manager.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface Social_activityMapper {
    List<Social_activity> findAllSocialActivity();
    List<Social_activity> findSocialActivityByStu(Student student);
    int insertSocialActivityByStudent(Social_activity social_activity);
    int deleteSocialActivityByStudent(Social_activity social_activity);
}
