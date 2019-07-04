package com.cn.zhaojz.algorithm;

/**
 * 快速排序
 * 基本思想：从数列中选择一个基准数，然后将比这个数大的数全部放到它的右边，将小于等于它的数全部放到它的左边，
 * 再将左右区别重复上面的步骤，直到各区间只剩1个数。
 *
 * 快速排序基于分治的思想，基准数选择方法会对算法的时间复杂度产生影响。
 * 其衍生版本的优化点集中于如何选取更优的基准数。
 */
public class QuickSort {

    public static void sort(int[] arr, int left, int right){
        if(left >= right){
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
