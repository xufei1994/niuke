package com.basic.part8;/*
    @Author  87814   algs4.xufei
    @Date  2019/4/5    18:48
*//*
    @Author  87814   algs4.xufei
    @Date  2019/4/5    18:48
*/


import java.util.Arrays;

public class Question_08 {
    public static void main(String[] args) {
        int[] arr={1,2,3,4};
        System.out.println(Arrays.toString(arr));
        int target=7;
       // System.out.println(isSum(arr,100,0,0));

        System.out.println(isSumByDP(arr,7));
    }

    public static boolean isSum(int[] arr,int target,int i,int res){ //i是下标
//        if (res==target){
//            System.out.println("找到了");
//            return t;  //只要找到一次即可
//        }
        if (i==arr.length){
            System.out.println(res);
            return res==target;
        }
        return isSum(arr, target, i+1,res+arr[i])|| isSum(arr, target, i+1,res);
    }

    //动态规划版本  错误  注意是变化范围可能性，可变参数，建表是关键  所以是最小值到最大值
    public static boolean isSumByDP(int[] arr,int target){
        if (arr==null||arr.length==0){ return false; }
        int n=arr.length;// 行
        int sum=0;
        for (int i = 0; i <n ; i++) {
            if(arr[i]>=0){ sum+=arr[i]; }
        }
        if (target>sum){ return false; }
        boolean[][] dp = new boolean[n+1][sum+1];
            //cong row ---> col  0-->0   dp[0][1]  dp[0][9]  代表从0+1+2+3....9  dp[0][0]=arr0
            //dp[0][1]=arr[0]+arr[1]  dp[0][2]=dp[0][1]+arr[2];  dp[1][1]
            // dp[2][3]=arr[2]+arr[3];  dp[3][2]=0

       //最后一行只有目标位置是true 其他的是false
        for (int i =0; i <=sum ; i++) {
            if (i==target){
                dp[n][i]=true; }   //递归最后要得到的答案
                else { dp[n][i]=false; }
        }
        for (int i = n-1; i >-1 ; i--) {
            for (int j = 0; j <sum ; j++) {
                if (arr[i]+j>sum){//防止越界
                    dp[i][j]=dp[i+1][j]||false;
                }else {
                    //j代表的是上一次选择的和  res+arr[i]
                    dp[i][j] = dp[i + 1][j] || dp[i + 1][arr[i] + j];  //递归实体
                }
            }
        }
        return dp[0][0];
    }



}
