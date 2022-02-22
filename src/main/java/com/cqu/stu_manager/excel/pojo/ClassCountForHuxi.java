package com.cqu.stu_manager.excel.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassCountForHuxi {

    @ExcelProperty(value = "序号",index =0 )
    private String Huxi_no;
    @ExcelProperty(value = "专业",index =1 )
    private String Huxi_major;
    @ExcelProperty(value = "班级",index =2 )
    private String Huxi_class;
    @ExcelProperty(value = "人数",index =3 )
    private String Huxi_studentcount;
    @ExcelProperty(value = "男生",index =4 )
    private String Huxi_boys;
    @ExcelProperty(value = "女生",index =5 )
    private String Huxi_girls;
    @ExcelProperty(value = "降级生",index =6 )
    private String Huxi_down;
    @ExcelProperty(value = "交换生",index =7 )
    private String Huxi_exchange;
    @ExcelProperty(value = "备注",index =8 )
    private String Huxi_ps;
}
