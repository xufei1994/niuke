package com.basic.part8;/*
    @Author  87814   algs4.xufei
    @Date  2019/4/5    11:36
*//*
    @Author  87814   algs4.xufei
    @Date  2019/4/5    11:36
*/

//汉诺塔问题
public class Question_02 {
    public static void main(String[] args) {
        int n=3;
        char  a,b,c;
        a='a';
        b='b';
        c='c';
        hanni(n,a,b,c);
    }

    private static void hanni(int n, char a, char b, char c) { //a 原来  b 辅助 c目标
        if (n>0) {
            hanni(n - 1, a, c, b);
            //  a->b   借助c    就是 分解为第一步 我把a上的n-1个盘子从a移动到b
            // 然后我把第n个从a移动到c
            //第三步  我再把剩下的n-1个盘子 从b->c  借助a
            move(n,a, c);
            hanni(n - 1, b, a, c);

        }
    }

    private static void move(int n,char a, char c) {
        System.out.println("将"+n+"盘从"+a+"移动到"+c);
    }
}
