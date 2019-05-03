package com.basic.part8;/*
    @Author  87814   algs4.xufei
    @Date  2019/4/5    13:10
*//*
    @Author  87814   algs4.xufei
    @Date  2019/4/5    13:10
*/

import java.util.*;

//打印一个字符串全部的子序列 ，包括空字符串  穷尽所有的子序列要和不要全写出来 要和不要两种情况  所以有2的n次方种可能

public class Question_03 {
    public static void main(String[] args) {
        String string = "abc";
          // printAllSub(string.toCharArray(),0,"");
        char[] chars="a".toCharArray();

        System.out.println(Question_03.Permutation("aa").size());


    }

    private static void printAllSub(char[] str,int i,String result) {
        if (i==str.length){
            System.out.println(result);
            return;
        }
        //两条路 要不要之前的决策
        printAllSub(str,i+1,result+"");
        printAllSub(str,i+1,result+String.valueOf(str[i]));

    }


//start   //打印一个字符串的全排列  里面字母可以重复
    public static ArrayList<String> Permutation(String str) {
        char[] chars=str.toCharArray();
        printAllWord(chars,0);
        return list;
    }
    static ArrayList<String> list =new ArrayList<>();
    private static void printAllWord(char[] chars,int i){
        if (i==chars.length){
            if (!list.contains(String.valueOf(chars))) {
                System.out.println(String.valueOf(chars));
                list.add(String.valueOf(chars));
            }
            return ;
        }else {
            for (int j = i; j < chars.length; j++) {
                swap(chars, i, j);
                printAllWord(chars, i + 1);
                swap(chars, i, j);
            }
        }
    }
    private static void swap(char[] chars, int j, int i) {
        if (i!=j){
            char temp =chars[j];
            chars[j]=chars[i];
            chars[i]=temp;
        }
    }



}
    //abc  a ab abc bc b c
