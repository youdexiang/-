package com.atguigu.crm.service;

import com.atguigu.crm.domain.Customer;

//处理业务的(增删改查)
public class CustomerService {
    //定义一个客户对象数组，用于存放所有的客户(对象)
    private Customer customers[];
    //属性表示当前有多少个客户
    private int customerNum = 1;
    //写一个id的自增变量, 控制id的值
    private int idCount = 1;

    //构造器中，初始化客户对象数组对象大小
    public CustomerService(int len) { // len = 10;
        customers = new Customer[len];
        //初始化一个客户，看看输出效果
        customers[0] = new Customer(1, 10, "tom", '男', "110", "tom@sohu.com");

    }

    //删除
    public boolean del(int delId) {
        //先判断delId 是否存在
        //1. 如果不存在，就返回 false;
        int index = -1;
        for (int i = 0; i < customerNum ; i++) {//遍历实际客户数量
            if(delId == customers[i].getId()) {//相等
                index = i;//找到..
                break;
            }
        }

        //2. 如果存在，就删除
        if(index == -1) {//没有找到
            System.out.println("没有找到这个客户，不能删除");
            return false;
        }
        //3. 如何将一个元素，从数组中删除?=>变化一点...
        // 将 arr[index + 1] 开始向前移动就可以，直到最后一个
        for(int i = index + 1; i < customerNum; i++ ) {
            customers[i-1] = customers[i];
        }
        customerNum--;
        return true;

    }

    //增加客户
    //这里假定，最多10个
    public boolean add(Customer newCustomer) {
        if(customerNum >= customers.length) {
            System.out.println("数组满，不能加人...");
            return false;
        }
        //这里需要重置id
        newCustomer.setId(++idCount);
        customers[customerNum++] = newCustomer;
        return true;

    }

    //显示列表 [尝试~~]

    public Customer[] showList() {
        //这里我们需要注意，我们Customer[]数组需要处理.
        //简单实现思路 ==> 优化
        //1. 将实际存放客户信息放入到一个新的数组中，返回
        Customer[] customerList = new Customer[customerNum];
        //2. 将客户拷贝到 customerList
        for (int i = 0; i < customerList.length; i++) {
            customerList[i] = customers[i];
        }
        return 	customerList;


    }


    //添加客户

    //删除客户

    //修改客户

}
