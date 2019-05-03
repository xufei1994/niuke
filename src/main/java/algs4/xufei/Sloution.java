package algs4.xufei;/*
    @Author  87814   algs4.xufei
    @Date  2018/11/4    13:08
*//*
    @Author  87814   algs4.xufei
    @Date  2018/11/4    13:08
*/


//Definition for singly-linked list.


import java.util.HashMap;
import java.util.LinkedList;

//* Definition for binary tree
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


class LeetCodeAVL {

    private int size;
    public TreeNode root;

    private LinkedList<TreeNode> stack = new LinkedList<>();


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0 ? true : false;
    }

    public void put(int key) {
        if (root == null) {
            root = new TreeNode(key);
            stack.push(root);
            size++;
        } else {
            TreeNode p = root;
            while (p != null) {
                stack.push(p);
                int compareResult = key - p.val;
                if (compareResult == 0) {
                    break;
                } else if (compareResult < 0) {
                    if (p.left == null) {
                        p.left = new TreeNode(key);
                        size++;
                        stack.push(p.left);
                        break;
                    } else {
                        p = p.left;
                    }
                } else { //1
                    if (p.right == null) {
                        p.right = new TreeNode(key);
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

    }

    private void fixAfterInsertion(int key) {
        TreeNode p = root;
        while (!stack.isEmpty()) {
            p = stack.pop();
            int newHeight = Math.max(getHeight(p.left), getHeight(p.right)) + 1;
            if (heightMap.containsKey(p) && getHeight(p) > 1 && newHeight == getHeight(p)) {
                stack.clear();
                return;
            }
            heightMap.put(p, newHeight);
            int d = getHeight(p.left) - getHeight(p.right);  //平衡因子
            if (Math.abs(d) <= 1) {
                continue;
            } else {
                if (d == 2) { //说明是左子树
                    if (key - p.left.val < 0) {
                        //情况一
                        p = rotateRight(p);
                    } else {
                        p = firstLeftThenRight(p);
                    }
                } else {
                    if (key - p.right.val > 0) {
                        p = rotateLeft(p);
                    } else {
                        p = firstRightThenLeft(p);
                    }
                }
                //确定爷爷节点
                if (!stack.isEmpty()) {
                    if (key - stack.peek().val < 0) {
                        //表明插入到了左子树
                        stack.peek().left = p;
                    } else {
                        //插入到了右子树
                        stack.peek().right = p;
                    }
                }

            }
        }
    }

    private HashMap<TreeNode, Integer> heightMap = new HashMap<>();


    public int getHeight(TreeNode p) {
        return heightMap.containsKey(p) ? heightMap.get(p) : 0;
    }

    //保证封装 将public 改为 private
    private TreeNode rotateRight(TreeNode p) {
        //首先取得p的左子树 left
        TreeNode left = p.left;
        p.left = left.right; // 将left的右子树 指向节点p的左子树
        left.right = p;    //p作为left的右子树
        heightMap.put(p, Math.max(getHeight(p.left), getHeight(p.right)) + 1);
        heightMap.put(left, Math.max(getHeight(left.left), heightMap.get(p)) + 1);
        return left;
    }

    private TreeNode rotateLeft(TreeNode p) {
        //首先取得 p的右子树
        TreeNode right = p.right;
        p.right = right.left;
        right.left = p;
        heightMap.put(p, Math.max(getHeight(p.left), getHeight(p.right)) + 1);
        heightMap.put(right, Math.max(getHeight(right.left), heightMap.get(p)) + 1);
        return right;
    }

    //先左旋后右旋
    private TreeNode firstLeftThenRight(TreeNode p) {
        p.left = rotateLeft(p.left);
        p = rotateRight(p);
        return p;
    }


    //先右旋后左旋
    private TreeNode firstRightThenLeft(TreeNode p) {
        p.right = rotateRight(p.right);
        p = rotateLeft(p);
        return p;
    }


}

public class Sloution {
    public TreeNode sortedArrayToBST(int[] num) {
        //边界检测
        if (num==null||num.length==0){
            return null;
        }
        LeetCodeAVL avl = new LeetCodeAVL();
        for (int key:num
             ) {
            avl.put(key);
        }
        return avl.root;

    }
}