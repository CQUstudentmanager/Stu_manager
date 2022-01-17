package com.cqu.stu_manager;

import com.cqu.stu_manager.utils.initLogRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StuManagerApplication {

    public static void main(String[] args) {
        initLogRecord.initLog();
        SpringApplication.run(StuManagerApplication.class, args);
    }


}
