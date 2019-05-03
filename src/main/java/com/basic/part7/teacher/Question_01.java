package com.basic.part7.teacher;/*
    @Author  87814   algs4.xufei
    @Date  2019/4/4    19:23
*//*
    @Author  87814   algs4.xufei
    @Date  2019/4/4    19:23
*/


public class Question_01 {
    private class TrieNode {
        private int path;  //经过的点
        private int end;   //以它结尾
        private TrieNode[] nexts;   //节点数组

        TrieNode() {
            path = 0;
            end = 0;
            nexts = new TrieNode[26];  //假设只有26个节点
        }
    }

        private TrieNode root;
        public void insert(String word){
            if (word==null){
                return;
            }
            char[] chars = word.toCharArray();
            TrieNode node = root;
            int index=0;
            for (int i = 0; i <chars.length ; i++) {
             index = chars[i]-'a';
             if (node.nexts[index]==null){
                 node.nexts[index] = new TrieNode();
             }
             node=node.nexts[index];
             node.path++;
            }
            node.end++;
        }
        public int search(String word){
            if (word == null){return 0;}
            char[] chars =word.toCharArray();
            TrieNode node = root;
            int index = 0 ;
            for (int i = 0; i <chars.length ; i++) {
                index = chars[i]-'a';
                if (node.nexts[index]==null){
                    return 0; //没找到
                }
                node=node.nexts[index];
            }
            return node.end;  //重复插入多少次这个word
        }

        public  void delete(String word){
            if (search(word)!=0){
                char[] chars=word.toCharArray();
                TrieNode node = root;
                int index = 0;
                for (int i = 0; i <chars.length ; i++) {
                    index=chars[i]-'a';
                    if (--node.nexts[index].path==0){  //每一步进来判断 然后path--
                        node.nexts[index]=null;
                        return;
                    }
                    node=node.nexts[index];
                }
                node.end--;
            }
        }

        public int prefixNumber(String pre){
            if (pre==null){
                return 0;
            }
            char[] chars = pre.toCharArray();
            TrieNode node = root ;
            int index = 0;
            for (int i = 0; i <chars.length ; i++) {
                index = chars[i]-'a';
                if (node.nexts[index]==null){
                    return 0;
                }
                node=node.nexts[index];
            }
            return node.path;
        }


}
