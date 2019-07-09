package com.cn.zhaojz.algorithm;

/**
 * 计数排序：一种线性时间复杂度的排序，要求输入的数列中的值在确定的整数范围内（或者说在预期的整数范围内），范围最好在100以内。
 * 不适用对数据范围很大的数组排序。
 * 排序思想：通过辅助空间计算原数列中的元素的最终排序位置，达到直接将元素放到最终位置的目的，整个过程不需要比较元素。
 * 该算法的核心逻辑就是计算元素在最终有序排列中的位置。
 *
 * 计数排序是一种稳定的排序算法。
 *
 * 排序过程：
 * 1、计算原数组A中的最小值min和最大值max，创建 max-min+1大小的辅助数组H（用于计数）
 * 2、遍历原数列A，对相等的元素进行计数。
 * 3、遍历辅助数组H，使每一个位置的计数值是前面所有位置（含自己）上值的累加值,以得到元素的最终排列位置。
 * 4、创建一个与原数据相同大小的新数据B；然后对原数组A进行遍历（从后向前），将元素按H中的位置填入B的指定位置。
 */
public class CountingSort {
    public static int[] sort(int[] arr){
        if(arr == null || arr.length == 0){
            return arr;
        }
        //计算最大最小值
        int min = arr[0], max = arr[0];
        for(int i = 1; i< arr.length; i++){
            if(arr[i] < min){
                min = arr[i];
            }else if(arr[i] > max){
                max = arr[i];
            }
        }
        if(min == max){
            return arr;
        }
        System.out.println("min: " + min + ", max: " + max);
        //创建计数数组
        int[] countArr = new int[max - min + 1];
        //遍历原数组，并对相等的元素计数
        for (int anArr : arr) {
            countArr[anArr - min]++;
        }
        AlgorithmUtils.out(countArr, "计数后");
        //计算最终排列位置，遍历计数数组
        for(int i = 1; i< countArr.length; i++){
            countArr[i] += countArr[i - 1];
        }
        AlgorithmUtils.out(countArr, "累加后");
        //创建与原数据相同大小的数据
        int[] newArr = new int[arr.length];
        //遍历原数据
        for(int i = arr.length; i > 0; i--){
            newArr[countArr[arr[i-1] - min] - 1] = arr[i-1];
            countArr[arr[i-1] - min]--;
        }
        AlgorithmUtils.out(newArr, "排序后");
        return newArr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,4, 5, 6, 7, 5, 6, 7, 8, 2, 1, 45, 32, 45};
        sort(arr);
    }
}
