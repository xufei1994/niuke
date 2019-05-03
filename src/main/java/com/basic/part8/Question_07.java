package com.basic.part8;/*
    @Author  87814   algs4.xufei
    @Date  2019/4/5    16:08
*//*
    @Author  87814   algs4.xufei
    @Date  2019/4/5    16:08
*/

/*
给你一个二维数组，二维数组的每个数都是正数，要求从左上角走到右下角，
每一步只能向右或者向下，沿途经过的数字要累加起来，返回最小路径和
先写出递归版本尝试版本
 */
public class Question_07 {
    public static void main(String[] args) {
        int[][]arr=new int[4][4];
        int k=0;
        for (int i = 0; i <4 ; i++) {
            for (int j = 0; j <4 ; j++) {
                arr[i][j]=k++;
            }
        }
        for (int i = 0; i <4 ; i++) {
            for (int j = 0; j <4 ; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        minPathError(arr);
        System.out.println(minPathRightByDigui(arr, 3, 3));
        System.out.println("walk");
        System.out.println(walk(arr,0,0));

    }

    //错误方法
    private static void minPathError(int[][] arr) {
        int i=0,j=0;
        int m=arr.length; //arr[m][n]
        int n=arr[0].length;
        while (i!=m-1||j!=n-1){
            System.out.println(arr[i][j]+"  arr"+i+""+j);
            if (i==m-1){
                j++;
                continue;
            }
            if (j==n-1){
                i++;
                continue;
            }
            if (arr[i+1][j]>arr[i][j+1]){
                j++;
            }else {
                i++;
            }
        }
        System.out.println(arr[i][j]+"  arr"+i+""+j);
    }

    /*
    //有重复步骤才能改动态规划,有重复状态并且重复状态对最后结果没有影响，才能暴力改递归
    //可变参数的变化范围就是 i和 j的 变换范围   设计一个二维表可以把所有的返回值都装下

    1.把需要的位置标记出来
    2.回到basecase中找到停止条件 不需要填的那个位置设置好
    3.分析一个普遍位置是如何依赖的
     */
    private static  int minPathRightByDP(int[][] arr){
        if (arr==null||arr.length==0||arr[0]==null||arr[0].length==0){
            return 0;
        }

        int row=arr.length;// 行
        int col = arr[0].length; //列
        int[][] dp = new int[row][col];
        dp[0][0]=arr[0][0];
        for (int i = 1; i <row ; i++) {
            dp[i][0]=arr[i][0]+dp[i-1][0];
        }
        for (int j = 0; j <col ; j++) {
            dp[0][j] = arr[0][j]+dp[0][j-1];
        }
        for (int i = 1; i <row ; i++) {
            for (int j = 1; j <col ; j++) {
                dp[i][j]=arr[i][j]+Math.min(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[row-1][col-1];
    }

    // 从（i,j）出发，到达左上角的位置，最短路径和是多少？
    private static  int minPathRightByDigui(int[][] arr,int i,int j){
     int res =arr[i][j];
     if (i==0&&j==0){
         return res;
     }
     if (i==0&&j!=0){
         return res+minPathRightByDigui(arr, i, j-1);
     }
     if (i!=0&&j==0){
         return res+minPathRightByDigui(arr,i-1,j);
     }
     return res+Math.min(minPathRightByDigui(arr,i,j-1),minPathRightByDigui(arr,i-1,j));
    }

    private static int walk(int[][] arr,int i,int j){
        int res =arr[i][j];
    if (i==arr.length-1&&j==arr[0].length-1) {
        return res;
    }
    if (i==arr.length-1){
        return res+walk(arr, i, j+1);
    }
    if (j==arr[0 ].length-1){
        return res+walk(arr, i+1, j);
    }
    int right =  walk(arr, i, j+1);//right-->右边位置到右下角的最短路径和
    int down = walk(arr, i+1, j);  //down--->下边位置到右下角的最短路径和
    return res+Math.min(right,down);
    }

}
