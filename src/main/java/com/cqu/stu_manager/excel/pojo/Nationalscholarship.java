package com.cqu.stu_manager.excel.pojo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Nationalscholarship {
    @ExcelProperty(value = "序号",index = 0)
    private Integer excel_no;
    @ExcelProperty(value = "姓名",index = 1)
    private String  stu_name;
    @ExcelProperty (value = "身份证号码",index = 2)
    private String  stu_id;
    @ExcelProperty (value = "院系",index = 3)
    private String  stu_dept="大数据与软件学院";
    @ExcelProperty (value = "专业",index = 4)
    private String  stu_major;
    @ExcelProperty (value = "学号",index = 5)
    private Integer stu_no;
    @ExcelProperty (value = "性别",index = 6)
    private String stu_gender;
    @ExcelProperty (value = "民族",index = 7)
    private String stu_ethnic;
    @ExcelProperty (value = "入学年份",index = 8)
    private String stu_join_time;
    @ExcelIgnore
    private String stu_class;
    @ExcelIgnore
    private String stu_birthday;
    @ExcelIgnore
    private String stu_address;
    @ExcelIgnore
    private String stu_politicalface;
    @ExcelIgnore
    private String stu_caucus_time;
    @ExcelIgnore
    private Integer stu_ismacau;
    @ExcelIgnore
    private String stu_telephone;
    @ExcelIgnore
    private String stu_qq;
    @ExcelIgnore
    private String  stu_email;
    @ExcelIgnore
    private String stu_origin;

}
