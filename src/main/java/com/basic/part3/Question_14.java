package com.basic.part3;/*
    @Author  87814   xufei
    @Date  2019/3/25    20:47
*//*
    @Author  87814   xufei
    @Date  2019/3/25    20:47
*/


import java.util.HashMap;

public class Question_14  {

    //判断有环无环可以使用哈希表
    public Node hasCycle(Node head){
        Node cur = head;
        HashMap<Node,Boolean> map=new HashMap<>();
        while (cur!=null){
            if (map.containsKey(cur)){
                return cur;
            }
            map.put(cur,true);
            cur=cur.next;
        }
        return null;

    }

    //使用哈希判断两个节点是否相交
    public  Node hasJoint(Node phead1,Node phead2){
        HashMap<Node,Boolean> map =new HashMap<>();
        Node cur =phead1;
        while (cur!=null){
            map.put(cur,true);
            cur=cur.next;
        }
        cur=phead2;
        while (cur!=null){
            if (map.containsKey(cur)){
                return cur;
            }
        }
        return null;
    }
    //不使用哈希判断两个节点是否相交
    public  Node hasJoint2(Node phead1,Node phead2){
        int size1 = 0;
        Node  firstLast=null;
        Node cur = phead1;
        while (cur.next!=null){
            size1++;
            cur=cur.next;
        }
        firstLast=cur;  //把最后一个节点赋值给firstLast

        int size2=0;
        Node secondLast=null;
        cur=phead2;
        while(cur.next!=null){
            size2++;
            cur=cur.next;
        }
        secondLast=cur;
        if (firstLast!=secondLast){
            return null;  //说明没有相交
        }
        //长度不相等，假设size1为100，size2为80，然后让1先走20步，
        // 然后一和二一起开始走，他们一定会在一起相遇即为第一个节点
        int i=0;
        Node cur2=phead2;
        if (size1>size2){
            cur =phead1;
            while (i<=size1-size2){
                i++;
                cur=cur.next;
            }
            while (cur!=null){
                if (cur==cur2){
                    return cur;
                }
                cur=cur.next;
                cur2=cur2.next;
            }
        }else if (size1==size2){
            cur=phead1;
            while (cur!=null){
                if (cur==cur2){
                    return cur;
                }
                cur=cur.next;
                cur2=cur2.next;
            }
        }else {//  size2>size1
            cur =phead1;
            while (i<=size2-size1){
                i++;
                cur2=cur2.next;
            }
            while (cur!=null){
                if (cur==cur2){
                    return cur;
                }
                cur=cur.next;
                cur2=cur2.next;
            }
        }
        return null;
    }


    //主问题
    public static Node getIntersectNode(Node head1,Node head2){
        if (head1 ==null ||head2 ==null){
            return null;
        }
        Node loop1 = getLoopNode(head1);  //第一个入环的节点
        Node loop2 = getLoopNode(head1);
        if (loop1 == null && loop2 ==null){
            return noLoop(head1,head2);  //两个无环链表的相交问题
        }
        if (loop1!=null&&loop2!=null){
            return bothLoop(head1,loop1,head2,loop2);
        }
        return null;
    }

    //使用快慢指针判断是否有环，使用两个指针，快指针一次走两步，慢指针一次走一步，快慢指针一定会在环上相遇
    // 相遇后，这个时候快指针从头结点出发，一次走一步，一定会和慢指针相遇在环入口相遇
    private static Node getLoopNode(Node head) {
        if (head==null ||head.next==null||head.next.next==null){
            return null;
        }
        Node n1 = head.next ;   //慢指针
        Node n2 = head.next.next;  //fast
        while (n1!=n2){
            if (n2.next==null||n2.next.next==null){
                return null;
            }
            n2=n2.next.next;
            n1= n1.next;
        }
        n2= head;   //再一次从头开始
        while (n2!=n1){
            n1=n1.next;
            n2=n2.next;
        }
        return n1;
    }


    private static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
        Node cur1 = null;
        Node cur2 = null;
        if (loop1 == loop2) {
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            while (cur1 != loop1) {
                n++;
                cur1 = cur1.next;
            }
            while (cur2 != loop2) {
                n--;
                cur2 = cur2.next;
            }
            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            n = Math.abs(n);
            while (n != 0) {
                n--;
                cur1 = cur1.next;
            }
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        } else {
            cur1 = loop1.next;
            while (cur1 != loop1) {
                if (cur1 == loop2) {
                    return loop1;
                }
                cur1 = cur1.next;
            }
            return null;
        }
    }

    private static Node noLoop(Node head1, Node head2) {
        if (head1 ==null ||head2 ==null){
            return null;
        }
        Node cur1 = head1;
        Node cur2 = head2;
        int n=0;
        while (cur1.next!=null){
            n++;
            cur1=cur1.next;
        }
        while (cur2.next!=null){
            n--;
            cur2=cur2.next;
        }
        if (cur1!=cur2){  //此时两个都走到了尾节点
            return null;
        }
        cur1 =n> 0?head1:head2;
        cur2 = cur1==head1?head2:head1;
        n=Math.abs(n);
        while (n!=0){
            n--;
            cur1=cur1.next;
        }
        while (cur1!=cur2){
            cur1=cur1.next;
            cur2=cur2.next;
        }
          return cur1;
    }

}
