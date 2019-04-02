package com.basic.part4.question;/*
    @Author  87814   xufei
    @Date  2019/4/1    19:38
*//*
    @Author  87814   xufei
    @Date  2019/4/1    19:38
*/

import com.basic.part4.teacher.Code_06_IsBalancedTree;

//判断一个数是否是 平很二叉树
public class Question06 {
   static int leftHigh=0 ;
   static int rightHigh=0;
    public static void main(String[] args) {
        TreeNode root= new TreeNode(
                null
                ,new TreeNode(new TreeNode(6),new TreeNode(7),3,new TreeNode(1))
                ,1,null);
        System.out.println(new Question06().IsBalanced_Solution(root));
    }

    public boolean IsBalanced_Solution(TreeNode root) {
        if (root==null){
            return true;
        }
        int chazhi =0;
        if (isBalanceTree(root)>1){
            return false ;
        }
        return true;

    }
    int left = 0;
    int right = 0;
    private int isBalanceTree(TreeNode root) {
        if (root==null){
            return 0 ;
        }
        left +=isBalanceTree(root.getLeftChild())+1;
        right +=isBalanceTree(root.getRightChild() )+1;
        return Math.abs(left-right);
    }
    //高度套路化处理   递归会回到一个节点三次，左边的树是否平衡，右树是否平衡，拿到左右的高度
    //
}
