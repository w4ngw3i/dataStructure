package com.wangwei.java8.stream;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @auther wangwei
 * @date 2019-05-19 23:16
 */
public class Test {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        Person p1 = new Person(18, "xiaoming");
        Person p2 = new Person(25, "bingbing");
        Person p3 = new Person(16, "zhaoliu");
        Person p4 = new Person(27, "wangwu");
        Person p5 = new Person(19, "xiaomei");
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);

        list.stream()
                .filter(p -> p.getAge() > 18)
                .map(Person::getName)
                .limit(2)
                .forEach(p -> System.out.println(p));

        System.out.println("---------------------------->");

        List<Integer> asList = Arrays.asList(1, 2, 1, 3, 3, 2, 4);

        asList.stream()
                .filter(i -> i % 2 == 0)
                .forEach(integer -> System.out.print(integer));
        System.out.println("去重复");
        asList.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .skip(1)
                .forEach(integer -> System.out.print(integer));
    }
}
