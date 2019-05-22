package com.wangwei.java8.optional;

import java.util.Optional;

/**
 * @auther wangwei
 * @date 2019-05-21 17:32
 */
public class Car {
//    private Insurance insurance;
//
//    public Insurance getInsurance() {
//        return insurance;
//    }

    /**
     *  车可能进行了保险，也可 能没有保险，所以将这个 字段声明为Optional
     */
    private Optional<Insurance> insurance;

    public Optional<Insurance> getInsurance() {
        return insurance;
    }
}
