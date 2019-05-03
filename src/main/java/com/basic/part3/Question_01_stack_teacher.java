package com.basic.part3;/*
    @Author  87814   algs4.xufei
    @Date  2019/3/21    19:01
*//*
    @Author  87814   algs4.xufei
    @Date  2019/3/21    19:01
*/

//用数组结构实现大小固定的栈
public class Question_01_stack_teacher {
   private  Integer[] arr;
   private  Integer  size;
   public Question_01_stack_teacher(int intSize){
       if (intSize<0){
           throw new IllegalArgumentException("the init size is less than 0");
       }
       arr =new Integer[intSize];
       size=0;
   }
   public Integer peek(){
       if (size==0){
           return null;
       }
       return arr[size-1];
   }
   public  void push(int obj){
       if (size == arr.length){
           throw new ArrayIndexOutOfBoundsException("the stcak is full");
       }
       arr[size++] =obj;
   }
    public Integer pop(){
       if (size == 0){
           throw  new ArrayIndexOutOfBoundsException("the stack is empty");
       }
       return arr[--size];
    }


}
