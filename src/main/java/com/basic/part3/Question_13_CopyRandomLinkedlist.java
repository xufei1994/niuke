package com.basic.part3;/*
    @Author  87814   xufei
    @Date  2019/3/25    19:53
*//*
    @Author  87814   xufei
    @Date  2019/3/25    19:53
*/

import java.util.HashMap;

//不考虑空间采用哈希的方式
public class Question_13_CopyRandomLinkedlist {
    public static RandomListNode copyListWithRand2(RandomListNode head) {
        if (head == null) {
            return null; }
        RandomListNode cur = head;
        RandomListNode next = null;
        // copy node and link to every node
        while (cur != null) {
            next = cur.next;
            cur.next = new RandomListNode(cur.label);
            cur.next.next = next;
            cur = next;
        }
        cur = head;
        RandomListNode curCopy = null;
        // set copy node rand
        while (cur != null) {
            next = cur.next.next;
            curCopy = cur.next;
            curCopy.random = cur.random != null ? cur.random.next : null;
            cur = next;
        }
        RandomListNode res = head.next;
        cur = head;
        // split
        while (cur != null) {
            next = cur.next.next;
            curCopy = cur.next;
            cur.next = next;
            curCopy.next = next != null ? next.next : null;
            cur = next;
        }
        return res;
    }


    public RandomListNode Clone(RandomListNode pHead)
    {
        HashMap<RandomListNode,RandomListNode> map=new HashMap<>();
        RandomListNode cur= pHead;
        while (cur!=null){
            map.put(cur,new RandomListNode(cur.label));
            cur=cur.next;
        }

        cur =pHead;
       while (cur!=null){
           map.get(cur).next=map.get(cur.next);
           map.get(cur).random=map.get(cur.random);
           cur=cur.next;
       }
       return map.get(pHead);
    }
}
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}