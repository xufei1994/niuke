package com.basic.part2;/*
    @Author  87814   xufei
    @Date  2019/4/16    20:55
*//*
    @Author  87814   xufei
    @Date  2019/4/16    20:55
*/

/*
给定数组arr 和整数 num 共返回有多少个子数组满足如下情况：  max(max=min)<=num
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Question_08_滑动窗口_最大值减去最小值小于或等于num的子数组数量 {
    //思路构建两个滑动窗口
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader  =new BufferedReader(new InputStreamReader(System.in));
        int num =Integer.parseInt(bufferedReader.readLine());
        String[] strings = bufferedReader.readLine().split(" ");
        int[] array =new int[strings.length];
        for (int i = 0; i <strings.length ; i++) {
            array[i] =  Integer.parseInt(strings[i]);
        }
        System.out.println("ans "+ kidNumber(array,num));
    }

    //结论： 如果一个数组达标的，它内部任何一个子数组都达标，如果缩小范围只能说使 max更小 min更大 所以子数组都是达标的小于等于n
    //   2： 如果子数组已经不达标 ，无论扩张都不达标，因为扩张只能使 max变大 min变小
    //
    private static int kidNumber(int[] array, int num) {
        if (array==null||array.length == 0){return 0;}
        LinkedList<Integer> qmin = new LinkedList<>();
        LinkedList<Integer> qmax = new LinkedList<>();
        int i = 0;
        int j = 0;
        int res = 0 ;
        while (i<array.length){
            while (j<array.length){
                while (!qmin.isEmpty()&&array[qmin.peekLast()]>=array[i]){
                    qmin.pollLast();
                }
                qmin.addLast(j);
                while (!qmax.isEmpty()&&array[qmax.peekLast()]<=array[i]){
                    qmax.pollLast();
                }
                qmax.addLast(j);
                if (array[qmax.getFirst()]-array[qmin.getFirst()]>num){
                    break;
                }
                j++;
            }
            if (qmin.peekFirst() == i){
                qmin.pollFirst();
            }
            if (qmax.peekFirst() == i){
                qmax.pollFirst();
            }
            res+=j-i;
            i++;//换一个开头继续
        }
        return res;
    }


    //暴力方法
    public static int getNum1(int[] arr,int n){
        int res =0;
        for (int start = 0; start <arr.length ; start++) {  //穷尽所有的子数组
            for (int end = start; end <arr.length ; end++) {
                if (isVaild(arr,start,end,n)){res++;}
            }
        }
        return res;

    }
    private static boolean isVaild(int[] arr, int start, int end, int n) {
        int max =Integer.MIN_VALUE;
        int min =Integer.MAX_VALUE;
        for (int i = start; i <=end ; i++) {
            max=Math.max(max,arr[i]);
            min=Math.min(min,arr[i]);
        }
        return max-min<= n;
    }

}
