package com.cqu.stu_manager.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Msg {
    private String msg_no;
    private String msg_content;
    private Integer msg_sender;

}
