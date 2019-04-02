package com.basic.part4.question;/*
    @Author  87814   xufei
    @Date  2019/4/1    22:04
*//*
    @Author  87814   xufei
    @Date  2019/4/1    22:04
*/

import java.util.LinkedList;
import java.util.Queue;

//已知一颗完全二叉树，求其节点的个数  要求时间复杂度低于On，N为这棵树的节点个数
public class Question_8 {
    public static void main(String[] args) {
            TreeNode root= new TreeNode(
                    new TreeNode(new TreeNode(4),new TreeNode(5),2,new TreeNode(1))
                    ,new TreeNode(new TreeNode(6),new TreeNode(7),3,new TreeNode(1))
                    ,1,null);
        System.out.println(countNumber2(root));
    }

    private static int countNumber2(TreeNode root) {
        if (root==null){
            return  0;
        }

        return  bs(root,1,mostLeftLever(root,1));
    }

    private static int bs(TreeNode root, int level, int h) {
        if (level==h){
            return 1;
        }
        if (mostLeftLever(root.getRightChild(),level+1)==h){
            return (1 <<(h-level)) + bs(root.getRightChild(),level+1,h);//2的某次方
        }else {
            return (1 <<(h-level-1)) + bs(root.getLeftChild(),level+1,h);
        }
    }

    private static int mostLeftLever(TreeNode root, int level) {
        while (root!=null){
            level++;
            root=root.getLeftChild();
        }
        return level-1;
    }

    //满二叉树 l  个数为2^l-1个
    private static int countNumber(TreeNode root) {
        int i=0;
        Queue<TreeNode> queue = new LinkedList<>();
        ((LinkedList<TreeNode>) queue).add(root);
        while (!queue.isEmpty()){
            root= ((LinkedList<TreeNode>) queue).pop();
            i++;
            if (root.getLeftChild()!=null){
                ((LinkedList<TreeNode>) queue).add(root.getLeftChild());
            }
            if (root.getRightChild()!=null){
                ((LinkedList<TreeNode>) queue).add(root.getRightChild());
            }
        }
        return i;
    }


}
