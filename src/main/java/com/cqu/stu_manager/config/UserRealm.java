package com.cqu.stu_manager.config;

import com.cqu.stu_manager.mapper.AdminMapper;
import com.cqu.stu_manager.mapper.StudentMapper;
import com.cqu.stu_manager.mapper.TeacherMapper;
import com.cqu.stu_manager.pojo.Admin;
import com.cqu.stu_manager.pojo.Student;
import com.cqu.stu_manager.pojo.Teacher;
import com.cqu.stu_manager.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    TeacherMapper teacherMapper;
    @Autowired
    AdminMapper adminMapper;
//授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        Subject subject=SecurityUtils.getSubject();
        UsernamePasswordToken usertoken= (UsernamePasswordToken) subject.getPrincipal();
        System.out.println("用户"+usertoken.getUsername()+"_______________________获取了认证权限______________");

        Student student=studentMapper.findOneStudent(Integer.parseInt(usertoken.getUsername()));
        Teacher teacher = teacherMapper.findOneTeacher(Integer.parseInt(usertoken.getUsername()));
        Admin admin=adminMapper.findAdminPasswod(usertoken.getUsername());
        if (student==null){

            if(teacher == null){
                if(admin==null){
                    return  null;
                }else {info.addStringPermission("admin");}
            }else
            {
                //老师
                info.addStringPermission("teacher");

            }
        }else {
           //学生
            info.addStringPermission("student");
        }

        return info;
    }
//认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取当前用户

        UsernamePasswordToken usertoken= (UsernamePasswordToken) token;
        String name="";
        String password="";

        Student student=studentMapper.findOneStudent(Integer.parseInt(usertoken.getUsername()));
        Teacher teacher = teacherMapper.findOneTeacher(Integer.parseInt(usertoken.getUsername()));
        Admin admin=adminMapper.findAdminPasswod(usertoken.getUsername());
        if (student==null){

            if(teacher == null){
                if(admin==null){
                    return  null;
                }else {
                    name =admin.getAdmin_username();
                    password=admin.getAdmin_password();

                }
            }else
            {
                name=teacher.getT_no().toString();
                password=teacher.getT_password();
            }
        }else {
            name=student.getStu_no().toString();
            password=student.getStu_password();
        }

        if(!usertoken.getUsername().equals(name)){
            return null;//用户名为空
        }
        System.out.println(password);
        System.out.println(usertoken);
            return new SimpleAuthenticationInfo(usertoken,password,"");


    }
}
