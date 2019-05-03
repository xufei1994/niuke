package 笔试.day414.头条;/*
    @Author  87814   xufei
    @Date  2019/4/14    17:06
*//*
    @Author  87814   xufei
    @Date  2019/4/14    17:06
*/

import java.util.Scanner;

//Z国的货币系统包含面值1元、4元、16元、64元共计四种硬币，以及面值1024元的纸币。
//
//        现在小Y使用1024元的纸币购买了一件价值为N的商品，请问最少他会收到多少硬币。
public class Main01 {
    public static void main(String[] args) {
        int[] arr={1,4,16,64};
        Scanner scanner =new Scanner(System.in);
        int n=scanner.nextInt();
        System.out.println(dp(arr, n));
    }

    private static int dp(int[] arr, int n) {
        int target=1024-n;
        int count=0;
        while (target!=0){
            if (target>=arr[3]){
                target=target-arr[3];
                count++;
                continue;
            }else if (target>=arr[2]){
                target=target-arr[2];
                count++;
                continue;
            }else if (target>=arr[1]){
                target=target-arr[1];
                count++;
                continue;
            }else if (target>=arr[0]){
                target=target-arr[0];
                count++;
                continue;
            }
        }
        return count;
    }
}
