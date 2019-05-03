package com.basic.advance.advanced_class_03.RBT.warmup.bst.rbt;/*
    @Author  87814   algs4.xufei
    @Date  2018/11/5    21:05
*//*
    @Author  87814   algs4.xufei
    @Date  2018/11/5    21:05
*/

/*

1.是一个二叉搜索树

2.每个节点要么是红的，要么是黑的

3.根节点是黑色的，并定义null 为 黑色

4.如果一个子结点是红色的，那么它的两个儿子都是黑色，且父节点也是黑色

5.对于任意一个结点而言，它到叶节点的每一条路径都包含相同数目的的黑色结点，称之为黑高

6.任意一棵以黑色节点为根的子树也必定是一颗红黑树

7.左右子树的高度最多是左右子树的两倍，则：若H（left）>H(right)  则 H(left)<=2*H(right)+1

-------------------------------------------------------------
无需调整的情况为：
   x为根节点，将X由红染黑，简称rootOver
   父节点P为黑色，BlackParentOver ，简称BpOver
仅仅需要考虑父节点P为红色的情况，由于性质4，爷爷的节点G必定为黑色可以分为下面三种情况
1.Y为红色，X可左可右：P，Y染黑，G染红  X 回溯至G
2.Y为黑色，X为右孩子：左旋P，X指向P，转换为3
3.Y为黑色，X为左孩子；P染黑，G染红，右旋G，结束

RBT的插入调整最多旋转2次

正在处理的节点X，也叫子节点
父节点P
爷爷节点G
叔叔节点Y
A3表示黑高为3的红黑树

 */
/*
利用 反射 输出map内部的变量信息，比如root
 */
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

//红黑树的辅助工具
public class ReflectUtilForTreeMap {
    public static Class<?> entryClass;
    public static Field leftField;
    public static Field rightField;
    public static Class<?> treeMapClass;
    public static Field rootField;
    public static Field colorFiled;
    static{
        try {
            //因为红黑树里的属性都是私有的 ，因此我们编辑一个工具类来查看的属性，打开封装
            entryClass=Class.forName("java.util.TreeMap$Entry");
            leftField=entryClass.getDeclaredField("left");
            leftField.setAccessible(true);
            rightField=entryClass.getDeclaredField("right");
            rightField.setAccessible(true);
            treeMapClass=TreeMap.class;
            rootField=treeMapClass.getDeclaredField("root");
            rootField.setAccessible(true);
            colorFiled=entryClass.getDeclaredField("color");
            colorFiled.setAccessible(true);
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
    //打印节点
    private static <K,V> void printTreeNode(Map.Entry<K, V> p) throws Exception{
        boolean color=(Boolean) colorFiled.getBoolean(p);
        String colorStr="";
        if(color){
            colorStr="BLACK";
        }else{
            colorStr="RED";
        }
        System.out.print(p.getKey()+"-"+colorStr+"-"+p.getValue()+"  ");
    }
    /**
     * 层序输出JDK的红黑树
     */
    @SuppressWarnings("unchecked")
    public static <K,V> void levelOrderPrintTree(TreeMap<K,V> map) throws Exception{
        Map.Entry<K, V> root=(Map.Entry<K, V>) rootField.get(map);
        if(root==null){
            return;
        }
        Queue<Map.Entry<K, V>> queue=new LinkedList<Map.Entry<K, V>>();
        queue.offer(root);
        int preCount=1; //上一层的数量
        int pCount=0;   //下一层的计数器
        while(!queue.isEmpty()){
            Map.Entry<K, V> p=queue.poll();
            preCount--;
            printTreeNode(p);
            if((Map.Entry<K, V>)leftField.get(p)!=null){
                queue.offer((Map.Entry<K, V>)leftField.get(p));
                pCount++;
            }
            if((Map.Entry<K, V>)rightField.get(p)!=null){
                queue.offer((Map.Entry<K, V>)rightField.get(p));
                pCount++;
            }
            //经典的换行操作
            if(preCount==0){
                preCount=pCount;
                pCount=0;
                System.out.println();
            }
        }
        System.out.println("------------------------");
    }
}