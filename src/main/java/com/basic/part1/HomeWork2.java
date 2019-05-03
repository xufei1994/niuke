package com.basic.part1;/*
    @Author  87814   algs4.xufei
    @Date  2019/3/18    10:04
*//*
    @Author  87814   algs4.xufei
    @Date  2019/3/18    10:04
*/
//末尾0的个数
//输入一个正整数n,求n!(即阶乘)末尾有多少个0？ 比如: n = 10; n! = 3628800,所以答案为2

import java.util.Scanner;

public class HomeWork2 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        System.out.print("请输入一个数 n  ");
        int n=Integer.parseInt(scanner.nextLine());
        System.out.println(ans(n));
    }
    public static int ans(int n){
        int ans= 0;
        //只记录10和5即可  偶数的数量2 4 6 8 足够
        for (int i = n; i >0 ; i--) {
            int temp=i;
            //125
            while (temp%5==0) {
                ans++;
               temp=temp/5;
            }
        }
        return ans;

    }
}
