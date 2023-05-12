package com.qjc.boot.boot;

/**
 * @Author: qjc
 * @Date: 2023/5/11 16:41
 * @Description: TODO
 **/
public class Pet {
    private String name;

    public Pet(String name) {
        this.name = name;
    }

    public Pet() {
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

