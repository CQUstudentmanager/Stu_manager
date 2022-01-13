package com.cqu.stu_manager.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class upDatePassword {
    private String old_password;
    private String new_password;
    private int stu_no;
}
