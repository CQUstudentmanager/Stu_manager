package com.cqu.stu_manager.mapper;

import com.cqu.stu_manager.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {
    Admin findAdminPasswod(String admin_username);
}
