package com.cqu.stu_manager.excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.excel.read.builder.ExcelReaderSheetBuilder;
import com.cqu.stu_manager.excel.listener.ExaminationListener;
import com.cqu.stu_manager.excel.listener.GradePointListener;
import com.cqu.stu_manager.excel.pojo.Examination;
import com.cqu.stu_manager.excel.pojo.GradePoint;
import com.cqu.stu_manager.mapper.ExaminationMapper;
import com.cqu.stu_manager.mapper.GradePiontMapper;
import com.cqu.stu_manager.utils.RedisUtil;
import org.burningwave.core.assembler.StaticComponentContainer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class Examination_reader {
    @Autowired
    ExaminationMapper examinationMapper;
    @Autowired
    RedisUtil redisUtil;
    public Examination_reader(ExaminationMapper examinationMapper,RedisUtil redisUtil){
        super();
        this.examinationMapper=examinationMapper;
        this.redisUtil=redisUtil;
    }
    public void gradepointread(String path){

        StaticComponentContainer.Modules.exportAllToAll();
        List<Examination> examinations=new ArrayList<>();
        ExcelReaderBuilder workBook = EasyExcel.read
                (path, Examination.class, new ExaminationListener(examinationMapper,examinations,redisUtil));

        // 封装工作表
        ExcelReaderSheetBuilder sheet1 = workBook.sheet();
        // 读取
        sheet1.doRead();
    }}