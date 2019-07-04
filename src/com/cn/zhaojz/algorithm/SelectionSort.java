package com.cn.zhaojz.algorithm;

/**
 * 选择排序
 * 基本思想：在长度为N的无序数据中，第一次遍历n-1个数，找到其中最小的那个元素与第一个元素交换，
 * 第二次遍历n-2个数，找到最小值与第二个元素交换，
 * 以此类推
 */
public class SelectionSort {

    public static void sort(int[] arr){
        for(int i = 0; i < arr.length; i++){
            int minIndex = i;
            for(int j = i + 1; j < arr.length; j++){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            if(minIndex > i){
                AlgorithmUtils.swap(arr, i, minIndex);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{6, 852, 3, 2, 45, 1, 17, 34, 66, 12, 13, 9, 557, 4555, 124555};
        sort(arr);
        AlgorithmUtils.out(arr, "排序后");
    }
}
