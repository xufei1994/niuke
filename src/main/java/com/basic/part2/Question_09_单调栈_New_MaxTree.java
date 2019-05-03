package com.basic.part2;/*
    @Author  87814   xufei
    @Date  2019/4/16    21:53
*//*
    @Author  87814   xufei
    @Date  2019/4/16    21:53
*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//单调栈结构想要解决的问题是 在一个数组中，所有的数 左边离他最近的比他大的   右边离他最近的比他大的
//1.准备一个栈  做到从栈底到栈顶是由大到小     就是从小到大出栈
// 右边最大值 谁让他弹出的 谁就是他右边离他最近 最大的值
// 左边最大值   它的底下是谁 就是离他最近的比他的左边的最大值  相等的时候要把下标链接在一起


/*
题目描述：一个数组MaxTree  1.数组中没有重复元素，是一棵二叉树，每个值对应一个二叉树节点，，最大的节点是头
思路： 构建单调栈 ：从左向右扫描一遍记录右边第一个比他大的值
                 从右向左扫描一遍记录左边第一个比他大的值
                 然后找出左右中比较小的那个点作为它的父节点
                 如果左右节点都是null，则该节点就是根节点
 */

public class Question_09_单调栈_New_MaxTree {
    public static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node(int data){
            this.value = data;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings= bufferedReader.readLine().split(" ");
        Integer[] arr= new Integer[strings.length];
        for (int i = 0; i <strings.length ; i++) {
            arr[i]=Integer.parseInt(strings[i]);
        }
        Node head = produceNode(arr);
        //层序遍历
        Node head0 = new Node(0);
        Node head1 = new Node(1);
        Node head2 = new Node(2);
        Node head3 = new Node(3);
        head0.left=head1;
        head0.right=head2;
        head1.left =head3;
        levelTraversal(head);
    }
    private static Node produceNode(Integer[] arr) {
        Node[] nodes = new Node[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nodes[i] = new Node(arr[i]);
        }
        //单调栈 结构
        Stack<Node> stack = new Stack<>();
        HashMap<Node, Node> leftMap = new HashMap();
        HashMap<Node, Node> rightMap = new HashMap();
        for (int i = 0; i <arr.length ; i++) {
            Node curNode=nodes[i];
            while (!stack.isEmpty()&&stack.peek().value<nodes[i].value){
                popStackSetMap(stack,leftMap);
            }
            stack.push(curNode);
        }
        while (!stack.isEmpty()){
            popStackSetMap(stack,leftMap);
        }

        for (int i = arr.length-1; i !=-1 ; i--) {
            Node curNode=nodes[i];
            while (!stack.isEmpty()&&stack.peek().value<nodes[i].value){
                popStackSetMap(stack,rightMap);
            }
            stack.push(curNode);
        }
        while (!stack.isEmpty()){
            popStackSetMap(stack,rightMap);
        }

        Node head=null;
        for (int i = 0; i <arr.length ; i++) {
            Node cur = nodes[i];
            Node left = leftMap.get(cur);
            Node right =rightMap.get(cur);
            if (left==null&&right==null){
                head = cur;
            }else if (right==null){
                if (left.left==null){
                    left.left=cur;
                }else {
                    left.right=cur;
                }
            }else if (left==null){
                if (right.left==null){
                    right.left=cur;
                }else {
                    right.right=cur;
                }
            }else { //左右都有的话找小的为父亲
                Node parent = left.value<right.value?left:right;
                if (parent.left==null){
                    parent.left=cur;
                }else {
                    parent.right=cur;
                }
            }
        }
        return head;
    }

    private static void popStackSetMap(Stack<Node> stack, HashMap<Node,Node> leftMap) {
        Node popNode =stack.pop();
        if (stack.isEmpty()){
            leftMap.put(popNode,null);
        }else {
            leftMap.put(popNode,stack.peek());
        }
    }


    private static void levelTraversal(Node head) {
        if (head == null){
            System.out.println(" 没有生成树");
            return;
        }
        Queue<Node> queue = new LinkedList<Node>();
        ((LinkedList<Node>) queue).add(head);
       Node nlast =null;
       Node last = head;
        while (!queue.isEmpty()){
            Node temp =((LinkedList<Node>) queue).pop();

            System.out.print(temp.value+" ");

            if (temp.left!=null){
                ((LinkedList<Node>) queue).add(temp.left);
                nlast=temp.left;
            }
            if (temp.right!=null){
                ((LinkedList<Node>) queue).add(temp.right);
               nlast = temp.right;
            }
       //当一行遍历完之后 它的最右节点才添加进去
            if (last.equals(temp)){
                System.out.println();
                last=nlast;
            }


        }

    }



}
