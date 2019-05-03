package dd.dp;/*
    @Author  87814   xufei
    @Date  2019/4/8    22:31
*//*
    @Author  87814   xufei
    @Date  2019/4/8    22:31
*/
//给定m行n列的网格，有一个机器人从左上角（0,0）出发，每一步可以向下或者向右走一步
// 问有多少种不同的方式走到右下角

//计数形式的动态规划
/*
1.确定状态 右下角坐标为（m-1,n-1），那么前一步机器人一定是在（m-2，n-1）或者是（m-1，n-2）中过渡而来的
那么，如果机器人有x种方式从左上角走到（m-2，n-1）
         机器人有y种方式从左上角走到（m-1，n-2）
         则机器人有x+y种方式走到（m-1，n-1）
 子问题 ：机器人现在有多少种方式从左上角走到（m-2，n-1） 和（m-1，n-2）

 顺序的定义和转移方程有关
 */
public class Test02 {
    public static void main(String[] args) {
        int[][]  arr = new int[8][9];
        System.out.println(walkByDp(arr));
        System.out.println(uniquePaths(8,9));
    }

    //我的代码  代码中有错误定义错了边界
    private static int walkByDp(int[][] arr) {
        if (arr==null){
            return 0;
        }
        int[][] dp =new int[arr.length+1][arr[0].length+1];  //这里不是+1  注意边界
        dp[arr.length][arr[0].length]=1;
        int m=arr.length;
        int n=arr[0].length;
        for (int i = 0; i <=m ; i++) {
            dp[i][0]=1;
        }
        for (int i = 0; i <n ; i++) {
            dp[0][i]=1;
        }
        dp[0][0]=0;
        for (int i = 0; i <=m ; i++) {
            for (int j = 0; j <=n ; j++) {
                if (i>=1&&j>=1)
                {
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[arr.length-1][arr[0].length-1];
    }
    //老师的代码
    public static int uniquePaths(int m,int n){
        int[][] dp = new int[m][n];
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j <n ; j++) {
                if (i==0||j==0){dp[i][j]=1;}
                else {
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
