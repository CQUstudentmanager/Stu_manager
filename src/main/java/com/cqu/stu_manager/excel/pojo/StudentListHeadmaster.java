package com.cqu.stu_manager.excel.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentListHeadmaster {

    @ExcelProperty(value = "序号",index =0 )
    private Integer excel_no;
    @ExcelProperty(value = "学号",index =1 )
    private String stu_no;
    @ExcelProperty(value = "姓名" ,index = 2)
    private String stu_name;
    @ExcelProperty(value = "班级",index =3 )
    private String stu_class;
    @ExcelProperty(value = "性别",index =4 )
    private String stu_gender;
    @ExcelProperty(value = "民族",index =5 )
    private String stu_ethnic;
    @ExcelProperty(value = "省份",index =6 )
    private String stu_origin;
    @ExcelProperty(value = "学生本人联系方式",index =7 )
    private String stu_tel;
    @ExcelProperty(value = "家长联系方式",index =8 )
    private String stu_family_tel;
    @ExcelProperty(value = "政治面貌",index =9 )
    private String stu_politicalface;
    @ExcelProperty(value = "入住楼栋",index =10 )
    private String stu_accommodation_information_building;
    @ExcelProperty(value = "房间",index =11 )
    private String stu_accommodation_information_room_no;
    @ExcelProperty(value = "床位号",index =12 )
    private String stu_accommodation_information_bed;
    @ExcelProperty(value = "考生类型",index =13 )
    private String stu_college_entrance_examination_type;
    @ExcelProperty(value = "中学名称",index =14 )
    private String stu_highschool_name;







}
