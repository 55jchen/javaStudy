package com.qjc.boot.boot;

/**
 * @Author: qjc
 * @Date: 2023/5/11 16:12
 * @Description: TODO
 **/
public class User {
    private String username;
    private int age;
    private Pet pet;

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public User(String username, int age) {
        this.username = username;
        this.age = age;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", age=" + age +
                ", pet=" + pet +
                '}';
    }
}
