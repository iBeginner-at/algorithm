package com.cn.zhaojz.algorithm;

import java.util.Arrays;

/**
 * 基数排序：整数排序算法，是根据键值的每位数字来排序，一般分为LSD（Least Significant Digit）和MSD(Most Significant Digit)两种方式.
 * 是一种分配方式的排序算法，线性时间复杂度
 *
 * （整数排序）基本步骤：
 * 1、计算元素绝对值的最大位数，取绝对值也是考虑到负数的情况
 * 2、从个位开始，将原数据元素放入0~19的桶（考虑到负整数，将负数放到0~9的桶中，0及正整数放入10~19的桶中）中。
 * 3、继续根据十位排序，直至最高位。
 *
 */
public class RadixSort {
    public static void sort(int[] arr){
        if(arr == null || arr.length == 0){
            return ;
        }
        //计算最大最小值
        int max = Math.abs(arr[0]);
        for(int i = 1; i< arr.length; i++){
            int abs = Math.abs(arr[i]);
            if(abs > max){
                max = abs;
            }
        }
        //取得最大位数
        int length = 0;
        for(int temp = max; temp != 0; temp /= 10){
            length++;
        }
        int mod = 10;
        int dev = 1;
        //排序
        for(int i = 0; i< length; i++, dev*=10, mod*=10){
            //创建桶, 考虑到负数，扩展一倍。
            int[][] buckets = new int[mod * 2][0];
            //分配元素
            for (int anArr : arr) {
                int index = anArr % mod / dev + mod;
                buckets[index] = scale(buckets[index], anArr);
            }
            //根据桶重排原数据
            int idx = 0;
            for (int[] bucket : buckets) {
                if (bucket.length == 0) {
                    continue;
                }
                for (int s : bucket) {
                    arr[idx++] = s;
                }
            }
        }
    }

    private static int[] scale(int[] bucket, int val) {
        bucket = Arrays.copyOf(bucket, bucket.length + 1);
        bucket[bucket.length - 1] = val;
        return bucket;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-1, -9, 1, 4, 5, 23, 35, 12, 7, 18, 14, -19, 21, -23, -1, -124, 21, -32, 32, 34, 36, -41, 6, 7, 5, 6, 56, 12, -12, 7, 8, -2, 1, 45, 32, 45};
        System.out.println("arr.length = " + arr.length);
        sort(arr);
        AlgorithmUtils.out(arr, "排序后");
    }
}
