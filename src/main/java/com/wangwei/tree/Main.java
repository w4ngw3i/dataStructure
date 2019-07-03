package com.wangwei.tree;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {

        BST<Integer> bst = new BST<>();

        Random random = new Random();

        int[] arr = {5,3,6,8,4,2};

        for (int i = 0; i < arr.length; i++) {
            bst.add(arr[i]);
        }

        bst.preOrder();

        System.out.println();

        bst.inOrder();

        System.out.println();

        System.out.println(bst);


    }
}
