package com.cqu.stu_manager.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    private int t_no;
    private String t_password;
    private String t_name;
    private String  t_telephone;
    private String t_officeroom;
    private int t_identity;

}
