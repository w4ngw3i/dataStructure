package com.wangwei.test;

import java.util.function.Function;

/**
 * @author: wangwei
 * @date: 2019-09-28 17:26
 */
public class FunctionDemo {

    public static void main(String[] args) {
        System.out.println(compute(5, value -> value * value));
        System.out.println(compute(5, value -> value - 2));

        System.out.println(compute(2, value -> value * 3, value -> value * value) );

        System.out.println(compute2(2, value -> value * 3, value -> value * value) );
    }

    public static int compute(int a, Function<Integer, Integer> function) {
        int result = function.apply(a);
        return result;
    }

    public static int compute(int a, Function<Integer, Integer> function1, Function<Integer, Integer> function2) {
        return function1.compose(function2).apply(a);
    }

    public static int compute2(int a, Function<Integer, Integer> function1, Function<Integer, Integer> function2) {
        return function1.andThen(function2).apply(a);
    }
}
