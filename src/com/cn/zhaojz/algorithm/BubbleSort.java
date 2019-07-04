package com.cn.zhaojz.algorithm;

/**
 * 冒泡排序
 * 从右向左，两两比较相邻元素，将值较小的元素上浮，最终最小元素被交换到集合的起始位置。
 * 重复以上过程。
 *
 */
public class BubbleSort {
    /**
     * 简单实现
     * @param arr
     */
    public static void sort(int[] arr){
        int length = arr.length;
        for(int k = 0; k < length; k++){
            for(int i = length - 1; i > k; i--){
                if(arr[i] < arr[i-1]){
                    AlgorithmUtils.swap(arr, i, i-1);
                }
            }
        }
    }

    /**
     * 优化针对问题：数据排好序后，冒泡排序仍然会继续执行，而后面的排序是没有意义的。
     * @param arr
     */
    public static void sort2(int[] arr){
        int length = arr.length;
        boolean swapFlag;
        for(int k = 0; k < length ; k++){
            swapFlag = false;
            for(int i = length - 1; i > k; i--){
                if(arr[i] < arr[i-1]){
                    AlgorithmUtils.swap(arr, i, i-1);
                    swapFlag = true;
                }
            }
            if(!swapFlag){
                System.out.println("当前K值：" + k);
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{6, 852, 3, 2, 45, 1, 17, 34, 66, 12, 13, 9, 557, 4555, 124555};
        //sort(arr);
        sort2(arr);
        AlgorithmUtils.out(arr, "排序后");
    }
}
