package 笔试.头条合集.后端实习生2017;/*
    @Author  87814   xufei
    @Date  2019/7/2    12:55
*//*
    @Author  87814   xufei
    @Date  2019/7/2    12:55
*/

import java.util.*;

public class 房间 {
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int x=sc.nextInt();
        long minRoom=Integer.MAX_VALUE;
        long[]room=new long[n];
        //注意，由于数据可能很大，所以这里需要为long
        Map<Long,List<Integer>>map=new HashMap<>();
        for(int i=0;i<n;i++){
            room[i]=sc.nextInt();
            minRoom=Math.min(minRoom,room[i]);
            List<Integer>list=map.getOrDefault(room[i],new ArrayList<>());
            list.add(i);
            map.put(room[i],list);
        }
        sc.close();
        List<Integer>temp=map.get(minRoom);
        int index=0;            //用于存储人数原本所在房间号数
        int len=temp.size();
        if(len==1)      //当分配后人数最少的房间只有一间时则该房间即为分配出去的房间
            index=temp.get(0);
        else{
            if(temp.get(0)<=x-1){        //情况为：  min  min   (min)  x   min
                //此时应该找到小于x的最大值
                int i=0;
                while(i<len&&temp.get(i)<=x-1)
                    i++;
                index=temp.get(i-1);
            }else                       //情况为：x   min    min    (min)
                //此时应该找到离x最远的值
                index=temp.get(len-1);
        }
        if(index>x-1){
            long tt=room[index]+1;
            for(int i=0;i<n;i++)
                room[i]-=tt;

            for(int i=x;i<=index;i++)
                room[i]+=1;
            room[index]+=((tt-1)*n+(n+x-1-index));
        }else{
            long tt=room[index];
            for(int i=0;i<n;i++)
                room[i]-=tt;

            for(int i=index+1;i<x;i++)
                room[i]-=1;
            room[index]+=((long)tt*n+(x-1-index));
        }
        for(int i=0;i<n;i++)
            System.out.print(room[i]+" ");
    }
}
