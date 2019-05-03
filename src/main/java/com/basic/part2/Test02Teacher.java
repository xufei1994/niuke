package com.basic.part2;/*
    @Author  87814   algs4.xufei
    @Date  2019/3/19    12:48
*//*
    @Author  87814   algs4.xufei
    @Date  2019/3/19    12:48
*/


public class Test02Teacher {
    public static int[] partition(int[] arr,int L,int R,int num){
        int less = L-1;  // - 1 未知区域
        int more = R+1;  //  n
        int cur=L;
        while (cur<more){
            if (arr[cur]<num){
                swap(arr,++less,cur++);  //小于区域位置扩一个，cur位置和小于第一个交换 cur前移
            }else if (arr[cur]>num){
                swap(arr,--more,cur);
            }else {
                cur++;
            }
        }
        return new int[]{less+1,more-1}; //返回的是等于区域的下标值
    }
    public static  void swap(int[] arr,int i,int j){
        arr[i]=arr[i]^arr[j];
        arr[j]=arr[i]^arr[j];
        arr[i]=arr[i]^arr[j];
    }
}
