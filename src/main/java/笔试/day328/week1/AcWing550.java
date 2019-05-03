package 笔试.day328.week1;/*
    @Author  87814   xufei
    @Date  2019/4/29    21:58
*//*
    @Author  87814   xufei
    @Date  2019/4/29    21:58
*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class AcWing550 {
    static int n;
    static int m;
    static String[] g;
    static  char[][] mp;
       static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());  //几组测试数据
        LinkedList<String[]> list = new LinkedList();
        for (int i = 0; i < N; i++) {
            String len = bufferedReader.readLine();
            String[] lens =len.split(" ");
            String[] strings = new String[Integer.parseInt(lens[0])];
            for (int j = 0; j < Integer.parseInt(lens[0]); j++) {
                strings[j] = bufferedReader.readLine();
            }
            list.add(strings);
        }

        for (int i = 0; i < N; i++) {
            System.out.println("Case #" + (i + 1) + ": " + deal(list.get(i), list.get(i).length, list.get(i)[0].length()));
        }
    }

    private static int deal(String[] strings, int row, int line) {

        n = row;
        m = line;
        g = strings;
        dist =new int[n][m];

        int l =0 ;
        int r =n+m;
        while (l<r){
            int mid = (l+r)/2;
            if (check(mid)){ r=mid;
            }else {l=mid+1;}
            System.out.println("l    "+l+"   r    "+r);

        }
        return r;
}


    static void bfs(int k) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i <n ; i++) {
            Arrays.fill(dist[i],-1);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (g[i].charAt(j) == '1') {
                    dist[i][j] = 0;
                    ((LinkedList<int[]>) queue).offer(new int[]{i, j});
                }
            }//forj
        }//fori
        int dx[] = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        while (!queue.isEmpty()) {
            int[] temp = ((LinkedList<int[]>) queue).poll();
            int x = temp[0];
            int y = temp[1];
            int distance = dist[x][y];
            if (distance == k) continue;
            for (int i = 0; i < 4; i++) {
                int a = x + dx[i];
                int b = y + dy[i];
                if (a >= 0 && a < n && b >= 0 && b < m && dist[a][b] == -1) {
                    dist[a][b] = distance + 1;
                    ((LinkedList<int[]>) queue).offer(new int[]{a,b});
                }
            }
        }

    }

   static  boolean check(int k) {

        bfs(k);
        int min_sum = Integer.MAX_VALUE;
        int max_sum = Integer.MIN_VALUE;
        int min_sub = Integer.MAX_VALUE;
        int max_sub = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dist[i][j] == -1) {
                    min_sum = Math.min(min_sum, i + j);
                    max_sum = Math.max(max_sum, i + j);
                    min_sub = Math.min(min_sub, i - j);
                    max_sub = Math.max(max_sub, i - j);

                }
            }
        }

       if (min_sum == Integer.MAX_VALUE) {return true;}
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <m ; j++) {
                if (dist[i][j]==-1){
                    int sum = Math.max(Math.abs(i+j-max_sum),Math.abs(i+j-min_sum));
                    int sub = Math.max(Math.abs(i-j-min_sub),Math.abs(i-j-max_sub));
                    if (Math.max(sum,sub)<=k){ return true;}
                }
            }
        }

        return false;
    }

}