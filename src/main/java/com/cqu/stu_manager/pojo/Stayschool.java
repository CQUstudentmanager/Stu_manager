package com.cqu.stu_manager.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stayschool {
   private String stay_school_info_no;
   private String stay_school_info_stu_no;
   private String stay_school_info_begin;
   private String stay_school_info_end;
   private String stay_school_info_reason;
   private String stay_school_info_status;
   private String stay_school_info_time;
   private String stay_school_info_stuname;
   private  String stay_school_info_stuclass;
   private String teacherNo;

}
