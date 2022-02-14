package com.cqu.stu_manager.mapper;

import com.cqu.stu_manager.pojo.Patent;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PatentMapper {
    List<Patent> findAllPatent();
}
