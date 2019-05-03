package dd.dp;/*
    @Author  87814   xufei
    @Date  2019/4/9    22:30
*//*
    @Author  87814   xufei
    @Date  2019/4/9    22:30
*/


import com.basic.part4.question.TreeNode;

import java.util.*;

//背包问题
/*
先写二维的
f[i][j]表示只看前i个物品，总体积是j的情况下，总价值最大是多少
result=f[n][0-v]
不选第i个物品：f[i][j]=f[i-1][j]
选第i个物品  ：f[i][j]=f[i][j-weight[i]]+value[i]
f[i][j]=Math.max(f[i-1][j],f[i][j-weight[i]]+value[i])

初始化：f[0][0]=0;
 */
public class Main {
    static int n;
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
             n=scanner.nextInt();
        int bagV=scanner.nextInt();

        int weight[]=new int[n+1];
        int value[] =new int[n+1];
        int number[] =new int[n+1];

        scanner.nextLine();
        for (int i = 1; i <=n ; i++) {
            weight[i]=scanner.nextInt();
            value[i]=scanner.nextInt();
            number[i]=scanner.nextInt();
            scanner.nextLine();
        }
        System.out.println(bagV);
        System.out.println(maxValue5(weight, value,number, bagV));
//        System.out.println(maxValue(weight, value, bagV));
//        System.out.println(maxValue2(weight, value, bagV));
//        System.out.println(maxValue1(weight, value, bagV));
//        System.out.println(maxValueCompletely(weight, value, bagV));


    }

    public static int maxValue2(int[] c, int[] p, int bag) {
        int[][] dp = new int[c.length + 1][bag + 1];
        for (int i = c.length - 1; i >= 0; i--) {
            for (int j = bag; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j];
                if (j + c[i] <= bag) {
                    dp[i][j] = Math.max(dp[i][j], p[i] + dp[i + 1][j + c[i]]);
                }
            }
        }
        return dp[0][0];
    }

    //01 背包   第一重循环循环物品    第二重循环体积  从大到小枚举
    private static int maxValue(int[] weight, int[] value, int bagV) {
        int f[][] = new int[1010][1010];  // i 坐标是数量，j是重量
        f[0][0]=0;
        for (int i = 1; i <weight.length ; i++) {
            for (int j = 0; j <=bagV ;j++ ) {
                f[i][j]=f[i-1][j];
                if (j>=weight[i]){
                    f[i][j]=Math.max(f[i][j],f[i-1][j-weight[i]]+value[i]);
                }

            }
        }
        int res = 0;
        for (int i = 0; i <=bagV ; i++) {
            res=Math.max(res,f[n][i]);
        }

       return res;
    }
   //f[i]  只与f[i-1]有关  一维数组解法
   private static int maxValue1(int[] weight, int[] value, int bagV) {
       int f[] = new int[1010];  // i 坐标是数量，j是重量
       f[0]=0;
       for (int i = 0; i <=n ; i++) {
           for (int j = bagV; j >=weight[i] ;j--) {
               f[j]=Math.max(f[j],f[j-weight[i]]+value[i]);
           }
       }
       return f[bagV];
   }

   //完全背包问题，每件物品可以选择无限次
    /*
    f[i] 总体积是i的情况下，最大价值是多少
    result = max{f[0.....bagV]};
    从前往后考虑
数学归纳法：
1.假设考虑前i-1个物品后，所有的f[j]都是正确的
2.来证明，考虑完第i个物品后，所有的f[j]也是正确的


     */
   //完全 背包   第一重循环循环物品    第二重循环体积  从小到大枚举
   private static int maxValueCompletely(int[] weight, int[] value, int bagV) {
       int f[] = new int[1010];  // i 坐标是数量，j是重量
       f[0]=0;
       for (int i = 0; i <=n ; i++) {
           for (int j = weight[i]; j <=bagV ;j++) {
               f[j]=Math.max(f[j],f[j-weight[i]]+value[i]);
           }
       }
    /*
       等同
       for (int i = 0; i <=n ; i++) {
           for (int j = bagV; j >=weight[i] ; j++) {
               for (int k = 0; k *weight[i]<=bagV ; k++) {
                   f[j]=Math.max(f[j],f[j-weight[i]*k]+k*value[i]);
               }
           }
       }
       */
       return f[bagV];
   }

    //多重背包问题   第一重循环循环物品    第二重循环体积  从大到小枚举  某些可以枚举si键
    private static int maxValueCompletely(int[] weight, int[] value,int[] number, int bagV) {
       int f[]=new int[101]; //质量 价值 个数
        f[0]=0;
        for (int i = 1; i <=n ; i++) {
            for (int j = bagV; j >=weight[i] ; j--) {
                for (int k = 0; k *weight[i]<=bagV&&k<=number[i] ; k++) {
                    f[j]=Math.max(f[j],f[j-k*weight[i]]+k*value[i]);
                }
            }
        }
        return f[bagV];
    }

    //多重背包大规模优化版本
    /*
数据范围
0<N≤1000
0<V≤2000
0<vi,wi,si≤2000
     */
    private static int maxValue5(int[] weight, int[] value,int[] number, int bagV){
        int[] a=new int[25000]; //2的12次方大于两千,也就是说一个数最多可以拆成12个，故数组的容量乘以12；
        int[] b=new int[25000];
        int[] f = new int[bagV*2+1];

        int total=0;
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=number[i] ; j*=2) { //二进制拆分
                a[total]=j*weight[i];  //存容量
                b[total++]=j*value[i];  //存价值
                number[i]-=j;
            }
            if (number[i]>0){
                a[total]=number[i]*weight[i];
                b[total++]=number[i]*value[i];
            }
        }
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        f[0]=0;
        for (int i = 0; i <=total ; i++) {
            for (int j = bagV; j >=a[i] ; j--) {
                f[j]=Math.max(f[j],f[j-a[i]]+b[i]);
            }
        }
        return f[bagV];
    }

    /*
    多重背包的单调队列优化    数据规模
0<N≤1000
0<V≤20000
0<vi,wi,si≤20000
     */


}
