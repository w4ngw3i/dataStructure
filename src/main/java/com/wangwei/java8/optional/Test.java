package com.wangwei.java8.optional;

import java.util.Optional;

/**
 * @auther wangwei
 * @date 2019-05-21 17:33
 */
public class Test {
    public static void main(String[] args) {
        Person person = new Person();

        Optional<Person> optionalPerson = Optional.ofNullable(person);

        String carInsuranceName = getCarInsuranceName(optionalPerson);

        System.out.println(carInsuranceName);

        String unknown = optionalPerson.flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("Unknown");
        System.out.println(unknown);

//        Optional<Insurance> insurance1 = Optional.ofNullable(insurance);

//        Optional<String> s = insurance1.map(Insurance::getName);

//        System.out.println(s);
    }

    public static String getCarInsuranceName(Optional<Person> person) {
        return person.flatMap(Person::getCar)
            .flatMap(Car::getInsurance) .map(Insurance::getName) .orElse("Unknown");
    }

}
