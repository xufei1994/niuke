package com.basic.part5;/*
    @Author  87814   xufei
    @Date  2019/4/24    20:06
*//*
    @Author  87814   xufei
    @Date  2019/4/24    20:06
*/

/*
信息1： 左树的最大搜索树的大小
信息2： 右树的最大搜索树的大小
信息3： 左树的最大二叉搜索树的头部
信息4： 右 树的最大二叉搜索树的头部
信息5： 左树的最大值，右树的最小值

 */
public class Tree {
    public static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node(int data){
            this.value =data;
        }
    }

    public static Node biggestSubBST(Node head){
        int[] record = new int[3]; // size  min max
        return null;
    }
    public static class ReturnType{
        public int size;
        public Node head;
        public int min;
        public int max ;

        public ReturnType(int size, Node head, int min, int max) {
            this.size = size;
            this.head = head;
            this.min = min;
            this.max = max;
        }
    }
//  处理消息体  列出可能性 改递归 简化递归
    public static ReturnType process(Node head){
        if (head == null){
            return new ReturnType(0,null,Integer.MAX_VALUE,Integer.MIN_VALUE);
        }
            Node left =head.left;
            ReturnType leftSubTressInfo = process(left);
            Node right =head.right;
            ReturnType rightSubTressInfo = process(right);

            int includeItself = 0;
            if (leftSubTressInfo.head ==left
                    && rightSubTressInfo.head == right
                    && head.value> leftSubTressInfo.max
                    && head.value< leftSubTressInfo.min
                    ){
                includeItself =leftSubTressInfo.size+1+rightSubTressInfo.size;
            }
            int p1 =leftSubTressInfo.size;
            int p2 =rightSubTressInfo.size;
            int maxSize =Math.max(Math.max(p1,p2),includeItself);

            Node maxHead =p1>p2?leftSubTressInfo.head:rightSubTressInfo.head;
            if (maxSize==includeItself){
                maxHead = head;
            }
            return new ReturnType(maxSize,maxHead,
                    Math.min(Math.min(leftSubTressInfo.min,rightSubTressInfo.min),head.value),
                    Math.max(Math.max(leftSubTressInfo.max,rightSubTressInfo.max),head.value)
            );
        }
//  最远距离 改
    public static ReturnType2 processDis(Node head){
        if (head ==null){
            return new ReturnType2(0,0);
        }
        ReturnType2 leftReturnType = processDis(head.left);
        ReturnType2 rightReturnType = processDis(head.right);
        int includeHeadDistance = leftReturnType.maxLength+1+rightReturnType.maxLength;
        int p1 =leftReturnType.maxLength;
        int p2 = rightReturnType.maxLength;
        int resultDistance =Math.max(Math.max(p1,p2),includeHeadDistance);
        int maxDeep = Math.max(leftReturnType.maxDeep,rightReturnType.maxDeep)+1;
        return new ReturnType2(resultDistance,maxDeep);
    }

    public static class ReturnType2{
        public int maxLength;
        public int maxDeep;


        public ReturnType2(int maxLength, int maxDeep) {
            this.maxLength = maxLength;
            this.maxDeep = maxDeep;
        }
    }



}
