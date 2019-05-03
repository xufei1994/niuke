package com.basic.part2;/*
    @Author  87814   xufei
    @Date  2019/4/16    17:25
*//*
    @Author  87814   xufei
    @Date  2019/4/16    17:25
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//有一个整型数组arr和一个大小为W的窗口从数组的最左边滑到最右边，窗口每次向右滑一个位置  滑动窗口最大值
// 双端队列结构  双向链表  LR 不能回退  相等时也要弹出
public class Question_07_滑动窗口_生成窗口最大值数组 {
    //数组长度为n 窗口大小为w，则一共产生n-w+1个窗口的最大值
    //输入：整型数组arr，窗口大小为w
    //输入：一个长度为n-w+1的数组res，res[i]表示每一种窗口状态下最大值
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(System.in));
        String stringW = bufferedReader.readLine();
        int w = Integer.parseInt(stringW);
        String stringArr = bufferedReader.readLine();
        String[] arr= stringArr.split(" ");
        int[] array = new int[arr.length];
        for (int i = 0; i <arr.length ; i++) {
            array[i] = Integer.parseInt(arr[i]);
        }
        System.out.println(Arrays.toString(getMaxWindow(array,w)));
        System.out.println(Arrays.toString(windows(array,w)));
    }

    private static int[] windows(int[] array,int w) {
    if (array==null||w<1||array.length<w){
        return null ;
    }
    int index = 0;
    int[] res = new int[array.length+1-w];//
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i <array.length ; i++) {
            while (!list.isEmpty()&&array[list.peekLast()]<=array[i]){
                list.pollLast();
            }
            list.addLast(i);
            if (list.peekFirst()==i-w){
                list.pollFirst();
            }
            if (i>=w-1){  //滑到了 窗口的长度就开始弹出
                res[index++]=array[list.peekFirst()];
            }
        }
        return res;
    }

   // LinkedList 就是一个双向链表   ArrayList是一个动态数组
    public static int[] getMaxWindow(int[] arr,int w){
        if (arr==null||w<1||arr.length<w){
            return null;
        }
        LinkedList<Integer> qmax = new LinkedList<>();
        int[] res = new int[arr.length-w+1];
        int index = 0;
        for (int i = 0; i <arr.length ; i++) {
            while (!qmax.isEmpty()&&arr[qmax.peekLast()]<=arr[i]){//尾节点小于等于array【i】时  将i压入 qmax 弹出
                qmax.pollLast();
            }
            qmax.addLast(i);
            if (qmax.peekFirst() ==i-w){  //过期  如果窗口在形成开始时，窗口没有形成完全 不会有下标弹出，
                // 当队列中的头下标为0时  i的坐标为3时 此时说明0已经过期了  则弹出头节点
                qmax.pollFirst();
            }
            if (i>=w-1){  //把当前的最大值收集起来返回到结果中去
                res[index++]= arr[qmax.peekFirst()];
            }
        }
        return res;
    }



}
