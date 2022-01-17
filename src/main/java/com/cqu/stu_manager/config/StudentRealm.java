package com.cqu.stu_manager.config;

import com.cqu.stu_manager.mapper.StudentMapper;
import com.cqu.stu_manager.pojo.Student;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentRealm extends AuthorizingRealm {
    @Autowired
    StudentMapper studentMapper;
//授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了授权");
        return null;
    }
//认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取当前用户

        UsernamePasswordToken usertoken= (UsernamePasswordToken) token;

        Student student=studentMapper.findOneStudent(Integer.parseInt(usertoken.getUsername()));
        String name="";
        String password="";
        if (student==null){
            return null;
        }else {
            name=student.getStu_no().toString();
            password=student.getStu_password();
        }

        if(!usertoken.getUsername().equals(name)){
            return null;//用户名为空
        }
        return new SimpleAuthenticationInfo("",password,"");




    }
}
