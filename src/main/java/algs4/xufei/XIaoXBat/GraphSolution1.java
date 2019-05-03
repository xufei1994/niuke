package algs4.xufei.XIaoXBat;/*
    @Author  87814   algs4.xufei
    @Date  2018/12/17    12:40
*//*
    @Author  87814   algs4.xufei
    @Date  2018/12/17    12:40
*/


import java.util.*;

public class GraphSolution1 {

    static String start;
    static String end;
    static Set<String> dict;


    // 传进来是start    需要的结果的是end
    public int ladderLength(String start1, String end1, Set<String> dict1){
        start=start1;
        end=end1;
        dict =dict1;

        Queue<String> current=new ArrayDeque<>();  //当前层
        Queue<String> next=new ArrayDeque<>();      //下一层
        Set<String> visited=new TreeSet<>();         //判重
        int level =0;   //层次
        boolean found =false;

        ((ArrayDeque<String>) current).push(start);
        while (!current.isEmpty()&&!found){
            ++level;
            while (!current.isEmpty()&&!found){
                String str =((ArrayDeque<String>) current).pop();  //栈顶元素出栈

                String[] new_states= state_extend(str);
                for (String state:new_states){
                    ((ArrayDeque<String>) next).push(state);
                    if (state_is_target(state)){
                        found=true; //找到了
                        break;
                    }
                }
            }
        }
        if (found) return level+1;
        else return 0;
    }

    private String[] state_extend(String str) {
        LinkedList<String> result=new LinkedList<>();
        for (int i = 0; i <str.length() ; i++) {

        }
        return new String[1];

    }

    public boolean state_is_target(String s){
        return  s ==end;
    }




}
