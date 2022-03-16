package com.cqu.stu_manager.excel.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.cqu.stu_manager.excel.pojo.Examination;
import com.cqu.stu_manager.mapper.ExaminationMapper;
import com.cqu.stu_manager.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ExaminationListener extends AnalysisEventListener<Examination> {
    @Autowired
    ExaminationMapper examinationMapper;
    @Autowired
    RedisUtil redisUtil;
    List<Examination> examinations;
    public  ExaminationListener(ExaminationMapper examinationMapper, List<Examination> examinations, RedisUtil redisUtil){
        super();
        this.examinationMapper=examinationMapper;
        this.redisUtil=redisUtil;
        this.examinations=examinations;
    }

    @Override
    public void invoke(Examination examination, AnalysisContext analysisContext) {

        SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
        String format = sdf.format(new Date());
        examination.setFinal_Information_no(format+examination.getFinal_Information_no_stu_no());
        System.out.println(examination);
        save(examination);

    }

    private void save(Examination examination) {
        System.out.println(examination);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        System.out.println("完毕");
    }
}
