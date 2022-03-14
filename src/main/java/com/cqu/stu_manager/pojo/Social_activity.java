package com.cqu.stu_manager.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.sf.cglib.core.Local;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Social_activity {
    private String social_activity_no;//这个前端随便传一个null或者0
    private String social_activity_stu_no;//学号
    private String social_activity_stu_name;//学生姓名
    private String social_activity_name;//社会服务名称
    private String social_activity_start_time;//起始年份，一定要是四位数
    private String social_activity_end_time;//截止年份
}
