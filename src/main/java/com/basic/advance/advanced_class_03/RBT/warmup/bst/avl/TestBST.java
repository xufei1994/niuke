package com.basic.advance.advanced_class_03.RBT.warmup.bst.avl;/*
    @Author  87814   algs4.xufei
    @Date  2018/11/3    14:43
*//*
    @Author  87814   algs4.xufei
    @Date  2018/11/3    14:43
*/


import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class TestBST {
    private Random random = new Random();
    private final  int MAX1=16;

    @Test
    public void testPutAndItr(){

        AVLMap<Integer,String> map = new AVLMap<>();
        for (int i = 0; i <MAX1 ; i++) {
            map.put(random.nextInt(MAX1),random.nextInt(MAX1)+"");
            System.out.println("我执行了"+random.nextInt(MAX1));
        }

        Iterator<AVLEntry<Integer,String>> it=map.iterator();
        System.out.println("-------");
        System.out.println(it.hasNext());
        while (it.hasNext()){
            System.out.print(it.next().key+" ");
        }

        System.out.println();
    }

    private final int MAX2=65535;
    @Test
    public void testPutAndItrWithJDK(){
        AVLMap<Integer,String> map1 = new AVLMap<Integer, String>();
        TreeMap<Integer,String> map2 = new TreeMap<>();
        for (int i = 0; i <MAX2 ; i++) {
            int key =random.nextInt(MAX2);
            String value = random.nextInt(MAX2)+"";
            map1.put(key,value);
            map2.put(key,value);
        }
        Assert.assertTrue(map1.size() == map2.size());
        System.out.println(map1.size());
        Iterator<AVLEntry<Integer,String>>  it1 = map1.iterator();
        Iterator<Map.Entry<Integer,String>>  it2 = map2.entrySet().iterator();
        //treemap本身不继承 iterable接口
        while (it1.hasNext()&&it2.hasNext()){
            Assert.assertTrue(it1.next().getKey().equals(it2.next().getKey()));
        }
        Assert.assertTrue(!it1.hasNext()&&!it2.hasNext());
    }

    @Test
    public void testQuery(){
        AVLMap<Integer,String>  map = new AVLMap<>();
        map.put(4,"a");
        map.put(3,"b");
        map.put(2,"c");
        map.put(1,"d");
        map.put(0,"e");
        map.put(11,"f");
        map.put(9,"a");
        map.put(4,"a");
        map.put(4,"a");
        Assert.assertTrue(map.get(4).equals("a"));

    }


    @Test
    public void testRemoveCase1(){
        AVLMap<Integer,String> map = new AVLMap<>();
        int[] array ={5,2,6,1,4,7,3};
        for (int key:array){
            map.put(key,key+"");
        }
        System.out.println(map.remove(1));
        map.levelOrder();

        Iterator<AVLEntry<Integer,String>>  it1 = map.iterator();
        //treemap本身不继承 iterable接口
        while (it1.hasNext()){
            System.out.print(it1.next().key+"");
        }
        System.out.println();
    }

    @Test
    public void testAVLDelete(){
        AVLMap<Integer,String> map1 = new AVLMap<>();
        TreeMap<Integer,String> map2 = new TreeMap<>();
        for (int i = 0; i <MAX2 ; i++) {
            String value= random.nextInt(MAX2)+"";
            int key = random.nextInt();
            map1.put(key,value);
            map2.put(key,value);
        }
        for (int i = 0; i <MAX2>>1 ; i++) {
            int key =random.nextInt(MAX2);
            map1.remove(key);
            map2.remove(key);
        }

        map1.checkBalance();
        Assert.assertTrue(map1.size()==map2.size());
        Iterator<AVLEntry<Integer,String>> it1 = map1.iterator();
        Iterator<Map.Entry<Integer,String>> it2 = map2.entrySet().iterator();
        while (it1.hasNext()&&it2.hasNext()){
            Assert.assertTrue(it1.next().getKey().equals(it2.next().getKey()));
        }
        Assert.assertTrue(!it1.hasNext()&&!it2.hasNext());
    }




}
