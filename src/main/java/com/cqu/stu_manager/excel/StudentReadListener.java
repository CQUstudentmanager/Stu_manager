package com.cqu.stu_manager.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.cqu.stu_manager.mapper.StudentMapper;
import com.cqu.stu_manager.pojo.Student;
import com.cqu.stu_manager.pojo.StudentForUpload;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Component
public class StudentReadListener extends AnalysisEventListener<StudentForUpload> {

    public StudentReadListener (StudentMapper studentMapper){
        super();
        this.studentMapper=studentMapper;

    }



    // 每读一样，会调用该invoke方法一次
    @Override

    public void invoke(StudentForUpload data, AnalysisContext context) {
        System.out.println("解析到一条数据：" + data);
        saveData(data);
    }

    private void saveData(StudentForUpload data) {
        studentMapper.addStudentByExcel(data);
    }

    private StudentMapper studentMapper;


    // 全部读完之后，会调用该方法
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        System.out.println("全部解析完成");
    }

}
