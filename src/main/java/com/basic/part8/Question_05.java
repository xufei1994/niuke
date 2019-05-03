package com.basic.part8;/*
    @Author  87814   algs4.xufei
    @Date  2019/4/5    15:36
*//*
    @Author  87814   algs4.xufei
    @Date  2019/4/5    15:36
*/

//  母牛每年生一只母牛，新出生的母牛成长三年后也能每年生一只牛，假设不会死求N年后，母牛的数量
public class Question_05 {
    public static void main(String[] args) {
        int n=10;
        System.out.println(cowNumber(5));
    }

    private static int cowNumber(int n) {
        if (n<=3){
            return n;
        }{
            return cowNumber(n-1)+cowNumber(n-3);
        }

    }
}
