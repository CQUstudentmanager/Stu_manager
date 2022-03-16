package com.cqu.stu_manager.excel.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.cqu.stu_manager.excel.pojo.GradePoint;
import com.cqu.stu_manager.mapper.GradePiontMapper;
import com.cqu.stu_manager.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Component
public class GradePointListener extends AnalysisEventListener<GradePoint> {
@Autowired
GradePiontMapper gradePiontMapper;
    @Autowired
    RedisUtil redisUtil;
    List<GradePoint> gradePoints;
    public GradePointListener (GradePiontMapper gradePiontMapper,List<GradePoint> gradePoints,RedisUtil redisUtil){
        super();
        this.gradePiontMapper=gradePiontMapper;
        this.gradePoints=gradePoints;
        this.redisUtil=redisUtil;

    }



    // 每读一样，会调用该invoke方法一次
    @Override

    public void invoke(GradePoint data, AnalysisContext context) {
        System.out.println("解析到一条数据：" + data);
        SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
        String format = sdf.format(new Date());
        data.setGrade_point_no(data.getGrade_point_stu_no()+format);
        save(data);

    }

    private void save(GradePoint data) {
        gradePoints.add(data);

    }


    // 全部读完之后，会调用该方法
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        if (!redisUtil.hasKey("test123")){
        redisUtil.set("test123",gradePoints,300);}
        gradePoints=new ArrayList<>();

    }

}