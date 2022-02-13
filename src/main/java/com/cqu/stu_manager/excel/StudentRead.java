package com.cqu.stu_manager.excel;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.excel.read.builder.ExcelReaderSheetBuilder;
import com.cqu.stu_manager.mapper.StudentMapper;
import com.cqu.stu_manager.pojo.Student;
import org.burningwave.core.assembler.StaticComponentContainer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;


import java.io.FileNotFoundException;

public class StudentRead {
    public StudentRead (StudentMapper studentMapper){
        this.studentMapper=studentMapper;
    }
    @Autowired
    StudentMapper studentMapper;
    public void simpleRead() {
        StaticComponentContainer.Modules.exportAllToAll();

        // 读取文件，读取完之后会自动关闭
        /*
        	pathName  		文件路径；
        	head			每行数据对应的实体；Student.class
        	readListener	读监听器，每读一样就会调用一次该监听器的invoke方法

        	sheet方法参数： 工作表的顺序号（从0开始）或者工作表的名字，不传默认为0
        */
        // 封装工作簿对象
        ExcelReaderBuilder workBook = EasyExcel.read
                ("E:\\student.xls", Student.class, new StudentReadListener(studentMapper));

        // 封装工作表
        ExcelReaderSheetBuilder sheet1 = workBook.sheet();
        // 读取
        sheet1.doRead();

    }

}

