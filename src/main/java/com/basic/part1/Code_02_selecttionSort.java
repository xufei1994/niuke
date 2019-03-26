package com.basic.part1;/*
    @Author  87814   xufei
    @Date  2019/3/17    20:46
*//*
    @Author  87814   xufei
    @Date  2019/3/17    20:46
*/


public class Code_02_selecttionSort {
    //选择排序
    public static void selectionSort(int[] array){
        if (array==null||array.length<2) {return;}
        //每次来一个数都和当前位置比较，插入到合适的位置

        //从哪开始到哪结束就是最大的for循环做的事情
        for (int i = 0; i <array.length ; i++) {
            int minIndex = i;
            //从i位置到最后一个位置，开始找到最小的数它的下标是什么
            for (int j = i+1; j <array.length ; j++) {
                minIndex = array[j]<array[minIndex]?j:minIndex;
            }
            swap(array,i,minIndex);
        }
    }

    //交换
    public static void swap(int[] array,int i,int j){
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }
    public static void main(String[] args) {
        int [] array = new int[]{9,8,7,6,5,4,1,2,3};
        selectionSort(array);
        for (int i = 0; i <array.length ; i++) {
            System.out.print("  "+array[i]);
        }
    }
}
