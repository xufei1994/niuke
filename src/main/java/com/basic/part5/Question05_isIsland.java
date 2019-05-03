package com.basic.part5;/*
    @Author  87814   algs4.xufei
    @Date  2019/4/4    13:10
*//*
    @Author  87814   algs4.xufei
    @Date  2019/4/4    13:10
*/

import java.util.HashMap;
import java.util.Scanner;



//岛问题
public class Question05_isIsland {
       static String arr[][];
    public static void main(String[] args) throws InterruptedException {
        System.out.println("输入的占地的规模");
        Scanner scanner = new Scanner(System.in);
        System.out.println("n=====");
        int n=scanner.nextInt();
        scanner.nextLine();
        System.out.println("m=====");
        int m = scanner.nextInt();
        scanner.nextLine();

        int[][] arrar = new int[n][m];
        arr = new String[n+2][m+2];
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <m ; j++) {
                arr[i][j]="00";
            }
        }
        //请给样本赋值
        arrar[0][2]=1;
        arrar[0][4]=1;
        arrar[1][0]=1;
        arrar[1][1]=1;
        arrar[1][2]=1;
        arrar[1][4]=1;
        arrar[2][0]=1;
        arrar[2][3]=1;
        System.out.println(n+""+m);
        System.out.println(island(arrar));
    }

    private static int island(int[][] arrar) {
        int n=arrar.length;
        int m=arrar[0].length;
        int size = 0;
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <m ; j++) {
                if (arrar[i][j]==1){
                    size++;
                    infect1(arrar,i,j,n,m);   //先让他自成体系
                }
            }
        }
        return size;
    }

    private static void infect1(int[][] arrar, int i, int j, int n, int m) {
        if (i<0||i>=n||j<0||j>=m||arrar[i][j]!=1){
            return;
        }
        arrar[i][j]=2;
        infect1(arrar,i+1,j,n,m);
        infect1(arrar,i-1,j,n,m);
        infect1(arrar,i,j+1,n,m);
        infect1(arrar,i,j-1,n,m);
    }

    //查找父亲的方法
    private static String findBoss(String x) {
        String r=x;  //找boss的事情交给r去做

        while (r!=arr[r.charAt(0)][r.charAt(1)]){
            r=arr[r.charAt(0)][r.charAt(1)];
        }
        //找到boss
        //压缩路径
        String i=x,j;
        while (!i.equals(r)){
            j=arr[i.charAt(0)][i.charAt(1)];
            arr[i.charAt(0)][i.charAt(1)]=r;
            i=j;
        }
        return r;//找到boss
    }

    private static void union(String x,String y){
        String xBoss = findBoss(x);
        String yBoss = findBoss(y);
        if (xBoss!=yBoss){
            arr[xBoss.charAt(0)][xBoss.charAt(1)]=yBoss;
        }
    }

    //多任务的思想  特别大的矩阵   多核一起跑

 }
