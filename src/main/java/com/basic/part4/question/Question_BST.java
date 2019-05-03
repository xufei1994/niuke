package com.basic.part4.question;/*
    @Author  87814   algs4.xufei
    @Date  2019/4/1    20:37
*//*
    @Author  87814   algs4.xufei
    @Date  2019/4/1    20:37
*/


//搜索二叉树   可以理解为  中序遍历是升序的二叉树

import org.omg.PortableInterceptor.INACTIVE;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//判断一棵树是否是搜索二叉树
public class Question_BST {
    public static void main(String[] args) {
        TreeNode root= new TreeNode(
                null
                ,new TreeNode(new TreeNode(6),new TreeNode(7),3,new TreeNode(1))
                ,1,null);
        isBstTree(root);
    }

    private static boolean isBstTree(TreeNode root) {
        if (root==null){
            return true;
        }
         inOrder(root);
         while (stack.isEmpty()){
             Integer temp = (Integer) stack.pop();
             int value = (int) stack.peek();
             if (value<=temp){
                 continue;
             }else {
                 return false;
             }
         }
         return true;
    }
     static Stack stack = new Stack();
    private static void inOrder(TreeNode root) {
        if (root == null){
            return;
        }
        inOrder(root.getLeftChild());
        stack.push(root.getValue());
        inOrder(root.getRightChild());
    }
    static  int temp=Integer.MIN_VALUE;
    private  static boolean inOrederNotByStack(TreeNode root){
        if (root==null){return true;}
        inOrederNotByStack(root.getLeftChild());
        int value =root.getValue();
        if (temp>value){
            return false;
        }else {
            temp=value;
        }
        inOrederNotByStack(root.getRightChild());
        return true;
    }
    //非递归版的
    private  static boolean inOrederNotByDigui(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        TreeNode temp = root;
        int num=Integer.MIN_VALUE;
        while (temp != null || !stack.isEmpty()) {
            while (temp != null) { //  一直向左并将沿途节点压入堆栈
                stack.push(temp);  //若节点左孩子不空，将左孩子压栈，应为需要借助遍历过的节点进入右子树
                temp = temp.getLeftChild();
            }
//            当t为空时，说明已经到达左子树最下边，这个时候需要出栈
            if (!stack.isEmpty()) {
                temp = (TreeNode) stack.pop();//节点弹出 堆栈

                temp = temp.getRightChild();  //转向右子树，开启新一轮遍历
            }
        }
        return true;
    }

    //判断一个树是否是 完全二叉树  层序遍历
    public  static boolean isCBT(TreeNode root){
        if (root ==null){
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        boolean leaf =false;
        TreeNode l =null;
        TreeNode r =null;
        queue.offer(root);
        while (!queue.isEmpty()){
            root = queue.poll();
            l=root.getLeftChild();
            r = root.getRightChild();
            if ((leaf&&(l!=null||r!=null))||(l==null&&r!=null)){
                return  false;
            }

//            if (l!=null){
//                queue.offer(l);
//            }
//            if (r!=null){
//                queue.offer(r);}
//            if (l==null||r==null){
//                leaf =true;
//            }  等效下面代码，在上面已经将左端不为空判断完毕

            if (l!=null){
                queue.offer(l);
            }
            if (r!=null){
                queue.offer(r);
            }else {
                leaf=true;
            }
        }
        return true;
    }


}
