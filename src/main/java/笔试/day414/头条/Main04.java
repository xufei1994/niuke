package 笔试.day414.头条;/*
    @Author  87814   xufei
    @Date  2019/4/15    21:22
*//*
    @Author  87814   xufei
    @Date  2019/4/15    21:22
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

//输出一个数字，表示裁剪后最长的长度，保留两位小数
public class Main04 {
    static  int maxLength=1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //第一行包含2个正整数N、M，表示原始绳子的数量和需求绳子的数量。
        String str = bufferedReader.readLine();
        String part[] =str.split(" ");
        int N=Integer.parseInt(part[0]);  //三段绳子
        int M=Integer.parseInt(part[1]);   //裁成4段
        int li[] =new int[N];
        String s =bufferedReader.readLine();
        bufferedReader.close();
        String[] strings = s.split(" ");
        for (int i = 0; i <N ; i++) {
            li[i]=Integer.parseInt(strings[i]);
        }
        System.out.println(String.format("%.2f", f(li, M)));
        // 第二行包含N个整数，其中第 i 个整数Li表示第 i 根绳子的长度
    }

    private static double f(int[] li, int m) {
       // Arrays.sort(li);
//        if (m<=li.length){
//            return (double) li[li.length-m];
//        }
        double min = 0;
        double max =maxLength;

        while (max-min>1e-4){
            double mid= (min+max)/2;

            int res = 0;
            for (int i = 0; i <li.length ; i++) {
                res+=li[i]/mid;
            }
            if (res>=m){
                min=mid;
            }else if (res<m){
                max=mid;
            }
        }
        return min;
    }
}
