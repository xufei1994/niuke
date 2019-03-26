package com.basic.part3;/*
    @Author  87814   xufei
    @Date  2019/3/21    19:01
*//*
    @Author  87814   xufei
    @Date  2019/3/21    19:01
*/

import java.util.Stack;

//用栈实现队列
public class Question_03_queue {
    public Stack<Integer> stackDate;
    public Stack<Integer> stackEle;

    public Question_03_queue(){
        stackDate = new Stack<Integer>();
        stackEle = new Stack<Integer>();
    }

    //先进先出  即是栈顶元素
    public Integer peek(){
        return stackEle.peek();
    }
    //其实不需要 互相清空  在push的过程中就已经弹空了
    public Integer pop(){
        int value= stackEle.pop();
         stackDate.clear();
        while (!stackEle.isEmpty()){
           stackDate.push(stackEle.pop());
        }
        Stack<Integer> temp = stackDate;
        stackEle.clear();
        while (!temp.isEmpty()){
            stackEle.push(temp.pop());
        }
        return value;
    }
    public void push(int obj){
        stackDate.push(obj);
        Stack<Integer> temp = stackDate;
        while (!temp.isEmpty()){
            stackEle.push(temp.pop());
        }

    }
}
