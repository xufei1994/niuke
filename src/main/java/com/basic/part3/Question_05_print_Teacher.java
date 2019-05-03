package com.basic.part3;/*
    @Author  87814   algs4.xufei
    @Date  2019/3/24    20:04
*//*
    @Author  87814   algs4.xufei
    @Date  2019/3/24    20:04
*/

//转圈打印矩阵


public class Question_05_print_Teacher {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4,}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        print(arr);
        System.out.println();
        int[][] arr2= {{1,2,3},{4,5,6},{7,8,9}};
        print(arr2);
        int[][] arr3= {{1}};
        print(arr3);
    }

    //不会？
    private static void print(int[][] arr) {
        int tR=0; //行
        int tC=0;  //列
        int dR=arr.length-1;
        int dC=arr[0].length-1;
        while (tR<=dR&&tC<=dC){
            printEdge(arr,tR++,tC++,dR--,dC--);//代表 对角线
            System.out.println();
        }
    }

    private static void printEdge(int[][] arr, int tR, int tC, int dR, int dC) {
        if (tR == dR){ //子矩阵只有一行时
            for (int i = tC; i <=dC ; i++) {
                System.out.print(arr[tR][i]+"  ");
            }
        }else if (tC==dC){  //子矩阵只有一列时
            for (int i = tR; i <=dR ; i++) {
                System.out.print(arr[i][tC]+"  ");
            }
        }else {//一般情况
            int curC =tC;
            int curR = tR;
            while (curC!=dC){
                System.out.print(arr[tR][curC]+"  ");
                curC++;
            }
            while (curR!=dR){
                System.out.print(arr[curR][dC]+"  ");
                curR++;
            }
            while (curC!=tC){
                System.out.print(arr[dR][curC]+"  ");
                curC--;
            }
            while (curR!=tR){
                System.out.print(arr[curR][tC]+"  ");
                curR--;
            }

        }
    }


}
