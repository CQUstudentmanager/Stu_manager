package com.cqu.stu_manager;

import com.cqu.stu_manager.config.TxProperties;
import com.cqu.stu_manager.config.TxSmsTemplate;
import com.cqu.stu_manager.mapper.*;

import com.cqu.stu_manager.pojo.Family;
import com.cqu.stu_manager.pojo.Student;
import com.cqu.stu_manager.service.MailService;
import com.cqu.stu_manager.utils.RedisUtil;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
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
@Autowired
DevelopmentPlanningMapper developmentPlanningMapper;
@Autowired
    TxSmsTemplate txSmsTemplate;
    @SneakyThrows
    @Test
    void contextLoads() {
//        String Msg = txSmsTemplate.sendMesModel("18357980493", "1111");
//        // Msg不为null 发送成功
//        // Msg为null  发送失败
//        System.out.println(Msg);

    }
}
