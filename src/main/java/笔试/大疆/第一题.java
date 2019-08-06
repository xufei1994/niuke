package 笔试.大疆;/*
    @Author  87814   xufei
    @Date  2019/8/6    10:43
*//*
    @Author  87814   xufei
    @Date  2019/8/6    10:43
*/


import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 第一题 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        while (scanner.hasNext()){
            int N = scanner.nextInt(); // 需要解决的 bug数量
            int A = scanner.nextInt(); // 喝咖啡后效率提升的倍数
            int X = scanner.nextInt(); // 一天最多可以喝掉多少咖啡
            scanner.nextLine();
            String[] strings =scanner.nextLine().split(" ");
            System.out.println(f(N,A,X,strings));
        }
    }

    private static int f(int n, int a, int x, String[] strings) {//给你的是分钟
        if (n==0) return 0;
        int[] array = new int[n];
        for (int i = 0; i <n ; i++) {
            array[i]= Integer.parseInt(strings[i]);
            if (array[i]/a>480){
                array[i]=0;  //一天 解决不了的bug
            }
        }
        Arrays.sort(array);
        int res = 0;
        for (int i = n-1,j=0; j <x ; i--,j++) {
            if (array[i]%a==0){
                array[i] = array[i]/a;
            }else {
                array[i]= array[i]/a+1;
            }
        }
        for (int i = 0; i <n ; i++) {
            res+=array[i];
        }
        System.out.println(Arrays.toString(array));
        return res;
    }
}
