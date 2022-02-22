package com.cqu.stu_manager.excel.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BedroomForHuxi {
   @ExcelProperty(value ="姓名" ,index = 0)
    private String name;
   @ExcelProperty(value ="性别" ,index = 1)
    private String gender;
   @ExcelProperty(value ="年级" ,index = 2)
    private String grade;
   @ExcelProperty(value ="专业" ,index = 3)
    private String major;
   @ExcelProperty(value ="入住楼栋" ,index = 4)
    private String building;
   @ExcelProperty(value ="入住宿舍号" ,index = 5)
    private String room;
   @ExcelProperty(value ="备注" ,index = 6)
    private String ps;

}
