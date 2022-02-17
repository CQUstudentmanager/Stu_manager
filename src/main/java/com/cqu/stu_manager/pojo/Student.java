package com.cqu.stu_manager.pojo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ColumnWidth(20)
public class Student {
    @ExcelProperty (value = "学号",index = 0)
    private Integer stu_no;
    @ExcelIgnore
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
    @ExcelIgnore
    private String stu_photourl;
}
