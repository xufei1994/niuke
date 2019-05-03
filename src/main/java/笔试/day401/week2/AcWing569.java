package 笔试.day401.week2;/*
    @Author  87814   xufei
    @Date  2019/4/23    22:28
*//*
    @Author  87814   xufei
    @Date  2019/4/23    22:28
*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class AcWing569 {
    private static int N=2000010;
    private static int mod=1000000007;
    private static int[] primes=new int[N];//素数集合
    private static int[] powers=new int[N];//次数
    private static boolean[] st=new boolean[N];//是否遍历过
    private static int cnt=0; //第一个素数为2

    private static void get_primes(int n){//获取素数
        int s=0; //计算次数
        for (int i = 2; i <=n ; i++) {
            if (!st[i]){
                primes[cnt++]=i;//如果没有遍历过这数 将他添加到素数表中
                for (int j = i*2; j <=n ; j+=i) {
                    st[j]=true;  //将合数进行标记
                    s++;
                }
            }
        }
    }

    private static int getPrimesNumber(int n,int p){  //16 14 12 10 8 6 4 2 ==4+ 1 + 2 + 1 +3 +1 +2 +1=15个
        //统计 n的阶乘里包含多少个素数因子p
        int s=0;
        while (n>0){//  8 + 4 + 2+ 1 =15 ge
            s+=n/p;
            n/=p;
        }
      return s;
    }



    private static int deal(int[] arr, int m) {
        int n =arr.length;
        get_primes(n); //找出所有的素数

        for (int i = 0; i <cnt ; i++) {
            int p = primes[i];
            //  n(n-1)(n-2)...1/ {m(m-1)(m-2)...1  * (n-m)(n-m-1)....1  即Cmn 的某一个素数有多少个
            powers[i] += getPrimesNumber(n,p)-getPrimesNumber(m,p)-getPrimesNumber(n-m,p);
        }

        int res = 1;

        for (int i = 0; i <cnt ; i++) {
            int p = primes[i];
            while (powers[i]-->0){
                res = (int) ((long)res*p%mod);

            }
        }
        for (int i = 0; i <n-m ; i++) {
            res=res*2/mod;
        }
        return res;
    }



    public static void main(String[] args) throws IOException {
           inputDeal();
    }

    private static void inputDeal() throws IOException {
        BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(System.in));
        String[] strings = bufferedReader.readLine().split(" ");
        int n=Integer.parseInt(strings[0]);   //3场
        int m=Integer.parseInt(strings[1]); // 赢两次
        String[] strings2 = bufferedReader.readLine().split(" ");
        int arr[] =new int[strings2.length];
        for (int i = 0; i <arr.length ; i++) {
            arr[i] = Integer.parseInt(strings2[i]);
        }

        System.out.println(deal(arr,m));
    }
}
