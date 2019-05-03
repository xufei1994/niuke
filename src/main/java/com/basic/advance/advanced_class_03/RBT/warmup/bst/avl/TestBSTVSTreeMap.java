package com.basic.advance.advanced_class_03.RBT.warmup.bst.avl;/*
    @Author  87814   algs4.xufei
    @Date  2018/11/5    17:34
*//*
    @Author  87814   algs4.xufei
    @Date  2018/11/5    17:34
*/


import org.junit.Test;

import java.util.Random;
import java.util.TreeMap;

public class TestBSTVSTreeMap {
    public static final int MAX=65535;
    private Random random=new Random();
    @Test
    public void testBSTRandom(){
        AVLMap<Integer, String> map=new AVLMap<Integer, String>();
        for(int i=0;i<MAX;i++){
            map.put(random.nextInt(MAX), random.nextInt(MAX)+"");
        }
        map.checkBalance();
        for(int i=0;i<MAX;i++){
            map.get(random.nextInt(MAX));
        }
    }
    @Test
    public void testTreeMapRandom(){
        TreeMap<Integer, String> map=new TreeMap<Integer, String>();
        for(int i=0;i<MAX;i++){
            map.put(random.nextInt(MAX), random.nextInt(MAX)+"");
        }
        for(int i=0;i<MAX;i++){
            map.get(random.nextInt(MAX));
        }
    }
    @Test
    public void testBSTIncrement(){
        AVLMap<Integer, String> map=new AVLMap<Integer, String>();
        for(int i=0;i<MAX;i++){
            map.put(i, random.nextInt(MAX)+"");
        }
        map.checkBalance();
        for(int i=0;i<MAX;i++){
            map.get(random.nextInt(MAX));
        }
    }
    @Test
    public void testTreeMapIncrement(){
        TreeMap<Integer, String> map=new TreeMap<Integer, String>();
        for(int i=0;i<MAX;i++){
            map.put(i, random.nextInt(MAX)+"");
        }
        for(int i=0;i<MAX;i++){
            map.get(random.nextInt(MAX));
        }



    }
}