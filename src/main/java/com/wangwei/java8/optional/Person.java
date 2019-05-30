package com.wangwei.java8.optional;

import java.util.Optional;

/**
 * @auther wangwei
 * @date 2019-05-21 17:31
 */
public class Person {

//    private Car car;
//
//    public Car getCar() {
//        return car;
//    }

    /**
     * 人可能有车，也可能没 有车，因此将这个字段 声明为Optional
     */

    protected Optional<Car> car;

    public Optional<Car> getCar() {
        return car;
    }
}
