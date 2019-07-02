package 笔试.头条合集.后端实习生2017;/*
    @Author  87814   xufei
    @Date  2019/7/2    14:14
*//*
    @Author  87814   xufei
    @Date  2019/7/2    14:14
*/


import java.util.*;

public class 球队 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        for (int i=0; i<k; i++){
            String res = judge(scanner.nextLong(), scanner.nextLong(), scanner.nextLong(), scanner.nextLong());
            System.out.println(res);
        }
    }

    public static String judge(long n, long k, long d1, long d2){
        long[] nums = {k-d1-d2, k-d1+d2, k+d1-d2, k+d1+d2};
        if (nums[0] >= 0 && nums[0]%3 == 0){
            if(test(n, k, nums[0]/3, nums[0]/3+d1, nums[0]/3+d2))
                return "yes";
        }
        if (nums[1] >= 0 && nums[1]%3 == 0){
            if(test(n, k, nums[1]/3, nums[1]/3+d1, nums[1]/3-d2))
                return "yes";
        }
        if (nums[2] >= 0 && nums[2]%3 == 0){
            if(test(n, k, nums[2]/3, nums[2]/3-d1, nums[2]/3+d2))
                return "yes";
        }
        if (nums[3] >= 0 && nums[3]%3 == 0){
            if(test(n, k, nums[3]/3, nums[3]/3-d1, nums[3]/3-d2))
                return "yes";
        }

        return "no";
    }

    public static boolean test(long n, long k, long s2, long s1, long s3){
        if (s1 < 0 || s2 < 0 || s3 < 0) return false;
        if (s1+s2+s3 != k) return false;
        long left = n-k;
        long max = Math.max(s1, Math.max(s2, s3));
        long need = 3*max-(s1+s2+s3);
        if (left>=need && (left-need)%3==0)
            return true;
        return false;
    }
}