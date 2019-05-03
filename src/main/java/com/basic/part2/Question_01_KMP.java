package com.basic.part2;/*
    @Author  87814   xufei
    @Date  2019/4/12    20:39
*//*
    @Author  87814   xufei
    @Date  2019/4/12    20:39
*/

import algs4.xufei.XIaoXBat.List;

import java.util.Arrays;

//KMP解决的是一个包含问题，str1中是否有和str2子串一样的
//  明确定义是子序列 是不连续的   子数组子串： 一定是连续的
public class Question_01_KMP {

    public static void main(String[] args) {
      String str1 = new String("abcdaaaaaaaaaabsabcdadaabasdbasbaaaaaasadda  cdadabcdaabcdadabcda");
      String str2 = new String("abcdadabcda");
        System.out.println(kmpBaoli(str1, str2));
        System.out.println(kmp(str1, str2));



    }

    //暴力方法  复杂度最坏O（M*N）
    private static boolean kmpBaoli(String str1, String str2) {
        int n = str1.length();
        int k= str2.length();
        int temp=0;  //temp==k  证明找到了
        for (int i = 0; i <n-k+1 ; i++) {
            if (str1.charAt(i)==str2.charAt(temp)){
                for (int j = 0; j <k ; j++) {
                    if (str1.charAt(i+j)==str2.charAt(j)){
                        ++temp;
                        if (temp==k){
                            return true;
                        }
                    }else {
                        temp=0;
                        continue;
                    }
                }
            }


        }
        return false;
    }

    //getIndexOf(str1,str2)  该方法使用的就是KMP
    //kmp 让前面已经配过的信息指导后面
    /*
    一个字符串中，一个字符之前这坨字符串最长前缀 和最长后缀的匹配长度
    abcabcd  d之前最长前缀  后最长后缀的匹配长度 为3
    实质是：
     */
    //自己实现建议的KMP
    //暴力方法  复杂度最坏O（M*N）
    private static int kmp(String str1, String str2) {
        if (str1==null||str2==null||str1.length()<0||str2.length()<0){
            return -1;
        }
        char[] s1=str1.toCharArray();
        char[] s2=str2.toCharArray();
        int i1=0;
        int i2=0;
        int[] next=gextNext (s2);
        while (i1<s1.length&&i2<s2.length){
            if (s1[i1]==s2[i2]){
                i1++;
                i2++;
            }else {
                if (next[i2]==-1){
                    i1++;
                }else {
                    i2=next[i2];  //此时 i1已经到了最大子字符串然后不匹配的位置  i2从子字符串后的第一个位置开始匹配
                }
            }
        }
        return i2==str2.length()?i1-i2:-1;
    }

    private static int[] gextNext(char[] str) {
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

}
