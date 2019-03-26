package com.basic.part2;/*
    @Author  87814   xufei
    @Date  2019/3/26    22:05
*//*
    @Author  87814   xufei
    @Date  2019/3/26    22:05
*/


public class ReverseList {
    //输入一个链表，反转链表后，输出新链表的表头。
    //反转数组
    public ListNode ReverseList(ListNode head){
        if(head==null){
            return null;
        }

        ListNode next =null;
        ListNode pre =null;
        while (head!=null){
            next =head.next;
            head.next=pre;
            pre=head;
            head=next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(3);
        ListNode l4=new ListNode(4);
        ListNode l5=new ListNode(5);
        ListNode l6=new ListNode(6);
        ListNode l7=new ListNode(7);
        ListNode l8=new ListNode(8);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        l5.next=l6;
        l6.next=l7;
        l7.next=l8;
        ListNode next=l1;
        for (int i = 0; i <8 ; i++) {
            System.out.print(next.val);
            next=next.next;
        }
        System.out.println();

//        ListNode newHead=reverseList(l1);
//        for (int i = 0; i <8 ; i++) {
//            System.out.println(newHead.val);
//            newHead=newHead.next;
//        }

        reversePartOfList(l1,l1,l8);
        ListNode frist=l8;
        for (int i = 0; i <8 ; i++) {
            System.out.print(frist.val);
            frist=frist.next;
        }
    }

    //下面开始测试局部链表翻转  123456789----123 987654    123456789     123 654 789
    public static void reversePartOfList(ListNode node,ListNode begin,ListNode end){

        ListNode p1=new ListNode(0);
        p1.next=node;
        ListNode p2=new ListNode(9);
        ListNode temp0=p1;
        while(temp0.next!=null){
            temp0=temp0.next;
        } temp0.next=p2;   //将9 和 尾部最后一个节点相连



        ListNode temp1=p1;
        while (temp1.next!=begin){
            temp1=temp1.next;
        } p1=temp1;//哨兵1  记录断开的前一个节点
        System.out.println(p1.val);


        ListNode temp2=p1;
        while (temp2.next!=null&&temp2.next!=end){
            temp2=temp2.next;
        }
        p2=temp2.next.next;//哨兵  记录断开的后一个节点
        System.out.println(p2.val);

        end.next=null;
        p1.next=null;
        ListNode partBegin=reverseList(begin);

        ListNode temp3=partBegin;
        while (temp3.next!=null){
            temp3=temp3.next;
        }
        ListNode partEnd=temp3;
        System.out.println(partBegin.val+"   "+partEnd.val);
        p1.next=partBegin;
        partEnd.next=p2;


    }

    //题目描述
    //输入一个链表，反转链表后，局部翻转链表
    public static ListNode reverseList(ListNode head) {
        if (head==null){
            return null;
        }
        ListNode pre=null;
        ListNode next=null;
        while(head!=null){
            next=head.next;
            head.next=pre;
            pre=head;
            head=next;
        }
        return pre;
    }

/*
头插法局部链表反转
    逻辑  四个指针 head  pre  cur next     head为哨兵不动  pre为尾节点值不变位置在移动 
     每次就是将cur插在head后面，将pre与next相连，举例  1 2 3 4        翻转23   
      就是 1=head   2=pre   3=cur  4=next  将3插在2前 完成头插
 翻转234    就是在上一步基础上      将4插在 32前面 1后面   就完成了翻转

找到   head pre cur 三个节点   构造next节点
next=cur.next;
pre.next=head.next;
head.next=cur;
pre.next=next;
cur=next;
 */

    public static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
    /**
     * 翻转链表的从结点m到结点n的部分
     *
     * @param head 头节点
     * @param from 翻转的开始位置
     * @param to 翻转的结束位置
     * @return 翻转后的新链表
    12345678        1 234567 8    1 765432 8
    初始化的Head  头节点为空
     */
    public static void reverseByHead(ListNode head, int from, int to) {
        if(from>to)return;
        ListNode cur=head.next;
        int i;
        for ( i = 0; i <from-1 ; i++) {  //找到断开的前一个节点
            head=cur;    //将前一个节点 标记为 head
            cur=cur.next;    //
        }
        ListNode pre=cur;   //反转的第一个节点即是翻转后的最后一个节点
        cur=cur.next;
        to--;              //必须减减  否则会数组越界
        ListNode next=null;
        for (;i<to;i++){
            next=cur.next;
            cur.next=head.next; //  1234 5678    1=head    2= pre    3=cur    4=next       3.next=(1.next)2    3->2
            head.next=cur;       // 1->3->2
            pre.next=next;        //1->3->2->4 5678
            System.out.println("第i次"+i+ "    "+"next值"+next.val+"   "+"cur值"+cur.val+"   "+"head值"+head.val+"   "+"pre值"+pre.val+"   ");
            cur=next;           //推火车   13245678        1=head   3=head.next  2=pre   4=cur   5=next
        }

    }
}
class ListNode {
    int val;
    ListNode next = null;
    public ListNode() {
    }
    ListNode(int val) {
        this.val = val;
    }
}