package com.cqu.stu_manager.controller;

import com.cqu.stu_manager.config.TxSmsTemplate;
import com.cqu.stu_manager.mapper.FamilyMapper;
import com.cqu.stu_manager.pojo.Code;
import com.cqu.stu_manager.pojo.Family;
import com.cqu.stu_manager.pojo.User;
import com.cqu.stu_manager.utils.RandamCode;
import com.cqu.stu_manager.utils.RedisUtil;
import com.cqu.stu_manager.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class familycontroller {
    @Autowired
    RedisUtil redisUtil;
    @Autowired
    FamilyMapper familyMapper;
    @Autowired
    TxSmsTemplate txSmsTemplatel;
    @PostMapping("/familylogin_code")
    public Result familylogin(@RequestBody Family family){
        Result result=new Result();
        String tel= family.getFamily_tel();
       if(familyMapper.isfamily(family)!=null){
       RandamCode randamCode=new RandamCode();
       String radom= randamCode.randomStr(6);
       redisUtil.set(tel+"family",radom,300);
       txSmsTemplatel.sendMesModel(family.getFamily_tel(),radom.toString());
       result.setMsg("验证码发送成功");
       }else {
           result.setMsg("未找到家长信息");
       }
       return  result;
    }


    @PostMapping("/familycode")
    public Result familycode(@RequestBody Code code){
    String CODE=code.getCode();
    String right_code="";
    String tel=code.getTel();
    tel=tel+"family";
        Result result=new Result();
    if (redisUtil.get(tel)==null){
    result.setMsg("验证超时");
    }else {
    right_code=redisUtil.get(tel).toString();

    if(right_code.equals(CODE)){
       result.setMsg("验证成功");
    }else {
        result.setMsg("验证失败");
    }}

    return result;
    }
    }
