package com.cqu.stu_manager.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Is_doing {
    private String is_doing_no;
    private String is_doing_stu_no;
    private String is_doing_stu_name;
    private String is_doing_end;
    private String is_doing_category;
    private String is_doing_guide_teacher;
    private String is_doing_name;
    private List<String> is_doing_member;
}
