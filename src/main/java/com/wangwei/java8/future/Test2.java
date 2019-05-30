package com.wangwei.java8.future;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * @auther wangwei
 * @date 2019-05-30 15:27
 */
public class Test2 {

    public static void main(String[] args) {

       List<Shop> shopList = Arrays.asList(new Shop("BestPrice"),
                new Shop("LetsSaveBig"),
                new Shop("MyFavoriteShop"),
                new Shop("BuyItAll"));

        long start = System.currentTimeMillis();

        List<String> iphoneXS = findPrices2("iphoneXS", shopList);


        long end = System.currentTimeMillis();

        System.out.println((end-start) / 1000);

        System.out.println(Runtime.getRuntime().availableProcessors());//得到处理器数

        /**
         * 创建守护线程的线程池
         */
        final Executor executor = Executors.newFixedThreadPool(Math.min(shopList.size(), 100), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                t.setDaemon(true);
                return t;
            }
        });

    }




    public static List<String> findPrices(String product, List<Shop> list, Executor executor){
        List<CompletableFuture<String>> futureList = list.stream()
                .map(shop -> CompletableFuture.supplyAsync(
                        () -> shop.getName() + "price is" + shop.getPriceBestAsync(product), executor))
                .collect(Collectors.toList());


        return futureList.stream()
                .map(CompletableFuture::join)//等待所有异步操作结束
                .collect(Collectors.toList());


    }


    public static List<String> findPrices2(String product, List<Shop> list){

        return list.stream()
                .map(shop ->
                        shop.getName() + shop.getPriceBestAsync(product))
                .collect(Collectors.toList());


    }



}
