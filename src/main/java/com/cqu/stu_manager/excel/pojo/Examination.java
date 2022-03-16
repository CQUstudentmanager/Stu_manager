package com.cqu.stu_manager.excel.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Examination {

    private String  final_Information_no="";
    @ExcelProperty(value = "学号")
    private String  final_Information_no_stu_no="";
    @ExcelProperty(value = "姓名")
    private String  final_Information_stu_name="";
    @ExcelProperty(value = "学年学期")
    private String  final_Information_year="";
    @ExcelProperty(value = "学院")
    private String  final_Information_dept="";
    @ExcelProperty(value = "课程名称")
    private String  final_Information_no_coursename="";
    @ExcelProperty(value = "课程代码")
    private String  final_Information_coursecode="";
    @ExcelProperty(value = "修读性质")
    private String  final_Information_character="";
    @ExcelProperty(value = "综合成绩")
    private String  final_Information_comprehensive_achievements="";
    @ExcelProperty(value = "有效成绩")
    private String  final_Information_effective_achievement="";
    @ExcelProperty(value = "考试情况")
    private String  final_Information_examination_situation="";
    @ExcelProperty(value = "考试类型")
    private String  final_Information_examination_type="";


}
