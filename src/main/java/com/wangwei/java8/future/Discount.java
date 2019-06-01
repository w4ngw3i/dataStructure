package com.wangwei.java8.future;

import java.text.Format;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * @auther wangwei
 * @date 2019-05-31 09:19
 */
public class Discount {
    public enum Code {
        NONE(0),
        SILVER(5),
        GOLD(10),
        PLATINUM(15),
        DIAMOND(20);

        private final int percentage;

        Code(int percentage) {
            this.percentage = percentage;
        } }


    /**
     * 将折扣代码应用于商品最初的元始价格
     * @param quote
     * @return
     */
    public static String applyDiscount(Quote quote) {
        return quote.getShopName() + " price is " +
                Discount.apply(quote.getPrice(),
                        quote.getDiscountCode());
    }

    /***
     * 模拟discount服务响应延迟
     * @param price
     * @param code
     * @return
     */
    private static double apply(double price, Code code) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return (price * (100 - code.percentage) / 100);
    }


    public List<String> findPrice(List<Shop> list, String product){
        return list.stream()
                .map(shop -> shop.getPrice2(product))
                .map(Quote::parse)
                .map(Discount::applyDiscount)
                .collect(Collectors.toList());
    }


    public List<String> findPrice2(List<Shop> list, String product){
        Executor executor = Executors.newFixedThreadPool(Math.min(list.size(), 100), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                t.setDaemon(true);
                return t;
            }
        });

        List<CompletableFuture<String>> completableFutures = list.stream()
                .map(shop -> CompletableFuture.supplyAsync(
                        () -> shop.getPrice2(product), executor
                ))
                .map(future -> future.thenApply(Quote::parse))
                .map(future -> future.thenCompose(quote -> CompletableFuture.supplyAsync(
                        () -> Discount.applyDiscount(quote), executor
                )))
                .collect(Collectors.toList());

        return completableFutures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
    }


    /***
     * java7 future
     * @param shop
     * @param product
     */
    public void test(Shop shop, String product){
        ExecutorService executor = Executors.newCachedThreadPool();

        Future<Double> futurePrice = executor.submit(new Callable<Double>() {
            @Override
            public Double call() throws Exception {
                return shop.getPrice(product);
            }
        });

        executor.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return shop.getPrice2(product);
            }
        });

    }



}
