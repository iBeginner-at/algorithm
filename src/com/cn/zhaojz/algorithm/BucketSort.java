package com.cn.zhaojz.algorithm;

import java.util.Arrays;

/**
 * 桶排序：计数排序的升级版，根据一定的函数关系，将待排序元素放入一定数量的桶当中，然后再运用比较排序算法对每一个桶中的元素排序。
 * 最后将桶中元素依次串连而得到一个有序的结果。
 *
 * 适用场景：数据分布相对均匀或者数据范围跨度不大。
 * 如果数据跨度过大，则空间可能无法承受。
 * 基本实现步骤：
 * 1、确认映射函数，及桶的数量。
 * 2、遍历原数据，根据映射关系将元素放入指定的Bucket中。
 * 3、选择一种比较算法对每一个桶中元素进行排序。(肯定还有其它很多的选择)
 *
 * 必须根据根据待排序数据的特征，事先确认映射函数与桶数。
 *
 * 稳定的排序算法
 */
public class BucketSort {
    /**
     * 桶排序
     * @param arr   待排序数组
     * @param bucketSize    将使用的桶容量
     */
    public static void sort(int[] arr, int bucketSize){
        if(arr == null || arr.length == 0 || bucketSize == 0){
            return ;
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
            return ;
        }
        //计算桶的数量
        int bucketCount = (int)Math.floor((max - min) / bucketSize) + 1;
        int[][] buckets = new int[bucketCount][0];
        //利用映射将数据分配到各个桶中
        for (int anArr : arr) {
            int index = (anArr - min) / bucketCount;
            //扩容与赋值
            buckets[index] = scale(buckets[index], anArr);
        }
        //对每一个桶进行排序
        int index = 0;
        for (int[] bucket : buckets) {
            if (bucket.length == 0) {
                continue;
            }
            //使用插入排序
            InsertionSort.sort(bucket);
            for (int aBucket : bucket) {
                arr[index++] = aBucket;
            }
        }
    }

    /**
     * 扩容与赋值
     * @param bucket 桶
     * @param val 元素
     * @return  返回扩容后的数组
     */
    private static int[] scale(int[] bucket, int val) {
        bucket = Arrays.copyOf(bucket, bucket.length + 1);
        bucket[bucket.length - 1] = val;
        return bucket;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-1, -9, 1, 4, 5, 23, 35, 12, 7, 18, 14, 19, 21, 23, 1, 24, 21, 32, 32, 34, 36, 41, 6, 7, 5, 6, 56, 12, 12, 7, 8, 2, 1, 45, 32, 45};
        System.out.println("arr.length = " + arr.length);
        sort(arr, 5);
        AlgorithmUtils.out(arr, "排序后");
    }
}
