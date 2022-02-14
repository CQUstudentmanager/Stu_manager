package com.cqu.stu_manager.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Paper {
    private Integer paper_no;
    private String paper_stuno;
    private String   paper_stuname;
    private String paper_name;
    private String  paper_periodical;
    private String paper_publicationTime;
    private String       paper_iscscd;
    private String paper_sciSearchNumber;
    private String       paper_eiSearchNumber;


}
