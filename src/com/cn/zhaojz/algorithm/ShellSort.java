package com.cn.zhaojz.algorithm;

/**
 * 希尔排序，算法名称来源于其提出者Donald Shell。
 * 希尔排序是基于插入排序算法的，是一种优化改进版本，又称“缩小增量排序”。
 * 希尔排序是不稳定的。
 */
public class ShellSort {
    public static void sort(int[] arr){
        int increment = arr.length;
        while(true){
            increment = increment/2;
            //按增量对元素分组
            for(int i = 0; i< arr.length; i = i + increment){
                for(int j = i+increment; j < arr.length; j = j + increment){
                    //把元素插入指定位置
                    insert(arr, j, arr[j]);
                }
            }
            if(increment == 1){
                break;
            }
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
        int[] arr = new int[]{6, 852, 3, 2, 45, 1, 17, 34, 66, 12, 13, 9, 557, 4555, 124555};
        sort(arr);
        AlgorithmUtils.out(arr, "排序后");
    }
}
