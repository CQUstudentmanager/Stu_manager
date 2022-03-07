package com.cqu.stu_manager.utils;

import java.util.Random;

public class RandamCode {
    /**
     * 生成随机码值，包含数字、大小写字母
     * @author zml2015
     * @param number 生成的随机码位数
     * @return
     */
    public  String getRandomCode(int number){
        String codeNum = "";
        int [] code = new int[3];
        Random random = new Random();
        for (int i = 0; i < number; i++) {
            int num = random.nextInt(10) + 48;
            int uppercase = random.nextInt(26) + 65;
            int lowercase = random.nextInt(26) + 97;
            code[0] = num;
            code[1] = uppercase;
            code[2] = lowercase;
            codeNum+=(char)code[random.nextInt(3)];
        }
        System.out.println(codeNum);

        return codeNum;
    }
    public static String characters1 = "0123456789";
    public static String randomStr(int factor){
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < factor; i++) {
            // nextInt(10) = [0, 10)
            sb.append(characters1.charAt(random.nextInt(10)));
        }
        return sb.toString();
    }
}
