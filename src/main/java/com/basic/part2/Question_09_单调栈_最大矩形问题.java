package com.basic.part2;/*
    @Author  87814   xufei
    @Date  2019/4/16    21:53
*//*
    @Author  87814   xufei
    @Date  2019/4/16    21:53
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//单调栈结构想要解决的问题是 在一个数组中，所有的数 左边离他最近的比他大的   右边离他最近的比他大的
//1.准备一个栈  做到从栈底到栈顶是由大到小     就是从小到大出栈
// 右边最大值 谁让他弹出的 谁就是他右边离他最近 最大的值
// 左边最大值   它的底下是谁 就是离他最近的比他的左边的最大值  相等的时候要把下标链接在一起
/*
求最大矩阵大小：给定一个整形矩阵map，只有0和1两种  求其中全是1的所有矩形中，最大矩形区域为一的数量
 */
public class Question_09_单调栈_最大矩形问题 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String N_and_M[] = bufferedReader.readLine().split(" ");
         int N = Integer.parseInt(N_and_M[0]);
         int M = Integer.parseInt(N_and_M[1]);
         int[][] arr = new int[N][M];
        for (int i = 0; i <N ; i++) {
            String[] strings= bufferedReader.readLine().split(" ");
            for (int j = 0; j< M ; j++) {
                arr[i][j]=Integer.parseInt(strings[j]);
            }
        }
        for (int i = 0; i <N ; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
        System.out.println(maxMatrix(arr));
    }

    private static int  maxMatrix(int[][] arr) {
       if (arr==null ||arr.length ==0||arr[0].length == 0 ){
           return 0;
       }
       int maxArea = 0 ;
       int[] height = new int[arr[0].length];
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j <arr[0].length ; j++) {
                height[j] = arr[i][j]==0?0:height[j]+1;
            }
            maxArea =Math.max(maxRecFromBottm(height),maxArea);

        }
       return maxArea;
    }

    private static int maxRecFromBottm(int[] height) {
        if (height==null||height.length==0){
            return 0;
        }
        int maxArea = 0;
        Stack<Integer> stack = new Stack();
        for (int i = 0; i <height.length ; i++) {
            while (!stack.isEmpty()&&height[i]<=height[stack.peek()]){
                int j = stack.pop();
                int k = stack.isEmpty()?-1:stack.peek();
                int curArea = (i-k-1)*height[j];
                maxArea =Math.max(maxArea,curArea);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            int j = stack.pop();
            int k =stack.isEmpty()?-1:stack.peek();
            int curArea = (height.length-k-1)*height[j]; //另一边没有比他更小的
            maxArea =Math.max(maxArea,curArea);
        }
        return maxArea;
    }

}
