package 笔试.day328.week1;/*
    @Author  87814   xufei
    @Date  2019/4/23    17:12
*//*
    @Author  87814   xufei
    @Date  2019/4/23    17:12
*/


import dd.dp.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class AcWing549 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        LinkedList<int[]> list =new LinkedList();
        int[] mArr =new int[N];
        for (int i = 0; i <N ; i++) {
            String[] strings1=bufferedReader.readLine().split(" ");
            String[] strings2=bufferedReader.readLine().split(" ");
            int m =Integer.parseInt(strings1[1]);
            int arr[] = new int[strings2.length];
            for (int j = 0; j <strings2.length ; j++) {
                arr[j] = Integer.parseInt(strings2[j]);
            }
            list.add(i,arr);
            mArr[i] =Integer.parseInt(strings1[1]);

        }


        for (int i = 0; i <N ; i++) {
            System.out.println("Case #"+(i+1)+": " +train(list.get(i),mArr[i]));
        }




    }


    private static int train(int[] arr, int m) {
        Arrays.sort(arr);
        int[] resArr = new int[arr.length-m+1];
        int sum = 0;
        int min=Integer.MAX_VALUE;
        for (int i = 0; i <=arr.length-m ; i++) {
            for (int j = i; j <m+i ; j++) {
                resArr[i]+=arr[m+i-1]-arr[j];
            }
            min = Math.min(min,resArr[i]);
        }

        if (m==arr.length){
            int temp=0;
            for (int i = 0; i <m ; i++) {
                temp +=arr[m-1]-arr[i];
            }
            min=Math.min(min,temp);
        }
        System.out.println(Arrays.toString(resArr));
        return min;
    }

}
