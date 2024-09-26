package com.wh.springbootdemo01.Pojo;

/**
 * className:       User
 * author:          wenhao2002
 * date:            2024/4/3 17:15
 */
public class User {

    private String name;
    private Integer age;
    private Address address;

    public User() {
    }

    public User(String name, Integer age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
