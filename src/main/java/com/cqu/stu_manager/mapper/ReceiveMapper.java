package com.cqu.stu_manager.mapper;

import com.cqu.stu_manager.pojo.Receive;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ReceiveMapper {
    int addReceiver(Receive receive);
}
