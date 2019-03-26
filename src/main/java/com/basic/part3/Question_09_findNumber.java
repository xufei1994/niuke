package com.basic.part3;/*
    @Author  87814   xufei
    @Date  2019/3/25    12:14
*//*
    @Author  87814   xufei
    @Date  2019/3/25    12:14
*/

//在行，列都排好的矩阵中找数
// 0 1 2 5
// 2 3 4 7
// 4 4 4 8
// 5 7 7 9
//中找一个数，假设为6，则为false  时间复杂度为O(N+M)  空间复杂度为O（1）
public class Question_09_findNumber {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4,}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int num=16;
        System.out.println(findNumber2(arr,num)) ;
    }
//最优解来自于数据状况 或者是最优解
    private static boolean findNumber2(int[][] arr,int num) {
        //从左下角或者 右上角开始走，假如从右上角开始走
        int j = arr[0].length-1;
        int i= 0;
        boolean flag=false;
        while (true) {
            if (arr[i][j]<num){
                i++;
            }
           else if (arr[i][j]==num){
                flag=true;
                break;
            }else {
                j--;
            }
            if (j<0||i==arr.length){
                break;
            }
        }
        return flag;
    }

    //该方法只能找m=n
    private static void findNumber(int[][] arr,int num) {
        int i;
        int N=arr.length;
        int M=arr[0].length;
        //找到第一个大于它的对角线
        for ( i = 0; i <N&&i<M ; i++) {
            if (arr[i][i]==num){
                System.out.println(arr[i][i]+" "+i+" "+i);
                 return; }
           if (arr[i][i]>num){break; }
        }
        //向左
        for (int j = i; j >=0 ; j--) {
            if (arr[i][j]==num){
                System.out.println(arr[i][j]+" "+i+" "+j);
                break;
            }
        }
        //向上
        for (int j = i; j >=0 ; j--) {
            if (arr[j][i]==num){
                System.out.println(arr[j][i]+" "+j+" "+i);
                break;
            }
        }
    }


}
