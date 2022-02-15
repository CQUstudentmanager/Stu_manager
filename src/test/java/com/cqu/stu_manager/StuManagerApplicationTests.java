package com.cqu.stu_manager;

import com.cqu.stu_manager.mapper.*;
import com.cqu.stu_manager.pojo.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class StuManagerApplicationTests {
@Autowired
    StudentMapper studentMapper;
@Autowired
    ReceiveMapper receiveMapper;
@Autowired
    ContestMapper contestMapper;
@Autowired
PaperMapper paperMapper;
@Autowired
PatentMapper patentMapper;
@Autowired
ProjectMapper projectMapper;
@Autowired
DispatchMapper dispatchMapper;
@Autowired
Voluntary_activitiesMapper voluntary_activitiesMapper;

    @Test
    void contextLoads() {
        Student student=new Student();
        student.setStu_no(123);
       Dispatch dispatch=new Dispatch();
       dispatch.setDispatch_no(2123);
       dispatch.setDispatch_name("事件发生的叫法是觉得很费解啊可是饭卡");
       dispatch.setDispatch_stu_no("123");
        dispatchMapper.findDispatchByStuno(student);
    }
}
