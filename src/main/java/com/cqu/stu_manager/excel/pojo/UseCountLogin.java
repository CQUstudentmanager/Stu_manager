package com.cqu.stu_manager.excel.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UseCountLogin  implements Serializable {
    public String useCountLogin;

}
