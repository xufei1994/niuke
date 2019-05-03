package com.basic.part8;

/*
1.....2 .....3...   ....N     给定一个位置m ，走p步到k的方法有多少种
N 一共有1~N个位置
M 初始停留的位置，来到的位置
p  可以走的步数
k  最终停留的位置
返回值一共有多少种步法
 */
public class 阿里笔试题_走P步 {
    public static int ways(int N,int M,int P,int K){
        if (N<2||M<1||M>N||P<0||K<1||K>N){
            return 0;
        }
        if (P==0){
            return M==K?1:0;
        }
        int res = 0;
        if (M==1){
            res =ways(N,M+1,P-1,K); //只能走左
        }else if(M==N){
            res =ways(N,M-1,P-1,K); // 只能走右
        }else {
            res =ways(N,M+1,P-1,K)+ways(N,M-1,P-1,K); //左右都能走
        }
        return res;
    }
    //画图  可变参数 两个 M（位置） 和 P（剩余的步数）

    public static int waysByDP(int n,int m,int p,int k){
        int[][] dp =new int[p+1][n+1];
        dp[0][k] = 1;
        for (int i = 1; i <p+1 ; i++) {
            for (int j = 0; j <n+1 ; j++) {
               if (j==0){
                   dp[i][j] = dp[i-1][j+1];
               }else if (j==n){
                   dp[i][j] =dp[i-1][j-1];
               }else {
                   dp[i][j]=dp[i-1][j-1]+dp[i-1][j+1];
               }
            }
        }

        return dp[p][k];
    }

    public static void main(String[] args) {
        System.out.println("递归" + ways(4,2,2,2));
        System.out.println("DP" + waysByDP(4,2,2,2));
    }
}
