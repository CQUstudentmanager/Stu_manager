package com.cqu.stu_manager.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Accommodation {
    private Integer accommodation_information_no;
    private String accommodation_information_stu_no;
    private String  accommodation_information_room_no;
    private String accommodation_information_bed;
    private String accommodation_information_building;
    private String accommodation_information_ismain;

}
