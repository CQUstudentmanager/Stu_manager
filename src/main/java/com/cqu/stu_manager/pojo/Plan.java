package com.cqu.stu_manager.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Plan {
    private String plan_no;
    private String plan_category;
    private String plan_end_time;
    private String plan_start_time;
    private String plan_stu_no;
    private String plan_stu_name;
}
