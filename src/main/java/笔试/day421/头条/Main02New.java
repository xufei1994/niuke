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

public class Main02New {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(bufferedReader.readLine());  //视频帧数
        String[] strings = new String[M];
        for (int i = 0; i < M; i++) {
            strings[i] = bufferedReader.readLine();
        }
        //创建一个list 存取每帧的信息
        LinkedList<HashSet<String>> cats = new LinkedList<>();

        //存取所有的特征,和第一次出现的下标
        HashMap<String,Integer> aspectsAll =new HashMap<>();

        //处理输入信息，把每帧的特征处理后放入一个set中 之后再放入一个list
        for (int i = 0; i < M; i++) {
            HashSet<String> temp =new HashSet<>();
            String[] part = strings[i].split(" ");
            int k =Integer.parseInt(part[0]);
            for (int j = 1; j <2*k; j+=2) {
             String str = part[j]+"#"+part[j+1];
             temp.add(str);
             if (!aspectsAll.containsKey(str)){
                 aspectsAll.put(str,i);
             }
            }
            cats.add(temp);
        }
        System.out.println(find(cats,aspectsAll));
    }

    private static int find(LinkedList<HashSet<String>> cats, HashMap<String, Integer> aspectsAll) {

        int maxNum = Integer.MIN_VALUE;
        for (String str: aspectsAll.keySet()) {
            int temp =0;
            //每次判断一个特征在所有帧中出现的次数
            for (int i = aspectsAll.get(str); i <cats.size() ; i++) {
                //利用哈希set 查找特性
                if (cats.get(i).contains(str)){
                    temp++;
                }else {
                    temp=0;
                }
                maxNum =Math.max(maxNum,temp);
            }
        }
        return maxNum;
    }

}


