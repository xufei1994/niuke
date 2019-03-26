package com.basic.part3;/*
    @Author  87814   xufei
    @Date  2019/3/21    20:44
*//*
    @Author  87814   xufei
    @Date  2019/3/21    20:44
*/

import java.util.Stack;

//实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作
//要求 pop push getmin的时间复杂度都是1    可以使用现成的栈结构
public class Question_02_spectial_stack {
    public Stack stack1;
    public Stack stack2;

     public Integer pop(){
         if (stack1.size()==0){
             throw  new IllegalArgumentException("no element in stack");
         }
         int temp=(Integer) stack1.pop();
         if (temp == (Integer) stack2.peek()){
             stack2.pop();
         }
         return temp;
     }

     public void push(int obj){
         if (stack2.size()==0){
             stack2.push(obj);
         }
         if (obj<=(Integer) stack2.peek()){
             stack2.push(obj);
         }
         stack1.push(obj);

     }
     public Integer getMin(){
         int temp = (Integer) stack2.peek();
         return temp;
     }
}
