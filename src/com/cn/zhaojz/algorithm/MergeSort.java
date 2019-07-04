package com.cn.zhaojz.algorithm;

/**
 * 归并排序：顾名思义就是先递归后合并，即先递归的分解数列，再合并数列。归并排序也是采用分治法的典型应用。
 * 基本思想：将数列分成两个数列,如果两个数列分别都是有序的，那么就可以方便将这两个数组进行排序了；
 * 如何将这两个数组有序呢，我们可以将两个数列各自再进行分解，直到每组只有1个元素时，就可以视其为有序的了。
 */
public class MergeSort {

    public static void sort(int arr[], int first, int last, int[] tmp){
        if(first < last){
            int middle = (first + last)/2;
            //分解数列的左半部分
            sort(arr, first, middle, tmp);
            //分解数列的右半部分
            sort(arr, middle+1, last, tmp);
            //合并两个有序数列
            mergeArray(arr, first, middle, last, tmp);
        }
    }

    private static void mergeArray(int[] arr, int first, int middle, int last, int[] tmp) {
        int i = first, m = middle;
        int j = middle + 1, n = last;
        int k = 0;
        while(i<=m && j<=n){
            if(arr[i] <= arr[j]){
                tmp[k] = arr[i];
                k++;
                i++;
            }else{
                tmp[k] = arr[j];
                k++;
                j++;
            }
        }
        while(i<=m){
            tmp[k] = arr[i];
            k++;
            i++;
        }
        while(j<=n){
            tmp[k] = arr[j];
            k++;
            j++;
        }
        for(int s = 0; s < k; s++){
            arr[first+s] = tmp[s];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{6, 852, 3, 2, 45, 1, 17, 34, 66, 12, 13, 9, 557, 4555, 124555};
        int[] tmp = new int[arr.length];
        sort(arr, 0, arr.length - 1, tmp);
        AlgorithmUtils.out(arr, "排序后");
    }
}
