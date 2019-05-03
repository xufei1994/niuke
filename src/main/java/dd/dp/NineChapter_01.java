package dd.dp;/*
    @Author  87814   xufei
    @Date  2019/4/8    20:00
*//*
    @Author  87814   xufei
    @Date  2019/4/8    20:00
*/

/*
假设有三种硬币足够多  2,5,7，要求支付某一面额 花费最少的硬币
 */
public class NineChapter_01 {
    public static void main(String[] args) {
        System.out.println(findMinNum(39));
        System.out.println(findMinNumByDp(39));
    }

    //递归方法
    private static int findMinNum(int x) {
        if (x==0){ return 0; }
        int res = 10000000;   //边界条件与限制
        if (x>=2){res= Math.min(findMinNum(x-2)+1,res);}
        if (x>=5){res= Math.min(findMinNum(x-5)+1,res);}//最后一步  是是什么
        if (x>=7){res= Math.min(findMinNum(x-7)+1,res);}
        return res;
    }
/*
1.确定状态  ，解动态规划是需要看一个数组，数组的每个元素f[i]或者 f[i][j]代表什么
a.最后一步：最优策略中的最后一个决策
b.子问题
2.转移方程：设状态f[x]=最少用多少枚硬币拼出x，对于任意的X   f[x] = min{f[x-2]+1,f[x-5]+1,f[x-7]+1};
3.初始条件和边界情况  用转移方程计算不出来  需要自己定义，防止数组越界，还要给一个初始值
4.计算顺序  以一个怎么样的顺序进行计算
 */
    //动态规划,设状态f[x]=最少用多少枚硬币拼出x，对于任意的X
    // f[x] = min{f[x-2]+1,f[x-5]+1,f[x-7]+1};
    private static int findMinNumByDp(int x) {
        if (x==0){return 0;}
        int[] dp = new int[x+1];
        dp[0]=0;
        for (int i = 1; i <=x ; i++) {
            dp[i]=100000;  //先将所有的赋值为最大值
        }
        for (int i = 0; i <=x ; i++) {
            if (i>=2){dp[i]=Math.min(dp[i-2]+1,dp[i]);}
            if (i>=5){dp[i]=Math.min(dp[i-5]+1,dp[i]);}
            if (i>=7){dp[i]=Math.min(dp[i-7]+1,dp[i]);}
        }
        return dp[x];
    }
    //官方代码
    private static int findMinNumByDp(int[] A,int M) { //A是含有2,5,7,的数组  ，M是目标
        int[] dp=new int[M+1];
        int n=A.length;
        dp[0]=0;
        int i,j;
        for ( i = 1; i <=M ; i++) {
            dp[i]=Integer.MAX_VALUE;
            for ( j = 0; j <n ; j++) {
                if (i>=A[j]&&dp[i-A[j]]!=Integer.MAX_VALUE){//边界条件  无穷大不能加1
                    dp[i]=Math.min(dp[i-A[j]]+1,dp[i]);
                }
            }
            }
            if (dp[M]==Integer.MAX_VALUE){
            dp[M]=-1;
            }
            return dp[M];
        }
}
