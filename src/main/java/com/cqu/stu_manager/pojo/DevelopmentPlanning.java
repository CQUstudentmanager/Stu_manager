package com.cqu.stu_manager.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DevelopmentPlanning {
    private String development_planning_no;
    private String development_planning_stu_no;
    private String development_planning_stu_name;
    private String development_planning_stu_class;
    private String development_planning_room;
    private String development_planning_gpa;
    private String development_planning_nopass_point;
    private String development_planning_wish;
    private String development_planning_planone;
    private String development_planning_plantwo;
    private String development_planning_summary;
    private String development_planning_howto;
    private String development_planning_status;
    private String development_planning_family_status;
    private String year;

}
