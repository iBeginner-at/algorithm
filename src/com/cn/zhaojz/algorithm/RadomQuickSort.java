package com.cn.zhaojz.algorithm;

/**
 * 随机快速排序
 */
public class RadomQuickSort {
    public static void sort(int[] arr, int left, int right){
        if(left >= right){
            return;
        }
        int r = (int)(Math.random()*(right-left)) + left;
        AlgorithmUtils.swap(arr, left, r);
        int key = arr[left];
        int i = left, j = right;
        while(i < j){
            //从右向左找出第一个小于基准元素的值
            while(i < j && arr[j] >= key){
                j--;
            }
            if(i < j){
                arr[i] = arr[j];
                i++;
            }
            while(i < j && arr[i] < key){
                i++;
            }
            if(i < j){
                arr[j] = arr[i];
            }
        }
        arr[i] = key;
        sort(arr, left, i-1);
        sort(arr, i+1, right);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{6, 852, 3, 2, 45, 1, 17, 34, 66, 12, 13, 9, 557, 4555, 124555};
        sort(arr, 0, arr.length - 1);
        AlgorithmUtils.out(arr, "排序后");
    }
}
