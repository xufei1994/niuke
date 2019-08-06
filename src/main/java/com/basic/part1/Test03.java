package com.basic.part1;/*
    @Author  87814   algs4.xufei
    @Date  2019/3/18    14:41
*//*
    @Author  87814   algs4.xufei
    @Date  2019/3/18    14:41
*/

//  逆序对问题：一个数组中，左边的数如果比右边的数大，则这两个数构成一个逆序对，打印所有逆序对
import java.util.Arrays;

public class Test03 {
    public static void main(String []args) throws InterruptedException {
        int []arr = {9,8,7,6,5,4,3,2,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(ORDER_COUNT);
        int [] arr2={2,1,5,3,2};
        Thread.sleep(1000);
        ORDER_COUNT=0;
        sort(arr2);
        System.out.println(Arrays.toString(arr2));
        System.out.println(ORDER_COUNT);
    }
        private static int ORDER_COUNT=0;

        public static void sort(int []arr){
            int []temp = new int[arr.length];//在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
            mergeSort(arr,0,arr.length-1,temp);
        }
        private static void  mergeSort(int[] arr,int left,int right,int []temp){
            if(left<right){
                int mid = (left+right)/2;
                mergeSort(arr,left,mid,temp);//左边归并排序，使得左子序列有序
                mergeSort(arr,mid+1,right,temp);//右边归并排序，使得右子序列有序
                merge(arr,left,mid,right,temp);//将两个有序子数组合并操作
            }
        }
        private static void merge(int[] arr,int left,int mid,int right,int[] temp){
            int i = left;//左序列指针
            int j = mid+1;//右序列指针
            int t = 0;//临时数组指针
            //求解归逆序对中的数量只需要改进一下while循环方法
            while (i<=mid && j<=right){
                if(arr[i]<=arr[j]){  //此时没有逆序对
                    temp[t++] = arr[i++];
                }else {  //否则产生了逆序对，我们需要对逆序对做出统计
                    temp[t++] = arr[j++];
                    ORDER_COUNT+=mid-i+1;//+1的作用是将0的序列变为按下标的序列,
                    // mid+1是左边的总数，i是第一个比右边数值大的坐标
                }
            }
            while(i<=mid){//将左边剩余元素填充进temp中
                temp[t++] = arr[i++];
            }
            while(j<=right){//将右序列剩余元素填充进temp中
                temp[t++] = arr[j++];
            }
            t = 0;
            //将temp中的元素全部拷贝到原数组中
            while(left <= right){
                arr[left++] = temp[t++];
            }
        }

}
