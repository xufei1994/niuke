package com.basic.part4.question;/*
    @Author  87814   algs4.xufei
    @Date  2019/3/31    22:01
*//*
    @Author  87814   algs4.xufei
    @Date  2019/3/31    22:01
*/


import javafx.scene.effect.SepiaTone;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
      if (pNode==null){ return null;}
      if (pNode.right!=null){
          pNode=pNode.right;
          while (pNode.left!=null){
              pNode=pNode.left;
          }
          return pNode;
      }
      while (pNode.next!=null){
          if (pNode==pNode.next.left){
              return  pNode.next;  //x 是p的左孩子嘛
          }
          pNode=pNode.next;
      }
      return null;
    }
/*
add        增加一个元索                     如果队列已满，则抛出一个IIIegaISlabEepeplian异常
remove   移除并返回队列头部的元素    如果队列为空，则抛出一个NoSuchElementException异常
element  返回队列头部的元素             如果队列为空，则抛出一个NoSuchElementException异常
offer       添加一个元素并返回true       如果队列已满，则返回false
poll         移除并返问队列头部的元素    如果队列为空，则返回null
peek       返回队列头部的元素             如果队列为空，则返回null
put         添加一个元素                      如果队列满，则阻塞
take        移除并返回队列头部的元素    
---------------------
作者：乐不思书
来源：CSDN
原文：https://blog.csdn.net/hui12581/article/details/45023197
版权声明：本文为博主原创文章，转载请附上博文链接！
 */


    //先序遍历序列化
    String Serialize(TreeNode root) {
        if (root==null){
            return "#_";
        }
        String res = root.val+"_";
        res+=Serialize(root.left);
        res+=Serialize(root.right);
        return res;
    }
    TreeNode Deserialize(String str) {
        String[] value = str.split("_");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i !=value.length ; i++) {
            ((LinkedList<String>) queue).offer(value[i]);
        }
        return  reconPreOrder(queue);
    }

    private TreeNode reconPreOrder(Queue<String> queue) {
        String value =queue.poll();
        if (value.equals("#")){
            return null;
        }
        TreeNode head = new TreeNode(Integer.valueOf(value));
        head.left=reconPreOrder(queue);
        head.right=reconPreOrder(queue);
        return head;
    }


    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

}
