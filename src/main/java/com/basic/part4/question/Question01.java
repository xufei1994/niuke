package com.basic.part4.question;/*
    @Author  87814   algs4.xufei
    @Date  2019/3/31    15:45
*//*
    @Author  87814   algs4.xufei
    @Date  2019/3/31    15:45
*/

import org.junit.Test;

//实现二叉树的前序中序后序遍历 包括递归方式和非递归方式
public class Question01 {
    @Test
    public void traversalByDigui(){

        TreeNode root=new TreeNode(new TreeNode(new TreeNode(4),new TreeNode(5),2,new TreeNode(1))
                ,new TreeNode(new TreeNode(6),new TreeNode(7),3,new TreeNode(1))
                ,1,null);

        preTraversal(root);
        System.out.println();
        inTraversal(root);
        System.out.println();
        postTraversal(root);
    }
    //前序遍历
    public void preTraversal(TreeNode root){
        if (root==null){
            return;
        }
        System.out.print(root.getValue());
        preTraversal(root.getLeftChild());
        preTraversal(root.getRightChild());
    }

    //中序遍历
    public void inTraversal(TreeNode root){
        if (root==null){
            return;
        }
        inTraversal(root.getLeftChild());
        System.out.print(root.getValue());
        inTraversal(root.getRightChild());
    }

    //后序遍历
    public void postTraversal(TreeNode root){
        if (root==null){
            return;
        }
        postTraversal(root.getLeftChild());
        postTraversal(root.getRightChild());
        System.out.print(root.getValue());
    }


}
