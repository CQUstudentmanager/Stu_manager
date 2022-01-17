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
    int findAlreadyReady(String msg_no);
    int findNotRead(String msg_no);
    List<Receive> findmsgnoByreceiver(Receive receive);
}
