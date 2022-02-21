package com.cqu.stu_manager.mapper;

import com.cqu.stu_manager.pojo.Contest;
import com.cqu.stu_manager.pojo.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ContestMapper {
    List<Contest> findAllContest();
    int insertContestByStudent(Contest contest);
    List<Contest> findContestByStuno(Student student);
    int updateContestByContestNo(Contest contest);
    int deleteContestByStu(String contest_no);
    int pass_contest(String contest_no);
    int refuse_contest(String contest_no);
}
