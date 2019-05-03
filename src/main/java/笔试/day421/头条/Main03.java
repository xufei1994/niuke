package 笔试.day421.头条;/*
    @Author  87814   xufei
    @Date  2019/4/21    17:00
*//*
    @Author  87814   xufei
    @Date  2019/4/21    17:00
*/


import java.util.Arrays;

/*机器人正在玩一个古老的基于DOS的游戏。

        游戏中有N+1座建筑——从0到N编号，从左到右排列。

        编号为0的建筑高度为0个单位，编号为 i 的建筑高度为H(i)个单位。

        起初，机器人在编号为0的建筑处。

        每一步，它跳到下一个（右边）建筑。

        假设机器人在第k个建筑，且它现在的能量值是E，下一步它将跳到第k+1个建筑。

        如果H(k+1)>E，那么机器人就失去H(k+1)-E的能量值，否则它将得到E-H(k+1)的能量值。

        游戏目标是到达第N个建筑，在这个过程中能量值不能为负数个单位。

        现在的问题是机器人以多少能量值开始游戏，才可以保证成功完成游戏？

        输入格式
        第一行输入整数N。

        第二行是N个空格分隔的整数，H(1),H(2),…,H(N)代表建筑物的高度。

        输出格式
        输出一个整数，表示所需的最少单位的初始能量值。

        数据范围
        1≤N,H(i)≤105,

        输入样例1：
        5
        3 4 3 2 4
        输出样例1：
        4
        输入样例2：
        3
        4 4 4
        输出样例2：
        4
        输入样例3：
        3
        1 6 4
        输出样例3：
        3
        */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main03 {
    static  int[] arr;
    static int H =100000;
    //二分法 数据规模 1≤N,H(i)≤105
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        String[] strings = bufferedReader.readLine().split(" ");
        arr =new int[N];
        for (int i = 0; i <N ; i++) {
            arr[i] = Integer.parseInt(strings[i]);
        }

        System.out.println(find());
    }

    private static int find() {
        //跳跃规则 2E - h0 =x0  2(x0)-h1 = 4E-2h0-hi
      int L=0;
      int R =H;

      while (L<R){
        int mid =(L+R)/2;//l+r>>1
        if (binarySearch(mid)) {
            R = mid;
        }else {
            L = mid+1;
        }
          System.out.println(R);
      }

      return R;
    }
    private static boolean binarySearch(int mid) {
        for (int i = 0; i <arr.length ; i++) {
            mid=mid - (arr[i]-mid);
         if (mid>=100010){ return true;}  //
         if (mid<0){ return false;}
        }
        return true;

    }

}

/*
50000
25000
12500
6250
3125
1562
781
390
195
97
48
24
12
6
3
3
3
3
 */