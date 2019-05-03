package 笔试.day401.week2;/*
    @Author  87814   xufei
    @Date  2019/4/28    20:29
*//*
    @Author  87814   xufei
    @Date  2019/4/28    20:29
*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
小Q得到了一个奇妙的数列，这个数列有无限多项，
数列中的第 i 个数字为i∗(−1)^i，比如数列的前几项为-1，2，-3，4，-5…
对于这个数列，我每次询问你一个区间，你在1秒内把这个区间里的数字的和告诉我，如果你答得上来我就跟你一起去吃饭
 */
public class AcWing568 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(bufferedReader.readLine().trim());
        int[] ans=new int[n];

        while (n-->0){
            String s=bufferedReader.readLine();
            String[] parts = s.split(" ");
            int p=Integer.parseInt(parts[0]);
            int q=Integer.parseInt(parts[1]);
            int sum1=0;//奇数和
            int sum2=0;//偶数和
            ans[n]=0;
            int m=q-p;
            if (p==q){
                if (p%2==0){
                    ans[n]=p;
                }else {
                    ans[n]=-p;
                }
            }else {
                if ((m)%2==0&&p%2==0){//两个偶数 一个奇数
                    sum1=-(m)/2*(p+1)+(m/2)*(m/2-1)*(-1);
                    sum2=(m/2+1)*p+(m/2+1)*(m/2);
                }else  if ((m)%2==0&&p%2==1){//两个奇数 一个偶数
                    sum1=-(m/2+1)*p+(m/2)*(m/2+1)*(-1);
                    sum2=(m/2)*(p+1)+(m/2-1)*(m/2);
                }else {//两个奇数 两个偶数
                    m=m+1;
                    if (p%2==1){
                        sum1=-(m/2)*p-(m/2-1)*(m/2);
                        sum2=(m/2)*(p+1)+(m/2-1)*(m/2);
                    }else {
                        sum1=-(m/2)*(p+1)-(m/2-1)*(m/2);
                        sum2=(m/2)*p+(m/2-1)*(m/2);
                    }
                }
                ans[n]=sum1+sum2;

            }
        }

        for (int i = ans.length-1; i >=0 ; i--) {
            System.out.println(ans[i]);
        }
    }
}