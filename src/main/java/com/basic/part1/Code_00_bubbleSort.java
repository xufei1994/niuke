package com.basic.part1;/*
    @Author  87814   xufei
    @Date  2019/3/17    20:32
*//*
    @Author  87814   xufei
    @Date  2019/3/17    20:32
*/


import java.util.Arrays;

public class Code_00_bubbleSort {
    public static void main(String[] args) {
        int[] array=new int[]{8,9,3,2,1};
        int [] array2 = new int[]{9,8,7,6,5,4,1,2,3};
        //bubbleSort(array);

        sort2(array);
        sort2(array2);
        for (int i = 0; i <array.length ; i++) {
            System.out.print("  "+array[i]);
        }
        System.out.println();
        Arrays.stream(array2).forEach(value -> System.out.print(" "+value));
    }
    //改进  原理记录最后一位冒泡交换的下标，
    public static void sort2(int[] array){
        int m=array.length;
        while (m !=0) {//这里的边界  要设置为0
            int lastExchangeIndex = 0;
            for (int j = 0; j < array.length-1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    lastExchangeIndex = j;
                }
                    m = lastExchangeIndex;  //只要最后一位交换的下标不是0，就一直循环

            } // forj
        } //while
    }
    //冒泡排序
    public static void bubbleSort(int[] array){
        //1先判断空值
        if (array == null||array.length<2) {
            return;
        }
        for (int end = array.length-1; end>0  ; end--) { //循环次数 一共循环n-1次
            for (int i = 0; i <end ; i++) {  //每次都是从0开始
                if (array[i]>array[i+1]){
                    swap(array,i,i+1);}
            }
        }

        /*
        复杂度估计：O（N^2）
         */
    }
    //交换
    public static void swap(int[] array,int i,int j){
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }
}
