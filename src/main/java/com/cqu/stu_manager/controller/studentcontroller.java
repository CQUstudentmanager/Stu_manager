package com.cqu.stu_manager.controller;

import com.cqu.stu_manager.mapper.*;
import com.cqu.stu_manager.pojo.*;
import com.cqu.stu_manager.service.MailService;
import com.cqu.stu_manager.utils.RandamCode;
import com.cqu.stu_manager.utils.RedisUtil;
import com.cqu.stu_manager.utils.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController//表示返回json文件类型
public class studentcontroller {
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    ReceiveMapper receiveMapper;
    @Autowired
    MsgMapper msgMapper;
    @Autowired
    PaperMapper paperMapper;
    @Autowired
    ClassMapper classMapper;
    @Autowired
    MailService mailService;
    @Autowired
    RedisUtil redisUtil;
    @PostMapping("/findpassword")
    public Result findPaawordByEmail(@RequestBody Student student){
        Student student1=studentMapper.findOneStudent(student.getStu_no());
        String email="";
        if (student1!=null){
         email=student1.getStu_email();}
        else  email="";
        Result result=new Result();
        if(email!=null&&!email.equals("")){
            RandamCode randamCode=new RandamCode();
            String random_email=randamCode.getRandomCode(6);
            redisUtil.set(student1.getStu_no().toString()+"email",random_email,300);
            mailService.send(email,"大数据与软件本科生管理系统--密码找回",random_email);
            result.setMsg("验证码已发送到"+email+"请查收");
            result.setCode(1);
        }else {
            result.setCode(0);
            result.setMsg("邮箱信息未找到");
        }
        return result;
    }
    @PostMapping("/judgeemailcode")
    public Result judgeemailcode(@RequestBody EmailCode emailCode){
        Result result=new Result();
        if(redisUtil.get(emailCode.getStu_no()+"email")==null){
            result.setMsg("验证信息过期（有效期五分钟）");
            result.setCode(0);
        }
        else {
        String right_code=redisUtil.get(emailCode.getStu_no()+"email").toString();

        if(emailCode.getStu_code().equals(right_code)){
            redisUtil.set(emailCode.getStu_code(),emailCode.getStu_no(),300);
            result.setMsg("验证成功");
            result.setCode(1);
            Subject subject1= SecurityUtils.getSubject();
            UsernamePasswordToken token=new UsernamePasswordToken("147852369","findpass");
        try {
            subject1.login(token);
        }catch (UnknownAccountException e){

        }catch (IncorrectCredentialsException e)
        {

        }
        }
        else {result.setMsg("验证码错误");
        result.setCode(0);}}
        return  result;
    }
    @PostMapping("/passwordbyemail")
    public Result passwordbyemail(@RequestBody upDatePassword upDatePassword){
        Result result=new Result();
        upDatePassword.getNew_password();
        Student student=new Student();
        String right_no="00";
        if(redisUtil.get(upDatePassword.getOld_password())!=null){
        right_no=redisUtil.get(upDatePassword.getOld_password()).toString();}
        else {result.setMsg("验证账户不匹配");
        return result;}
        student=studentMapper.findOneStudent(Integer.parseInt(right_no));
        student.setStu_password(upDatePassword.getNew_password());
        studentMapper.upDatePassword(student);
        result.setMsg("修改成功");
        Subject subject=SecurityUtils.getSubject();
        subject.logout();
        redisUtil.del(right_no+"email");
        result.setCode(1);
        redisUtil.del(upDatePassword.getOld_password());
        return result;
    }

    @Autowired
    Voluntary_activitiesMapper voluntary_activitiesMapper;
    @Autowired
    ContestMapper contestMapper;
    @Autowired
    ProjectMapper projectMapper;
    @Autowired
    PatentMapper patentMapper;
    @Autowired
    DispatchMapper dispatchMapper;
    @PostMapping ("Stu/findallinfoforone")
    public Result findallinfo(@RequestBody Student student){
        StudentInfoAll studentInfoAll=new StudentInfoAll();
        BeanUtils.copyProperties(student,studentInfoAll);
        Accommodation accommodation=new Accommodation();
        accommodation=accommodationMapper.findStuAccommodation(student.getStu_no().toString());
        studentInfoAll.setStu_accommodation(accommodation);
        List <Family> familyList=new ArrayList<>();
        familyList=familyMapper.findAllMembers(student.getStu_no().toString());
        studentInfoAll.setStu_family(familyList);
        System.out.println(studentInfoAll);
        //获取志愿时长
        List<Voluntary_activities> activitiesList = voluntary_activitiesMapper.findVoluntary_activitiesByStuno(student);
        Double hour = 0.0;
        if(activitiesList==null || activitiesList.size() == 0){
            studentInfoAll.setVolunteerTime(hour + "小时");
        }
        else{
            for(Voluntary_activities v:activitiesList){
                //这里转换的时候可能出错
                hour += v.getVoluntary_activities_time_long();
            }
            studentInfoAll.setVolunteerTime(hour + "小时");
        }
        //获取论文信息
        List<Paper> paperList = paperMapper.findPaperByStuno(student);
        List<Paper> right_paperlist=new ArrayList<>();
        if(paperList == null || paperList.size() ==0){
            studentInfoAll.setPaper(null);
        }
        else {
            for (int i = 0; i < paperList.size(); i++) {
                Paper paper=new Paper();
                if(paperList.get(i).getPaper_status().equals("1")){
                    paper=paperList.get(i);
                    right_paperlist.add(paper);
                }

            }
            studentInfoAll.setPaper(right_paperlist);
        }
        //获取比赛
        List<Contest > right_contestlist=new ArrayList<>();
        List<Contest> contestList = contestMapper.findContestByStuno(student);
        if(contestList == null || contestList.size() ==0){
            studentInfoAll.setContest(null);
        }
        else {
            for (int i = 0; i < contestList.size(); i++) {
                Contest contest=new Contest();
                if(contestList.get(i).getContest_status().equals("1")){
                    contest=contestList.get(i);
                    right_contestlist.add(contest);
                }
            }
            studentInfoAll.setContest(right_contestlist);
        }
        //获取项目信息
        List<Project >right_projectList=new ArrayList<>();
        List<Project> projectList = projectMapper.findProjectByStuno(student);
        if(projectList == null || projectList.size() ==0){
            studentInfoAll.setProject(null);
        }
        else {
            for (int i = 0; i < projectList.size(); i++) {
                Project project=new Project();
                if(projectList.get(i).getProject_audit_status().equals("1")){
                    project=projectList.get(i);
                    right_projectList.add(project);
                }
            }
            studentInfoAll.setProject(right_projectList);
        }
        //获取专利
        List<Patent > right_patent=new ArrayList<>();
        List<Patent> patentList = patentMapper.findPatentByStuno(student);
        if(patentList == null || patentList.size() ==0){
            studentInfoAll.setPatent(null);
        }
        else {
            for (int i = 0; i < patentList.size(); i++) {
                Patent patent=new Patent();
                if(patentList.get(i).getPatent_status().equals("1")){
                    patent=patentList.get(i);
                    right_patent.add(patent);
                }
            }
            studentInfoAll.setPatent(right_patent);
        }
        //获取外派
        List<Dispatch> dispatchList = dispatchMapper.findDispatchByStuno(student);
        if(dispatchList == null || dispatchList.size() ==0){
            studentInfoAll.setDispatch(null);
        }
        else {
            studentInfoAll.setDispatch(dispatchList);
        }
        Result result=new Result();
        result.setData(studentInfoAll);
        return result;
    }


    @PostMapping("Stu/stuList")
    @ResponseBody
    //1.得到所有学生名单
    public List<Student> students(@RequestBody Teacher teacher){
        List<Student> studentList = studentMapper.findAllStudent();
        List<Student> s = new ArrayList<>();
        String grade = teacher.getT_identity().toString();
        for(int i=0;i<=studentList.size()-1;i++){
            if(studentList.get(i).getStu_class().substring(0,2).equals(grade)){
                s.add(studentList.get(i));
            }
            else if(teacher.getT_identity().toString().equals("2")){
                List<String> classList=new ArrayList<>();
                classList=classMapper.findClassByTeacher(teacher.getT_no().toString());
                List<Student> studentList1=new ArrayList<>();
                for (int j=0;j<classList.size();j++){
                   if(studentList.get(i).getStu_class().equals(classList.get(j))) {
                    s.add(studentList.get(i));}
                }
            }
        }
        return s;
    }


    @PostMapping("Stu/findOneStudent")
    @ResponseBody
    //2.根据stu_no准确找到对应的学生
    public Result findOneStudent(@RequestBody Student your_s){
        Result result = new Result();
        Student student = studentMapper.findOneStudent(your_s.getStu_no());
        if(student == null){
            result.setMsg("无当前学生信息");
        }
        else{
            result.setData(student);
            result.setMsg("成功找到学生教师信息");
        }
        return result;
    }


    @PostMapping("Stu/upDateStudent")
    @ResponseBody
    //3.修改学生信息
    public Result upDateStudent(@RequestBody Student your_t){
        Result result = new Result();
        Student student = studentMapper.findOneStudent(your_t.getStu_no());
        if(student == null){
            result.setMsg("当前学生不存在");}
        else{
            studentMapper.upDateStudentInfo(your_t);
            Student student2 = studentMapper.findOneStudent(your_t.getStu_no());
            result.setMsg("修改成功");
            result.setData(student2);
        }

        return result;
    }


        @PostMapping("Stu/upDatePassword")
        @ResponseBody
        //4.更改密码
        public Result updatePassword(@RequestBody upDatePassword your_up){
            Result result= new Result();
            Student student = studentMapper.findOneStudent(your_up.getNo());
            if(student == null){
                result.setMsg("用户不存在");
            }
            else if(your_up.getOld_password().equals(student.getStu_password()))
            {
                //确定student不为NULL而且旧密码输入正确，直接改成新密码就可以了
                student.setStu_password(your_up.getNew_password());
                studentMapper.upDatePassword(student);
                result.setData(student);
                result.setMsg("密码修改成功");
            }
            else{
                result.setMsg("密码修改失败");
            }
            return result;
        }


        @PostMapping("Stu/findStudentsByName")
        @ResponseBody
        //5.根据stu_no或者stu_name实现模糊查询
        public Result findStudents(@RequestBody Student student){
            Result result = new Result();
            List<Student> studentList=studentMapper.findStudentsByName(student.getStu_name());
            if(studentList.isEmpty()){
                //如果根据stu_name未找到，尝试将其当作stu_no来进行查找
                studentList = studentMapper.findStudentsByNO(student.getStu_name());
                if(studentList.isEmpty()){
                    result.setMsg("未找到相关信息");
                }
                else{
                    result.setMsg("成功找到信息");
                    result.setData(studentList);
                }
            }
            else{
                result.setMsg("成功找到信息");
                result.setData(studentList);
            }
            return result;
        }


        @PostMapping("Stu/findStudentsByClass")
        @ResponseBody
        //6.根据班级找到对应的学生
        public Result findStudentsByClass(@RequestBody Student student){
            Result result = new Result();
            List<Student> studentList = studentMapper.findStudentsByClass(student.getStu_class());
            if(studentList.isEmpty()){
                result.setMsg("未找到");
            }else{
                result.setMsg("成功找到信息");
                result.setData(studentList);
            }
            return result;
        }


        //7.上传头像
        @PostMapping("Stu/upLoadPicture")
        @ResponseBody
        @CrossOrigin
        public Result upLoadPicture(MultipartFile file, HttpServletRequest request){
            Result result = new Result();
//            获取上传的文件名字，看是否为jpg文件，不是的话直接返回错误信息
            if(file == null){
                result.setMsg("未收到文件");
                return result;
            }
            else {
                String originName = file.getOriginalFilename();
                if(!originName.endsWith(".jpg")){
                result.setMsg("文件类型错误");
                return result;
                }
            }

            FilePath2 f = new FilePath2();
            //String realPath = "D:\\java_project\\vue_m\\vue\\src\\assets\\Pictures" ;//存储在本机上的路径
            File folder = new File(f.getPath()+"\\Pictures");
            if(!folder.exists()){
                folder.mkdirs();
            }
            String newName = UUID.randomUUID().toString() + ".jpg";
            try {
                file.transferTo(new File(folder,newName));
                result.setMsg("上传成功");
                String url =  newName;
                result.setData(url);
            }catch (IOException e) {
                result.setMsg(e.getMessage());
            }
            return result;
        }

        @Autowired
        AccommodationMapper accommodationMapper;

        //8.获取学生的住宿信息
        @PostMapping("Stu/findDormitoryInfo")
        @ResponseBody
    public Result findDormitoryinfo(@RequestBody Student student){
        Result result = new Result();
        Accommodation accommodation = accommodationMapper.findStuAccommodation(student.getStu_no().toString());
        if(accommodation!=null){
            result.setMsg("找到当前学生宿舍信息如下：");
            result.setData(accommodation);
            return result;
        }
        result.setMsg("未找到当前学生宿舍信息");
        return result;
        }

        //9.修改学生的住宿信息
        @PostMapping("Stu/updateDormitoryInfo")
        @ResponseBody
    public Result updateDormitoryInfo(@RequestBody Accommodation accommodation){
            Accommodation accommodation1=new Accommodation();
            accommodation1=accommodationMapper.findStuAccommodation(accommodation.getAccommodation_information_stu_no());
            Result result = new Result();
            if(accommodation.getAccommodation_information_no() == null){
                SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
                String format = sdf.format(new Date());
                String no = accommodation.getAccommodation_information_stu_no();
                accommodation.setAccommodation_information_no(no +format);
            }
            if(accommodation1!=null&&accommodationMapper.updateAccommodationInfo(accommodation) == 1) {
                result.setMsg("信息更新成功");
            }
            else{
                accommodationMapper.addaccommodation(accommodation);
                result.setMsg("消息上传成功");}
            return result;
        }

        @Autowired
        CollegeEntranceExaminationMapper collegeEntranceExaminationMapper;

        //10.获取学生的高考信息
        @PostMapping("Stu/findEntranceInfo")
        @ResponseBody
    public Result findEntranceInfo(@RequestBody Student student){
            Result result = new Result<>();
            CollegeEntranceExamination c = collegeEntranceExaminationMapper.findStudentCollegeEntranceExamination(student.getStu_no().toString());
            if(c != null){
                result.setMsg("找到当前学生高考信息如下");
                result.setData(c);
                return result;
            }
            result.setMsg("未找到当前学生信息");
            return result;
        }

        //11.修改学生的高考信息
        @PostMapping("Stu/updateEntranceInfo")
        @ResponseBody
        public Result updateEntranceInfo(@RequestBody CollegeEntranceExamination c){
            Result result = new Result<>();
           CollegeEntranceExamination collegeEntranceExamination=new CollegeEntranceExamination();
           collegeEntranceExaminationMapper.findStudentCollegeEntranceExamination(c.getCollege_entrance_examination_no());
            if(c.getCollege_entrance_examination_no() == null || c.getCollege_entrance_examination_no().length() == 0){
                SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
                String format = sdf.format(new Date());
                String no = c.getCollege_entrance_examination_stu_no();
                c.setCollege_entrance_examination_no(no + format);
            }
            if(collegeEntranceExamination!=null&&collegeEntranceExaminationMapper.updateEntranceInfo(c) == 1) {
                result.setMsg("信息更新成功");
            }
            else{
                collegeEntranceExaminationMapper.addcollegeEntranceExamination(c);
                result.setMsg("信息添加成功");}
            return result;
        }


        @Autowired
        FamilyMapper familyMapper;

        //12.获取学生的家庭信息
        @PostMapping("Stu/findFamilyInfo")
        @ResponseBody
        public Result findFamilyInfo(@RequestBody Student student){
            Result result = new Result<>();
            List<Family> familyList = familyMapper.findAllMembers(student.getStu_no().toString());
            List<Family> f = new ArrayList<>();
            f.add(null);
            f.add(null);
            result.setMsg("找到当前学生家庭信息如下");
            if(familyList == null || familyList.size() == 0){
                result.setMsg("未找到当前学生信息");
            }
            else if(familyList.size() == 1){
                if(familyList.get(0).getFamily_relationship() == null||familyList.get(0).getFamily_relationship().equals("父亲")){
                    f.set(0,familyList.get(0));
                }
                else {
                    f.set(1,familyList.get(0));
                }
            }
            else{
                if(familyList.get(0).getFamily_relationship() == null || familyList.get(0).getFamily_relationship().equals("父亲")){
                    f.set(0,familyList.get(0));
                    f.set(1,familyList.get(1));
                }
                else{
                    f.set(0,familyList.get(1));
                    f.set(1,familyList.get(0));
                }
            }
            result.setData(f);
            return result;
        }

    //13.修改学生的家庭信息
    @PostMapping("Stu/updateFamilyInfo")
    @ResponseBody
    public Result updateFamilyInfo(@RequestBody Family family){
        Result result = new Result<>();
        List<Family> familyList=new ArrayList<>();
        Integer countfather=0;
        Integer countmother=0;

        familyList=familyMapper.findAllMembers(family.getFamily_stu_no());
        if(familyList.size()!=0){
        for (int i = 0; i < familyList.size(); i++) {
            if("母亲".equals(familyList.get(i).getFamily_relationship())){
                countmother=1;
            }
            if ("父亲".equals(familyList.get(i).getFamily_relationship())){
                countfather=1;
            }
        }}
        if( familyMapper.updateFamilyInfo(family) == 1) {
            result.setMsg("信息更新成功");
        }
        else if((countfather==0 ||countmother==0)){
            if(countmother==0&&"母亲".equals(family.getFamily_relationship())){
            familyMapper.addFamilyInfo(family);
            result.setMsg("信息上传成功");
            }
            else if (countfather==0&&"父亲".equals(family.getFamily_relationship())){
                familyMapper.addFamilyInfo(family);
                result.setMsg("信息上传成功");
            }
        }
        else {
            result.setMsg("操作错误");

        }
        return result;
    }
    @PostMapping("/read_msg")
    public Result read_msg(@RequestBody Receive receive){


        Result result=new Result();
        result.setMsg( receiveMapper.readMsg(receive.getMsg_no2(),receive.getReceiver())+"条已读");
        return  result;}
    @PostMapping("/finish_msg")
    public Result finish_msg(@RequestBody Receive receive){
        Result result=new Result();

        result.setMsg(receiveMapper.finish(receive.getMsg_no2(),receive.getReceiver())+"条已完成");
        return  result;

    }

    @Autowired
    TeacherMapper teacherMapper;
    @PostMapping("getstudent_msg")
    public Result getstudent_msg(@RequestBody Student student){
            List<Receive> receivelist=new ArrayList<>();
            receivelist=receiveMapper.findmsgnoByreceiver(student.getStu_no());
            Result result=new Result();
            List<Msg> msgList=new ArrayList<>();
        for (int i = 0; i <receivelist.size() ; i++) {
            Msg msg=new Msg();
            msg=msgMapper.findMsgByMsgNo(receivelist.get(i).getMsg_no2());
            msg.setStatus(receivelist.get(i).getStatus());
            Teacher teacher = teacherMapper.findOneTeacher(msg.getMsg_sender());
            msg.setTeacherName(teacher.getT_name());
            msgList.add(msg);
        }
            result.setData(msgList);
            return result;
    }


    @Autowired
    DevelopmentPlanningMapper developmentPlanningMapper;

    //1.找到对应学生的计划
    @PostMapping("Stu/getStudentPlan")
    @ResponseBody
    public Result getStudentPlan(@RequestBody Student student){
        Result result = new Result();
        List<DevelopmentPlanning> planList = developmentPlanningMapper.findPlanByStuNo(student.getStu_no().toString());
        if(planList == null || planList.size() == 0){
            result.setMsg("当前学生暂无发展规划");
        }
        else {
            result.setMsg("当前学生发展规划信息有" + planList.size() + "条");
            result.setData(planList);
        }
        return result;
    }

    //2.修改或者新增发展规划
    @PostMapping("Stu/uploadPlan")
    @ResponseBody
    public Result uploadPlan(@RequestBody DevelopmentPlanning plan){
        //将planno设置为学号加上最后一次修改的时间(精确到分钟)，前端发送planno时默认null值
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmm");
        String format = sdf.format(new Date());
        String str = plan.getDevelopment_planning_stu_no() + format;
        plan.setDevelopment_planning_no(str);
        Result result =new Result<>();
        //判断是进行更新还是进行插入操作
        List<DevelopmentPlanning> planList = developmentPlanningMapper.findPlanByStuNo(plan.getDevelopment_planning_stu_no());
        if(planList == null || planList.size() == 0){
            //插入新的规划
            developmentPlanningMapper.insertPlan(plan);
            result.setMsg("发展规划更新完成");
            return result;
        }
        for(DevelopmentPlanning dp:planList){
            if(dp.getYear().equals(plan.getYear())){
                //进行更新操作
                developmentPlanningMapper.updatePlan(plan);
                result.setMsg("发展规划更新完成");
                return result;
            }
        }
        //非以上两种情况，直接进行插入操作
        developmentPlanningMapper.insertPlan(plan);
        result.setMsg("发展规划更新完成");
        return result;
    }

    //3.导员驳回发展规划
    @PostMapping("rejectPlan")
    @ResponseBody
    public Result rejectPlan(@RequestBody DevelopmentPlanning plan){
        Result result = new Result<>();
        developmentPlanningMapper.rejectPlan(plan);
        result.setMsg("驳回发展计划");
        return result;
    }

    //4.导员审核通过
    @PostMapping("passPlan")
    @ResponseBody
    public Result passPlan(@RequestBody DevelopmentPlanning plan){
        Result result = new Result<>();
        developmentPlanningMapper.passPlan(plan);
        result.setMsg("发展计划审核通过");
        return result;
    }

    //5.家长审核通过
    @PostMapping("passPlan2")
    @ResponseBody
    public Result passPlan2(@RequestBody DevelopmentPlanning plan){
        Result result = new Result<>();
        developmentPlanningMapper.passPlan2(plan);
        result.setMsg("发展计划审核通过");
        return result;
    }

    //6.家长驳回发展规划
    @PostMapping("rejectPlan2")
    @ResponseBody
    public Result rejectPlan2(@RequestBody DevelopmentPlanning plan){
        Result result = new Result<>();
        developmentPlanningMapper.rejectPlan2(plan);
        result.setMsg("驳回发展计划");
        return result;
    }

    @PostMapping("Stu/findStuPicture")
    public Result findStuPicture(@RequestBody Student student){
        Result result = new Result();
        Student s = studentMapper.findOneStudent(student.getStu_no());
        if(s==null){
            result.setData("test.jpg");
            result.setMsg("当前学生不存在,返回默认图片路径");
            return result;
        }
        result.setData(s.getStu_photourl());
        result.setMsg("当前学生照片路径如下：");
        return result;
    }
}


