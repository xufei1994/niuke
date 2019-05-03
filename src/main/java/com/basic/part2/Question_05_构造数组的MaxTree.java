package com.basic.part2;/*
    @Author  87814   xufei
    @Date  2019/4/17    21:10
*//*
    @Author  87814   xufei
    @Date  2019/4/17    21:10
*/
/*
定义如下： 数组必须没有重复元素
         MaxTree 是一棵二叉树，数组的每一个值对应一个二叉树节点
         包括Maxtree 树在内且在其中的每一颗子树上，值最大的节点都是树的头
         没有重复元素数组arr，写出生成这个数组的MaxTree的函数 ，要求如果数组长度为N，则时间复杂度和空间复杂度都为ON
 */

public class Question_05_构造数组的MaxTree {
    public class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int data){
            this.value=data;
        }
    }
}
