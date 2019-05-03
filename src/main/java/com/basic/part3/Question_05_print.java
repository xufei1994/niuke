package com.basic.part3;/*
    @Author  87814   algs4.xufei
    @Date  2019/3/24    20:04
*//*
    @Author  87814   algs4.xufei
    @Date  2019/3/24    20:04
*/

//转圈打印矩阵


public class Question_05_print {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4,}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        print(arr);
        System.out.println();
        int[][] arr2= {{1,2,3},{4,5,6},{7,8,9}};
        print(arr2);
        int[][] arr3= {{1}};
        print(arr3);
    }

    //不会？  将矩阵分成两个小举证
    private static void print(int[][] arr) {
        int maxEdge = (int) Math.floor(Math.min(arr.length, arr[0].length)/ 2)+1;
        for (int k = 0; k < maxEdge; k++) {//第几圈 0,1
            int i;
            for ( i = k; i < arr[0].length - k; i++) {
                System.out.print("   → " + arr[k][i]);
            }
            i--;  //i=4 溢出
            int j=k+1; //越过重复项
            for (; j<arr.length-k ; j++) {
                System.out.print("   → " + arr[j][i]);
            }
            j--;// j=4 溢出
            i--;  //越过重复项
            for ( ; i >=k ; i--) {
                System.out.print("   → " + arr[j][i]);
            }
            i++;  //i=-1
            j--; //越过重复项
            for (; j >k ; j--) {
                System.out.print("   → " + arr[j][i]);
            }
            System.out.println();
        }

    }


}
