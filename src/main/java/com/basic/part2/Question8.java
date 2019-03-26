package com.basic.part2;/*
    @Author  87814   xufei
    @Date  2019/3/20    23:01
*//*
    @Author  87814   xufei
    @Date  2019/3/20    23:01
*/

//给定一个数组，求如果排序之后，相邻两数的最大差值，要求时间复杂度O（N） ，且要求用基于比较的排序
public class Question8 {
    public static void main(String[] args) {
       int[] arr = new int[]{78,8,5,12,56,1,45,14,52,5,1,47,5,1,74,5,81,47,1,85};
        //int[] arr = new int[]{9,8,7,4,5,6,12,3,1,5};
        //int[] arr = new int[]{9,9,9,9,9,9,9,9,9,9};


        System.out.println(sortCom(arr));
        System.out.println(Question8_new.maxGap(arr));
    }

    private static int sortCom(int[] arr) {
        int maxInex=arr[0];
        int max=0;
        int min =arr[0];
        int minIndex=0;
        for (int i = 0; i <arr.length ; i++) {
            if (arr[i]>max){
                maxInex=i;
                max=arr[i];

            }
            if (arr[i]<=min){
                min = arr[i];
                minIndex =i ;
            }
        }
        int[] tong = new int[max+1];  //用下标代表这个数
        int j=0;
        for (int i = 0; i <arr.length ; i++) {
            tong[arr[i]]++;
        }
        //开始寻找连续0最多的数
        int length=0;
        int lengthMax=0;
         //首先要找到最小值
        for (int i = min; i <tong.length ; i++) {
            if (tong[i]==0){
                length++;
                continue;
            }
            if (length>lengthMax){
                lengthMax=length;
            }
            length=0;
            continue;
        }


        if (min==max){
            return 0;
        }
    return  lengthMax+1;
    }
}
