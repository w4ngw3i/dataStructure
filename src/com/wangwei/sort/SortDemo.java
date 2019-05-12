package com.wangwei.sort;

public class SortDemo {

    public static void main(String[] args) {

        int[] arr = new int[]{5, 3, 9, 2, 1, 32, 17, 78};
        printArr(arr);

        selectSort(arr);
//        bubbleSort(arr);


//        Arrays.sort(arr);
        printArr(arr);
    }


    /**
     * 冒泡排序
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        for (int x = 0; x < arr.length; x++) {
            for (int y = 0; y < arr.length - x - 1; y++) {
                if (arr[y] > arr[y + 1]) {
                    int temp = arr[y];
                    arr[y] = arr[y + 1];
                    arr[y + 1] = temp;
                }
            }
        }
    }

    /**
     * 选择排序
     *
     * @param arr
     */
    public static void selectSort(int[] arr) {
        for (int x = 0; x < arr.length - 1; x++) {
            for (int y = x + 1; y < arr.length; y++) {
                if (arr[x] > arr[y]) {
//                    int temp = arr[x];
//                    arr[x] = arr[y];
//                    arr[y] = temp;
                    swap(arr, y, x);
                }
            }
        }
    }


    public static void printArr(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length - 1)
                System.out.print(arr[i] + ",");
            else
                System.out.println(arr[i] + "]");
        }
    }


    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}

