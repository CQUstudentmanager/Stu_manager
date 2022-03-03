package com.cqu.stu_manager;

import com.cqu.stu_manager.mapper.*;

import com.cqu.stu_manager.service.MailService;
import com.cqu.stu_manager.utils.RedisUtil;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;


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
@Autowired
AccommodationMapper accommodationMapper;
@Autowired
CollegeEntranceExaminationMapper collegeEntranceExaminationMapper;
@Autowired
TeacherMapper teacherMapper;
@Autowired
FamilyMapper familyMapper;
@Autowired
ClassMapper classMapper;
@Autowired
StayschoolMapper stayschoolMapper;
@Autowired
MsgMapper msgMapper;
@Autowired
    RedisUtil redisUtil;
@Autowired
AdminMapper adminMapper;
@Autowired
    MailService mailService;
    @SneakyThrows
    @Test
    void contextLoads() {
        System.out.println(redisUtil.get("20191574email"));
        //     mailService.send("122706559@qq.com","this is simple mail"," hello LingDu");
    }
}
