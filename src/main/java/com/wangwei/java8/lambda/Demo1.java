package com.wangwei.java8.lambda;

/**
 * @auther wangwei
 * @date 2019-05-13 09:34
 */
public class Demo1 {
    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println("hello world");



        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world");
            }
        };

        process(runnable1);
        process(runnable);
        process(() -> System.out.println("hello world"));


    }

    public static void process(Runnable runnable){
        runnable.run();
    }
}
