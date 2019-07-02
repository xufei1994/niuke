package 笔试.头条合集.后端实习生2017;/*
    @Author  87814   xufei
    @Date  2019/7/2    14:16
*//*
    @Author  87814   xufei
    @Date  2019/7/2    14:16
*/


import java.util.Scanner;

/**
 * 有一个仅包含’a’和’b’两种字符的字符串s，长度为n，
 * 每次操作可以把一个字符做一次转换（把一个’a’设置为’b’，或者把一个’b’置成’a’)；但是操作的次数有上限m
 * ，问在有限的操作数范围内，能够得到最大连续的相同字符的子串的长度是多少。
 * @author hp
 *
 */
public class 变化字符串 {
    public static void main(String[] args) {
        int max = 0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String s = sc.next();
        char[] data = s.toCharArray();
        max = Math.max(maxLength(n, m, 'a', data), maxLength(n, m, 'b', data));
        System.out.println(max);
    }

    public static int maxLength(int n,int m,char c,char[] data) {
        int max = 0;
        int j = 0;
        for(int i=0;i<n;i++) {
            if(data[i] == c) {
                if(m > 0) {
                    m--;
                }else {
                    while(data[j] != c) {
                        j++;
                    }
                    j++;
                }
            }
            max = Math.max(max, i+1-j);
        }
        return max;
    }
}