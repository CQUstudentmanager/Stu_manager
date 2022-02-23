package com.cqu.stu_manager.mapper;

import com.cqu.stu_manager.pojo.Patent;
import com.cqu.stu_manager.pojo.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PatentMapper {
    List<Patent> findAllPatent();
    int insertPatentByStudent(Patent patent);
    List<Patent> findPatentByStuno(Student student);

    int updatePatenByStudent(Patent patent);

    int deletePatentByStu(String patent_no);

    int pass_patent(String patent_no);

    int refuse_patent(String patent_no);
}
