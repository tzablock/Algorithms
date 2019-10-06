package com.algorithms.DivideAndConquerSortingAndSearchingAndRandomizedAlgorithms.sort;

import java.util.Arrays;

public class MergeSort {
    public int[] sort(int[] arr){
        if (arr.length<=1){
            return arr;
        }
        return recursiveSort(arr);
    }

    private int[] recursiveSort(int[] arr){
        if (arr.length == 1){
            return arr;
        } else if(arr.length == 2){
            return arr[0] <= arr[1] ? arr : new int[]{arr[1], arr[0]};
        } else {
            int half = arr.length / 2;
            return merge(
                    recursiveSort(Arrays.copyOfRange(arr,0, half)),
                    recursiveSort(Arrays.copyOfRange(arr, half, arr.length))
            );
        }
    }


    // I take smaller element from two sorted arrays and add as next to result array till end of elements
    private int[] merge(int[] arr1, int[] arr2){
        int i = 0;
        int j = 0;
        int[] resArr = new int[arr1.length + arr2.length];
        for (int k = 0; k<resArr.length; k++){
            if (arr1.length == i || (arr2.length != j && arr2[j] < arr1[i])){
                resArr[k] = arr2[j];
                j++;
            } else if (arr2.length == j || (arr1.length != i && arr1[i] < arr2[j])) {
                resArr[k] = arr1[i];
                i++;
            } else {
                resArr[k] = arr1[i];
                resArr[++k] = arr2[j];
                i++;
                j++;
            }
        }
        return resArr;
    }
}
