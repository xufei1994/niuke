package com.basic.part2;/*
    @Author  87814   xufei
    @Date  2019/4/13    15:20
*//*
    @Author  87814   xufei
    @Date  2019/4/13    15:20
*/

import java.util.Arrays;

//求最长回文子字符串
public class Question_04_Manacher {
    public static void main(String[] args) {
        String a="11311";
//        //System.out.println("ans+"+maxManacherBaoli(a));
//        System.out.println("ans+"+maxManacherBaoli("11111122111111"));
//        System.out.println("ans+"+maxLcpsLength("11111122111111"));
        System.out.println(manacher01("abc1234321"));
        
    }

    private static int maxManacherBaoli(String a) {
        char[] chars=a.toCharArray();
        String str="";
        for (int i = 0; i < chars.length; i++) {
            str+="#"+chars[i];
            if (i==chars.length-1){
                str=str+"#";
            }
        }
        System.out.println(str);

        int max=0;
        char[] strArray = str.toCharArray();
        for (int i = 1; i <strArray.length-1 ; i++) {
            int i1=i-1;
            int i2=i+1;
            int temp=0;
            while (i1>=0&&i2<strArray.length&&strArray[i1]==strArray[i2]){
                i1--;
                i2++;
                temp+=2;
            }
            //简易通过 左右回文优化，正确性未知
            if (temp!=0){
                i=i+temp/2-1;
            }
            max=Math.max(max,temp);
        }

        return max/2;
    }

    /*
    回文直径   1. 需要准备一个数组 记载它的回文半径数组0-n  next
    最右回文右边界  2.所有回文边界中最靠右的位置 未开始扩张是arr[0]=-1
    当你到达一个更右的回文右边界的时候，你的回文中心是什么   取得这个最右边界的中心在哪里  只记录第一次冲到该位置的下标

    可能性一  回文右边界在其左边   直接暴力扩张

    i 在回文右边界内  做i关于 中心点c的对称点 i1
    可能性二  i1+它的回文半径依然在 回文直径的内部   此时i的回文半径不需要计算 将i1的回文半径直接赋值给i
    可能性三  i1+它的回文半径 不 在 回文直径的内部   此时i的回文半径不需要计算   i的回文半径为  到 最右边界的距离
    可能性四  i1+它的回文半径 压线 回文直径的边界   此时i的回文半径需要计算      i的回文半径进行扩张判断
   */
    public static char[] manacherString(String str){
        char[] chars =str.toCharArray();
        String ans="";
        for (int i = 0; i <chars.length ; i++) {
            ans+="#"+chars[i];
        }
        ans=ans+"#";
        return ans.toCharArray();
    }
    public static int maxLcpsLength(String str){
        if (str == null||str.length()==0){
            return 0;
        }
        char[] charArray = manacherString(str);
        int[] pArr = new int[charArray.length];   //回文右边界字符串
        int C=-1;  //回文中心坐标
        int R=-1;   //回文右边界（起始位置为-1）
        int max=Integer.MIN_VALUE;
        for (int i = 0; i !=charArray.length ; i++) {
            pArr[i]=R>i?Math.min(pArr[2*C-i],R-i):1;  //i在回文右边界的里面，谁小谁是瓶颈   2*C-i是i1的位置  -（i-C）+C
            while (i+pArr[i]<charArray.length&&i-pArr[i]>-1){
                if (charArray[i+pArr[i]]==charArray[i-pArr[i]]){
                    pArr[i]++;
                }else {
                    break;
                }
            }
            if (i+pArr[i]>R){
                R=i+pArr[i];
                C=i;
            }
            max=Math.max(max,pArr[i]);
        }
        return max-1;
    }

    //向字符串的后面添加字符让整个变成最短的回文串，求其最短时间
    public static char[] manacherString01(String str){
        String ans ="";
        for (int i = 0; i <str.length() ; i++) {
            ans+="#"+str.charAt(i);
        }
        ans+="#";
        System.out.println(ans);
        return ans.toCharArray();
    }

    public static String manacher01(String str){
        char[] charArray  = manacherString01(str);
        int[] pChar = new int[charArray.length];
        int C= -1;
        int R=-1;
        int max=Integer.MIN_VALUE;
        int end=0;
        for (int i = 0; i <charArray.length ; i++) {
            pChar[i]=i<R?Math.min(2*C-i,R-i):1;
            while (i-pChar[i]>-1&&i+pChar[i]<pChar.length){
                if (charArray[i+pChar[i]]==charArray[i-pChar[i]] ){
                    pChar[i]++;
                }else {
                    break;
                }
            }

            if (i+pChar[i]>R){
                R=i+pChar[i];
                C=i;
            }
           max=Math.max(pChar[i],max);
            if (i+pChar[i]==charArray.length){
                end=i;
                break;
            }
        }

        for (int j=end-pChar[end]+1; j>=0 ; j--) {
            System.out.println(j);
            if (charArray[j]!='#'){
                str+=charArray[j];
            }
        }
        return str;
    }

}
