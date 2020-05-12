package com.wangwei.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

/**
 * @Author wangwei
 * @Date 2020/5/7 11:09 上午
 * @Version 1.0
 */
public class MenuDemo {
    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH) );

        menu.forEach(System.out::println);

        String shortMenu = menu.stream().map(Dish::getName).collect(joining());
        System.out.println(shortMenu);

        List<String> collect = menu.stream()
                .filter(d -> d.getCalories() > 300)
                .map(Dish::getName)
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(collect);

        List<String> title = Arrays.asList("Java8", "In", "Action");
        Stream<String> s = title.stream();
        s.forEach(System.out::println);
        //s.forEach(System.out::println);

        List<Integer> integers = Arrays.asList(1, 3, 6, 8, 2, 4);
        integers.stream().filter( i -> i%2 == 0).distinct().forEach(System.out::println);
    }
}
