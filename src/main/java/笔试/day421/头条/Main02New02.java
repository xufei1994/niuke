package 笔试.day421.头条;/*
    @Author  87814   xufei
    @Date  2019/4/21    15:36
*//*
    @Author  87814   xufei
    @Date  2019/4/21    15:36
*/




import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.HashMap;

public class Main02New02{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(bufferedReader.readLine());  //视频帧数
        String[] strings = new String[M];
        for (int i = 0; i < M; i++) {
            strings[i] = bufferedReader.readLine();
        }
        //创建一个list 存取每帧的最后出现的lasttime
        LinkedList<HashSet<String>> last_time = new LinkedList<>();

       //存取所有的特征,每一次累加的次数
        LinkedList<HashMap<String,Integer>> countsStr = new LinkedList<>();

        int res = 0 ;
        //处理输入信息，把每帧的特征处理后放入两个hashmap 中
        for (int i = 0; i < M; i++) {
            HashSet<String> temp =new HashSet<>();
            HashMap count =new HashMap();
            String[] part = strings[i].split(" ");
            int k =Integer.parseInt(part[0]);
            for (int j = 1; j <2*k; j+=2) {
                String str = part[j]+"#"+part[j+1];
                temp.add(str);
                if (i>=1&&last_time.get(i-1).contains(str)){
                    count.put(str,countsStr.get(i-1).get(str)+1);
                }else {
                    count.put(str,1);
                }
                res =Math.max(res,(int)count.get(str));
            }
            last_time.add(temp);
            countsStr.add(count);

        }
        System.out.println(res);
    }

}



