package com.basic.advance.advanced_class_03.RBT.warmup;/*
    @Author  87814   algs4.xufei
    @Date  2018/11/3    21:30
*//*
    @Author  87814   algs4.xufei
    @Date  2018/11/3    21:30
*/


public class InorderSuccessorInBST {
    public  TreeNode inorderSuccessorInBST(TreeNode root,TreeNode p){
        if (p==null){
            return null;
        }
        if (getLastEntry(root)==p){
            return null;
        }
        if (p.right!=null){
            return getFristEntry(p.right);
        }
        TreeNode parent =root;
        TreeNode temp =root;
        while (parent!=null){
            if (parent==p){
                break;
            }else if (p.val<parent.val){
                temp =parent;
                parent = parent.left;
            }else {
                parent = parent.right;
            }
        }
        return temp;
    }

    private TreeNode getFristEntry(TreeNode p){
        while (p.left!=null){
            p=p.left;
        }
        return p;
    }

    private TreeNode getLastEntry(TreeNode p){
        while (p.right!=null){
            p=p.right;
        }
        return p;
    }
}
