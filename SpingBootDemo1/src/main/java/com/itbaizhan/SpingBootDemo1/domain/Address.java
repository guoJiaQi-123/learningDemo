package com.itbaizhan.SpingBootDemo1.domain;

public class Address {
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Address{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
