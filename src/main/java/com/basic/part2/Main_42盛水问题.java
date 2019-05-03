package com.basic.part2;/*
    @Author  87814   xufei
    @Date  2019/4/17    9:21
*//*
    @Author  87814   xufei
    @Date  2019/4/17    9:21
*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_42盛水问题 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = bufferedReader.readLine().split(",");
        int[] arr =new int[strings.length];
        for (int i = 0; i <strings.length ; i++) {
            arr[i] = Integer.parseInt(strings[i]);
        }

        System.out.println((arr));


    }
    public int trap(int[] arr) {
        int res = 0;
        for (int i = 1; i <arr.length ;i++ ) {
            if (arr[i-1]>arr[i]){
                int templeft = i-1; //保留前一位的下标
                while (i<arr.length-1&&arr[i+1]<=arr[i]){
                    i++;
                }//找到第一个比 前一位大的值
                int cur =i;//拐点
                int max=arr[i];
                while (cur<arr.length&&arr[cur]<arr[templeft]){
                    if (arr[cur]>=max){
                        max=arr[cur];
                        i=cur;
                    }
                    cur++;
                }
                int value = Math.min(arr[templeft],max);

                int temp=res;
                for (int j = templeft; j <=i ; j++) {
                    if (value-arr[j]>=0)
                        res+=value-arr[j];
                }
            }

        }
        return res;
    }
}
