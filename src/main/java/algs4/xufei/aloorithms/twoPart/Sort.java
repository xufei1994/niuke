package algs4.xufei.aloorithms.twoPart;/*
    @Author  87814   algs4.xufei
    @Date  2018/8/13    12:59
*//*
    @Author  87814   algs4.xufei
    @Date  2018/8/13    12:59
*/


import org.junit.Test;

public class Sort {
    public static void insertionSort(int a[]){
        for (int j = 2; j <a.length ; j++) {
            int key=a[j];
            int i=j-1;
            while (i>0&&a[i]>key){
                a[i+1]=a[i];
                i=i-1;
                }
                a[i+1]=key;
        }


    }
    /*
    @para a 数组
    @para p、q、r都是数组下标   p<=q<=r

     */
    public static void mergeSort(int a[],int p,int q,int r){
        int n1=q-p+1;
        int n2=r-q;
        int left[]=new int[n1+1];
        int right[]=new int[n2+1];
        for (int i = 0; i <n1 ; i++) {
            left[i]=a[p+i-1];
        }
        Sort.insertionSort(left);
        for (int i = 0; i <n2 ; i++) {
            right[i]=a[q+i];
        }
        left[n1]=0;
        left[n2]=0;
        Sort.insertionSort(right);
         int i=1;
         int  j=1;
        for (int k = p; k <=r ; k++) {
            if (left[i]<=right[j]&&left[i]!=0){
                a[k]=left[i];
               i=i+1;

            }else if (left[i]>=right[j]&&right[i]!=0){
                a[k] = right[j];
                j=j+1;
            }

        }
}




    @Test
    public void test1(){
        int a[]={10,77,88,99,66,55,44,22,33,11};
        Sort.mergeSort(a,1,4,a.length);

        for (int i = 0; i <a.length ; i++) {
            System.out.println(a[i]);
        }

    }




}
