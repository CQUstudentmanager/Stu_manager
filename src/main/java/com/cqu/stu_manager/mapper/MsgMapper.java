package com.cqu.stu_manager.mapper;

import com.cqu.stu_manager.pojo.Msg;
import com.cqu.stu_manager.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MsgMapper {
    int addMsg(Msg msg);
    List<String> findAllMsg(Teacher teacher);//找到该老师发布的所有消息
    Msg findOneMsg(String msg_no);//根据一条消息的msg_no找到对应消息
}
