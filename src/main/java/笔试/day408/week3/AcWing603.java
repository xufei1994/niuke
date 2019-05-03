package 笔试.day408.week3;/*
    @Author  87814   xufei
    @Date  2019/4/23    21:55
*//*
    @Author  87814   xufei
    @Date  2019/4/23    21:55
*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AcWing603 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        long[] beat = new long[N+1];
        int[] money = new int[N+1];
        String[] strings = bufferedReader.readLine().split(" ");
        String[] strings2 = bufferedReader.readLine().split(" ");
        for (int i = 1; i <=N ; i++) {
            beat[i]=Long.parseLong(strings[i-1]);
            money[i]=Integer.parseInt(strings2[i-1]);
        }
        System.out.println(fun(beat,money));
    }

    private static int fun(long[] beat, int[] money) {
        int n= beat.length-1;
        long[][] dp = new long[55][110];
        for (int i = 0; i <55 ; i++) {
            Arrays.fill(dp[i],-1);
        }
        dp[0][0]=0;

        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=i*2 ; j++) {
                if (j>=money[i]&&dp[i-1][j-money[i]]!=-1) {
                    dp[i][j] = dp[i - 1][j - money[i]] + beat[i];
                }
                if (dp[i-1][j]!=-1&&dp[i-1][j]>=beat[i]){
                    dp[i][j] = Math.max(dp[i][j],dp[i-1][j]);
                }
            }
        }
        int res =0;
        for (int i = 0; i <=110 ; i++) {
            if (dp[n][i] != -1) {
                res =i;
                break;
            }
        }
        return res;
    }
}
