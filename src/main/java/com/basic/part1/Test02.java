package com.basic.part1;/*
    @Author  87814   algs4.xufei
    @Date  2019/3/18    13:37
*//*
    @Author  87814   algs4.xufei
    @Date  2019/3/18    13:37
*/

//小和问题 逆序对


import java.util.Arrays;

/*
在一个数组中，每一个数左边比当前数小的数累加起来，叫做这个数组的小和。 求一个数组的小和
例子 [1，3，4，2，5]
1左边比1小的数 ，没有
3左边比3小的数：1；
4左边比4小的数：1，3；
2左边比2小的数：1；
5左边比5小的数：1，3，4，2；
所以小和为 1+1+3+1+1+3+4+2 = 16


 */
public class Test02 {
    public static void main(String[] args) {
        int [] array = new int[]{1,3,4,2,5};
        System.out.println(smallSum(array));
        for (int i = 0; i <array.length ; i++) {
            System.out.print("  "+array[i]);
        }
    }

    public static int smallSum(int[] arr){
        if (arr==null||arr.length<2){return 0;}
        return mergeSort(arr,0,arr.length-1);
    }

    private static int mergeSort(int[] arr, int L, int R) {
        if (L==R){return 0;}
        int mid =(L+R)/2;//mid = L+(R-L)/2  L+（R-L）>>1;  防止溢出
        return mergeSort(arr,L,mid)+
        mergeSort(arr,mid+1,R)+
        merge(arr,L,mid,R);
    }

    private static int merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r-l+1]; //该方法开辟了许多无用空间
        int i=0;
        int p1 =l;
        int p2 = mid+1;
        int res=0;
        while (p1<=mid&&p2<=r){
            //如果p1比当前的p2小 产生p2后面的个数乘以当前的p1  即1 3 4 | 2 5   即（4-3+1）*1
            //  +（4-4+1）*3+4
            res+=arr[p1]<arr[p2]?(r-p2+1)*arr[p1]:0;
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
        return res;
    }
}
