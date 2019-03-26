package com.basic.part1;/*
    @Author  87814   xufei
    @Date  2019/3/17    20:32
*//*
    @Author  87814   xufei
    @Date  2019/3/17    20:32
*/


public class Code_00_bubbleSort {
    public static void main(String[] args) {
        int [] array = new int[]{9,8,7,6,5,4,1,2,3};
        bubbleSort(array);
        for (int i = 0; i <array.length ; i++) {
            System.out.print("  "+array[i]);
        }
    }
    //冒泡排序
    public static void bubbleSort(int[] array){
        //1先判断空值
        if (array == null||array.length<2) {
            return;
        }
        for (int end = array.length-1; end>0  ; end--) { //循环次数 一共循环n次 下一次n-1次 n-2次
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
