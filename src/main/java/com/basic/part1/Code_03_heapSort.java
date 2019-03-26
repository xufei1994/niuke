package com.basic.part1;/*
    @Author  87814   xufei
    @Date  2019/3/19    17:38
*//*
    @Author  87814   xufei
    @Date  2019/3/19    17:38
*/

//二叉堆：实际上是一种完全二叉树 1.最大堆  2.最小堆
//堆的自我调整  插入节点  删除节点  构建二叉堆
// 假设父节点的下标是parent，那么他左孩子的下标就是2*parent+1  右孩子就是2*parent+2
// 假设子结点的坐标是cur   parent的坐标是cur-1/2
public class Code_03_heapSort {
    public static void heapSort(int[] arr) {
        if (arr==null||arr.length<2){
            return;
        }
        for (int i = 0; i <arr.length ; i++) {
            heapInsert(arr,i);
        }
        int size =arr.length;
        swap(arr,0,--size);  //把最大值沉在最后
        while (size>0){
            heapify(arr,0,size);
            swap(arr,0,--size);
        }

    }

    public static void heapInsert(int[] arr, int index) {
        while (arr[index]>arr[(index-1)/2]){  //如果当前节点大于他的父节点
            swap(arr,index,(index-1)/2);    //和它的父节点交换
            index=(index-1)/2;              //自己成为父节点
        }
    }

    public static void heapify(int[] arr, int index, int size) {
          int left = index*2+1;
          while (left<size){
              int largest=left+1<size&&arr[left+1]>arr[left]?left+1:left;
              largest=arr[largest]>arr[index]?largest:index;
              if (largest == index){
                  break;
              }
              swap(arr,largest,index);
              index=largest;
              left=index*2+1;
          }

    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
