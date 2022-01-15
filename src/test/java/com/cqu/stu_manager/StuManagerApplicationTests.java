package com.cqu.stu_manager;

import com.cqu.stu_manager.mapper.StudentMapper;
import com.cqu.stu_manager.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class StuManagerApplicationTests {
@Autowired
    StudentMapper studentMapper;
    @Test
    void contextLoads() {
        List<Student> studentList=studentMapper.findStudentsByName("李");
        System.out.println(studentList);

    }

}
