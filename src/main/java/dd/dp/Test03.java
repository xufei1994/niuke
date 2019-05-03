package dd.dp;/*
    @Author  87814   xufei
    @Date  2019/4/8    23:04
*//*
    @Author  87814   xufei
    @Date  2019/4/8    23:04
*/




public class Test03 {
    public static void main(String[] args) {
        System.out.println(JumpFloor(10));
        System.out.println(JumpFloorByDp(10));
        int[] arr={-3,-4};
        System.out.println(maxProduct(arr));
    }
    public static int JumpFloor(int target) {
        if (target <=2 ) {return target;}
        return JumpFloor(target-1)+JumpFloor(target-2);

    }

    //动态规划
    public static int JumpFloorByDp(int target) {
        if (target<=2){
            return target;
        }
        int[] dp = new int[target+1];
        dp[0]=1;
        dp[1]=1;
        dp[2]=2;
        for (int i = 2; i <target+1 ; i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[target];
    }
    //变态跳台阶
    public int JumpFloorII(int target) {
        if(target<=2){ return target;}
        int s=1;
        for(int i=1;i<target;i++){
            s+=JumpFloorII(target-i);
        }

        return s;
    }
    //变态跳台阶 计数器模式   前一步要记录后一步的状态
    // 状态转移方程： f(n)=f(1)+f(2)+....f(n);
    public int JumpFloorIIByDp(int target) {
        if (target<=2){
        return target;}
        int dp[] = new int[target+1];
        dp[0]=1;
        dp[1]=1;
        dp[2]=2;
        for (int i = 2; i <=target ; i++) {
            for (int j = 1; j <=i ; j++) {
                dp[i]+=dp[i-j];
            }
        }
        return dp[target];
    }

    public int Fibonacci(int n) {
        if (n<=1) {return n;}
        return Fibonacci(n-1)+Fibonacci(n-2);
    }
    //斐波那契动态规划   f(n)=f(n-1)+f(f-2)
    public int FibonacciByDp(int n) {
        if (n<=2){
            return n;
        }
        int[] dp =new int[n+1];
        dp[0]=0;
        dp[1]=1;
        dp[2]=1;
        for (int i = 2; i <=n ; i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    //存在性问题
    public boolean canJump(int[] arr){
        int n=arr.length;
        boolean dp[] =new boolean[n];
        dp[0]=true;//第一个点青蛙能跳到
        for (int i = 1; i <n ; i++) {
            dp[i]=false;
            for (int j = 0; j <j ; j++) {
                if (dp[j]&&j+arr[j]>=i){//该石头已经确认跳到，而且j+arr[j]能跳的值大于 i   dp[i]=true
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[n-1];
    }

    //非动态规划版本
   // dp[i][j]=arr[i]*...arr[j]
    //dp[i][j]表示从i到j最大的连续数
    public static int maxProduct(int[] nums) {//0---n-1   1....n
        // write your code here
        int n=nums.length;
        int[][] dp= new int[n][n];
        for (int i = 0; i <n ; i++) {
            for (int j = i; j <n ; j++) {
                dp[i][j]=1;
                for (int k = i; k <=j ; k++) {
                    dp[i][j]*=nums[k];
                }
            }
        }
        int max=Integer.MIN_VALUE;
        for (int i = 0; i <n ; i++) {
            for (int j = i; j <n ; j++) {
                if (dp[i][j]>=max){
                    max=dp[i][j];
                }
            }
        }
        return max;
    }

    public int maxProduct2(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        int ans;
        for(int i = 0;i < n;++i){
            ans = nums[i];
            if(ans > max)
                max = ans;
            if(i != n - 1){
                for(int j = i + 1;j < n;++j){
                    ans *= nums[j];
                    if(ans > max)
                        max = ans;
                }
            }
        }
        return max;
    }


    //非动态规划版本
    // dp[i][j]=arr[i]*...arr[j]
    //dp[i][j]表示从i到j最大的连续数
    public static int maxProductByDp(int[] nums) {//0---n-1   1....n
        if (nums==null||nums.length<1){
            return 0;
        }
        // write your code here
        int n=nums.length;
        int max=nums[0];
        int min=nums[0];
        int result =nums[0];
        //每有一个新的数字加入，最大值要么是当前最大值*新数，要么是当前最小值（负数）*新数（负数），要么是当前值。
        for (int i = 1; i <n ; i++) {
           int temp=max;
           max=Math.max(Math.max(max*nums[i],min*nums[i]),nums[i]);
           min=Math.min(Math.min(temp*nums[i],min*nums[i]),nums[i]);
           if (max>result){
               result = max;
           }
        }

        return result;
    }

    /*
1.确定状态  ，解动态规划是需要看一个数组，数组的每个元素f[i]或者 f[i][j]代表什么
a.最后一步：最优策略中的最后一个决策
b.子问题
2.转移方程：设状态f[x]=最少用多少枚硬币拼出x，对于任意的X   f[x] = min{f[x-2]+1,f[x-5]+1,f[x-7]+1};
3.初始条件和边界情况  用转移方程计算不出来  需要自己定义，防止数组越界，还要给一个初始值
4.计算顺序  以一个怎么样的顺序进行计算
*/


}
