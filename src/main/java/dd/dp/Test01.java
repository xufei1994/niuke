package dd.dp;


/*
有N件物品和一个容量为V的背包。
第i件物品的重量是c[i]，价值是w[i]。
求解将哪些物品装入背包可使这些物品的费用总和不超过背包容量，且价值总和最大
解题思路： 这是一个基本的背包问题

我可以采用dp[i][j]
其中i  代表容量
其中j  代表价值
价值最大  应该是所有都加在一起
大小堆问题
把
  */

import com.basic.part8.teacher.Code_09_Knapsack;

import java.util.PriorityQueue;

public class Test01 {
    public static void main(String[] args) {
        int V=10;
        int[] weight = {1,2,3,4,8};
        int[] values = {5,9,13,19,37};
        System.out.println(arrange(V,weight,values));
        System.out.println(notDigui(weight,values,V));
        System.out.println(Code_09_Knapsack.maxValue1(weight,values,V));
    }

    private static int arrange(int v, int[] weight, int[] values) {
       return digui(weight,values,0,0,v)-values[values.length-1];
    }

    private static int digui(int[] weight, int[] values, int i, int alreadWeight, int V) {
        if (i==weight.length){
            return 0;
        }
        if (alreadWeight>V){
            return 0;
        }
        return Math.max(
                digui(weight, values, i+1, alreadWeight, V),
                values[i] + digui(weight, values, i+1, alreadWeight+weight[i], V)) ;
    }
    private static int notDigui(int[] weight, int[] values, int V) {
        int[][] dp = new int[values.length+1][V+1];

        for (int i = weight.length - 1; i >= 0; i--) {
            for (int j = V; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j];
                if (j + weight[i] <= V) {
                    dp[i][j] = Math.max(dp[i][j], values[i] + dp[i + 1][j + weight[i]]);
                }
            }
        }

        return dp[0][0];
    }
    
}
