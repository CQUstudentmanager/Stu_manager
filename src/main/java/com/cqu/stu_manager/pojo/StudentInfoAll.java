package com.cqu.stu_manager.pojo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentInfoAll {
    @ExcelProperty(value = "学号",index = 0)
    private Integer stu_no;
    @ExcelIgnore
    @JsonIgnore
    private String stu_password;
    @ExcelProperty (value = "姓名",index = 1)
    private String  stu_name;
    @ExcelProperty (value = "性别",index = 2)
    private Integer stu_gender;
    @ExcelProperty (value = "班级",index = 3)
    private String stu_class;
    @ExcelProperty (value = "生日",index = 4)
    private String stu_birthday;
    @ExcelProperty (value = "民族",index = 5)
    private String stu_ethnic;
    @ExcelProperty (value = "生源地",index = 6)
    private String stu_origin;
    @ExcelProperty (value = "身份证号码",index = 7)
    private String  stu_id;
    @ExcelProperty (value = "政治面貌",index = 8)
    private String stu_politicalface;
    @ExcelProperty (value = "党团时间",index = 9)
    private String stu_caucus_time;
    @ExcelProperty (value = "是否港澳",index = 10)
    private Integer stu_ismacau;
    @ExcelProperty (value = "手机号码",index = 11)
    private String stu_telephone;
    @ExcelProperty (value = "QQ号码",index = 12)
    private String stu_qq;
    @ExcelProperty (value = "电子邮箱",index = 13)
    private String  stu_email;
    @ExcelProperty (value = "家庭地址",index = 14)
    private String stu_address;
    @ExcelProperty (value = "专业",index = 15)
    private String stu_major;
    @ExcelProperty (value = "入学时间",index = 16)
    private String stu_join_time;
    @ExcelIgnore
    private String stu_photourl;
    private List<Family> stu_family;
    private Accommodation stu_accommodation;
    private String volunteerTime;
    private List<Patent> patent;
    private List<Paper> paper;
    private List<Contest> contest;
    private List<Dispatch> dispatch;
    private List<Project> project;
    private List<DevelopmentPlanning> developmentPlannings;
    private Is_doing is_doing;
    private Plan plan;
 }
