package algs4.xufei.offer;/*
    @Author  87814   algs4.xufei
    @Date  2018/9/9    18:52
*//*
    @Author  87814   algs4.xufei
    @Date  2018/9/9    18:52
*/

/*

把一个数组最开始的若干个元素搬到数组的末尾，
我们称之为数组的旋转。 输入一个非减排序的数组的一个旋转
，输出旋转数组的最小元素。 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，
该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class Fanzhuanshuzu {
    public static void main(String[] args) {
        //给定一个反转数组
        //int[] s={4,5,1,2,3};//561234    789123456    678912345  678345   234567891    912345678
        int[] s={7,8,9,2,3,4,5,6};
        int[][]a=new int[3][3];
        int m=0;
        for (int i = 0; i <3 ; i++) {
            for (int j = 0; j <3 ; j++) {
                a[i][j]=m;
                System.out.println(a[i][j]);
                m++;
            }
        }

        System.out.println(a.length);
//        int length=a[0].length;
//
//
//        int n1 =search(s,0,s.length);
//   int n=minNumberInRotateArray(s);
//        System.out.println(n+" "+n1);
    }

    public static int search(int[] arr,int begin,int end) {
        int mid=(begin+end)/2;

        if (arr[mid]<arr[mid-1]){

            return arr[mid];
        }
        if (arr[mid]<arr[begin]){
            //如果中间比起始的小，说明在begin到mid有最小值  因为数组是递增的
            return search(arr,begin,mid);
        }
        if (arr[mid]>arr[end]){
            //如果中间比末尾的小，说明在end到mid有最小值  因为数组是递增的
            return search(arr,mid,end);
        }
        return -1;
    }


    public static int minNumberInRotateArray(int [] array) {
        int mid = 0;
        int begin=0;
        int end=array.length;
        while(begin<=end){
            mid=(end-begin)/2+begin;
            if (array[mid]<array[mid-1]){
                System.out.println(mid);
                return array[mid];
            }
            if (array[mid]<array[begin]){
                //如果中间比起始的小，说明在begin到mid有最小值  因为数组是递增的
                end=mid;
            }
            if(array[mid]>array[end]){
                //如果中间比末尾的小，说明在end到mid有最小值  因为数组是递增的
                begin=mid;
            }

        }
        return -1;

    }

    public boolean Find(int target, int [][] array) {
        int length2 = array[0].length-1;
        int length1 =array.length-1;
        for(int i=0;i<length1;i++){
            if(target<array[i][length2]){
                //说明target在数组中
                for(int j=0;j<length2;j++){
                    if(array[i][j]==target){
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
