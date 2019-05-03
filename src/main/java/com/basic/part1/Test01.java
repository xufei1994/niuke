package com.basic.part1;/*
    @Author  87814   algs4.xufei
    @Date  2019/3/18    11:07
*//*
    @Author  87814   algs4.xufei
    @Date  2019/3/18    11:07
*/

//在一个数组中找最大值  递归实现
public class Test01 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,36,7,8,999,5,4,6};
        int max=getMax(arr,0,arr.length-1);
        System.out.println(max);
        System.out.println(getMax2(arr,0,arr.length-1));
    }

    public static int getMax(int[] arr,int L,int R){
        //递归第一步终止条件  递归思路 先找左边最大值，再找右边最大值
        int mid=(L+R)/2;
        if (R-L==1){return arr[L]; }
        return getMax(arr,L,mid)>getMax(arr,mid,R)?getMax(arr, L, mid):getMax(arr, mid, R);
    }
    public static int getMax2(int[] arr,int L,int R){
        if (R == L) {
            return arr[R];
        }
        int mid =(L+R)/2;
        int maxLeft=getMax2(arr, L, mid);
        int maxRight=getMax2(arr, mid+1, R);
        return Math.max(maxLeft,maxRight);
        }

}
