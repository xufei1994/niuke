package com.basic.part3;/*
    @Author  87814   algs4.xufei
    @Date  2019/3/25    13:25
*//*
    @Author  87814   algs4.xufei
    @Date  2019/3/25    13:25
*/

//打印两个有序链表的公共部分
public class Question_10_printQue {

    public static void main(String[] args) {
        Node temp=new Node(Integer.MIN_VALUE);
        Node head1=temp;
        for (int i = 0; i <15 ; i++) {
            Node node = new Node(i);
            temp.next=node;
            temp=node;
        }

        Node temp2=new Node(Integer.MIN_VALUE);
        Node head2=temp2;
        for (int i = 7; i <25 ; i++) {
            Node node = new Node(i);
            temp2.next=node;
            temp2=node;
        }
        Node cur=head1.next;
        while (cur!=null){
          //  System.out.println(cur.val);
            cur= cur.next;
        }
        printCommon(head1.next,head2.next);
    }

    private static void printCommon(Node head1, Node head2) {
        int i =0;
        int j =0;
        //类似于快排  归并 那个小 那个走 相等打印  一个到头停止
        while (head1!=null||head2!=null){
            if (head1.val>head2.val){
                head2=head2.next;
            }else if (head1.val<head2.val){
                head1=head1.next;
            }else {
                System.out.println(head1.val);
                head1=head1.next;
            }
            if (head1==null||head2==null){
                break;
            }
        }
    }

}
class Node{
    Node next;
    int val;
    public Node(int val){
        this.val =val;
    }

}

