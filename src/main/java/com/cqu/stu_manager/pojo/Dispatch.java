package com.cqu.stu_manager.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Dispatch {
    private Integer dispatch_no;
    private String dispatch_name;
    private String dispatch_level;
    private String dispatch_project_type;
    private String dispatch_nation;
    private String dispatch_continent;
    private String dispatch_foreign_counterpart;
    private String dispatch_stu_name;
    private String dispatch_stu_gender;
    private String dispatch_stu_no;
    private String dispatch_stu_department;
    private String dispatch_stu_major;
    private String dispatch_project_time_from_to;
    private String dispatch_greater_than_3month;
    private String dispatch_arrangement;
    private String dispatch_grade;
    private String dispatch_passport_no;
    private String dispatch_tel;
    private String dispatch_email;
    private String dispatch_is_admission;
    private String dispatch_is_top200;

}
