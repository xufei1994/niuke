package 笔试.day421.头条;/*
    @Author  87814   xufei
    @Date  2019/4/21    13:47
*//*
    @Author  87814   xufei
    @Date  2019/4/21    13:47
*/
/*

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main02 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(bufferedReader.readLine());  //视频帧数
        String[] strings = new String[M];
        for (int i = 0; i < M; i++) {
            strings[i] = bufferedReader.readLine();
        }
        ArrayList[] arr = new ArrayList[M];  //防止越界

        for (int i = 0; i <arr.length ; i++) {
            arr[i]=new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            String[] part = strings[i].split(" ");
            for (int j = 0; j < part.length; j++) {
                if (Integer.parseInt(part[0])!=0){
                    arr[i].add(j,Integer.parseInt(part[j]));
                }else {
                    arr[i].add(0,0);
                }
            }
        }
        System.out.println(findAspect(arr));
    }

    private static int findAspect(ArrayList[] arr) {
        int maxNum = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 2; j < ((int)arr[i].get(0) == 0 ? 0 : (int)arr[i].get(0) * 2 + 1); j++) {
                int max = walk(arr, (int)arr[i].get(j-1), (int)arr[i].get(j),i);
                maxNum = Math.max(max, maxNum);
                if (maxNum>n/2+1&&max==0){
                    return maxNum;
                }
            }
        }
            return maxNum;
        }

        private static int walk(ArrayList[] arr, int p, int q,int start) {
            int ans = 0;
            int max = 0;
            for (int i =start ; i < arr.length; i++) {
                int temp = ans;
                for (int j = 2; j < ((int)arr[i].get(0) == 0 ? 0 : (int)arr[i].get(0) * 2 + 1); j += 2) {
                    if ((int)arr[i].get(j-1) == p && (int)arr[i].get(j) == q) {
                        ans += 1;
                    }
                }
                max = Math.max(max, ans);
                if (temp == ans) {
                    ans = 0;
                }
            }
            return max;
        }
}