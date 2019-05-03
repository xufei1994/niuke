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
        if (root.getLeftChild()!=null){
            return root.getLeftChild();
        }
        if (root.getLeftChild()==null &&root.getRightChild()!=null){
            return root.getRightChild();
        }
        if (root.getRightChild()==null&&root.getLeftChild()==null){
            while (root.getParent()!=null){ //如果他是左子树的右子树，则返回根节点
                if (root.getParent().getParent()==null){
                    return root.getParent().getRightChild();
                }
                if (root.getParent()==root.getParent().getParent().getLeftChild()&&root.getParent()
                        .getParent().getRightChild()!=null){return root.getParent().getParent().getRightChild();}

            }
        } //如果它是右子树的右子树  则返回 null
      return root.getLeftChild();
    }

}
