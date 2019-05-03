package 笔试.day414.头条;/*
    @Author  87814   xufei
    @Date  2019/4/14    21:58
*//*
    @Author  87814   xufei
    @Date  2019/4/14    21:58
*/

import java.sql.Time;
import java.util.*;

/*
有n个人参加编程比赛，比赛结束后每个人都得到一个分数；现在所有人排成一圈（第一个和第n个相邻）领取奖品，要求：

1、如果某个人的分数比左右的人高，那么奖品数量也要比左右的人多；

2、每个人至少得到一个奖品；

问最少应该准备多少个奖品。
 */
public class Main03 {
    static class Student{
        int index;
        int score;
        int sweetNumber=1;
        @Override
        public String toString() {
            return "Student{" +
                    "index=" + index +
                    ", score=" + score +
                    ", sweetNumber=" + sweetNumber +
                    '}';
        }
    }
    static class Times{
        Student[] students;
        int capacity;
        Times(int capacity){
            this.capacity=capacity;
            students=new Student[capacity];
        }
    }
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Times[] times =new Times[n]; //几次  几组学生

        for (int i = 0; i <n ; i++) {
              times[i]=new Times(Integer.parseInt(scanner.nextLine()));//第一组的学生个数
            for (int j = 0; j <times[i].students.length ; j++) {
                times[i].students[j]=new Student();
                times[i].students[j].score=scanner.nextInt();
                times[i].students[j].index=j;
            }
            scanner.nextLine();
        }
        for (int i = 0; i <n ; i++) {
            System.out.println(f(times[i]));
        }
    }
    private static int f(Times time) {
        HashMap<Integer,Student> map = new HashMap<>();
        for (int i = 0; i <time.capacity ; i++) {
            map.put(i,time.students[i]);
        }
         Arrays.sort(time.students, new Comparator<Student>() {
             @Override
             public int compare(Student o1, Student o2) {
                 return o1.score>o2.score?1:-1;
             }
         });
        System.out.println(Arrays.toString(time.students));
         //排序完成后  下标也发生了改变
        for (int i = 0; i <time.capacity; i++) {
            Student cur = time.students[(i+time.capacity)%time.capacity];//第几个小朋友

            Student left = map.get((cur.index-1+time.capacity)%time.capacity); //左边小朋友
            Student right = map.get((cur.index+1)%time.capacity); //右边小朋友
            int lv=1,rv=1;
            if (cur.score>left.score) lv=left.sweetNumber+1;
            if (cur.score>right.score) rv=right.sweetNumber+1;
            cur.sweetNumber=Math.max(lv,rv);
        }
        int ans=0;
        for (int i = 0; i <time.capacity ; i++) {
            Student cur = time.students[i];//第几个小朋友
            ans+=cur.sweetNumber;
        }
        System.out.println(Arrays.toString(time.students));
          return ans;
    }
}
