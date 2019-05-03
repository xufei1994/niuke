package 笔试.day421.头条;/*
    @Author  87814   xufei
    @Date  2019/4/21    19:01
*//*
    @Author  87814   xufei
    @Date  2019/4/21    19:01
*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main05 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(bufferedReader.readLine());
        String[] strings =new String[N];

        for (int i = 0; i <N ; i++) {
            String m=bufferedReader.readLine();
            strings[i] =bufferedReader.readLine();
        }

        for (int i = 0; i < N; i++) {
            String[] part =strings[i].split(" ");
            long[] arr =new long[part.length];
            for (int j = 0; j <part.length ; j++) {
                arr[j]=Integer.parseInt(part[j]);
            }
            System.out.println(Arrays.toString(arr));
            System.out.println(minCrossRiver(arr,part.length));
        }

    }

    //为了安全起见，要求每次至少有两个人才能过河。
    //一共分为三种情况 这次船 送一个人   两个原来船上的人回来，
    //一共分为三种情况 这次船 送两个个人 1个原来船上的人回来，加上留在河对岸的一个次小值
    //一共分为三种情况 这次船 送三个人   0原来船上的人回来， 两个最小的回来
    private static long minCrossRiver(long[] arr, int m) {
        Arrays.sort(arr); //先排序
        long f[] = new long[m+1];
        Arrays.fill(f,0);


        if (arr.length<=3){
            return arr[m-1];
        }else {
            for (int i = m-1; i >2 ; i--) {
                f[i] = f[i+1]+arr[1]+arr[i];
                if (i+2<=m) f[i]=Math.min(f[i],f[i+2]+arr[i+1]+2*arr[2]+arr[1]);
                if (i+3<=m) f[i]=Math.min(f[i],f[i+ 3]+ 2*arr[1]+ arr[2] + arr[i+2] + 2*arr[3]);
            }
        }
        System.out.println(Arrays.toString(f));
        return (arr[2]+f[3]);
    }
}
