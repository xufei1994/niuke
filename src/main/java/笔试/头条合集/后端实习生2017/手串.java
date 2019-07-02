package 笔试.头条合集.后端实习生2017;/*
    @Author  87814   xufei
    @Date  2019/7/2    12:29
*//*
    @Author  87814   xufei
    @Date  2019/7/2    12:29
*/


import java.util.HashMap;

import java.util.LinkedList;

import java.util.Map;

import java.util.Scanner;


public class 手串 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();/* n个手串*/
        int m = scanner.nextInt();/* 间隔为m*/
        int c = scanner.nextInt();/* 有c种颜色*/
        Map<Integer, LinkedList<Integer>> map = new HashMap<Integer, LinkedList<Integer>>();
        for (int i = 1; i <= c; i++)
            map.put(i, new LinkedList<Integer>());
        int total = 1;
        while (total <= n) {
            int num = scanner.nextInt();/* 表示有多少顔色*/
            for (int i = 0; i < num; i++) {
                int color = scanner.nextInt();
                LinkedList<Integer> linkedList = map.get(color);/* 得到某種顔色的位置*/
                linkedList.add(total);/* 再加上此位置*/
                map.put(color, linkedList);
            }
            total++;
        }
        int error = 0;
        for (int i = 1; i <= c; i++) {
            LinkedList<Integer> linkedList = map.get(i);/* 得到某種顔色的位置*/
            int[] array = new int[linkedList.size()];
            int k = 0;
            for (int j : linkedList)
                array[k++] = j;
            for (int j = 0; j < array.length; j++)
                if (j + 1 < array.length && array[j + 1] - array[j] < m) {
                    error++;
                    break;
                } else if (j + 1 == array.length && array[0] + n - array[j] < m) {
                    error++;
                    break;
                }
        }
        System.out.println(error);
    }
}