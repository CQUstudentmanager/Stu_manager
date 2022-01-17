package com.cqu.stu_manager.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Receive {
    private String receive_no;
    private String msg_no2;
    private Integer receiver;
    private Integer status;
}
