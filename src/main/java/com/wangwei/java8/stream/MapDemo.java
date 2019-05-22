package com.wangwei.java8.stream;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @auther wangwei
 * @date 2019-05-19 23:43
 */
public class MapDemo {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Java 8", "Lambdas", "In", "Action");
        List<Integer> list = words.stream()
                .map(String::length)
                .collect(Collectors.toList());

        list.stream().forEach(w -> System.out.println(w));

        String name = "wangwei";


        String[] word = new String[]{"Hello","World"};
        Arrays.stream(word)
                .map(w -> w.split(""))
                .flatMap(Arrays::stream)
                .forEach(w -> System.out.println(w) );


//        String[] arrayOfWords = {"Goodbye", "World"};

        int[] nums = new int[]{};


        List<Integer> asList = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> integers = asList.stream()
                .map(i -> i * i)
                .collect(Collectors.toList());
        integers.stream().forEach(i -> System.out.print(i));


    }
}
