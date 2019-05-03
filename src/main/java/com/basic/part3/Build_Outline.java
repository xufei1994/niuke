package com.basic.part3;/*
    @Author  87814   xufei
    @Date  2019/4/20    13:55
*//*
    @Author  87814   xufei
    @Date  2019/4/20    13:55
*/


import java.util.*;

public class Build_Outline {

    //记录大楼高度变化的对象
    public class Node{
        public int x; // x轴上的值·
        public boolean isAdd;  //true 为加入 ，false为删除

        public int height; //高度
        public Node(int x, boolean isAdd, int height) {
            this.x = x;
            this.isAdd = isAdd;
            this.height = height;
        }
    }
    //排序的比较策略
    //1.第一个维度的值从小到大
    //2.如果第一个维度的值相等，看第二个维度的值，“加入”排在前，“删除“排在后
    //3.如果两个对象第一维度和第二维度的值都相等，则认为两个对象相等，谁在前都可以
    public class NodeCompparator implements Comparator<Node>{

        @Override
        public int compare(Node o1, Node o2) {
            if (o1.x!=o2.x){
                return o1.x-o2.x;  //按x的坐标排序
            }
            if (o1.isAdd!=o2.isAdd){
                return o1.isAdd?-1:1;  //true  在前  flase在后
            }
            return 0;
        }
    }
    //全部流程的主方法
    public List<List<Integer>> buildongOutline(int[][] maritx){
        Node[] nodes = new Node[maritx.length*2];
        //每一个大楼轮廓数组产生两个描述高度变化的 对象
        for (int i = 0; i <maritx.length ; i++) {
            //matrix [i][0] 起始坐标   matrix [i][1] 终止坐标  matrix [i][2] 高度
            nodes[i*2]=new Node(maritx[i][0],true,maritx[i][2]);
            nodes[i*2+1]=new Node(maritx[i][1],false,maritx[i][2]);
        }
        //把描述高度变化的对象按数组参照的规定的排序策略排序
        Arrays.sort(nodes,new NodeCompparator());
        //treemap 就是java中的红黑树结构，直接当做有序表来使用
        TreeMap<Integer,Integer> mapHeightTimes = new TreeMap<>(); //高度出现的次数
        TreeMap<Integer,Integer> mapXvalueHeight = new TreeMap<>(); //当前x坐标所对应的高度
        for (int i = 0; i <nodes.length ; i++) {
            //如果当前是加入操作
            if (nodes[i].isAdd){
                //没有出现新高度直接添加新纪录
                if (!mapHeightTimes.containsKey(nodes[i].height)){
                    mapHeightTimes.put(nodes[i].height,1);
                }else {//之前出现的高度，次数加一 即可
                    mapHeightTimes.put(nodes[i].height,
                            mapHeightTimes.get(nodes[i].height)+1);
                }
            }else {//如果当前是删除操作
                //如果当前的高度出现次数为1，则直接删除记录
                if (mapHeightTimes.get(nodes[i].height)==1){
                    mapHeightTimes.remove(nodes[i].height);
                }else {//如果当前的高度出现次数大于1，则直接次数-1
                    mapHeightTimes.put(nodes[i].height,
                            mapHeightTimes.get(nodes[i].height)-1);
                }
            }

            //根据mapHeighttimes中的最大高度，设置mapXvalueHeight 表
            if (mapHeightTimes.isEmpty()){//如果mapHeightTimes的表为空，说明最大高度的值为0
                mapXvalueHeight.put(nodes[i].x,0);
            }else {//如果mapHeightTimes的表不为空，说明最大高度的值是mapHeightTimes.lastKey()
                mapXvalueHeight.put(nodes[i].x,mapHeightTimes.lastKey());
            }
        }
        //res为结果数组，每一个List<Integer> 代表一个轮廓线
        //有开始位置，结束位置，和高度，一共三个信息
        List<List<Integer>> res = new ArrayList<>();
        //一个新轮廓线的开始位置
        int start = 0;
        //之前的最大高度
        int preHeight = 0;
        //根据mapXvalueHeight生成res数组
        for (Map.Entry<Integer,Integer> entry : mapXvalueHeight.entrySet()){
            //当前位置
            int curX = entry.getKey();
            //当前的最大高度
            int curMaxHeight = entry.getValue();
            if (preHeight!=curMaxHeight){//之前的最大高度和当前的最大高度不一致
                if (preHeight!=0){
                    res.add(new ArrayList<>(Arrays.asList(start,curX,preHeight)));
                }
                start=curX;
                preHeight = curMaxHeight;
            }
        }
        return res;
    }





}
