package com.cn.zhaojz.algorithm;

/**
 * 公用方法定义
 */
public class AlgorithmUtils {
    /**
     * 交换元素
     * @param arr
     * @param i
     * @param i1
     */
    public static void swap(int[] arr, int i, int i1) {
        int tmp = arr[i1];
        arr[i1] = arr[i];
        arr[i] = tmp;
    }

    /**
     * 打印数据元素
     * @param arr
     * @param message
     */
    public static void out(int[] arr, String message){
        System.out.println(message);
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]);
            System.out.print("\t");
        }
        System.out.println();
    }
}
