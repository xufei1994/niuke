package com.basic.part3;/*
    @Author  87814   algs4.xufei
    @Date  2019/3/25    16:18
*//*
    @Author  87814   algs4.xufei
    @Date  2019/3/25    16:18
*/

import java.util.Arrays;

//将单向链表按某值划分为，左边小的，中间相等的，右边大的形式
public class Question_12_Node {

    public static void main(String[] args) {
        Node temp=new Node(Integer.MIN_VALUE);
        Node head1=temp;
        for (int i = 0; i <20 ; i++) {
            Node node = new Node((int)(Math.random()*10));
            temp.next=node;
            temp=node;
        }
        Node cur=head1.next;
        while (cur!=null){
            System.out.print(cur.val+"  ");
            cur= cur.next;
        }
        int num=6;
        System.out.println();

        Node node=partitionNotSpace(head1.next,num);
        while (node!=null){
            System.out.print(node.val+"  ");
            node= node.next;
        }
    }

    private static Node partitionNotSpace(Node next, int num) {
        //建立六个节点
        Node leftS = null;
        Node leftE = null;
        Node midS = null;
        Node midE = null;
        Node rightS = null;
        Node rightE = null;
        Node temp = null;

      while(next!=null){
          temp = next.next;  //保存下一个节点
          next.next = null;
          if (next.val<num){
              if (leftS==null){
                  leftS = next;
                  leftE = next;
              }else {
                  leftE.next=next;
                  leftE=next;
              }
          }else if (next.val==num){
              if (midS==null){
                  midS=next;
                  midE=next;
              }else {
                  midE.next =next;
                  midE =next;
              }
          }else {
              if (rightS==null){
                  rightS=next;
                  rightE=next;
              }else {
                  rightE.next=next;
                  rightE=next;
              }
          }
          next=temp;
      }
      if (leftE!=null){
          leftE.next=midS;
          midE = midE==null?leftE:midE;
      }
      if (midE!=null){
          midE.next=rightS;
      }
      return leftS!=null?leftS:midS!=null?midS:rightS;

    }

    public static void arrPartition(Node[] nodeArr, int pivot) {
        int small = -1;
        int big = nodeArr.length;
        int index = 0;
        while (index != big) {
            if (nodeArr[index].val < pivot) {
                swap(nodeArr, ++small, index++);
            } else if (nodeArr[index].val == pivot) {
                index++;
            } else {
                swap(nodeArr, --big, index);
            }
        }
    }
    public static void swap(Node[] nodeArr, int a, int b) {
        Node tmp = nodeArr[a];
        nodeArr[a] = nodeArr[b];
        nodeArr[b] = tmp;
    }

    public static void mainArrayNeedSpace(String[] args) {
        Node temp=new Node(Integer.MIN_VALUE);
        Node head1=temp;
        for (int i = 0; i <20 ; i++) {
            Node node = new Node((int)(Math.random()*10));
            temp.next=node;
            temp=node;
        }
        Node cur=head1.next;
        while (cur!=null){
             System.out.print(cur.val+"  ");
            cur= cur.next;
        }
        int num=6;
        System.out.println("----");
        partition(head1.next,num);

        Node cur2=head1.next;
        while (cur2!=null){
            System.out.print(cur2.val+"  ");
            cur2= cur2.next;
        }
    }
    //可以使用空间
    private static void partition(Node head, int num) {
        int size=0;
        Node cur1 = head;
        while (cur1!=null){
            size++;
            cur1=cur1.next;
        }
        int[] arr = new int[size];
        int i=0;
        Node cur2 = head;
        while (cur2!=null){
            arr[i++]=cur2.val;
            cur2=cur2.next;
        }//将链表放到一个数组中
        arr=partitionArray(arr,num);
        System.out.println(Arrays.toString(arr));
        int j=0;
        while (head!=null){
            head.val=arr[j++];
            head=head.next;
        }
    }

    //等于中间，小于左边，大于右边  荷兰国旗 申请空间的
    private static int[] partitionArray(int[] arr, int num) {
        int[] temp=new int[arr.length];
        int j = arr.length-1;
        int k=0;
        for ( int i=0;i <arr.length ; i++) {
            if (arr[i]>num){
                temp[j--]=arr[i];
            }else if (arr[i]==num){

            }else {
                temp[k++]=arr[i];
            }
        }
        if (j==k){
            //说明没有和num相等的,不用添加
        }else {
            for (int i = k; i <=j ; i++) {
                temp[i]=num;
            }
        }
       return temp;
    }
}
