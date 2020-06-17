package com.atguigu.crm.view;

import com.atguigu.crm.domain.Customer;
import com.atguigu.crm.service.CustomerService;
import com.atguigu.crm.utils.CMUtility;

//界面
public class CustomerView {

    private boolean loop = true;
    private char key = ' '; //接收到用户菜单选择
    //这里创建一个 CustomerService的目的是为了调用 方法
    private CustomerService cs = new CustomerService(10);
    //显示主菜单->方法
	/*
	 * -----------------客户信息管理软件-----------------

                            1 添 加 客 户
                            2 修 改 客 户
                            3 删 除 客 户
                            4 客 户 列 表
                            5 退           出

                            请选择(1-5)：_

	 */
    public void mainMenu() {

        do{
            System.out.println("-----------------客户信息管理软件-----------------");
            System.out.println("\t\t\t 1 添 加 客 户");
            System.out.println("\t\t\t 2 修 改 客 户");
            System.out.println("\t\t\t 3 删 除 客 户");
            System.out.println("\t\t\t 4 客 户 列 表");
            System.out.println("\t\t\t 5 退         出");
            System.out.print("请输入你的选择:");
            //使用工具类
            key = CMUtility.readChar();
            //switch
            switch (key) {
                case '1':
                    add();
                    break;
                case '2':
                    System.out.println("2 修 改 客 户");
                    break;
                case '3':
                    del();
                    break;
                case '4':
                    list();
                    break;
                case '5':
                    //要求在退出时，确认下
                    //在增加或者修改功能时，我们需要知道在哪里
                    System.out.println("你确认要退出吗 Y/N");
                    //工具类，一般你参加工作后，每个公司都有自己的工具库。
                    //业务逻辑-----》 使用 工具库...
                    char select = CMUtility.readConfirmSelection();
                    if(select == 'Y') {
                        loop = false;
                    }
                    break;
                default:
                    System.out.println("你的菜单输入有误，请重新输入~~");
                    break;
            }

        }while(loop);


    }
    /*
     * ---------------------------客户列表---------------------------
编号  姓名       性别    年龄   电话            邮箱
 1    张三       男      30     010-56253825   abc@email.com
 2    李四       女      23     010-56253825    lisi@ibm.com
 3    王芳       女      26     010-56253825   wang@163.com
-------------------------客户列表完成-------------------------

     */
    //增加新方法
    public void list() {
        Customer[] customers = cs.showList();//显示的客户信息
        System.out.println("---------------------------客户列表---------------------------");
        System.out.println("编号\t姓名\t性别\t年龄\t电话\t邮箱");
        //遍历并输出, 输出时，我们将输出信息，直接封装到Customer的toStriing
        for (int i = 0; i < customers.length; i++) {
            //System.out.println(showCustomerList[i].getId() + "\t" + );
            System.out.println(customers[i]);
        }
        System.out.println("-------------------------客户列表完成-------------------------");
    }

    //增加新方法，完成添加
	/*
	 * ---------------------添加客户---------------------
		姓名：张三
		性别：男
		年龄：30
		电话：010-56253825
		邮箱：zhang@abc.com
		---------------------添加完成---------------------
	 */
    public void add() {
        //界面
        System.out.println("---------------------添加客户---------------------");
        System.out.print("姓名：");
        String name = CMUtility.readString(8);
        System.out.print("性别：");
        char gender = CMUtility.readChar();
        System.out.print("年龄：");
        int age = CMUtility.readInt();
        System.out.print("电话：");
        String phone = CMUtility.readString(11);
        System.out.print("邮箱：");
        String email = CMUtility.readString(20);
        //? id? => 自增的方法，单独给一个自增变量
        //创建一个customer对象
        //假定给一个初始id, 后面修改
        Customer newCustomer = new Customer(0, age, name, gender, phone, email);
        if(cs.add(newCustomer)) {
            System.out.println("---------------------添加完成---------------------");
        } else {
            System.out.println("---------------------添加失败---------------------");
        }




    }

    //界面，接收要删除的id
	/*
	 * ---------------------删除客户---------------------
		请选择待删除客户编号(-1退出)：1
		确认是否删除(Y/N)：y
		---------------------删除完成---------------------

	 */
    public void del() {// 各司其职->分工不同

        System.out.println("---------------------删除客户---------------------");
        System.out.print("请选择待删除客户编号(-1退出)：");
        int delId = CMUtility.readInt();

        if(delId == -1) {
            System.out.println("---------------------删除放弃---------------------");
            return;
        }
        //这里 readConfirmSelection 本身就含有确认必须输入 y/n 逻辑
        System.out.print("确认是否删除(Y/N)：");
        char select = CMUtility.readConfirmSelection();
        if(select == 'Y') {
            //删除业务
            if(cs.del(delId)) { //调用CustomerService的 del方法
                System.out.println("---------------------删除完成---------------------");
            } else {
                System.out.println("---------------------删除失败，Id不存在---------------------");
            }
        }
        //如果输出的N , 就不处理...

    }


}
