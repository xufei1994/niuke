package com.basic.part8;/*
    @Author  87814   algs4.xufei
    @Date  2019/4/5    11:29
*//*
    @Author  87814   algs4.xufei
    @Date  2019/4/5    11:29
*/

//求 n的 阶乘
public class Question_01 {
    public static void main(String[] args) {
        int n=10;
        System.out.println(factorial(10));
    }

    //暴力递归
    private static int factorial(int n) {
        if (n==1){return 1;}
        return n*factorial(n-1);
    }
    //动态规划   这其实就可以理解为一个动态规划问题
    private static int factorial2(int n){
        int result=1;
        for (int i = 1; i <+n ; i++) {
            result*=i;
        }
        return result;
    }

}
