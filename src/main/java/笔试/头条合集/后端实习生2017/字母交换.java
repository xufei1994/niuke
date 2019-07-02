package 笔试.头条合集.后端实习生2017;/*
    @Author  87814   xufei
    @Date  2019/7/2    12:39
*//*
    @Author  87814   xufei
    @Date  2019/7/2    12:39
*/


import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
public class 字母交换 {
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        int m=sc.nextInt();
        sc.close();

        Map<Character,List<Integer>>map=new HashMap<>();
        int len=str.length();
        //将每个字符出现的每个位置都放在一起
        for(int i=0;i<len;i++){
            List<Integer> eachWord=map.getOrDefault(str.charAt(i),new ArrayList<>());
            eachWord.add(i);
            map.put(str.charAt(i),eachWord);
        }
        int maxLen=1;

        for(char ch:map.keySet()){
            //如果一个字符只出现了一次那么直接跳过
            if(map.get(ch).size()==1)
                continue;
            int maxCharLen=getMaxCharLen(map.get(ch),m);
            maxLen=Math.max(maxLen,maxCharLen);
        }
        System.out.println(maxLen);
    }

    public static int getMaxCharLen(List<Integer>eachWord,int m){
        int n=eachWord.size();
        //dp[i][j]表示将链表中第i和第j个元素移动到一起所花的交换次数
        int[][]dp=new int[n][n];
        for(int i=0;i<n-1;i++){
            dp[i][i]=0;
            dp[i][i+1]=eachWord.get(i+1)-eachWord.get(i)-1;
        }
        dp[n-1][n-1]=0;
        //一次遍历选择不动的中心
        int maxLen=0;
        //因为从状态转移方程可以看出，每一行与其后面的一行有关，所以i--
        //每一列与前一列有关，所以j++
        //然后，因为这里状态方程是i+1,j-1，所以默认了i<=j，而前面初始化的时候又考虑了i=j和i+1=j的情况
        for(int i=n-3;i>=0;i--){
            for(int j=i+2;j<n;j++){
                dp[i][j]=dp[i+1][j-1]+eachWord.get(j)-eachWord.get(i)-(j-i);
                if(dp[i][j]<=m)
                    maxLen=Math.max(maxLen,j-i+1);
            }
        }
        return maxLen;
    }

}
