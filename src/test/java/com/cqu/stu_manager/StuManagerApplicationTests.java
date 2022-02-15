package com.cqu.stu_manager;

import com.cqu.stu_manager.mapper.*;
import com.cqu.stu_manager.pojo.Paper;
import com.cqu.stu_manager.pojo.Patent;
import com.cqu.stu_manager.pojo.Project;
import com.cqu.stu_manager.pojo.Student;
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
        Project project=new Project();
        project.setProject_no(1231);
        project.setProject_name("casfasfahgfhageyfagysdgfjagsdhfasdf");
        project.setProject_student_no("123");
        projectMapper.findProjectByStuno(student);

    }


}
