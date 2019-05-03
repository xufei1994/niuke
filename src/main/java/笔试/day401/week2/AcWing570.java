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
import java.util.*;

public class AcWing570 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(System.in));
        String[] strings = bufferedReader.readLine().split(" ");
         int n=Integer.parseInt(strings[0]);
         int m=Integer.parseInt(strings[1]); //m个数组
        String[] strings2 = bufferedReader.readLine().split(" ");
        int arr[] =new int[strings2.length];
        for (int i = 0; i <arr.length ; i++) {
            arr[i] = Integer.parseInt(strings2[i]);
        }
        System.out.println(minNumber2(arr,m));
        //System.out.println(minNumber(arr,m));

    }

    private static int minNumber2(int[] arr, int m) {
        //使用双指针法
        int n= arr.length;
        int bool[] = new int[m+1];
        int color=0;
        int j=0;
        int ans = n+1;
        for (int i = 0; i <n ; i++) {
            if (arr[i]!=0&&bool[arr[i]]==0){
                color++;
            }
            bool[arr[i]]++;
            System.out.println(color);
            if (color==m){
                while (arr[j]==0||bool[arr[j]]>1){
                    bool[arr[j]]--;
                    j++;
                }
                ans = Math.min(i-j+1,ans);
            }
        }
        return ans;

    }
    private static int minNumber(int[] arr, int m) {
       //滑动窗口
        int n =arr.length;
        int bool[] =new int[m+1];
        Arrays.fill(bool,0);
        //0视为没有击中
        //按收元素的数量即可
        LinkedList<Integer> qmin=new LinkedList<>();
        int ans=Integer.MAX_VALUE;
        int temp =0;
        if (arr[0]!=0){
            temp = 1;
        }
         bool[arr[0]]=1;
         qmin.add(arr[0]);
         int i= 1;
         while (qmin.size()>0){

                while (temp<m&&i!=n){
                       qmin.add(arr[i]);
                       if (bool[arr[i]]==0&&arr[i]!=0){ temp++; }
                       bool[arr[i]]++;
                       i++;
                }
                if (temp==m){
                    ans= Math.min(ans,qmin.size());
                }
                if (qmin.peekFirst()!=null){

                    int peek =qmin.pollFirst();
                    bool[peek]--;
                    if (peek!=0&&bool[peek]==0){
                        temp--;
                    }
                }

            }
        return ans==Integer.MAX_VALUE?-1:ans;
    }

}
