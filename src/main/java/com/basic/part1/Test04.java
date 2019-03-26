package com.basic.part1;/*
    @Author  87814   xufei
    @Date  2019/3/18    22:39
*/

import java.util.ArrayList;
import java.util.Arrays;

//给定一个数组arr,和一个数num，请把小于等于num的数放在数组的左边，
// 大于num的数放在数组的右边  空间复杂度O1  时间复杂度ON
public class Test04 {
    public static void main(String[] args) {
        int[] arr= new int[]{7,8,9,4,5,6,1,2,3,10,11,0,1,1,5,5};
        dispatch(arr,5);
        System.out.println(Arrays.toString(arr));
    }

    private static void dispatch(int[] arr, int num) {
        //不能使用排序  排序复杂度为nlogn
        int i=0;
        int j=arr.length-1;
        while (true){
            if (i==j) {break;}
            if (i<arr.length&&j>0){
                if (arr[i]<=num){
                    i++;
                }else {
                    if (arr[j]<=num){
                        swap(arr,i,j);
                    }else {
                        j--;
                    }
                }
            }
        }
        }

    private static void swap(int[] arr, int k, int i) {
        int temp=arr[k];
        arr[k]=arr[i];
        arr[i]=temp;
    }


}
