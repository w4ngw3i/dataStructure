package com.wangwei.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @auther wangwei
 * @date 2019-05-20 17:53
 */
public class MapDemo2 {
    public static void main(String[] args) {
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);

        List<int[]> ints = numbers1.stream()
                .flatMap(i -> numbers2.stream()
                        .map(w -> new int[]{i, w})
                )
                .collect(Collectors.toList());

        ints.stream()
                .forEach(i -> {
                    System.out.print("[");
                    for (int j = 0; j < i.length; j++) {
                        if (j < i.length-1)
                            System.out.print(i[j] + ",");
                        else
                            System.out.println(i[j]+"]");
                    }
                });
    }
}
