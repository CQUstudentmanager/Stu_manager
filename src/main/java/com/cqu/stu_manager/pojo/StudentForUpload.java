package com.cqu.stu_manager.pojo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentForUpload {

    private Integer stu_no;

    private String stu_password;

    private String  stu_name;

    private Integer stu_gender;

    private String stu_class;

    private String stu_birthday;

    private String stu_ethnic;

    private String stu_origin;

    private String  stu_id;

    private String stu_politicalface;

    private String stu_caucus_time;

    private Integer stu_ismacau;

    private String stu_telephone;

    private String stu_qq;

    private String  stu_email;

    private String stu_address;

    private String stu_photourl;

    private String stu_major;

    private String stu_join_time;


}
