package com.wangwei.java8.future;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

/**
 * @auther wangwei
 * @date 2019-05-30 13:50
 */
public class Shop {

    private String name;

    public Shop() {
    }

    public Shop(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * 模拟同步情况下的阻塞调用
     * @param product
     * @return
     */
    public double getPrice(String product){
        return calculatePrite(product);
    }


    /**
     * 使用 实现非阻塞的异步调用
     * @param product
     * @return
     */
    public Future<Double> getPriceAsync(String product){
        CompletableFuture<Double> future = new CompletableFuture<>();

        //在另一个线程中以异步的方式执行计算
        new Thread(() -> {
            try {
                double prite = calculatePrite(product);
                future.complete(prite); //将计算结果设置future的返回值
            }catch (Exception e){
                future.completeExceptionally(e);//抛出导致失败的异常，完成这次future操作
            }
        }).start();

        return future;
    }

    /**
     * 最佳异步实现
     * @param product
     * @return
     */
    public Future<Double> getPriceBestAsync(String product){
        return CompletableFuture.supplyAsync(() -> calculatePrite(product));
    }


    public static void delay(){
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public double calculatePrite(String product){
        delay();

        return new Random().nextDouble() * product.charAt(0) + product.charAt(1);
    }


    public String getPrice2(String product) {
        double price = calculatePrice2(product);
        Discount.Code code = Discount.Code.values()[
                new Random().nextInt(Discount.Code.values().length)];
        return String.format("%s:%.2f:%s", name, price, code);
    }


    private double calculatePrice2(String product) {

        delay();

        return new Random().nextDouble() * product.charAt(0) + product.charAt(1);
    }
}
