package com.basic.advance.advanced_class_03.RBT.warmup.bst.avl;/*
    @Author  87814   algs4.xufei
    @Date  2018/11/3    11:05
*//*
    @Author  87814   algs4.xufei
    @Date  2018/11/3    11:05
*/


import java.util.Map;

public class AVLEntry<K,V> implements Map.Entry<K,V> {
    public K key;
    public V value;
    public AVLEntry<K,V> left;
    public AVLEntry<K,V> right;
    public int height=1;
    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public V setValue(V value) {
        this.value = value;
        return value;
    }

    public AVLEntry() {
    }

    public AVLEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public AVLEntry(K key) {
        this.key = key;
    }



    @Override
    public String toString() {
        return "AVLEntry{" +
                "key=" + key +
                ", value=" + value +
                ", height=" + height +
                '}';
    }

    public AVLEntry(K key, V value, AVLEntry<K, V> left, AVLEntry<K, V> right) {
        this.key = key;
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
