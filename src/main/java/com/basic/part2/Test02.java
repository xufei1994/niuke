package com.basic.part2;
/*
    @Author  87814   xufei
    @Date  2019/3/19    9:06
*/

import java.lang.reflect.Array;
import java.util.Arrays;

//荷兰国旗问题
// 给定一个数组arr,和一个数num，请把小于num的数放在数组的左边，
//// 大于num的数放在数组的右边   等于的数放在数组中间，空间复杂度O1  时间复杂度ON
public class Test02 {
    public static void main(String[] args) {
        int[] arr={9,8,7,4,5,1,2,3,1,12,5,4,1,5,21,1,5,5,6,7,7,8,9,5,5,5,5,5,5,5,5,4,5,4,5,9,6,5,61,4};
        int num=5;
        dispatch(arr,num);
        System.out.println(Arrays.toString(arr));
    }

    private static void dispatch(int[] arr, int num) {
        int i =0;
        int j= arr.length-1;
        int numLeft=-1;//取下标
        int numMid=0;
        int numRight=0;
        //计数操作  可以知道左边几个元素，右边几个元素，中间几个元素
        for (int k = 0; k <arr.length ; k++) {
            if (arr[k]==num){
                numMid++;
            }else if (arr[k]>num){
                numRight++;
            }else {
                numLeft++;
            }
        }
        core(arr,0,arr.length-1,num);
        core(arr,0,arr.length-1-numRight,(num-1));
        while (true){
            if (i==j) {break;}
            if (i<arr.length&&j>0){
                if (arr[i]<=num){
                    i++;
                }else {
                    if (arr[j]<=num){
                        swap(arr,i,j);
                    }else {
                        j--;
                    }
                }
            }
        }
        int p1 =0;
        int p2= arr.length-1-numRight;
        while (true){
            if (p1==p2) {break;}
            if (p1<arr.length&&p2>0){
                if (arr[p1]<num){
                    p1++;
                }else {
                    if (arr[p2]<num){
                        swap(arr,p1,p2);
                    }else {
                        p2--;
                    }
                }
            }
        }
    }

    public static void core(int[] arr,int i,int j,int num){
        while (true){
            if (i==j) {break;}
            if (i<arr.length&&j>0){
                if (arr[i]<=num){
                    i++;
                }else {
                    if (arr[j]<=num){
                        swap(arr,i,j);
                    }else {
                        j--;
                    }
                }
            }
        }

    }

    public static  void swap(int[] arr,int i,int j){
          arr[i]=arr[i]^arr[j];
          arr[j]=arr[i]^arr[j];
          arr[i]=arr[i]^arr[j];
    }

}
