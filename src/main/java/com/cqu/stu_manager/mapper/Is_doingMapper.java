package com.cqu.stu_manager.mapper;

import com.cqu.stu_manager.pojo.Is_doing;
import com.cqu.stu_manager.pojo.Member;
import com.cqu.stu_manager.pojo.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface Is_doingMapper {
    Is_doing find_my_is_doing(Student student);
    List<Member> find_my_member(String is_doing_name);
    int insert_is_doing(Is_doing is_doing);
    int insert_is_doing_member(Member member);
    int delete_is_doing(Is_doing is_doing);
    int delete_is_doing_member(String is_doing_name);
}
