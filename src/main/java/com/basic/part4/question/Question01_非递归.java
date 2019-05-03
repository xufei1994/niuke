package com.basic.part4.question;/*
    @Author  87814   algs4.xufei
    @Date  2019/3/31    16:12
*//*
    @Author  87814   algs4.xufei
    @Date  2019/3/31    16:12
*/


import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Question01_非递归 {
    @Test
    public void traversalByDigui(){
        TreeNode root= new TreeNode(
                new TreeNode(new TreeNode(4),new TreeNode(5),2,new TreeNode(1))
                ,new TreeNode(new TreeNode(6),new TreeNode(7),3,new TreeNode(1))
                ,1,null);


    }


    //层序遍历
    private void cengTraversalByStack(TreeNode root) {
        Queue queue = new LinkedList();
        ((LinkedList) queue).add(root);
        while (!queue.isEmpty()){
            TreeNode temp = (TreeNode) ((LinkedList) queue).pop();
            System.out.print(temp.getValue());
            if (temp.getLeftChild()!=null){((LinkedList) queue).add(temp.getLeftChild());}
            if (temp.getRightChild()!=null){((LinkedList) queue).add(temp.getRightChild());}
        }
    }


    //二叉树的非递归的实现  中序遍历  使用堆栈
    public void inOrderTraversal(TreeNode root){
        TreeNode temp= root;
        Stack stack = new Stack() ;  //创建并初始化堆栈stack
        while (temp!=null||!stack.isEmpty()){
            while (temp!=null){ //  一直向左并将沿途节点压入堆栈
                stack.push(temp);  //若节点左孩子不空，将左孩子压栈，应为需要借助遍历过的节点进入右子树
                temp=temp.getLeftChild();
            }
//            当t为空时，说明已经到达左子树最下边，这个时候需要出栈
            if (!stack.isEmpty()){
                temp= (TreeNode) stack.pop();//节点弹出 堆栈
                System.out.println(temp.getValue());  //访问根节点
                temp=temp.getRightChild();  //转向右子树，开启新一轮遍历
            }
        }

    }


    // ...........前序遍历  使用堆栈
    public void preOrderTraversal(TreeNode root){
        TreeNode temp=root;
        Stack<TreeNode> stack = new Stack<TreeNode>() ;   //创建并初始化堆栈stack
        while (temp!=null||!stack.isEmpty()){
            while (temp!=null){ //  一直向左并将沿途节点压入堆栈
                System.out.println(temp.getValue());  //若节点不为空先访问压栈，每个节点都可以看做是根节点
                stack.push(temp);
                temp=temp.getLeftChild();    //将当前节点置为t的左孩子，若不为空继续访问压栈
            }
            //当t等于空的时候，说明根节点和左孩子打印遍历完毕了，接下来遍历右孩子
            if (!stack.isEmpty()){
                temp= (TreeNode) stack.pop();//节点弹出 堆栈
                temp=temp.getRightChild();  //转向右子树
            }
        }

    }


    //二叉树的非递归的实现  后序遍历  使用堆栈
    public void postOrderTraversal(TreeNode root){
        TreeNode temp=root;
        Stack<TreeNode> stack1 = new Stack<TreeNode>() ;  //创建并初始化堆栈stack
        Stack<Integer> stack2 = new Stack<Integer>();
        int i=1;
        while (temp!=null||!stack1.isEmpty()) {
            while (temp != null) { //  一直向左并将沿途节点压入堆栈
                stack1.push(temp);
                stack2.push(0);
                temp = temp.getLeftChild();
            }
            while (!stack1.empty() && stack2.peek() == i) {
                stack2.pop();
                System.out.print(stack1.pop().getValue() + "   ");
            }
            if (!stack1.empty()) {
                stack2.pop();
                stack2.push(1);
                temp = stack1.peek();
                temp = temp.getRightChild();
            }

        }
    }

    public void preTraversal(TreeNode root){
        System.out.println("前序遍历");
          if (root!=null){
              Stack<TreeNode> stack =new Stack<>();
              stack.add(root);
              while (!stack.isEmpty()||root!=null){
                  root = stack.pop();
                  System.out.print(root.getValue());
                  if (root.getRightChild()!=null){
                      stack.push(root.getRightChild());
                  }
                  //栈是一种反的结构  你先压右后压左  弹出就是先左后右
                  if (root.getLeftChild()!=null){
                      stack.push(root.getLeftChild());
                  }
              }
          }
    }

    public void inTraversal(TreeNode root){
        System.out.println("中序遍历");
        if (root!=null){
            Stack<TreeNode> stack = new Stack<>();
            stack.add(root);
            while (!stack.isEmpty()||root!=null){
                if (root.getLeftChild()!=null){
                    stack.push(root.getLeftChild());
                    root=root.getLeftChild();
                }else {
                    root = stack.pop();
                    System.out.print(root.getValue());
                    root=root.getRightChild();
                }
            }
        }
    }

    public void postTraversal(TreeNode root){
        System.out.println("后序遍历");
        if (root!=null){
            Stack<TreeNode> stack = new Stack<>();
            stack.add(root);
            Stack<TreeNode> stack2 = new Stack<>();
            while (!stack.isEmpty()||root!=null){
                root=stack.pop();
                stack2.push(root);
                if (root.getLeftChild()!=null){
                    stack.push(root.getLeftChild());
                }
                if (root.getRightChild()!=null){
                    stack.push(root.getRightChild());
                }
            }
            while (!stack2.isEmpty()){
                System.out.print(stack2.pop().getValue());
            }
        }
    }


}
