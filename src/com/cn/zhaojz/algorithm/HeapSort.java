package com.cn.zhaojz.algorithm;

/**
 * 堆排序：使用的堆的特点来实现的排序的算法。
 * 堆排序的过程分为两个基本步骤：
 * 1、将原始数据堆化成大根堆
 * 2、不断重复以下操作：1、删除堆顶元素（实际上是交换堆项元素与尾部叶元素，数列将被分成树区和有序区两部分） 2 重新堆化。
 *
 * 非稳定排序，时间复杂度稳定在O(nlogn)
 *
 */
public class HeapSort {
    public static void sort(int[] arr){
        heapify(arr);
        AlgorithmUtils.out(arr, "堆化后");
        //排序
        int n = arr.length;
        for(int i = 1; i< n; i++){
            //删除堆顶(将堆顶元素交换到数组的尾部)
            int m = n - i;
            AlgorithmUtils.swap(arr, 0, m);
            reheap(arr, 1, m);
        }
    }

    /**
     * 堆化，构建最大堆
     * 有两种堆化方式：一是以创建的方式，二是以将半堆转化为堆的方式。后者效率更高，其时间复杂度为O(n)
     * 本方法采用第二种方式
     * @param arr
     */
    private static void heapify(int[] arr){
        int n = arr.length;
        if(n == 0){
            return ;
        }
        for(int i = n/2; i >= 1; i--){
            reheap(arr, i, n);
        }
    }

    private static void reheap(int[] arr, int pos, int lastIndex){
        int k = pos;
        int j = 2 * k;
        while(j <= lastIndex){
            if(j < lastIndex && arr[j-1] < arr[j]){
                j++;
            }
            if(arr[k-1] < arr[j-1]){
                AlgorithmUtils.swap(arr, k-1, j-1);
                k = j;
                j = 2 * k;
            }else{
                break;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[]{6, 852, 3, 2, 45, 1, 17, 34, 66, 12, 13, 9, 557, 4555, 124555};
        sort(arr);
        AlgorithmUtils.out(arr, "排序后");
    }
}
