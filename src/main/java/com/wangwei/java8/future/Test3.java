package com.wangwei.java8.future;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @auther wangwei
 * @date 2019-05-31 09:39
 * 使用Discount服务
 */
public class Test3 {
    public static void main(String[] args) {

        List<Shop> shopList = Arrays.asList(new Shop("BestPrice"),
                new Shop("LetsSaveBig"),
                new Shop("MyFavoriteShop"),
                new Shop("BuyItAll"));
        findPrice2(shopList, "iphoneXS")
                .map(future -> future.thenAccept(System.out::println));


    }


    public static Stream<CompletableFuture<String>> findPrice2(List<Shop> list, String product){
        Executor executor = Executors.newFixedThreadPool(Math.min(list.size(), 100), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                t.setDaemon(true);
                return t;
            }
        });

        return list.stream()
                .map(shop -> CompletableFuture.supplyAsync(
                        () -> shop.getPrice2(product), executor
                ))
                .map(future -> future.thenApply(Quote::parse))
                .map(future -> future.thenCompose(quote -> CompletableFuture.supplyAsync(
                        () -> Discount.applyDiscount(quote), executor
                )));
    }
}
