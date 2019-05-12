package com.wangwei.sort;



/**
 * @auther wangwei
 * @date 2019-05-12 15:19
 */
public class SortTest {
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

    public static void main(String[] args) {

        SelectSort selectSort = new SelectSort();
        int[] arr = new int[]{5, 3, 9, 2, 1, 32, 17, 78};
        printArr(arr);

        selectSort.selectSort(arr);
//        bubbleSort(arr);


//        Arrays.sort(arr);
        printArr(arr);
    }
}
