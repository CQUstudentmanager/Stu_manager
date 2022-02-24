package com.cqu.stu_manager.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
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
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
        private LocalDateTime msg_deadline;
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
        private LocalDateTime msg_releasetime;
}
