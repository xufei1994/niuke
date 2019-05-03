package com.basic.part2;/*
    @Author  87814   xufei
    @Date  2019/4/14    14:36
*//*
    @Author  87814   xufei
    @Date  2019/4/14    14:36
*/

import java.util.Arrays;
import java.util.Random;

//在一个无序数组中 找到第k小的数  On
/*
BFPRT 算法选划分值不是随便选的
1.先逻辑分组  每五个数一组   不满五个的单独成组
2.分完组之后 每个组排序  跨组不保证有序  五个数之间排序  不固定是五个数
3.把每个组的中位数拿出来 组成一个新数组 组成新的数组 长度为n/5
4.递归调用bfprt 算法  找新数组的 中位数   选一个划分值这个划分值大约是中间的
5.把原数组按 上一步递归得到的值进行划分
6.选择左边还是右边
 */
public class Question_6_BFPRT {
    public static void main(String[] args) {
        int[] array={0,1,2,4,5,125,1,5,21,5,12,1,51,213,24,13,12,5,41,12,48,64,4515,125,1,454,5,1,5,151,51,515,1,55};
        int k=29;  //找到第十五小的数
        //System.out.println(arrays(array, k)); //利用排序解
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(getMinKNumbersByHeap(array,k)));
        System.out.println("---------");
        System.out.println(Arrays.toString(getMinKnumsByBFKRT(array,k)));
        System.out.println(select(array,0,array.length-1,k-1));

    }
    //堆实现算法 算法复杂度Nlogk
    public static int[] getMinKNumbersByHeap(int[] arr,int k){
        if (k<1||k>arr.length){
            return arr;
        }
        int[] kHeap = new int[k]; //建一个大小为k的堆
        for (int i = 0; i !=k ; i++) {
            heapInsert0(kHeap,arr[i],i);
        }
        //最大堆 的 弹出 n-1-k个数就是 第k大得数
        for (int i = k; i !=arr.length ; i++) {
            if (arr[i]<kHeap[0]){
                kHeap[0]=arr[i];
                heapify(kHeap,0,k);
            }
        }
        return kHeap;
    }

    //最大堆 的插入
    private static void heapInsert0(int[] arr, int value, int index) {
        arr[index] = value;
        while (index!=0){
            int parent =(index-1)/2;
            if (arr[index]>arr[parent]){
                swap(arr,parent,index);
                index=parent;
            }else {
                break;
            }
        }
    }

    private static void heapify(int[] arr, int index, int size) {
         int left = 2*index+1;
         int right= 2*index+2;
         int largest = index;
         while(left<size){
             if (arr[left]>arr[right]){
                 largest =left;
             }
             if (right<size&&arr[right]>arr[largest]){
                 largest=right;
             }
             if (largest!=index){
                 swap(arr,index,largest);
             }else {
                 break;
             }
             index=largest;
             left=2*index+1;
             right = 2*index+1;
         }
    }


    /*
      BFPRT算法  O（N复杂度）
1.先逻辑分组  每五个数一组   不满五个的单独成组
2.分完组之后 每个组排序  跨组不保证有序  五个数之间排序  不固定是五个数
3.把每个组的中位数拿出来 组成一个新数组 组成新的数组 长度为n/5
4.递归调用bfprt 算法  找新数组的 中位数   选一个划分值这个划分值大约是中间的
5.把原数组按 上一步递归得到的值进行划分
6.选择左边还是右边
     */
    public static int[] getMinKnumsByBFKRT(int[] arr,int k){
        if (k<1||k>arr.length)return arr;

        int minKth = getMinKthByBFKRT(arr,k);
        int[] res =new int[k];
        int index =0;
        //将原数组进行划分
        for (int i = 0; i <arr.length ; i++) {
            if (arr[i]<minKth){  //小于等于k的数
                res[index++]=arr[i];
            }
        }
        for (; index <res.length ; index++) {
            res[index]=minKth;
        }
        return res;

    }

    //不破坏原来的数组
    private static int getMinKthByBFKRT(int[] arr, int k) {
        int[] copyArr = copyArray0(arr);
        return select(copyArr,0,copyArr.length-1,k-1);
    }

    //主体 函数
    private static int select(int[] arr, int begin, int end, int i) {
        if (begin ==end ){
            return arr[begin];
        }
        int pivot = medianOfMedians0(arr,begin,end);
        int[] pivotRange = partition0(arr,begin,end,pivot);
        if (i>=pivotRange[0]&&i<=pivotRange[1]){
            return arr[i];
        }else if (i<pivotRange[0]){
            return select(arr,begin,pivotRange[0]-1,i);
        }else {
            return select(arr,pivotRange[1]+1,end,i);
        }
    }



    private static int medianOfMedians0(int[] arr, int begin, int end) {
        int num =end -begin+1;
        int offset = num%5==0?0:1;
        int[] mArr = new  int[num/5+offset];
        for (int i = 0; i <mArr.length ; i++) {
            int beginI = begin+i*5;
            int endI = beginI+4;
            mArr[i]=getMedian0(arr,beginI,Math.min(end,endI));//min  防止越界
        }
        return select(mArr,0,mArr.length-1,mArr.length/2); //反复递归寻找中位数
    }
    private static int[] partition0(int[] arr, int begin, int end, int pivot) {
        int less = begin - 1;
        int cur = begin;
        int more = end+1;
        while (cur!=more){
            if (arr[cur]<pivot){
                swap(arr,++less,cur++);
            }else if (arr[cur]>pivot){
                swap(arr,cur,--more);  //换过来的未知大小
            }else {
                cur++;
            }
        }
        int range[] = new int[2];
        range[0] = less+1;
        range[1] = more -1 ;
        return range;
    }

    private static int getMedian0(int[] arr, int begin, int end) {
    insertionSort0(arr,begin,end);
    int sum =end+begin;
    int mid = (sum/2) + sum%2;  //如果是偶数的话取左边
        return arr[mid];
    }
    private static void insertionSort0(int[] arr, int begin, int end) {
        for (int i = begin+1; i <end+1 ; i++) {
            for (int j = i; j !=begin ; j--) {
                if (arr[j-1]>arr[j]){
                    swap(arr,j-1,j);
                }else {
                    break;
                }
            }

        }
    }

    private static int[] copyArray0(int[] arr) {
        int[] res = new int[arr.length];
        for (int i = 0; i <arr.length ; i++) {
            res[i]=arr[i];
        }
        return res;
    }


    private static int arrays(int[] array, int k) {
        Arrays.sort(array);
        return array[k-1];
    }


    private static void swap(int[] array, int left, int cur) {
        int temp =array[left];
        array[left]=array[cur];
        array[cur]=temp;
    }

}
