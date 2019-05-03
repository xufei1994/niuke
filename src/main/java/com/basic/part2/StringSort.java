package com.basic.part2;/*
    @Author  87814   algs4.xufei
    @Date  2019/3/26    21:41
*//*
    @Author  87814   algs4.xufei
    @Date  2019/3/26    21:41
*/


import java.util.Arrays;
/**
 * 比较两个字符串大小规则如下：
 * 1.如果两个字符串长度不相同，则短字符串比长字符串小
 * 2.如果两个字符串长度相同，则按照A~ Z,a~z,0~9的大小关系排序  该顺序为从小到大
 */
public class StringSort {
    public static void main(String[] args) {
        String[] strs = {"a", "Abc", "123", "1", "abc", "CBD", "abcd", "a"};
        sort(strs);
        for (String str:strs) {
            System.out.print(str+"\t");
        }
    }

    /**
     * 比较a和b的大小
     * @param a
     * @param b
     * @return
     */




    public static boolean less2(String a, String b){
        if (a.length()<b.length()) {return true;}
        else if (a.length()==b.length()){
            for (int i = 0; i <a.length() ; i++) {
                if (a.charAt(i)>='0'&&a.charAt(i)<='9') {
                    if (b.charAt(i) >= '0' && b.charAt(i) <= '9')
                        return b.charAt(i)>a.charAt(i)?true:false;
                    if (b.charAt(i)>='A'&&b.charAt(i)<='z') return false;
                }else {
                    if (b.charAt(i) >= '0' && b.charAt(i) <= '9') return true;
                    else return b.charAt(i)>a.charAt(i)?true:false;
                }
            }
        }
        return false;
    }





    public static boolean less(String a,String b){
        if (a.length()<b.length()) {
            return true;
        }else if (a.length()>b.length()) {
            return false;
        }else{
            for (int i = 0;i<a.length();i++){
                if(a.charAt(i)>=48&&a.charAt(i)<=57){
                    if(b.charAt(i)>=48&&b.charAt(i)<=57){
                        return a.charAt(i)<b.charAt(i);
                    }else{
                        return false;
                    }
                }else{
                    if(b.charAt(i)>=48&&b.charAt(i)<=57){
                        return true;
                    }else{
                        return (int)a.charAt(i)<(int)b.charAt(i);
                    }
                }
            }
            return true;
        }
    }
    /**
     * 以下为归并排序模板
     * @param arr
     */
    public static void sort(String []arr){
        String []temp = new String[arr.length];//在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        mergeSort(arr,0,arr.length-1,temp);
    }
    private static void  mergeSort(String[] arr,int left,int right,String []temp){
        if(left<right){
            int mid = (left+right)/2;
            mergeSort(arr,left,mid,temp);//左边归并排序，使得左子序列有序
            mergeSort(arr,mid+1,right,temp);//右边归并排序，使得右子序列有序
            merge(arr,left,mid,right,temp);//将两个有序子数组合并操作
        }
    }
    private static void merge(String[] arr,int left,int mid,int right,String[] temp){
        int i = left;//左序列指针
        int j = mid+1;//右序列指针
        int t = 0;//临时数组指针
        while (i<=mid && j<=right){
            if(less(arr[i],arr[j])){
                temp[t++] = arr[i++];
            }else {
                temp[t++] = arr[j++];
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