package com.basic.part8;/*
    @Author  87814   xufei
    @Date  2019/5/2    10:40
*//*
    @Author  87814   xufei
    @Date  2019/5/2    10:40
*/


import java.util.HashMap;

public class 求累加和为aim的最长子数组 {
    public static void main(String[] args) {
        int aim = 10;
        int[] arr = new int[]{1, 2, 3, 4, 5, 1, 5, 2, 1, 1, 1, 1, 1, 1, 1,1,1,1,0, 2, 14, 14, 1, 24};
        System.out.println(MaxLength1(arr, aim));
        System.out.println(longestSumSub(arr, aim));
        System.out.println(doubleISumSub(arr, aim));
    }

    //方法1  采取前n项和  暴力法
    private static int MaxLength1(int[] arr, int aim) {
        int[] sum = new int[arr.length + 1];  //为了方便计数
        sum[0] = 0;
        sum[1] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sum[i + 1] = sum[i] + arr[i];
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (sum[j] - sum[i] == aim) {
                    max = Math.max(j - i, max);
                    System.out.println(j + "  " + i);
                }
            }
        }
        return max;
    }

    //方法2
    private static int longestSumSub(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int max = 0;
        map.put(sum, -1);
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum - target)) { //如果包含
                int temp = i - map.get(sum - target);
                max = Math.max(temp, max);
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return max;
    }

    //双指针,准备两个指针 i，j  一开始累加和为6  如果小于目标数 R向右走一位
    private static int doubleISumSub(int[] arr, int target) {
        int i = 0;
        int j = 0;
        //i走  j 不走  i
        int sum = 0;
        int max = 0;
        while (i < arr.length) {
            if (sum <= target) {
                if (sum == target) {
                max = Math.max(i - j , max); }
                sum += arr[i];
                i++;

            }else {
                    sum = sum - arr[j];
                    if (j < arr.length - 1) j++;
                }
            }
        if (sum==target){
            max = Math.max(i - j , max);
        }

        return max;
    }

    public static int getMaxLength(int[] arr,int aim){
        if (arr ==null|| arr.length ==0||aim<=0){
            return 0;
        }
        int L = 0;
        int R = 0;
        int sum = arr[0];
        int len = 0 ;
        while (R<arr.length){
            if (sum == aim){
                len = Math.max(len,R-L+1);
                sum -=arr[L++];
            }else if (sum<aim){
                R++;
                if (R ==arr.length){
                    break;
                }
                sum+=arr[R];
            }else {
                sum -=arr[L++];
            }
        }
        return len;
    }

    //一个包含正数负数0 的数组求小于等于target的最长子数组
    public static int maxLongestAwesome(int[] arr,int k){
        if (arr ==null||arr.length<0){
            return 0;
        }
        int[] sums =new  int[arr.length];
        int[] ends = new  int[arr.length]; //右边界
        sums[arr.length-1]=arr[arr.length-1];
        ends[arr.length-1]=arr.length-1;  //最后一个位置的最小值等于他自己的，所以记录它的下标就是他本身
        for (int i = arr.length-2; i >=0 ; i--) {
            if (sums[i+1]<0){//看它前一项的累加和如果小于0的话，最长等于它加上它前一项的最长
                sums[i]=sums[i+1]+arr[i];
                   ends[i]=ends[i+1];
            }else {
                sums[i]=arr[i];
                ends[i]=i;
            }
        }
        int end = 0;
        int sum = 0;
        int res = 0;
        for (int start = 0; start <arr.length ; start++) { //k=7
            while (end<arr.length&&sum+sums[end]<=k){
                sum+=sums[end];
                end = ends[end]+1;
            }
            sum -=end>start?arr[start]:0;
            res = Math.max(res,end - start);
            end = Math.max(end,start +1);//100 200 7 -6 -3
        }
        return res;
    }
}