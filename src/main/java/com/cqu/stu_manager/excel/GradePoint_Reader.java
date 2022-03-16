package com.cqu.stu_manager.excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.excel.read.builder.ExcelReaderSheetBuilder;
import com.cqu.stu_manager.excel.listener.GradePointListener;
import com.cqu.stu_manager.excel.pojo.GradePoint;
import com.cqu.stu_manager.mapper.GradePiontMapper;
import com.cqu.stu_manager.pojo.StudentForUpload;
import com.cqu.stu_manager.utils.RedisUtil;
import org.burningwave.core.assembler.StaticComponentContainer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class GradePoint_Reader {
    @Autowired
    GradePiontMapper gradePiontMapper;
    @Autowired
    RedisUtil redisUtil;
    public GradePoint_Reader(GradePiontMapper gradePiontMapper,RedisUtil redisUtil){
        super();
        this.gradePiontMapper=gradePiontMapper;
        this.redisUtil=redisUtil;
    }
    public void gradepointread(String path){

        StaticComponentContainer.Modules.exportAllToAll();
        List<GradePoint> gradePoints=new ArrayList<>();
        ExcelReaderBuilder workBook = EasyExcel.read
                (path, GradePoint.class, new GradePointListener(gradePiontMapper,gradePoints,redisUtil));

        // 封装工作表
        ExcelReaderSheetBuilder sheet1 = workBook.sheet();
        // 读取
        sheet1.doRead();
    }
}
