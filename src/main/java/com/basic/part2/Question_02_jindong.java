package com.basic.part2;/*
    @Author  87814   xufei
    @Date  2019/4/13    13:25
*//*
    @Author  87814   xufei
    @Date  2019/4/13    13:25
*/


import java.util.Arrays;

//给定一个字符串  然后对这个字符串进行扩充，使其包含两个原来的字符串
public class Question_02_jindong {
    public static void main(String[] args) {
        String a= "abcabcd";
        String b="abcabc";
        System.out.println(extendString(a));
        System.out.println(extendString(b));
    }

    private static String extendString(String a) {
        char[] str = (a+"*").toCharArray(); //加一层转义符
        int[] next=getNextArray(str);
        if (next[str.length-1]==0){
            return a+a;
        }else {
            return a+a.substring(next[str.length-1],a.length());
        }
    }

    private static int[] getNextArray(char[] str) {
        if (str.length==1){
            return new int[]{-1};
        }
        int[] next = new int[str.length];
        next[0]=-1;
        next[1]=0;
        int i=2;
        int cn=0;  //cn是跳跃到的位置
        while(i<str.length){
            if (str[i-1]==str[cn]){
                next[i++]=++cn;
            }else if (cn>0){
                cn=next[cn];
            }else {
                next[i++]=0;
            }
        }
        System.out.println(Arrays.toString(next));
        return next;
    }


    //序列化字符串


}
