package com.basic.part4;/*
    @Author  87814   xufei
    @Date  2019/4/20    22:39
*//*
    @Author  87814   xufei
    @Date  2019/4/20    22:39
*/


import java.util.HashMap;

public class LongestSumSubArrayLength {
    public static void main(String[] args) {
        int[] arr  = new int[]{7,1,2,3,1,7,-1,-6,7,8};
        int target = 7;
        int ans = longestSumSub(arr,target);
        System.out.println(ans);
        System.out.println(longestSum(arr));

    }

    private static int longestSumSub(int[] arr, int target) {
        HashMap<Integer,Integer> map =new HashMap<>();
        int sum=0;
        int max=0;
            map.put(sum,-1);
        for (int i = 0; i <arr.length ; i++) {
            sum+=arr[i];
           if (map.containsKey(sum-target)){ //如果包含
               int temp=i-map.get(sum-target);
               max =Math.max(temp,max);
           }
           if (!map.containsKey(sum)){
                map.put(sum,i);
            }
        }
         return max;
    }

    //一个数组中只包含奇数和偶数，求奇数和偶数相等的最长子数组
    //将问题转换  奇数为-1  偶数为1  求和0的最长子数组

    private static int longestSum(int[] arr){
        int temp[] =new int[arr.length];
        for (int i = 0; i <arr.length ; i++) {
            temp[i]=arr[i]%2==0?1:-1;
        }
        int maxLen =0;
        int sum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        //将temp数组 赋值为 只包含0 和 1 的数组
        for (int i = 0; i <temp.length ; i++) {
            sum=sum+temp[i];
            if (map.containsKey(sum)){
                    int maxTemp = i - map.get(sum);
                    maxLen = Math.max(maxLen,maxTemp);
            }

            if (!map.containsKey(sum)){
                map.put(sum,i);
            }
        }
        return maxLen;
    }

    /*
    定义数组的 异或概念 数组中所有的数异或起来，得到的结果叫做数组的异或和
    比如数组（3,2,1）的异或和是，3^2^1 = 0
    给定一个数组arr，你可以任意把 arr分成很多不相容的子数组，你的目的是：
    分出来的子数组中，异或和为0的子数组最多
    分出来的子数组中，异或和为0的子数组最多是多少

    异或运算满足交换律 和结合律  0和n异或还为n
    1.i所在的最后一个部分不是异或和为0的子数组
    2.i所在的最后一个部分是异或和为0的子数组

    0--i 整体异或的结果为sum 从0到i-1中间异或还是sum的最晚的位置，最晚的位置下一个位置就是k这个位置
     */
    private static int moreArr(int[] arr){
        int ans = 0 ;
        int xor = 0;
        int[] dp = new int[arr.length];
        HashMap<Integer,Integer> map =new HashMap<>();
        map.put(0,-1);
        for (int i = 0; i <arr.length ; i++) {
            xor ^= arr[i];
            if (map.containsKey(xor)) {
                int pre = map.get(xor);
                dp[i] = pre == -1 ? 1 : dp[pre]+ 1;
            }
            if (i > 0) {
                dp[i] = Math.max(dp[i - 1], dp[i]);
            }
            map.put(xor, i);
            ans = Math.max(ans, dp[i]);
        }
        return ans;

    }




}
