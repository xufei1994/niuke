package com.basic.advance.advanced_class_03.RBT.warmup;/*
    @Author  87814   algs4.xufei
    @Date  2018/11/3    11:54
*//*
    @Author  87814   algs4.xufei
    @Date  2018/11/3    11:54
*/


import java.util.ArrayList;
import java.util.Iterator;

public class BSTIterator {
    private Iterator<Integer> itr;

    public BSTIterator(TreeNode root){
        ArrayList<Integer>  list = new ArrayList<>();
        inOrder(root,list);
        itr = list.iterator();
    }
    //递归
    private  void inOrder(TreeNode p,ArrayList<Integer> list){
        if (p!=null){
            inOrder(p.left, list);
            list.add(p.val);
            inOrder(p.right, list);
        }
    }

    public boolean hasNext(){
        return itr.hasNext();
    }

    public int  next(){
        return itr.next();
    }






}
