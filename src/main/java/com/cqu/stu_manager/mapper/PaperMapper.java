package com.cqu.stu_manager.mapper;

import com.cqu.stu_manager.pojo.Paper;
import com.cqu.stu_manager.pojo.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface PaperMapper {
    List<Paper> findAllStuPaper();//找到所有的论文（不论审核是否通过）
    int insertPaperByStudent(Paper paper);//将学生上传的信息插入到数据库中
    List<Paper> findPaperByStuno(Student student);//根据学生的no找到他对应的论文情况
   int updatePaperByPaperNo(Paper paper);
   int deletePaperByStu(String paper_no);
   int pass_paper(String paper_no);
   int refuse_paper(String paper_no);
}
