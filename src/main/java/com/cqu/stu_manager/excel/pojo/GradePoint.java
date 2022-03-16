package com.cqu.stu_manager.excel.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class GradePoint {
    private String grade_point_no;
    @ExcelProperty(value = "学号")
    private String grade_point_stu_no;
    @ExcelProperty(value = "姓名")
    private String grade_point_stu_name;
    @ExcelProperty(value = "班级")
    private String         grade_point_stu_class;
    @ExcelProperty(value = "专业百分比")
    private String grade_point_mrjorpercentage;
    @ExcelProperty(value = "国家英语")
    private String         grade_point_national_english;
    @ExcelProperty(value = "学生课程平均绩点")
    private String grade_point_gpa;
    @ExcelProperty(value = "年级排名")
    private String         grade_point_rankforclass;
    @ExcelProperty(value = "专业排名")
    private String grade_point_rankformajor;
    @ExcelProperty(value = "专业人数")
    private String         grade_point_major_num;
    @ExcelProperty(value = "英语学分")
    private String grade_point_english_score;
    @ExcelProperty(value = "体育总学分")
    private String         grade_point_sportsscore;
    @ExcelProperty(value = "健康知识")
    private String grade_point_healthknowledge;
    @ExcelProperty(value = "长跑")
    private String         grade_point_long_distance_run;
    @ExcelProperty(value = "全校通识")
    private String grade_point_general_knowledge;
    @ExcelProperty(value = "是否总绩点")
    private String         grade_point_istatol;
    @ExcelProperty(value = "学年")
    private String grade_point_time;

}
