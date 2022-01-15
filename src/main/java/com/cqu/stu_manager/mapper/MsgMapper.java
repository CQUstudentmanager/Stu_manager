package com.cqu.stu_manager.mapper;

import com.cqu.stu_manager.pojo.Msg;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MsgMapper {
    int addMsg(Msg msg);
}
