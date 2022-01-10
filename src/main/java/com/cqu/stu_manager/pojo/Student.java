package com.cqu.stu_manager.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Student {
    private Integer Stu_no;
    private String Stu_password;
    private String  Stu_name;
    private Integer Stu_gender;
    private String Stu_class;
    private String Stu_birthday;
    private String Stu_ethnic;
    private String Stu_origin;
    private Integer   Stu_id;
    private String Stu_politicalface;
    private String Stu_caucus_time;
    private Integer Stu_isMacau;
    private Integer      Stu_telephone;
    private Integer Stu_qq;
    private String  Stu_email;
    private String Stu_address;
}
