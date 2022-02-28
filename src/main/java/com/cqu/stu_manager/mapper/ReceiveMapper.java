package com.cqu.stu_manager.mapper;

import com.cqu.stu_manager.pojo.Msg;
import com.cqu.stu_manager.pojo.Receive;
import com.cqu.stu_manager.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ReceiveMapper {
    int addReceiver(Receive receive);
    List<Receive> findAlreadyReady(String msg_no2);
    List<Receive> findNotRead(String msg_no2);
    List<Receive> findHaveDone(String msg_no2);
    List<Receive> findmsgnoByreceiver(Integer receiver_no);
    List<Receive> findAll(String msg_no2);

    int  readMsg(String msg_no,Integer receiver);

    int  finish(String msg_no,Integer receiver);

    int deleteByMsgNo(String msg_no);
}
