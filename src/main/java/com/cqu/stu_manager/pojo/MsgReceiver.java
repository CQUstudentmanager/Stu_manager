package com.cqu.stu_manager.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MsgReceiver {
        private Integer msg_sender;//发送消息的人的no
        private String msg_content;//消息的内容
        private int[] stuList;//接收信息的学生
        private int isAllStudent;//是否为全部学生
        private List<String> msg_class;//接收学生的班级
}
