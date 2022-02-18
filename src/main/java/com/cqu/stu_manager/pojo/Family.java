package com.cqu.stu_manager.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Family {
    private String family_stu_no;
    private String family_relationship;
    private String family_name;
    private String family_age;
    private String family_tel;
    private String family_work;
    private String family_duties;
    private String family_workplace;
    private String family_ismain;

}
