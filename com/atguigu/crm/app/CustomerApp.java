package com.atguigu.crm.app;

import com.atguigu.crm.view.CustomerView;

//程序入口，即主类
public class CustomerApp {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        CustomerView customerView = new CustomerView();
        customerView.mainMenu();
        System.out.println("你退出了客户关系管理");
    }

}
