package com.basic.part3;/*
    @Author  87814   algs4.xufei
    @Date  2019/3/25    14:00
*//*
    @Author  87814   algs4.xufei
    @Date  2019/3/25    14:00
*/


import java.util.Stack;

public class Question_11_huiwen {


    public static void main(String[] args) {
        Node temp = new Node(Integer.MIN_VALUE);
        Node head1 = temp;
        for (int i = 0; i < 15; i++) {
            Node node = new Node(i);
            temp.next = node;
            temp = node;
        }
        for (int i = 16; i >=0 ; i--) {
            Node node = new Node(i);
            temp.next = node;
            temp = node;
        }
        Node cur=head1.next;
        while (cur!=null){
              System.out.println(cur.val);
            cur= cur.next;
        }

        System.out.println(huiwenNew(head1.next));
    }
    //要求空间复杂度为1
    private static boolean huiwenNotSpace(Node head) {
        // need O(1) extra space

            if (head == null || head.next == null) {
                return true;
            }
            Node n1 = head;
            Node n2 = head;
            while (n2.next != null && n2.next.next != null) { // find mid node
                n1 = n1.next; // n1 -> mid
                n2 = n2.next.next; // n2 -> end
            }
            n2 = n1.next; // n2 -> right part first node
            n1.next = null; // mid.next -> null
            Node n3 = null;
            while (n2 != null) { // right part convert
                n3 = n2.next; // n3 -> save next node
                n2.next = n1; // next of right node convert
                n1 = n2; // n1 move
                n2 = n3; // n2 move
            }
            n3 = n1; // n3 -> save last node
            n2 = head;// n2 -> left first node
            boolean res = true;
            while (n1 != null && n2 != null) { // check palindrome
                if (n1.val != n2.val) {
                    res = false;
                    break;
                }
                n1 = n1.next; // left to mid
                n2 = n2.next; // right to mid
            }
            n1 = n3.next;
            n3.next = null;
            while (n1 != null) { // recover list
                n2 = n1.next;
                n1.next = n3;
                n3 = n1;
                n1 = n2;
            }
            return res;

    }

    //不要求 空间复杂度  创建一个栈 把链表压入栈中去，然后链表弹出的顺序就是反的结构 皆可以判断是否是一个回文结构
    private static boolean huiwen(Node next) {
        Node cur = next;
        Stack<Integer> stack = new Stack<>();
        while (cur!=null){
            stack.push(cur.val);
            cur=cur.next;
        }
        Node p=next;
        while (p!=null){
            if (stack.pop()==p.val){
                p=p.next;
            }else {
                return false;
            }
        }
        return true;

    }

    //不要求 空间复杂度  创建一个栈 把链表压入栈中去，然后链表弹出的顺序就是反的结构 皆可以判断是否是一个回文结构
    private static boolean huiwenNew(Node next) { //优化第一种方法
        if (next == null || next.next == null) {
            return true;
        }
        Node cur = next;
        Node p=next;
        while (p!=null&&p.next!=null){
            cur=cur.next;
            p=p.next.next;
        }
        Stack<Integer> stack = new Stack<>();
        while (cur!=null){
            stack.push(cur.val);
            cur=cur.next;
        }

        Node pNew=next;
        while (!stack.isEmpty()){
            if (stack.pop()==pNew.val){
                pNew=pNew.next;
            }else {
                return false;
            }
        }
        return true;

    }

}
