package com.basic.part3;/*
    @Author  87814   algs4.xufei
    @Date  2019/3/24    21:37
*//*
    @Author  87814   algs4.xufei
    @Date  2019/3/24    21:37
*/

import java.sql.Array;
import java.util.Arrays;

//将一个正方形旋转90°
public class Question_06_rotate {
    public static void main(String[] args) {
        int[][] arr={{1,2,3},{4,5,6},{7,8,9}};
        rotate(arr);
        for (int i = 0; i <arr.length ; i++) {
            System.out.println(Arrays.toString(new String[]{Arrays.toString(arr[i])}));
        }

    }
    // 7 4 1 8 5 2   9 6 3
    private static void rotate(int[][] arr) {
        //向右旋转90° 变化时
        int tR = 0;
        int tC = 0;
        int dR = arr.length-1;
        int dC = arr[0].length-1;
        while (tR<dR){
            totateEdge(arr,tR++,tC++,dR--,dC--);
        }

    }

    private static void totateEdge(int[][] arr, int tR, int tC, int dR, int dC) {
        int times = dC-tC;  //就是总的组数
        int temp=0;  //少申请空间
        for (int i = 0; i <times ; i++) {
            temp =arr[tR][tC+i];
            arr[tR][tC+i] = arr[dR-i][tC];
            arr[dR-i][tC] =arr[dR][dC-i];
            arr[dR][dC-i] = arr[tR+i][dC];
            arr[tR+i][dC] = temp;
        }

    }
}
