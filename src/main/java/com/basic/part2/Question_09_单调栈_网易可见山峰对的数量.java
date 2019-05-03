package com.basic.part2;/*
    @Author  87814   xufei
    @Date  2019/4/16    21:53
*//*
    @Author  87814   xufei
    @Date  2019/4/16    21:53
*/

import com.basic.book.chapter_3_binarytreeproblem.Problem_08_BiggestBSTTopologyInTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

//单调栈结构想要解决的问题是 在一个数组中，所有的数 左边离他最近的比他大的   右边离他最近的比他大的
//1.准备一个栈  做到从栈底到栈顶是由大到小     就是从小到大出栈
// 右边最大值 谁让他弹出的 谁就是他右边离他最近 最大的值
// 左边最大值   它的底下是谁 就是离他最近的比他的左边的最大值  相等的时候要把下标链接在一起
/*
一个数组 代表一个环形的山，相邻可以看到，不相邻 只能看到较小的，能相互看见的山峰有多少对
i个数  2*i - 3对  小的去找大的数，解释 除去最高和次高两个点  一共还剩下n-2个点 这n-2个点 每个点都能左右找到两对比自己大的点
故2*（n-2）  还有最后的次高到最高的点  即 2*n-3对 能相互看见的山峰

如果有相同的值的时候 我先找到最大值，多个最大值，找到其中一个最大值即可, 把这个最大值作为起点
往后遍历  单调栈  从大到小 栈底到栈顶
 */
public class Question_09_单调栈_网易可见山峰对的数量 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String N_and_M[] = bufferedReader.readLine().split(" ");
        int N = Integer.parseInt(N_and_M[0]);
        int M = Integer.parseInt(N_and_M[1]);
        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] strings = bufferedReader.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(strings[j]);
            }
        }
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
    public class Record{
        public int value;
        public int times;
        public  Record(int value,int times){
            this.value =value;
            this.times =times;
        }
    }
    public int getVisibleNum(int[] arr){
        if (arr == null|| arr.length<2){
            return 0;
        }
        int size = arr.length;
        int maxIndex =0;
        //先在环中找到其中一个最大值的位置，哪一个都行
        for (int i = 0; i <arr.length ; i++) {
            maxIndex = arr[maxIndex]<arr[i]?i:maxIndex;
        }
        Stack<Record> stack =new Stack<>();
        //先把（最大值，1）这个记录放入stack中
        stack.push(new Record(arr[maxIndex],1));
        //从最大值位置的下一个位置开始沿next方向遍历
        int index = nextIndex(maxIndex,size);
        //用“小找大” 的方式统计所有可见山峰
        int res = 0;
        //遍历阶段开始，当index再次回到maxIndex的时候，说明转了一圈，遍历阶段就结束了
        while (index!=maxIndex){
            //如果当前数字arr[index] 要进栈，判断会不会破坏第一维的数组从顶到底依次变大
            //如果破坏了，就依次弹出栈顶记录，并计算山峰对数量
            while (stack.peek().value<arr[index]){
                int k =stack.pop().times;
                //弹出记录为（x,k），如果k==1,产生2对
                //如果k>1,产生2*k+C（2，k）对
                res +=getInternalSum(k) + 2*k;
            }
            //当前数字arr[index]要进入栈了，如果和当前栈顶数字一样就合并
            //不一样就把记录（arr[index],1）放入栈中
            if (stack.peek().value==arr[index]){
                stack.peek().times++;
            }else {
                stack.push(new Record(arr[index],1));
            }
            index =nextIndex(index,size);
        }



        //清算阶段开始
        //清算阶段的第一小阶段
        while (stack.size()>2){
            int times = stack.pop().times;
            res += getInternalSum(times)+2*times;
        }
        //清算阶段的第2小阶段
        if(stack.size()==2){
            int times =stack.pop().times;
            res += getInternalSum(times) + (stack.peek().times == 1 ?times:2*times);
        }
        //清算阶段的第三小阶段
        res +=getInternalSum(stack.pop().times);
        return res;
    }

    //环形数组中当前的位置为i，数组长度为size，返回i的下一个位置
    private int nextIndex(int index, int size) {
        return index<(size-1)?(index+1):0;
    }
    //如果k==1，返回0;如果k>1，则返回C（2，k）
    private int getInternalSum(int k) {
        return k==1 ? 0:(k*(k-1)/2);
    }


}
