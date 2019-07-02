package 笔试.头条合集.后端实习生2017;/*
    @Author  87814   xufei
    @Date  2019/7/1    23:22
*//*
    @Author  87814   xufei
    @Date  2019/7/1    23:22
*/


import java.util.ArrayList;
import java.util.Scanner;

public class 魔法权值 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int K = scanner.nextInt();
            String[] strs = new String[n];
            for (int i = 0; i < n; i++) {
                strs[i] = scanner.next();
            }
            System.out.println(getNumWeightK(n, K, strs));
        }
    }

    public static int getNumWeightK(int n, int K, String[] strs) {
        int count = 0;
        ArrayList<String> strings = new ArrayList<String>();
        permutation(strings, strs, 0);
        for (int i = 0; i < strings.size(); i++) {
            int weightTemp = getWeight(strings.get(i));
            if (weightTemp == K) {
                count++;
            }
        }
        return count;
    }

    // 循环移位得到的权重 超时
    /*public static int getWeight(String s) {
        int weight = 0;
        char[] cs = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            char temp = cs[0];
            for (int j = 0; j < s.length() - 1; j++) {
                cs[j] = cs[j + 1];
            }
            cs[s.length() - 1] = temp;
            String rotateS = new String(cs);
            if (rotateS.equals(s)) {
                weight++;
            }
        }
        return weight;
    }*/
    //求一个字符的权重
    public static int getWeight(String s) {
        int weight = 0;
        int len = s.length();
        for(int i=0;i<s.length();i++){
            if(s.substring(0, i).equals(s.substring(len - i, len))
                    && s.substring(0, len-i).equals(s.substring(i, len))){
                weight++;
            }
        }
        return weight;
    }

    // 全排列
    public static void permutation(ArrayList<String> strings, String[] strs, int k) {
        if (k == strs.length) { // 去除重复排列
            String temp = "";  //一开始用StringBuffer类来保存，就超时了。所以尽量不要用StringBuffer
            for (int i = 0; i < strs.length; i++) {
                temp += strs[i];
            }
            strings.add(temp);// 不需要去除重复的排列
        }
        else{
            for (int i = k; i < strs.length; i++) {
                swap(strs, i, k);
                permutation(strings, strs, k + 1);
                swap(strs, i, k);
            }
        }
    }

    public static void swap(String[] strs, int i, int j) {
        if (i != j) {
            String t = strs[i];
            strs[i] = strs[j];
            strs[j] = t;
        }
    }
}
