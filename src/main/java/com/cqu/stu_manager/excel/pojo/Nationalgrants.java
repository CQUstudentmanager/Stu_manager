package com.cqu.stu_manager.excel.pojo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Nationalgrants {
    @ExcelProperty(value = "序号" ,index = 0)
    private Integer excel_no;
    @ExcelProperty(value = "学号",index = 2)
    private Integer stu_no;
    @ExcelIgnore
    private String stu_password;
    @ExcelProperty (value = "姓名",index = 3)
    private String  stu_name;
    @ExcelProperty (value = "性别",index = 4)
    private String stu_gender;
    @ExcelProperty (value = "班级",index = 1)
    private String stu_class;
    @ExcelIgnore
    private String stu_birthday;
    @ExcelProperty (value = "民族",index = 5)
    private String stu_ethnic;
    @ExcelProperty(value = "金额" ,index = 6)
    private String excel_money;
    @ExcelIgnore
    private String stu_origin;
    @ExcelIgnore
    private String  stu_id;
    @ExcelIgnore
    private String stu_politicalface;
    @ExcelIgnore
    private String stu_caucus_time;
    @ExcelIgnore
    private Integer stu_ismacau;
    @ExcelProperty(value = "联系电话",index = 7)
    private String stu_telephone;
    @ExcelIgnore
    private String stu_qq;
    @ExcelIgnore
    private String  stu_email;
    @ExcelIgnore
    private String stu_address;
    @ExcelIgnore
    private String stu_major;
    @ExcelIgnore
    private String stu_join_time;
    @ExcelIgnore
    private String stu_photourl;
}
