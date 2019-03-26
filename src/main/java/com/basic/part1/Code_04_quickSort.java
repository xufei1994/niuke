package com.basic.part1;/*
    @Author  87814   xufei
    @Date  2019/3/19    13:14
*//*
    @Author  87814   xufei
    @Date  2019/3/19    13:14
*/

//随机快排额外的空间复杂度OLogN
public class Code_04_quickSort {

    public static void quickSort(int[] arr){
        if (arr == null||arr.length<2){
            return;
        }
        quickSort(arr,0,arr.length-1);
    }

    private static void quickSort(int[] arr, int L, int R) {
        if (L<R){
            swap(arr,L+(int)(Math.random()*(R-L+1)),R); //防止有序  打乱
            int[] p =partition(arr,L,R);
            quickSort(arr,L,p[0]-1);//除等于外的左边界
            quickSort(arr, p[1]+1, R); //除等于外的右边界
        }
    }

    //以最后一个为划分，返回等于区域是哪个范围   p[0]代表等于区域的左边界，p[1]代表等于区域的右边界
    private static int[] partition(int[] arr, int L, int R) {
        int less = L-1;  // - 1 未知区域
        int more = R;  //  arr[n-1]
        while (L<more){
            if (arr[L]<arr[R]){
                swap(arr,++less,L++);  //小于区域位置扩一个，L位置和小于第一个交换 L前移
            }else if (arr[L]>arr[R]){
                swap(arr,--more,L);
            }else {
                L++;
            }

        }
        swap(arr,more,R); //是以R作为判断的
        return new int[]{less+1,more}; //返回的是等于区域的下标值
    }


    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    public static void main(String[] args) {
        int [] array = new int[]{9,8,7,6,5,4,1,2,3,5};
        quickSort(array);
        for (int i = 0; i <array.length ; i++) {
            System.out.print("  "+array[i]);
        }
    }
}
