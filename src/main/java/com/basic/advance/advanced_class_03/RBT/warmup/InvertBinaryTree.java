package com.basic.advance.advanced_class_03.RBT.warmup;/*
    @Author  87814   algs4.xufei
    @Date  2018/11/3    10:19
*//*
    @Author  87814   algs4.xufei
    @Date  2018/11/3    10:19
*/


import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {
    //交换所有节点的左右子树
    //               4                   4
//                2      7            7       2
    //          1  3   6  9         9   6   3   1

//先序遍历
    public TreeNode invertTreeByPre(TreeNode root){
        if (root!=null){
            TreeNode temp= root.left;
            root.left=root.right;
            root.right=temp;
            invertTreeByPre(root.left);
            invertTreeByPre(root.right);
            return root;
        }else {
            return null;
        }
    }

//  后序遍历
public TreeNode invertTreeByPost(TreeNode root){
    if (root!=null){
        invertTreeByPre(root.left);
        invertTreeByPre(root.right);
        TreeNode temp= root.left;
        root.left=root.right;
        root.right=temp;

        return root;
    }else {
        return null;
    }
}


    //  中序遍历
    public TreeNode invertTreeByMid(TreeNode root){
        if (root!=null){
            invertTreeByPre(root.left);
            TreeNode temp= root.left;
            root.left=root.right;
            root.right=temp;
            invertTreeByPre(root.left); //由于此时左右子树已经完成交换，所以递归右子树真正意义上是递归左子树

            return root;
        }else {
            return null;
        }
    }

    //层序遍历
    public TreeNode invertTreeByLever(TreeNode root){
        if (root==null) {return null;}
        else {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()){
                TreeNode p = queue.poll();
                TreeNode temp= p.left;
                p.left=p.right;
                p.right = temp;
                if (p.left!=null) {
                    queue.offer(p.left);
                }
                if (p.right!=null) {
                    queue.offer(p.right);
                }
            }
        }
        return root;
    }


}


