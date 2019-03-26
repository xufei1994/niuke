package com.basic.part1;/*
    @Author  87814   xufei
    @Date  2019/3/20    21:38
*//*
    @Author  87814   xufei
    @Date  2019/3/20    21:38
*/

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

//其他数都出现K次中找只出现一次的数，时间复杂度O(N)，空间复杂度1
public class Test05 {
    public static void main(String[] args) {
        int[] arr= new int[]{3,3,3,5,5,5,9,9,9,8,8,8,7,7,7,15,4,4,4};
        //int[] arr= new int[]{7,8,9,1,5,6,7,8,9,2,1,5,6,7,8,9,1,5,6};
        System.out.println(findK_Map(arr));
    }


    private static void findK(int[] arr) {

    }
    //使用map  不要求空间
    private static Integer findK_Map(int[] arr) {
        HashMap<Integer,Integer> map =new HashMap<>();
        for (int i = 0; i <arr.length ; i++) {
            if (map.containsKey(arr[i])){
                map.put(arr[i],(map.get(arr[i])+1) );
            }else {
                map.put(arr[i], 1);
            }
        }
        for (Map.Entry<Integer,Integer> entry:map.entrySet()
             ) {
            if (entry.getValue()==1){
                return entry.getKey();
            }
        }
        return null;
//        Integer i=1;
//        return map.entrySet().stream().filter(entry ->i.equals(entry.getValue()))
//                .map((Function<? super Map.Entry<Integer, Integer>, ?>) Map.Entry::getKey);
    }
}
