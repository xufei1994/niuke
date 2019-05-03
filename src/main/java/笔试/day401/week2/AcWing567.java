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

public class AcWing567 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(System.in));
        String[] strings = bufferedReader.readLine().split(" ");
         int max=Integer.parseInt(strings[0]);
         int price=Integer.parseInt(strings[1]);
         
        System.out.println(payNumber(max,price));
        
    }
//数据范围
//1≤n≤105,
//1≤m≤109
    private static int payNumber(int max, int price) {
        int res=price/max;
        return res+1;
    }

}
