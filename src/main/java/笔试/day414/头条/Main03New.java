package 笔试.day414.头条;/*
    @Author  87814   xufei
    @Date  2019/4/14    21:58
*//*
    @Author  87814   xufei
    @Date  2019/4/14    21:58
*/



import java.util.*;
/*
有n个人参加编程比赛，比赛结束后每个人都得到一个分数；现在所有人排成一圈（第一个和第n个相邻）领取奖品，要求：

1、如果某个人的分数比左右的人高，那么奖品数量也要比左右的人多；

2、每个人至少得到一个奖品；

问最少应该准备多少个奖品。
 */
public class Main03New {

    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        ArrayList list = new ArrayList<>(n); //几次  几组学生  存结果

        for (int i = 0; i <n ; i++) {
            int[] score=new int[Integer.parseInt(scanner.nextLine())];//第一组的学生个数
            for (int j = 0; j <score.length ; j++) {
                score[j]=scanner.nextInt();
            }
            scanner.nextLine();
            list.add(f(score));
        }
        for (int i = 0; i <n ; i++) {
            System.out.println(list.get(i));
        }
    }




    /*
    问题所在 Scanner的输入速度过慢
    BufferedReader可以用来读取文件或者接收来自键盘（控制台）的信息。
    它比Scanner更加快捷，能够大幅度缩短程序运行时间。它下面的readline()方法可以一次性读取一行文字（String），
    非常方便。需要注意的是，使用BufferedReader对象的readLine()方法必须处理java.io.IOException异常(Exception)。
    以及，在使用完BufferredReader以后，需要用close()方法关闭流。
     */
    private static int f(int[] temp) { //需要保留一个对照的数组

        int n =temp.length;

        List<int[]> personList = new ArrayList<>();
        // 记录每个人的分数和位置
        for (int i = 0; i < n; ++i) {
            personList.add(new int[]{temp[i], i});
        }
        //按分数从低到高排序
        Collections.sort(personList, Comparator.comparingInt(o -> o[0]));


        int[] sweetNumber =new int[n];

        //排序完成后  下标也发生了改变
        for (int i = 0; i <n; i++) {
            int[] ints= personList.get(i);//最小的这个小朋友原来的下标是多少
            int index =ints[1];
            int cur =ints[0];
            int left = (index-1+n)%n; //左边小朋友
            int right = (index+1)%n; //右边小朋友
            int lv=1,rv=1;
            if (cur>temp[left]) lv=sweetNumber[left]+1;
            if (cur>temp[right]) rv=sweetNumber[right]+1;
            sweetNumber[index]=Math.max(lv,rv);
        }
        int ans=0;
        for (int i = 0; i <n ; i++) {
            ans+=sweetNumber[i];
        }
        //System.out.println(Arrays.toString(time.students));
        return ans;
    }
}
