package com.basic.part3;/*
    @Author  87814   algs4.xufei
    @Date  2019/3/21    22:25
*//*
    @Author  87814   algs4.xufei
    @Date  2019/3/21    22:25
*/

//先增后减 二分法  有序的数组  N个不同的数,空间复杂度为o1 时间复杂度为3Ologn
public class Test {
   static int changePoint;
    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 5, 7, 9, 11, 10, 8, 6, 4, 2, 0};
        int value = 6;
        changePoint = find(array, 0, array.length - 1);
        System.out.println(changePoint);
        System.out.println(findValue(array,value,0,array.length-1));
    }

    private static int findValue(int[] array, int value, int left, int right) {
        int leftValue=twoPartUp(array,value,left,changePoint);
        int rightValue=twoPartDown(array,value,changePoint,right);
        return leftValue>rightValue?leftValue:rightValue;
    }

    private static int twoPartDown(int[] array, int value, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            if (array[mid]>value) { //说明left-mid在变区间上
                twoPartUp(array, value,mid+1, right);
            }else if (array[mid]==value){  //说明在增区间上还没到变点
                return mid;
            }else {
                twoPartUp(array, value, left, mid-1);
            }
        }
        return -1;
    }

    private static int twoPartUp(int[] array,int value, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            if (array[mid]<value) { //说明left-mid在变区间上
                twoPartUp(array, value,mid+1, right);
            }else if (array[mid]==value){  //说明在增区间上还没到变点
                return mid;
            }else {
               twoPartUp(array, value, left, mid-1);
            }
        }
        return -1;
    }

    private static int find(int[] array, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            if (array[mid + 1] < array[mid] && array[mid] > array[mid - 1]) { //说明left-mid在变区间上
                return mid;
            }else if (array[mid + 1] > array[mid] && array[mid] > array[mid - 1]){  //说明在增区间上还没到变点
                find(array, mid+1, right);
            }else {
                find(array, left, mid-1);
            }
        }
        return -1;
    }
}