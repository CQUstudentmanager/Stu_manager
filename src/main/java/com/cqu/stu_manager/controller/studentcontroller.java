package com.cqu.stu_manager.controller;

import com.cqu.stu_manager.mapper.*;
import com.cqu.stu_manager.pojo.*;
import com.cqu.stu_manager.utils.Result;
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

                    studentList1=studentMapper.findStudentsByClass(classList.get(j));
                    s.addAll(studentList1);
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
//            if((!your_t.getStu_name().equals("String") ) && (!your_t.getStu_name().equals(student.getStu_name()))){
//                student.setStu_name(your_t.getStu_name());
//            }姓名不可修改
//            if(!your_t.getStu_gender().equals(student.getStu_gender())){
//                student.setStu_gender(your_t.getStu_gender());
//            }性别不能改
//            if((!your_t.getStu_class().equals("String")) && (!your_t.getStu_class().equals(student.getStu_class()))){
//                student.setStu_class(your_t.getStu_class());
//            }班级不能改
//            if((!your_t.getStu_birthday().equals("String")) && (!your_t.getStu_birthday().equals(student.getStu_birthday()))){
//                student.setStu_birthday(your_t.getStu_birthday());
//            }出生日期不能改
//            if((!your_t.getStu_ethnic().equals("String")) && (!your_t.getStu_ethnic().equals(student.getStu_ethnic()))){
//                student.setStu_ethnic(your_t.getStu_ethnic());
//            }民族不能改
            if((!your_t.getStu_origin().equals("String")) && (!your_t.getStu_origin().equals(student.getStu_origin()))){
                student.setStu_origin(your_t.getStu_origin());
            }
//            if((!your_t.getStu_id().equals("String")) && (!your_t.getStu_id().equals(student.getStu_id()))){
//                student.setStu_id(your_t.getStu_id());
//            }身份证不能改
            if((!your_t.getStu_politicalface().equals("String")) && (!your_t.getStu_politicalface().equals(student.getStu_politicalface()))){
                student.setStu_politicalface(your_t.getStu_politicalface());
            }
            if((!your_t.getStu_caucus_time().equals("String")) && (!your_t.getStu_caucus_time().equals(student.getStu_caucus_time()))){
                student.setStu_caucus_time(your_t.getStu_caucus_time());
            }
//            if(!your_t.getStu_ismacau().equals(student.getStu_ismacau())){
//                student.setStu_ismacau(your_t.getStu_ismacau());
//            }港澳台信息不能改
            if((!your_t.getStu_telephone().equals("String")) && (!your_t.getStu_telephone().equals(student.getStu_telephone()))){
                student.setStu_telephone(your_t.getStu_telephone());
            }
            if((!your_t.getStu_qq().equals("String")) && (!your_t.getStu_qq().equals(student.getStu_qq()))){
                student.setStu_qq(your_t.getStu_qq());
            }
            if((!your_t.getStu_address().equals("String")) && (!your_t.getStu_address().equals(student.getStu_address()))){
                student.setStu_address(your_t.getStu_address());
            }
            if((!your_t.getStu_email().equals("String")) && (!your_t.getStu_email().equals(student.getStu_email()))){
                student.setStu_email(your_t.getStu_email());
            }
            if((!your_t.getStu_photourl().equals("String")) && (!your_t.getStu_photourl().equals(student.getStu_photourl()))){
                student.setStu_photourl(your_t.getStu_photourl());
            }
            result.setMsg("信息修改成功");
            result.setData(student);

        }
        studentMapper.upDateStudentInfo(student);
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
            SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd/");
            String format = sdf.format(new Date());
            String realPath = "C:\\Users\\drifter\\Desktop\\Pictures" + format;//存储在本机上的路径
            File folder = new File(realPath);
            if(!folder.exists()){
                folder.mkdirs();
            }
            String newName = UUID.randomUUID().toString() + ".jpg";
            try {
                file.transferTo(new File(folder,newName));
                result.setMsg("上传成功");
                String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + format + newName;
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
            Result result = new Result();
            if(accommodation.getAccommodation_information_no() == null){
                SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
                String format = sdf.format(new Date());
                String no = accommodation.getAccommodation_information_stu_no();
                accommodation.setAccommodation_information_no(no +format);
            }
            if(accommodationMapper.updateAccommodationInfo(accommodation) == 1) {
                result.setMsg("信息更新成功");
            }
            else{result.setMsg("信息更新失败");}
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
            if(c.getCollege_entrance_examination_no() == null || c.getCollege_entrance_examination_no().length() == 0){
                SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
                String format = sdf.format(new Date());
                String no = c.getCollege_entrance_examination_stu_no();
                c.setCollege_entrance_examination_no(no + format);
            }
            if(collegeEntranceExaminationMapper.updateEntranceInfo(c) == 1) {
                result.setMsg("信息更新成功");
            }
            else{result.setMsg("信息更新失败");}
            return result;
        }


        @Autowired
        FamilyMapper familyMapper;

        //12.获取学生的家庭信息
        @PostMapping("Stu/findFamilyInfo")
        @ResponseBody
        public Result findFamilyInfo(@RequestBody Student student){
            Result result = new Result<>();
            Family f = familyMapper.findMainmember(student.getStu_no().toString());
            if(f != null){
                result.setMsg("找到当前学生高考信息如下");
                result.setData(f);
                return result;
            }
            result.setMsg("未找到当前学生信息");
            return result;
        }

//    //13.修改学生的高考信息
//    @PostMapping("Stu/updateFamilyInfo")
//    @ResponseBody
//    public Result updateFamilyInfo(@RequestBody Family family){
//        Result result = new Result<>();
//        if( == 1) {
//            result.setMsg("信息更新成功");
//        }
//        else{result.setMsg("信息更新失败");}
//        return result;
//    }


}


