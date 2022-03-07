package com.cqu.stu_manager.controller;

import com.cqu.stu_manager.mapper.ClassMapper;
import com.cqu.stu_manager.pojo.Class;
import com.cqu.stu_manager.pojo.Teacher;
import com.cqu.stu_manager.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class classcontroller {
    @Autowired
    ClassMapper classMapper;

    @PostMapping("/classList")
    public List<Class> listClass(@RequestBody Teacher teacher)
    {
        List<Class> classList=classMapper.findAllClass();
        String grade = teacher.getT_identity().toString();
        List<Class> c = new ArrayList<>();
        for(int i=0;i<=classList.size()-1;i++){
            if(classList.get(i).getClass_name().substring(0,2).equals(grade)){
                c.add(classList.get(i));
            }
        }
        return c;
    }
    @PostMapping("/findallclasslist")
    public  Result findallclasslist(){
        Result result=new Result();
        List<Class> classList=classMapper.findAllClass();
        result.setData(classList);
        return result;
    }

    @PostMapping("/updateClassInfo")
    public Result updateclassinfo(@RequestBody Class class_){
        int i=classMapper.updateClassinfo(class_);
        Result result=new Result();
        result.setMsg(i+"个班级已经修改完成");
        return result;


    }
    @PostMapping("/insertClass")
    public Result insertClass(@RequestBody Class class_){
        int i=classMapper.insertClass(class_);
        Result result=new Result();
        result.setMsg(class_.getClass_name()+"添加成功");
        return result;
    }

}
