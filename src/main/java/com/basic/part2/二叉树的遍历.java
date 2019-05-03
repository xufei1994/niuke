package com.basic.part2;/*
    @Author  87814   xufei
    @Date  2019/4/19    13:44
*//*
    @Author  87814   xufei
    @Date  2019/4/19    13:44
*/


/*
当前节点为cur
1.如果cur无左孩子，cur向右移动（cur =cur.right）
2.如果cur有左孩子，找到cur的左子树最右的节点，记为mostright，
如果mostright的right指针指向空，让其指向cur cur向左移动（cur=cur.left）
如果mostright的right指针指向cur，让其指向空 cur向右移动（cur=cur.right）
 */
public class 二叉树的遍历 {
    public class Node{
        private int value;
        private Node left;
        private Node right;
        public Node(int data){
            this.value=data;
        }
    }
    public static void morrisIn(Node head){
        if (head == null){
            return;
        }
        Node cur = head;
        Node mostright = null;
        while (cur!=null){
            if (cur.left==null){//1
               cur=cur.right;
            }else {//2 cur 有左孩子
                mostright=cur.left; //如果不满足while，则说明mostright 就是mostright
               while (mostright.right!=null&&mostright.right!=cur){
                       mostright=mostright.right;
                   }
                   if (mostright.right==null){
                       mostright.right=cur;
                       cur=cur.left;
                   }else {
                       cur=cur.right;
                       mostright.right=null;
                   }
               }

            }

        }


//下面代码优化了上面代码
    public static void morrisInByIn(Node head){
        if (head ==null){
            return;
        }
        Node cur =head;
        Node mostright =null;
        while (cur!=null){
            mostright=cur.left;
            if (mostright!=null){ //左孩子不为空 直接执行第二步 如果cur有左孩子，找到cur的左子树最右的节点，记为mostright，
                while (mostright.right!=null&&mostright.right!=cur){
                    mostright=mostright.right;
                }
                if (mostright.right ==null){
                    mostright.right=cur;
                    cur=cur.left;
                    continue;
                }else {
                    mostright.right =null;
                }
            }
            System.out.print(" "+cur.value);  
            cur=cur.right;     //1 如果cur无左孩子，cur向右移动（cur =cur.right）
        }
        System.out.println();
    }

    public static void morrisInByPre(Node head){
        if (head ==null){
            return;
        }
        Node cur =head;
        Node mostright =null;
        while (cur!=null){
            mostright=cur.left;
            if (mostright!=null){ //左孩子不为空 直接执行第二步 如果cur有左孩子，找到cur的左子树最右的节点，记为mostright，
                while (mostright.right!=null&&mostright.right!=cur){
                    mostright=mostright.right;
                }
                if (mostright.right ==null){
                    mostright.right=cur;
                    cur=cur.left;
                    System.out.print(cur.value+" "); //第一次来到右孩子
                    continue;
                }else {
                    mostright.right =null;
                }
            }else {
                System.out.print(" "+cur.value);    //第一次来到左孩子
            }

            cur=cur.right;     //1 如果cur无左孩子，cur向右移动（cur =cur.right）
        }
        System.out.println();
    }

    public static void morrisInByPost(Node head){
        if (head ==null){
            return;
        }
        Node cur =head;
        Node mostright =null;
        while (cur!=null){
            mostright=cur.left;
            if (mostright!=null){ //左孩子不为空 直接执行第二步 如果cur有左孩子，找到cur的左子树最右的节点，记为mostright，
                while (mostright.right!=null&&mostright.right!=cur){
                    mostright=mostright.right;
                }
                if (mostright.right ==null){
                    mostright.right=cur;
                    cur=cur.left;
                    continue;
                }else {
                    mostright.right =null;
                  printEdge(cur.left);   //逆序打印左子树的 右边界
                }
            }
            cur=cur.right;     //1 如果cur无左孩子，cur向右移动（cur =cur.right）
        }
        printEdge(head);  //逆序打印整个树的右边界
        System.out.println();
    }

    private static void printEdge(Node left) {
    }

}
