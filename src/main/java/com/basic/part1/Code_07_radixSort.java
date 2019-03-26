package com.basic.part1;/*
    @Author  87814   xufei
    @Date  2019/3/26    19:23
*//*
    @Author  87814   xufei
    @Date  2019/3/26    19:23
*/
//基数排序  分配式排序  其时间复杂度为O (nlog(r)m) 其中r为所采取的基数，而m为堆数
/*
73, 22, 93, 43, 55, 14, 28, 65, 39, 81
第一步
首先根据个位数的数值，在走访数值时将它们分配至编号0到9的桶子中：
0
1 81
2 22
3 73 93 43
4 14
5 55 65
6
7
8 28
9 39
第二步
接下来将这些桶子中的数值重新串接起来，成为以下的数列：
81, 22, 73, 93, 43, 14, 55, 65, 28, 39
接着再进行一次分配，这次是根据十位数来分配：
0
1 14
2 22 28
3 39
4 43
5 55
6 65
7 73
8 81
9 93
第三步
接下来将这些桶子中的数值重新串接起来，成为以下的数列：
14, 22, 28, 39, 43, 55, 65, 73, 81, 93
这时候整个数列已经排序完毕；如果排序的对象有三位数以上，则持续进行以上的动作直至最高位数为止
 */

public class Code_07_radixSort {

        public static void sort(int[] number, int d) //d表示最大的数有多少位
        {
            int k = 0;
            int n = 1;  //表示到了第几位
            int m = 1; //控制键值排序依据在哪一位
            int[][] temp = new int[10][number.length]; //数组的第一维表示可能的余数0-9
            int[] order = new int[10]; //数组orderp[i]用来表示该位是i的数的个数
            while(m <= d){
                for(int i = 0; i < number.length; i++)
                {
                    int lsd = ((number[i] / n) % 10);
                    temp[lsd][order[lsd]] = number[i];
                    order[lsd]++;
                }

                for(int i = 0; i < 10; i++)
                {
                    if(order[i] != 0) {
                        for (int j = 0; j < order[i]; j++) {
                            number[k] = temp[i][j];
                            k++;
                        }
                    }
                    order[i] = 0;
                }
                n *= 10;
                k = 0;
                m++;
            }
        }
        public static void main(String[] args)
        {
            int[] data =
                    {73, 22, 93, 43, 55, 14, 28, 65, 39, 81, 33, 100};
            //找到最大值100，求出它的d = 3
            int max=data[0];
            for (int i = 0; i <data.length ; i++) {
                if (data[i]>max){
                    max=data[i];
                }
            }
            Code_07_radixSort.sort(data,String.valueOf(max).length());
            for(int i = 0; i < data.length; i++)
            {
                System.out.print(data[i] + "");
            }
        }

}
