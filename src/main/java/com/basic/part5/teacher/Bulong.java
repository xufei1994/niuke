package com.basic.part5.teacher;/*
    @Author  87814   algs4.xufei
    @Date  2019/4/2    22:28
*//*
    @Author  87814   algs4.xufei
    @Date  2019/4/2    22:28
*/


public class Bulong {
    public static void main(String[] args) {
        int[] arr = new int[1000]; //32000  一个int32个bit

        int index = 30000;
        int intIndex = 30000/32;  //确定定位到哪一个桶

        int bitIndex = 30000/32;  //确定那个bit被描黑

        arr[intIndex] = (arr[intIndex]|1<<bitIndex);  //1<<16  指的是第十六位为1,
    }
}
