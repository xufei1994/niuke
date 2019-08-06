package com.basic.part4.question;/*
    @Author  87814   algs4.xufei
    @Date  2019/3/31    17:47
*//*
    @Author  87814   algs4.xufei
    @Date  2019/3/31    17:47
*/

//在二叉树中找到一个节点的后继节点
public class Question02 {
    public static void main(String[] args) {
        TreeNode root= new TreeNode(
                new TreeNode(new TreeNode(4),new TreeNode(5),2,new TreeNode(1))
                ,new TreeNode(new TreeNode(6),new TreeNode(7),3,new TreeNode(1))
                ,1,null);
     findNext(root);   
    }

    //中序遍历中，node的下一个节点叫做 它的后继节点  左根右的顺序
    private static TreeNode findNext(TreeNode root) {
        //一般情况
      if (root==null) return null;
      if (root.getRightChild()!=null){
          return getLeftMost(root);
      }else {
          TreeNode parent = root.getParent();
          while (parent!=null&&parent.getLeftChild()!=root){
              root=parent;
              parent=root.getParent();
          }
          return parent;
      }

    }

    private static TreeNode getLeftMost(TreeNode root) {
        if (root==null) return root;
        while (root.getLeftChild()!=null){
            root=root.getLeftChild();
        }
        return root;
    }

}
