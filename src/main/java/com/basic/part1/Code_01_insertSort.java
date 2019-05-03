package com.basic.part1;/*
    @Author  87814   algs4.xufei
    @Date  2019/3/17    21:12
*//*
    @Author  87814   algs4.xufei
    @Date  2019/3/17    21:12
*/


public class Code_01_insertSort {
    //插入排序 扑克牌  每次插入合适的位置
    public static void insertSort(int[] array){
        for (int i = 1; i <array.length ; i++) {  //从一号位开始，和0号位比较
//            int j=i-1;
//            while (array[j+1]<array[j]){
//                swap(array,j+1,j);
//                j--;
//                if (j<0) break;
//            }

            for (int k = i-1; k>=0&&array[k]>array[k+1]  ; k--) {
                swap(array,k+1,k);
            }

        }


    }
    //交换
    public static void swap(int[] array,int i,int j){
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }
    //交换
    public static void swap2(int array[],int i,int j){
        array[i]=array[i]^array[j];
        array[j]=array[i]^array[j];
        array[i]=array[i]^array[j];
    }
    public static void main(String[] args) {
        int [] array = new int[]{9,8,7,6,5,4,1,2,3};
        insertSort(array);
        for (int i = 0; i <array.length ; i++) {
            System.out.print("  "+array[i]);
        }
    }
}
