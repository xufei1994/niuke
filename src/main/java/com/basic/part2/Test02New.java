package com.basic.part2;/*
    @Author  87814   xufei
    @Date  2019/3/19    10:31
*//*
    @Author  87814   xufei
    @Date  2019/3/19    10:31
*/

import java.util.Arrays;

public class Test02New {
    public static void main(String[] args) {
        int[] arr={9,8,7,4,5,1,2,3,1,12,5,4,1,5,21,1,5,5,6,7,7,8,9,5,5,5,5,5,5,5,5,4,5,4,5,9,6,5,61,4};
        int num=5;
        dispatch(arr,num);
        System.out.println(Arrays.toString(arr));
    }

    private static void dispatch(int[] arr, int num) {
        int numRight=0;
        //计数操作  右边几个元素
        for (int k = 0; k <arr.length ; k++) {
            if (arr[k]>num){ numRight++; }
        }
        core(arr,0,arr.length-1,num);
        core(arr,0,arr.length-1-numRight,(num-1));
    }
    public static void core(int[] arr,int i,int j,int num){
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
    public static  void swap(int[] arr,int i,int j){
        arr[i]=arr[i]^arr[j];
        arr[j]=arr[i]^arr[j];
        arr[i]=arr[i]^arr[j];
    }

}
