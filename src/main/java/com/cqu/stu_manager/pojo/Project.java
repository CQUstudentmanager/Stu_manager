package com.cqu.stu_manager.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    private Integer project_no;
    private String project_name;
    private String project_unit;
    private String project_type;
    private String project_status;
    private String project_join_time;
    private String project_teacher_name;
    private String project_teacher_dept;
    private String project_student_name;
    private String project_student_no;
    private String project_issubmit;
    private String project_year;
    private String project_supporting_materials;
}
