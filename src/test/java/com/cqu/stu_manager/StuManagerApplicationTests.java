package com.cqu.stu_manager;

import com.cqu.stu_manager.config.TxProperties;
import com.cqu.stu_manager.config.TxSmsTemplate;
import com.cqu.stu_manager.excel.Examination_reader;
import com.cqu.stu_manager.excel.GradePoint_Reader;
import com.cqu.stu_manager.excel.pojo.FilePath;
import com.cqu.stu_manager.mapper.*;

import com.cqu.stu_manager.pojo.Family;
import com.cqu.stu_manager.pojo.Student;
import com.cqu.stu_manager.service.MailService;
import com.cqu.stu_manager.utils.DocUtil;
import com.cqu.stu_manager.utils.RedisUtil;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


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
@Autowired
GradePiontMapper gradePiontMapper;
@Autowired
ExaminationMapper examinationMapper;
    @SneakyThrows
    @Test
    void contextLoads() {
//        GradePoint_Reader gradePoint_reader=new GradePoint_Reader(gradePiontMapper,redisUtil);
//        String path="";
//        FilePath filePath=new FilePath();
//        path=filePath.getPath()+"UploadExcel\\绩点排名上传模板.xls";
//        gradePoint_reader.gradepointread(path);


        Examination_reader examination_reader=new Examination_reader(examinationMapper,redisUtil);
        examination_reader.gradepointread("C:\\Users\\drifter\\Desktop\\期末成绩信息.xlsx");

    }
}
