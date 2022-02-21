package com.cqu.stu_manager.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patent {
  private String  patent_no;;
  private String          patent_stu_no;
  private String  patent_stu_name;
  private String          patent_name;
  private String  patent_type;
  private String          patent_application_no;
  private String  patent_application_time;
  private String          patent_certificate_no;
  private String  patent_authorization_time;
  private String          patent_isfirstone;
  private String       patent_year;
 private String patent_supporting_materials;
 private  String patent_status;

}
