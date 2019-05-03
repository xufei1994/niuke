package algs4.xufei;/*
    @Author  87814   algs4.xufei
    @Date  2018/9/8    20:37
*//*
    @Author  87814   algs4.xufei
    @Date  2018/9/8    20:37
*/


import org.junit.Test;

public class Test1 {
    @Test
    public void est1() {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19};//20个数,现有19个数
        //找出缺失的数组4，长度是已知的

        int index = search(array, 0, 19);
        System.out.println(index);
    }



    public static int search(int[] arr,int begin,int end) {
        int mid = (begin + end) / 2;
        int a=arr.length;
        if (arr[0] != 0) {
            return 0;}
            if ((arr[mid - 1] == mid - 1) && (arr[mid] > mid)) {
                return mid;
            }
            if (arr[mid] == mid) {
                // mid ==n  说明 缺值在mid-high之间，将mid设置为begin
                return search(arr, mid + 1, end);
            }
            if (arr[mid] > mid) {
                // mid ==n  说明 缺值在low-mid之间，将mid设置为end
                return search(arr, begin, mid - 1);
            }
            return -1;
        }
    }




