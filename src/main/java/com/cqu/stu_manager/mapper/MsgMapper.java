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
    List<Msg> findAllMsg(Teacher teacher);//找到该老师发布的所有消息
    Msg findAllMsgByNo(Msg msg);
    Msg findMsgByMsgNo(String msg_no);


    int  updateMsg(Msg msg);

    int deleteMsg(String msg_no);
}
