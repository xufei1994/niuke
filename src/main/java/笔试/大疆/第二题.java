package 笔试.大疆;/*
    @Author  87814   xufei
    @Date  2019/8/6    11:41
*//*
    @Author  87814   xufei
    @Date  2019/8/6    11:41
*/


import java.util.ArrayList;
import java.util.Scanner;

public class 第二题 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        while (scanner.hasNext()){
            int N = scanner.nextInt(); // 总金额
            int X = scanner.nextInt(); // 零食种类
            int[] value = new int[X+1];
            int[] agree = new int[X+1];
            int[] number = new int[X+1];
            scanner.nextLine();
            for (int i= 1; i <=X ; i++) {
                String[] strings1 =scanner.nextLine().split(" ");
                value[i] = Integer.parseInt(strings1[0]);
                agree[i] = Integer.parseInt(strings1[1]);
                number[i] = Integer.parseInt(strings1[2]);

            }
            System.out.println(f(N,X,value,agree,number));
        }

    }
    private static int f(int allPaice, int n, int[] value, int[] agree, int[] number) {
        //这是一个明显的动态规划问题
        int[] dp= new int[allPaice+2];
        for (int i = 0; i <=n ; i++) { //物品种类
            for (int j = allPaice; j >=0 ; j--) {
                for (int k = 0; k <=number[i]&&k*value[i]<=j ; k++) {
                    dp[j]=Math.max(dp[j],dp[j-k*value[i]]+k*agree[i]);
                }
            }
        }
        return dp[allPaice];
    }

}
