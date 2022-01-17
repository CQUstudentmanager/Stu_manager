package com.cqu.stu_manager;

import com.cqu.stu_manager.mapper.MsgMapper;
import com.cqu.stu_manager.mapper.ReceiveMapper;
import com.cqu.stu_manager.mapper.StudentMapper;
import com.cqu.stu_manager.pojo.Msg;
import com.cqu.stu_manager.pojo.Receive;
import com.cqu.stu_manager.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
class StuManagerApplicationTests {
@Autowired
    StudentMapper studentMapper;
@Autowired
    ReceiveMapper receiveMapper;
@Autowired
    MsgMapper msgMapper;
    @Test
    void contextLoads() {

        Msg msg=new Msg();
        List<Msg> msgList=new ArrayList<>();
        Receive receive=new Receive();
        receive.setReceiver(20204146);
        List<Receive> msgnolist=receiveMapper.findmsgnoByreceiver(receive);
        System.out.println(msgnolist);
        if (msgnolist.isEmpty()){
            msg.setMsg_content("没有查询到你的通知");
            msgList.add(msg);
            System.out.println(msgList);
        }
        else {


            for (int i=0;i<msgnolist.size();i++){
                msg.setMsg_no(msgnolist.get(i).getMsg_no2());
                msg=msgMapper.findAllMsgByNo(msg);
                msgList.add(msg);

            }

            System.out.println(msgList);
        }


    }

}
