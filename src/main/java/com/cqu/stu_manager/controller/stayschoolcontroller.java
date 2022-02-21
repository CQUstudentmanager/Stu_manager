package com.cqu.stu_manager.controller;

import com.cqu.stu_manager.mapper.StayschoolMapper;
import com.cqu.stu_manager.pojo.Stayschool;
import com.cqu.stu_manager.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class stayschoolcontroller {
    @Autowired
    StayschoolMapper stayschoolMapper;
    @PostMapping("/find_stayschool_info")
    public List<Stayschool> find_stayschool_info(@RequestBody Stayschool stayschool){
        return stayschoolMapper.findAllStayschoolInfo(stayschool);
    }
    @PostMapping("upload_stayschool_info")
    public Result
    upload_stayschool_info(@RequestBody Stayschool stayschool){
        List<Stayschool> stayschools=new ArrayList<>();
        Result result=new Result();
        stayschools=stayschoolMapper.findAllStayschoolInfo2();
        for(int i=0;i<stayschools.size();i++){
            stayschools.get(i).setStay_school_info_no("");
            if(stayschools.get(i).equals(stayschool)){
                result.setMsg("请勿重复上传");
                return result;
            }
        }
        if(stayschool.getStay_school_info_no().length()==0){
            String str=stayschool.getStay_school_info_stu_no();
            SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
            String format = sdf.format(new Date());
            stayschool.setStay_school_info_no(str+format);
            result.setMsg(stayschoolMapper.addStayschoolInfoByStu(stayschool)+"条信息已上传");
            return  result;
        }else {
            result.setMsg(stayschoolMapper.updateStayschoolInfo(stayschool)+"条消息已修改");
            return result;
        }


    }
}
