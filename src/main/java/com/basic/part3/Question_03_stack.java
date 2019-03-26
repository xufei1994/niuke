package com.basic.part3;/*
    @Author  87814   xufei
    @Date  2019/3/21    19:01
*//*
    @Author  87814   xufei
    @Date  2019/3/21    19:01
*/

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//队列实现栈
public class Question_03_stack {
    public Queue<Integer> queueData;
    public Queue<Integer> queueEle;

    public Question_03_stack(){
        queueData = new LinkedList<Integer>();
        queueEle = new LinkedList<Integer>();
    }

    //先进先出  即是栈顶元素
    public Integer peek(){
        if (queueEle.isEmpty()){
            throw  new IllegalArgumentException("the queue is empty");
        }
        return queueEle.peek();
    }
    public Integer pop(){
        int value= queueEle.remove();
        queueData.clear();
        while (!queueEle.isEmpty()){
            queueData.add(queueEle.remove());
        }
        Queue<Integer> temp =new LinkedList<Integer>();
        queueEle.clear();
        while (!temp.isEmpty()){
            queueEle.add(temp.remove());
        }
        return value;
    }
    public void push(int obj){
        queueData.add(obj);
        Queue<Integer> temp =queueData;
        while (!temp.isEmpty()){
            queueEle.add(temp.remove());
        }

    }

}
