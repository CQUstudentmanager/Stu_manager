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
        student.setStu_no(10);

        projectMapper.findProjectByStuno(student);

    }
}
