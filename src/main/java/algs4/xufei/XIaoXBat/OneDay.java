package algs4.xufei.XIaoXBat;/*
    @Author  87814   algs4.xufei
    @Date  2018/8/6    17:51
*//*
    @Author  87814   algs4.xufei
    @Date  2018/8/6    17:51
*/


import java.util.Random;
import java.util.Scanner;

public class OneDay {
    public static void main(String[] args) {
        int m, n;  // 输入要改变部分的链表起始位置和结束位置
        int len = 0;
        int mid = 0;  // 若是从中间翻转，需先求出中间结点的位置
        // 生成0~100内的随机数
        Random random = new Random(100);
        // 初始化一个单链表，头结点为空
        Node head = new Node();
        Node pre = head;
        for (int i = 0; i < 20; i++) {
            Node node = new Node(random.nextInt(100));
            pre.next = node;  // 尾插法构建链表
            pre = node;
        }
        System.out.print("原链表：");
        print(head.next);
        len = getLinkedLength(head);
        if(len % 2 == 1) {
            mid = (1 + len) / 2;
        } else {
            mid = len / 2;
        }
        System.out.println("翻转链表的范围m和n：");
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        System.out.println("m = " + m + " n = " + n);
        // 翻转链表
        reverse(head, m, n);
        // 若是想翻转链表的前半部分或者后半部分，由mid值传入合适参数即可
        // reverse(head, mid+1, len);
        System.out.print("翻转之后的链表：");
        print(head.next);
    }

    /**
     * 打印输出链表的结点值
     */
    public static void print(Node head) {
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    /**
     * 获取链表的长度
     */
    public static int getLinkedLength(Node head) {
        int len = 0;
        while(head.next != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    /**
     * 翻转链表的从结点m到结点n的部分
     *
     * @param head 连标点额头结点
     * @param m 翻转的开始位置
     * @param n 翻转的结束位置
     * @return 翻转后的新链表
     */
    public static void reverse(Node head, int from, int to) {
        if (from >= to) return;
        Node cur = head.next;
        int i;
        for (i = 0; i < from - 1; i++) {
            head = cur;
            cur = cur.next;
        }
        Node pre = cur;
        cur = cur.next;
        to--;
        Node next;

        print(head.next);
        for (; i < to; i++) {
            next = cur.next;
            cur.next = head.next;  // 采用头插法
            head.next = cur;
            pre.next = next;
            cur = next;

            print(head.next);
        }
    }


}