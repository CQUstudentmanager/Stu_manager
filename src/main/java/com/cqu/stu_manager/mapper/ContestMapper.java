package com.cqu.stu_manager.mapper;

import com.cqu.stu_manager.pojo.Contest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ContestMapper {
    List<Contest> findAllContest();
}
