package com.cqu.stu_manager.controller;

import com.cqu.stu_manager.mapper.StudentMapper;
import com.cqu.stu_manager.pojo.Student;
import com.cqu.stu_manager.pojo.Teacher;
import com.cqu.stu_manager.pojo.User;
import com.cqu.stu_manager.pojo.upDatePassword;
import com.cqu.stu_manager.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController//表示返回json文件类型
public class studentcontroller {
    @Autowired
    StudentMapper studentMapper;


    @PostMapping("Stu/stulist")
    @ResponseBody
    //得到所有学生名单
    public List<Student> students(){
        return studentMapper.findAllStudent();
    }


    @PostMapping("Stu/findOneStudent")
    @ResponseBody
    //根据stu_no准确找到对应的学生
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
    //修改学生信息
    public Result upDateStudent(@RequestBody Student your_t){
        Result result = new Result();
        Student student = studentMapper.findOneStudent(your_t.getStu_no());
        if(student == null){
            result.setMsg("当前学生不存在");}
        else{
            if((!your_t.getStu_name().equals("String") ) && (!your_t.getStu_name().equals(student.getStu_name()))){
                student.setStu_name(your_t.getStu_name());
            }
            if((your_t.getStu_gender()!=0) && (!your_t.getStu_gender().equals(student.getStu_gender()))){
                student.setStu_gender(your_t.getStu_gender());
            }
            if((!your_t.getStu_class().equals("String")) && (!your_t.getStu_class().equals(student.getStu_class()))){
                student.setStu_class(your_t.getStu_class());
            }
            if((!your_t.getStu_birthday().equals("String")) && (!your_t.getStu_birthday().equals(student.getStu_birthday()))){
                student.setStu_birthday(your_t.getStu_birthday());
            }
            if((!your_t.getStu_ethnic().equals("String")) && (!your_t.getStu_ethnic().equals(student.getStu_ethnic()))){
                student.setStu_ethnic(your_t.getStu_ethnic());
            }
            if((!your_t.getStu_origin().equals("String")) && (!your_t.getStu_origin().equals(student.getStu_origin()))){
                student.setStu_origin(your_t.getStu_origin());
            }
            if((!your_t.getStu_id().equals("String")) && (!your_t.getStu_id().equals(student.getStu_id()))){
                student.setStu_id(your_t.getStu_id());
            }
            if((!your_t.getStu_politicalface().equals("String")) && (!your_t.getStu_politicalface().equals(student.getStu_politicalface()))){
                student.setStu_politicalface(your_t.getStu_politicalface());
            }
            if((!your_t.getStu_caucus_time().equals("String")) && (!your_t.getStu_caucus_time().equals(student.getStu_caucus_time()))){
                student.setStu_caucus_time(your_t.getStu_caucus_time());
            }
            if((your_t.getStu_isMacau() != 0) && (!your_t.getStu_isMacau().equals(student.getStu_isMacau()))){
                student.setStu_isMacau(your_t.getStu_isMacau());
            }
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
        //更改密码
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
        //根据stu_no或者stu_name实现模糊查询
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
        //根据班级找到对应的学生
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

        @PostMapping("Stu/upLoadPicture")
        @ResponseBody
        public Result upLoadPicture(MultipartFile file, HttpServletRequest request){
            Result result = new Result();
//            获取上传的文件名字，看是否为pdf文件，不是的话直接返回错误信息
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
                String url = request.getScheme() + request.getServerName() + ":" + request.getServerPort() + format + newName;
                result.setData(url);
            }catch (IOException e) {
                result.setMsg(e.getMessage());
            }
            return result;
        }
}


