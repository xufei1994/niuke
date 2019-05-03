package 笔试.day421.头条;/*
    @Author  87814   xufei
    @Date  2019/4/21    10:54
*//*
    @Author  87814   xufei
    @Date  2019/4/21    10:54
*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
值0代表空单元格;
值1代表产品经理;
值2代表程序员;
每分钟，任何与程序员(在4个正方向上)相邻的产品经理都会变成程序员。

返回直到单元格中没有产品经理为止所必须经过的最小分钟数。
2 1 1      2 2 1      2 2 2      2 2 2      2 2 2
1 1 0  ->  2 1 0  ->  2 2 0  ->  2 2 0  ->  2 2 0
0 1 1      0 1 1      0 1 1      0 2 1      0 2 2
 */
public class Main01 {
     static int N=11;
     static int[][] g;
     static int[][] d;
     static int n;
     static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader  =new BufferedReader(new InputStreamReader(System.in));
        int i=0;
        String[] strings = new String[10];
        String s;
        while (true){
            s=bufferedReader.readLine();
            if (s.trim().equals("")) {break;}
            strings[i]= s;
            i++;
        }
        n=i;
        g =new int[11][11];
        d = new int[11][11];
        m=strings[0].split(" ").length;
        for (int j = 0; j <i ; j++) {
            for (int k = 0; k <m ; k++) {
                String temp[] = strings[j].split(" ");
                g[j][k] = Integer.parseInt(temp[k]);
            }
        }
        System.out.println(bfs());

    }
public static class Pair{
        int x;
        int y;

    public  Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

  //队列入队使用addLast 不要使用push
    public static int bfs(){
        Queue queue =new LinkedList();
        for (int j = 0; j <n ; j++) {
            Arrays.fill(d[j],-1); //将d数组全部填充为-1
        }
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <m ; j++) {
                if (g[i][j]==2){
                    d[i][j] =0;  //同时将d[i][j]的距离设置为0
                    ((LinkedList) queue).addLast(new Pair(i,j));
                }
            }
        }
        int dx[] ={-1,0,1,0};
        int dy[] ={0,-1,0, 1};
        while (!queue.isEmpty()){
            Pair temp = (Pair) ((LinkedList) queue).pop();
            int x= temp.x;
            int y= temp.y;
            int dist = d[x][y];

            for (int i = 0; i <4 ; i++) {
                int a= x+dx[i];
                int b= y+dy[i];
                if (a>=0&&a<n&& b>=0 &&b<m && d[a][b]==-1&&g[a][b]==1){
                    d[a][b]=dist+1;
                    ((LinkedList) queue).addLast(new Pair(a,b));
                }
            }
        }


        int res =0 ;
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <m ; j++) {
                if (g[i][j]==1){
                    if (d[i][j]==-1) {return -1;}
                    res = Math.max(res,d[i][j]);
                }
            }
        }
        return res;
    }
}
/*
多元最短路问题
所有边的权值为1  可以使用bfs
宽松 bfs
 */