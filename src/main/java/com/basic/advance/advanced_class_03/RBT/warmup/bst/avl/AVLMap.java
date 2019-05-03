package com.basic.advance.advanced_class_03.RBT.warmup.bst.avl;/*
    @Author  87814   algs4.xufei
    @Date  2018/11/3    11:09
*//*
    @Author  87814   algs4.xufei
    @Date  2018/11/3    11:09
*/


import org.junit.Assert;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class AVLMap<K, V> implements Iterable<AVLEntry<K, V>> {
    private int size;
    private AVLEntry<K, V> root;
    private Comparator<K> comparator;   //比较器
    private LinkedList<AVLEntry<K,V>> stack = new LinkedList<>();  //辅助栈 实现 插入调整的非递归算法

    @SuppressWarnings("unchecked")
    private int compare(K a, K b) {  //比较关键字的大小
        if (comparator != null) {
            return comparator.compare(a, b);
        } else {
            Comparable<K> c = (Comparable<K>) a;
            return c.compareTo(b);
        }
    }

    public AVLMap() {
    }

    public AVLMap(Comparator<K> comparator) {
        this.comparator = comparator;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0 ? true : false;
    }

    public V put(K key, V value) {
        if (root == null) {
            root = new AVLEntry<>(key, value);
            stack.push(root);  // 要把插入时的所有路径全部压栈
            size++;
        } else {
            AVLEntry<K, V> p = root;
            while (p != null) {
                stack.push(p);
                int compareResult = compare(key, p.key);
                if (compareResult == 0) {
                    p.setValue(value);
                    break;
                } else if (compareResult < 0) {
                    if (p.left == null) {
                        p.left = new AVLEntry<>(key, value);
                        size++;
                        stack.push(p.left);
                        break;
                    } else {
                        p = p.left;
                    }
                } else { //1
                    if (p.right == null) {
                        p.right = new AVLEntry<>(key, value);
                        size++;
                        stack.push(p.right);
                        break;
                    } else {//2
                        p = p.right;
                    }//2
                }//1

            }//while

        }//else
        fixAfterInsertion(key);
        return value;
    }

    private void fixAfterInsertion(K key){
        AVLEntry<K,V> p =root;  //定义一个指针p
        while (!stack.isEmpty()){  //弹栈  不断弹栈的过程就是指针回溯的过程
            p=stack.pop();
            int newHeight = Math.max(getHeight(p.left),getHeight(p.right))+1;  //重新计算节点p的高度
            if (p.height>1&&newHeight==p.height){    //  高度并未发生改变
                stack.clear();
                return;
            }
            p.height = newHeight;
            int d= getHeight(p.left) - getHeight(p.right);  //平衡因子
            if (Math.abs(d)<=1){
                continue;
            }else {
                if (d==2){ //说明是左子树
                    if(compare(key,p.left.key)<0){
                        //情况一（左子树的左子树）
                        p=rotateRight(p);
                    }else {
                        //情况二（左子树的右子树）
                        p=firstLeftThenRight(p);
                    }
                }else {    // 否则说明是右子树
                    if (compare(key,p.right.key)>0){
                        //情况三（右子树的右子树）
                        p=rotateLeft(p);
                    }else {
                        //情况四（右子树的左子树）
                        p=firstRightThenLeft(p);
                    }
                }
                //确定爷爷节点
                if (!stack.isEmpty()){
                    if (compare(key,stack.peek().key)<0){  //关键字小于栈顶元素
                        //表明插入到了左子树
                        stack.peek().left = p;
                    }else {
                        //插入到了右子树
                        stack.peek().right= p;
                    }
                }

            }
        }
        root =p;
    }

    //用于检测整个树是否是平衡的
    public void checkBalance(){
        postOrderCheckBalance(root);
    }

    private void postOrderCheckBalance(AVLEntry<K,V> p){
        if (p!=null){
            postOrderCheckBalance(p.left);
            postOrderCheckBalance(p.right);
            Assert.assertTrue(Math.abs(getHeight(p.left)-getHeight(p.right))<=1);
        }
    }



    public int getHeight(AVLEntry<K,V>  p) {
        return  p == null?0:p.height;
    }


    /*
     插入key到左子树引起平衡改变，及平衡因子为正数
     插入key到右子树引起平衡改变，及平衡因子为负数
     */

    //情况一  保证封装 将public 改为 private     key<left.key
    private AVLEntry<K,V>  rotateRight(AVLEntry<K,V> p){
        //首先取得p的左子树 L,(右子树为R)，L的左子树为L-left 右子树L-right，右旋L的左子树不动，
        //  L代替P成为P.parent的子节点，L成为P的父节点，P的左子树为L-right，右子树为R
        AVLEntry<K,V> left =p.left;  //（注释中的L,要和p做交换）  找到L
        p.left=left.right ; // 将left的右子树 指向节点p的左子树  P的左子树为L-right
        left.right = p;    //p作为left的右子树   右旋左子树不动，p节点变为L的右子树


        p.height=Math.max(getHeight(p.left),getHeight(p.right))+1;
        left.height=Math.max(getHeight(left.left),p.height)+1;
        return left;
    }

    //情况三
    private AVLEntry<K,V> rotateLeft(AVLEntry<K,V> p){
        //首先取得 p的右子树，左旋右子树保持不变，p 左右孩子是L R   R的左右孩子是R-left R-right
        //  左旋保持右子树不变，即R-right不动，R变为p的父节点，p为R的左子树，p的左子树不变，右子树为R-left
        AVLEntry<K,V> right = p.right;   //  取得R节点
        p.right = right.left;           //   p的右孩子为R的左子树
        right.left=p;                  //    p变为R的左子树
        p.height=Math.max(getHeight(p.left),getHeight(p.right))+1;
        right.height = Math.max(p.height,getHeight(right.right))+1;
        return right;
    }

    //先左旋后右旋    情况二
    private AVLEntry<K,V>  firstLeftThenRight(AVLEntry<K,V> p){
        p.left = rotateLeft(p.left);
        p=rotateRight(p);
        return p;
    }


    //先右旋后左旋   情况四
    private AVLEntry<K,V>  firstRightThenLeft(AVLEntry<K,V> p){
        p.right = rotateRight(p.right);
        p=rotateLeft(p);
        return p;
    }

    private AVLEntry<K, V> getEntey(K key) {
        AVLEntry<K, V> p = root;
        while (p != null) {
            int compareResult = compare(key, p.key);
            if (compareResult == 0) {
                return p;
            } else if (compareResult < 0) {
                p = p.left;
            } else {
                p = p.right;
            }
        } //while
        return null;
    }

    public boolean containsKey(K key) {
        AVLEntry<K, V> p = getEntey(key);
        return p != null;
    }

    public V get(K key) {
        AVLEntry<K, V> p = getEntey(key);
        return p != null ? p.getValue() : null;
    }

    public boolean containsValue(V value) {
        Iterator<AVLEntry<K, V>> itr = this.iterator();
        while (itr.hasNext()) {
            if (itr.next().getValue().equals(value)) {
                return true;
            }
        }
        return false;
    }

    public AVLEntry<K, V> getFirstEntry(AVLEntry<K, V> p) {
        if (p == null) {
            return null;
        }
        while (p.left != null) {
            p = p.left;
        }
        return p;
    }

    public AVLEntry<K, V> getLastEntry(AVLEntry<K, V> p) {
        if (p == null) {
            return null;
        }
        while (p.right != null) {
            p = p.right;
        }
        return p;
    }

    public AVLEntry<K, V> deleteEntry(AVLEntry<K, V> p, K key) {
        if (p == null) {
            return null;
        } else {//0
            int cmopareResult = compare(key, p.key);
            if (cmopareResult == 0) {  //没有孩子为叶子节点，直接删除
                if (p.left == null && p.right == null) {
                    p = null;
                } else if (p.left != null && p.right == null) {
                    p = p.left;  //有一个孩子 将孩子赋值给父亲，即可
                } else if (p.right != null && p.left == null) {
                    p = p.right;
                } else {   //1 有两个孩子,找到右子树的最小值 ，
                    if ((size & 1) == 0) {
                        AVLEntry<K, V> rightMin = getFirstEntry(p.right);
                        p.key = rightMin.key;
                        p.value = rightMin.value;  //右子树中删除 key
                        AVLEntry<K, V> newRight = deleteEntry(p.right, p.key);
                        p.right = newRight;
                    } else {//2
                        if ((size & 1) == 0) {  //左子树的最大值
                            AVLEntry<K, V> leftMax = getLastEntry(p.left);
                            p.key = leftMax.key;
                            p.value = leftMax.value;  //左子树中删除key
                            AVLEntry<K, V> newLeft = deleteEntry(p.left, p.key);
                            p.left = newLeft;
                        }
                    }//2
                }//1
            } else if (cmopareResult < 0) {
                AVLEntry<K, V> newLeft = deleteEntry(p.left, key);
                p.left = newLeft;
            } else {
                AVLEntry<K, V> newRight = deleteEntry(p.right, key);
                p.left = newRight;
            }
            fixAfterDeletion(p);
            return p;
        }//0

    }

    public AVLEntry<K,V> fixAfterDeletion(AVLEntry<K,V> p){
        if (p==null){ // 边界检查
            return null;
        }else {
            p.height = Math.max(getHeight(p.left),getHeight(p.right))+1;  //计算节点P的高度
            int d = getHeight(p.left) - getHeight(p.right);              //计算平衡因子
            if (d == 2){
                if (getHeight(p.left.left)-getHeight(p.left.right)>=0){  //左子树高度大于右子树，满足情况一二
                    p =rotateRight(p);
                }else {
                    p = firstLeftThenRight(p);
                }
            }else if (d==-2){
                if (getHeight(p.right.right)-getHeight(p.right.left)>=0){
                    p =rotateLeft(p);
                }else{
                    p = firstRightThenLeft(p);
                }
            }
            return p;
        }
    }


    public V remove(K key) {
        AVLEntry<K, V> entry = getEntey(key);
        if (entry == null) {
            return null;
        }
        V oldValue = entry.getValue();
        root = deleteEntry(root, key);
        size--;
        return oldValue;
    }

    public void levelOrder() {
        Queue<AVLEntry<K, V>> queue = new LinkedList<>();
        queue.offer(root);
        int preCount = 1;
        int pCount = 0;
        while (!queue.isEmpty()) {
            preCount--;
            AVLEntry<K, V> p = queue.poll();
            System.out.println(p + " ");
            if (p.left != null) {
                queue.offer(p.left);
                pCount++;
            }
            if (p.right != null) {
                queue.offer(p.right);
                pCount++;
            }
            if (preCount == 0) {
                preCount = pCount;
                pCount = 0;
                System.out.println();
            }
        }
    }




    @Override
    public Iterator<AVLEntry<K, V>> iterator() {
        return new AVLIterator<K, V>(root);
    }
}