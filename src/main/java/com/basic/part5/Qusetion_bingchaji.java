package com.basic.part5;/*
    @Author  87814   algs4.xufei
    @Date  2019/4/4    12:57
*//*
    @Author  87814   algs4.xufei
    @Date  2019/4/4    12:57
*/


public class Qusetion_bingchaji {
    int[] pre =new int[1000];
    private int find(int x){//查找根节点
        int r = x;  //让r去帮他找
        while (r!=pre[r]){
            r=pre[r];  //将他的上级赋值给r
        }//r==pre[r] 时找到掌门人自成一体

        //进行路径压缩
        int i=x,j;
        while (i!=r){
            j= pre[i];   //先保留上级
            pre[i]=r;    //告诉他老大是谁
            i=j;         //上级也开始压缩
        }
        return  r;  //返回老大
    }
    private void join(int x,int y){
        int xBoss=find(x);
        int yBoss=find(y);
        if (xBoss!=yBoss){  //如果是一派就不用处理
            pre[xBoss]=yBoss;   //将两派合为一派
        }
    }
}
