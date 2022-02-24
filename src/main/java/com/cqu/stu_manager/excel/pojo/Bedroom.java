package com.cqu.stu_manager.excel.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bedroom {
    @ExcelProperty(value = "序号",index = 0)
    private Integer bedroom_no;
    @ExcelProperty(value = "楼栋房间",index = 1)
    private String bedroom_buildingandroom;
    @ExcelProperty(value = "学号",index = 2)
    private String bedroom_stuno;
    @ExcelProperty(value = "姓名",index = 3)
    private String bedroom_stuname;
    @ExcelProperty(value = "班级",index = 4)
    private String bedroom_stu_class;
    @ExcelProperty(value = "性别",index = 5)
    private String bedroom_stu_gender;
    @ExcelProperty(value = "民族",index = 6)
    private String bedroom_stu_ethnic;
    @ExcelProperty(value = "省份",index = 7)
    private String bedroom_stu_province;
    @ExcelProperty(value = "学生本人联系方式",index = 8)
    private String bedroom_stu_tel;
    @ExcelProperty(value = "家长联系方式",index = 9)
    private String family_tel;
    @ExcelProperty(value = "备注" ,index =10)
    private String bedroom_ps;
}
