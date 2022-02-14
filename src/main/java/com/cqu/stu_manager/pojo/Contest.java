package com.cqu.stu_manager.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contest {
      private Integer contest_id;
      private String     contest_name;
      private String  contest_projectname;
      private String        contest_grantingdepartment;
      private String  contest_level;
      private String       contest_ranking;
     private String  contest_date;
     private String        contest_teachername;
     private String  contest_teacherdept;
     private String       contest_stuname;
     private String contest_stuno;
     private String      contest_issubmitcertificate;
    private String       contest_year;
    private String contest_supporting_materials;

}
