package com.basic.part3;/*
    @Author  87814   algs4.xufei
    @Date  2019/3/24    22:46
*//*
    @Author  87814   algs4.xufei
    @Date  2019/3/24    22:46
*/




public class Question_08_zhiPrint {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4,}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        //SPrint(arr);
        System.out.println();
        int[][] arr2= {{1,2,3},{4,5,6},{7,8,9}};
        //SPrint(arr2);
        System.out.println();
        zhiPrint(arr);
        int[][] arr3= {{1}};
       // SPrint(arr3);
    }
  // 交替打印
    private static void SPrint(int[][] arr) {
          int times = arr.length;
        for (int i = 0; i <times ; i++) {
            for (int j = 0; j <arr[0].length ; j++) {
                System.out.print("  "+arr[i][j]);
            }
            i++;
            if (i==arr.length){
                break;
            }
            System.out.println();
            for (int j =arr.length-1 ; j >=0 ; j--) {
                System.out.print("  "+arr[i][j]);
            }
            System.out.println();
        }
    }
    //之字形打印
    private static void zhiPrint(int[][] arr) {
        int times = arr.length+arr[0].length-1;
        int endR=arr.length-1;
        int endC=arr[0].length-1;
        int aR=0;
        int aC=0;
        int bC=0;
        int bR=0;
        boolean flag=false;
        while (aR !=endR+1){
            printLevel(arr,aR,aC,bR,bC,flag);
            aR = aC == endC?aR+1:aR;  //a 没有到了最后一列，它的行数才不增加，保持原来的，列数增加
            aC = aC == endC?aC:aC+1;  //a 到了最后一列，它的行数才开始增加
            bC = bR == endR?bC+1:bC;   //b 到了最后一行，它的列数才开始增加，否则不增加，行数增加
            bR = bR == endR?bR:bR+1;   // b 到了最后一列 ，行数不变，它的列数 开始增加
            flag=!flag;
        }

        }

    private static void printLevel(int[][] arr, int aR, int aC, int bR, int bC, boolean flag) {
        if (flag){
            while (aR!=bR+1){
                System.out.print(arr[aR++][aC--]+" →");
            }
        }else {
            while (bC!=aC+1){
                System.out.print(arr[bR--][bC++]+" →");
            }
        }
        System.out.println();
    }


}
