package com.cn.zhaojz.algorithm;

import java.util.Date;

/**
 * 插入排序
 * 时间复杂度：最好情况O(n),最坏情况O(n^2)，平均情况O(n^2)
 * 最坏情况：当排列呈现反向有序时
 * 最好情况：当排列已经有序时
 * 重复元素越多，插入排序的排序效率越高
 */
public class InsertionSort {

    public static void sort(int[] arr){
        if(arr == null) return ;
        int length = arr.length;
        for(int pos = 1; pos < arr.length; pos++){
            //把元素插入指定位置
            insert(arr, pos, arr[pos]);
        }
    }

    private static void insert(int[] arr, int pos, int value){
        int i = pos - 1;
        while(i >= 0 && arr[i] > value){
            arr[i+1] = arr[i];
            arr[i] = value;
            i--;
        }
    }

    public static void main(String[] args) {
        //样本规模
        int n = 1024*2*2*2*2*2*2;
        int[] arr_3 = new int[n];
        for(int i = n; i > 0; i--){
            arr_3[i-1] = (int)(Math.random() * n);
        }
        //out(arr_3, "排序前");
        long start = new Date().getTime();
        InsertionSort.sort(arr_3);
        long end = new Date().getTime();
        System.out.println("执行时间ms：" + ((end - start)*1D/1000));
        AlgorithmUtils.out(arr_3, "排序后");
    }
}
