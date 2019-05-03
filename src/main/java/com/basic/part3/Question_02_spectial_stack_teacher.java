package com.basic.part3;/*
    @Author  87814   algs4.xufei
    @Date  2019/3/21    20:44
*//*
    @Author  87814   algs4.xufei
    @Date  2019/3/21    20:44
*/

import java.util.Stack;

//实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作
//要求 pop push getmin的时间复杂度都是1    可以使用现成的栈结构
public class Question_02_spectial_stack_teacher {
    public Stack<Integer> stackData;
    public Stack<Integer> stackMin ;

    public Question_02_spectial_stack_teacher(){
        this.stackData = new Stack<Integer>();
        this.stackMin  = new Stack<Integer>();
    }

    public void push(int newNum){
        if (this.stackMin.isEmpty()){
            this.stackMin.push(newNum);
        }else if (newNum<=this.getMin()){
            this.stackMin.push(newNum);
        }
        this.stackData.push(newNum);
    }

     public Integer pop(){
         if (this.stackData.isEmpty()){
             throw new IllegalArgumentException("no element in stack");
         }

         int temp=(Integer) stackData.pop();
         if (temp == (Integer) this.getMin()){
             this.stackMin.pop();
         }
         return temp;
     }


     public Integer getMin(){
        if (this.stackMin.isEmpty()){
            throw new IllegalArgumentException("no element in stack");
        }
        return this.stackMin.peek();
     }
}
