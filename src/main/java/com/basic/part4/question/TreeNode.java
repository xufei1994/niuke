package com.basic.part4.question;/*
    @Author  87814   algs4.xufei
    @Date  2019/3/31    15:51
*//*
    @Author  87814   algs4.xufei
    @Date  2019/3/31    15:51
*/


public class TreeNode {
    private TreeNode leftChild;
    private TreeNode rightChild;
    private Integer value;
    private TreeNode parent;

    TreeNode(Integer value){
        this.value=value;
    }

    public TreeNode(TreeNode leftChild, TreeNode rightChild, Integer value, TreeNode parent) {
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.value = value;
        this.parent = parent;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "leftChild=" + leftChild +
                ", rightChild=" + rightChild +
                ", value=" + value +
                ", parent=" + parent +
                '}';
    }
}
