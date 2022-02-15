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
        Voluntary_activities voluntary_activities=new Voluntary_activities();
        voluntary_activities.setVoluntary_activities_content("干了一堆大家都不知道在干啥的事情并且觉得对社会很有用");
        voluntary_activities.setVoluntary_activities_stu_no("123");
        voluntary_activities.setVoluntary_activities_no("1235654545");
        voluntary_activitiesMapper.findVoluntary_activitiesByStuno(student);

    }
}
