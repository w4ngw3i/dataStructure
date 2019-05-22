package com.wangwei.java8.optional;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @auther wangwei
 * @date 2019-05-21 21:53
 */
public class Test2 {
    public static void main(String[] args) {
        Map<String, Insurance> map = new HashMap<>();
        map.put("pingan", new Insurance("pingan"));
        map.put("renbao", new Insurance("renbao"));
        map.put("taiping", new Insurance("taipin"));

//        Insurance rensou = map.get("rensou");
//        rensou.getName();

        Optional<Insurance> optionalInsurance = Optional.ofNullable(map.get("pingan"));

        optionalInsurance.ifPresent((value) -> System.out.println(value.getName()));

//        if (optionalInsurance.isPresent())
//            System.out.println(optionalInsurance.get());

    }
}
