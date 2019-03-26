package com.basic.part2;/*
    @Author  87814   xufei
    @Date  2019/3/21    13:35
*/
public class Question8_new {
    int max = 0;
  public static int maxGap(int[] nums){
      if (nums == null||nums.length<2){
          return 0; }
      int len = nums.length;
      int min=Integer.MAX_VALUE;
      int max=Integer.MIN_VALUE;
      for (int i = 0; i <len ; i++) {//找到数组中的最大值和最小值
          min=Math.min(min,nums[i]);
          max=Math.max(max,nums[i]); }
      if (min==max){ return 0; }
      boolean[] hasNum =new  boolean[len+1];
      int[] maxs = new int[len+1];
      int[] mins = new int[len+1];
      int bid =0;
      for (int i = 0; i <len ; i++) {
          bid = bucket(nums[i],len,min,max);
          mins[bid]=hasNum[bid]?Math.min(mins[bid],nums[i]):nums[i];
          maxs[bid] = hasNum[bid]?Math.max(maxs[bid],nums[i]):nums[i];
          hasNum[bid]=true;
      }
      int res = 0;
      int lastMax = maxs[0];
      int i=1;
      for(;i<=len;i++){
          if (hasNum[i]){
              res = Math.max(res,mins[i]-lastMax);
              lastMax=mins[i];
          }
      }
      return res;
  }
    private static int bucket(int num, int len, int min, int max) {
      return (int)((num-min)*len/(max-min));
    }
}

