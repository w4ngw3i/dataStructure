package com.wangwei.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @auther wangwei
 * @date 2019-05-20 18:30
 */
public class SumDemo {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 3, 5, 8);

        System.out.println(list.stream()
                .map(i -> 1)
                .reduce(0, Integer::sum));

//        求最大值
        Integer max = list.stream()
                .reduce(0, Integer::max);

        System.out.println(max);

        list.stream().reduce((x, y) -> x > y ? x : y);


        float v = list.stream()
                .reduce(0, (a, b) -> a + b);


        Integer sum = list.stream()
                .reduce(0, (a, b) -> a + b);

        System.out.println("sum=" + sum);

        System.out.println(list.stream().reduce(0, Integer::sum));

        Optional<Integer> optionalInteger = list.stream().reduce(Integer::sum);

        Integer integer = optionalInteger.get();

        System.out.println(integer);


        System.out.println(v);

    }
}
