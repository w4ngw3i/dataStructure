package com.wangwei.test;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author: wangwei
 * @date: 2019-09-28 17:43
 */
public class BiFunctionDmeo {
    public static void main(String[] args) {
        System.out.println(compute3(2, 3, (v1, v2) -> v1 + v2));
        System.out.println(compute3(2, 3, (v1, v2) -> v1 - v2));
        System.out.println(compute3(2, 3, (v1, v2) -> v1 * v2));
        System.out.println(compute4(2, 3, (v1, v2) -> v1 + v2, v1 -> v1 * v1));
    }

    public static int compute3(int a, int b, BiFunction<Integer, Integer, Integer> biFunction) {
        return biFunction.apply(a, b);
    }

    public static int compute4(int a, int b, BiFunction<Integer, Integer, Integer> biFunction, Function<Integer, Integer> function) {
        return biFunction.andThen(function).apply(a, b);
    }
}
