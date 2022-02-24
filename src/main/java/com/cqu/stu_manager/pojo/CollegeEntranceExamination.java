package com.cqu.stu_manager.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CollegeEntranceExamination {
    private String college_entrance_examination_no;
    private String college_entrance_examination_highschool_name;
    private String college_entrance_examination_type;
    private String college_entrance_examination_chinese;
    private String college_entrance_examination_math;
    private String college_entrance_examination_english;
    private String college_entrance_examination_comprehensive;
    private String college_entrance_examination_stu_no;

}
