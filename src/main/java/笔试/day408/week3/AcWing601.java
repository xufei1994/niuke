package 笔试.day408.week3;/*
    @Author  87814   xufei
    @Date  2019/5/2    22:35
*//*
    @Author  87814   xufei
    @Date  2019/5/2    22:35
*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AcWing601 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(System.in));
        String[] strings =bufferedReader.readLine().split(" ");
        int n= Integer.parseInt(strings[0]);
        int m= Integer.parseInt(strings[1]);
        int[] arr = new int[m+1];
        for (int i = 0; i <m ; i++) {
            arr[i]=Integer.parseInt(bufferedReader.readLine());
        }
        arr[m] = n; //将 m+1看做是最后一个硬币
        System.out.println(minCoinsNumbers(arr,n));
    }

    private static int minCoinsNumbers(int[] arr, int m) {
        int res=0;
        Arrays.sort(arr);
        if (arr[0]!=1){
            return -1; }
        for (int i = 0,s=0; i <arr.length-1 ; i++) {
            int k =(arr[i+1]-1-s+arr[i]-1)/arr[i]; //向上取整
            res +=k;
            s +=k*arr[i];
        }
        return res;
    }
}
