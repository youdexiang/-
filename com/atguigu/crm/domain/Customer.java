package com.atguigu.crm.domain;

//表示是一个Customer信息的对象
public class Customer {

    private int id;
    private int age;
    private String name;
    private char gender;
    private String phone;
    private String email;

    public Customer(int id, int age, String name, char gender, String phone, String email) {
        super();
        this.id = id;
        this.age = age;
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    //toString 显示客户信息

    @Override
    public String toString() {
        return id + "\t" + name + "\t" + gender + "\t" + age + "\t" + phone
                + "\t" + email;
    }

}
