package com.cn.zhaojz.algorithm;

/**
 * 中值排序
 * 采用分治的思想，它将一个问题分解成两个独立的子问题，每个子问题的规模是原始问题的一半。
 * 使用中值排序的关键是高效的从待排序数组中选择出中值元素。
 */
public class MedianQuickSort {
    public static void sort(int[] arr, int left, int right){
        if(left >= right){
            return;
        }
        int num = right - left;
        if(num == 1){
            if(arr[left] > arr[right]){
                AlgorithmUtils.swap(arr, left, right);
                return;
            }
        }
        //中位取中,采用插入排序法
        int medianIndex = (left + right)/2;
        if(arr[medianIndex] < arr[left]){
            AlgorithmUtils.swap(arr, left, medianIndex);
        }
        if(arr[right] < arr[medianIndex]){
            AlgorithmUtils.swap(arr, medianIndex, right);
        }
        if(arr[medianIndex] < arr[left]){
            AlgorithmUtils.swap(arr, left, medianIndex);
        }

        if(num == 2){
            return;
        }
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
            //从左向右找出第一个大于等于
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
