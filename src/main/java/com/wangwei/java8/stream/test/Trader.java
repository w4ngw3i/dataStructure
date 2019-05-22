package com.wangwei.java8.stream.test;

/**
 * @auther wangwei
 * @date 2019-05-21 14:54
 */
public class Trader {

    private final String name;

    private final String city;

    public Trader(String n, String c){
        this.name = n;
        this.city = c;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Trader{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
