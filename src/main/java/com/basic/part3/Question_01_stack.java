package com.basic.part3;/*
    @Author  87814   xufei
    @Date  2019/3/21    19:01
*//*
    @Author  87814   xufei
    @Date  2019/3/21    19:01
*/

//用数组结构实现大小固定的栈
public class Question_01_stack {
    public static int[] arrar;
    public static int cur=0;
    //队列的基本结构，先进先出，主要方法，进队列，出队列，构造方法生成固定大小的队列
    //构造方法生成固定大小的队列
    public Question_01_stack(int capacity){
        if (arrar==null){
            arrar = new int[capacity];
        }else {
            int[] temp = new int[capacity];
            for (int i = 0; i <arrar.length ; i++) {
                temp[i]=arrar[i];
            }
            arrar=temp;
        }
    }
    //压入栈
    public static void push(int element){
        if (cur==arrar.length-1){
            System.out.println("已满");

        }
        if (cur<arrar.length-1){
            arrar[cur]=element;
            cur++;
        }
    }
    //输出栈顶的元素
    public static int peek(int element){
        return  arrar[cur];
    }
    //弹出栈
    public static int pop(int element){
        return arrar[cur--];
    }






}
