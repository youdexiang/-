package com.atguigu.crm.utils;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        //测试工具类的使用
        //这里是静态方法，可以通过类名，直接使用，关于静态，马上
        //接收的字符串的长度最大5=>体验
//		System.out.println("请输入字符串");
//		String readString = CMUtility.readString(5);
//		System.out.println("得到的字符串=" + readString);

        System.out.println("姓名(张三) : ");

        String name = CMUtility.readString(8, "");
        if("".equals(name)) {
            System.out.println("你不希望修改~~");
        } else {
            System.out.println("你希望修改成" + name);
        }
    }

}
