package com.basic.part3;/*
    @Author  87814   algs4.xufei
    @Date  2019/3/21    19:01
*//*
    @Author  87814   algs4.xufei
    @Date  2019/3/21    19:01
*/

//用数组结构实现大小固定的队列
public class Question_01_queue_teacher {
   private  Integer[] arr;
   private  Integer   size;
   private  Integer   start;
   private  Integer   end;
   public Question_01_queue_teacher(int intSize){
       if (intSize<0){
           throw new IllegalArgumentException("the init size is less than 0");
       }
       arr =new Integer[intSize];
       size=0;
       start=0;
       end = 0;
   }

    public Integer peek(){
        if (size==0){
            return null;
        }
        return arr[size-1];
    }
    public void push(int obj){
       if (size==arr.length){
           throw new ArrayIndexOutOfBoundsException("the queue is full");
       }
       size++;
       arr[end] = obj;
       end = end==arr.length-1?0:end+1;
    }

    public Integer poll(){
        if (size == 0){
            throw  new ArrayIndexOutOfBoundsException("the stack is empty");
        }
        size--;
        int temp = start;
        start =start == arr.length-1 ? 0:start+1;
        return arr[temp];
    }


}
