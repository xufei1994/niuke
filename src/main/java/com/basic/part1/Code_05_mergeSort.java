package com.basic.part1;/*
    @Author  87814   xufei
    @Date  2019/3/18    12:58
*/

public class Code_05_mergeSort {
    public static void main(String[] args) {
        int [] array = new int[]{9,8,7,6,5,4,1,2,3};
        mergeSort(array);
        for (int i = 0; i <array.length ; i++) {
            System.out.print("  "+array[i]);
        }
    }

    public static void mergeSort(int[] arr){
        if (arr==null||arr.length<2){return;}
        mergeSort(arr,0,arr.length-1);
    }

    private static void mergeSort(int[] arr, int L, int R) {
        if (L==R){return;}
        int mid =(L+R)/2;
        mergeSort(arr,L,mid);
        mergeSort(arr,mid+1,R);
        merge(arr,L,mid,R);
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r-l+1]; //该方法开辟了许多无用空间
        int i=0;
        int p1 =l;
        int p2 = mid+1;
        while (p1<=mid&&p2<=r){
            help[i++]=arr[p1]<arr[p2]?arr[p1++]:arr[p2++];
        }
        //两个有且仅有仅有一个越界
        while (p1<=mid){
            help[i++]=arr[p1++];
        }
        while (p2<=r){
            help[i++]=arr[p2++];
        }
        for ( i = 0; i <help.length ; i++) {
            arr[l+i]=help[i];
        }
    }
}
