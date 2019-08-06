package 笔试.头条合集.后端实习生2017;/*
    @Author  87814   xufei
    @Date  2019/7/2    16:51
*//*
    @Author  87814   xufei
    @Date  2019/7/2    16:51
*/


import java.util.*;
public class 传送门 {
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int[] p=new int[n+1];
        for(int i=1;i<n+1;i++)
        {
            p[i]=s.nextInt();
        }
        long[] dp=new long[n+2];
        dp[1]=0;
        long mod=1000000007;
        for(int i=2;i<n+2;i++)
        {
            dp[i]=dp[i-1]+1+dp[i-1]-dp[p[i-1]]+1;
            dp[i]=dp[i]<0?(dp[i]+mod)%mod:dp[i]%mod;
        }
        System.out.println(dp[n+1]);//防止long溢出
    }



}
