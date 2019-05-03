package com.basic.advance.advanced_class_03.RBT.warmup;/*
    @Author  87814   algs4.xufei
    @Date  2018/11/3    10:05
*/


import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

public class TestLinkedList {
    @Test
    public void testQuery(){
        //接收可变参数，把一个数组变成集合
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(0,1,2,3,4,5,6,7,8,910));
        System.out.println(list.get(3));
        System.out.println(list.get(9));

    }
}
