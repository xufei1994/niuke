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
import java.util.LinkedList;

public class AcWing602 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[] arr = new int[N];
        String[] strings = bufferedReader.readLine().split("");
        for (int i = 0; i <N ; i++) {
           arr[i]=Integer.parseInt(strings[i]);
        }
        System.out.println(remove(arr));
    }

    private static int remove(int[] arr) {
        for (int i = 0; i <arr.length ; i++) {
            if (arr[i]==0){
                arr[i]=-1;
            }
        }
        int res = 0;
        for (int i = 0; i <arr.length ; i++) {
            res+=arr[i];
        }
        return Math.abs(res);
    }
}
