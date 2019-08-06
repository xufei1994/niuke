package dd.dp;/*
    @Author  87814   xufei
    @Date  2019/4/25    23:04
*//*
    @Author  87814   xufei
    @Date  2019/4/25    23:04
*/


import java.util.*;

public class Solution {
    public int GetUglyNumber_Solution(int index) {

        if (index <= 0) {
            return 0;
        }
        int[] result = new int[index];
        int count = 0;
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        result[0] = 1;
        int temp = 0;
        while (count < index - 1) {
            temp = Math.min(result[i2] * 2, Math.min(result[i3] * 3, result[i5] * 5));
            if (temp == result[i2] * 2) i2++;
            if (temp == result[i3] * 3) i3++;
            if (temp == result[i5] * 5) i5++;
            result[++count] = temp;
        }

        return result[index - 1];
    }

    public static void main(String[] args) {
        System.out.println(hasPath("abcesfcsadee".toCharArray(), 3, 4, "abcb".toCharArray()));
    }

    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        //标识符
        boolean[] flag = new boolean[matrix.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (judge(matrix, i, j, rows, cols, flag, str, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean judge(char[] matrix, int i, int j, int rows, int cols, boolean[] flag, char[] str, int k) {
        //当前点的坐标
        int index = i * cols + j;
        if (i < 0 || j < 0 || i >= rows || j >= cols || matrix[index] != str[k] || flag[index] == true) {
            return false;
        }
        if (k == str.length - 1) {
            return true;
        }
        flag[index] = true;
        if (    judge(matrix, i+1, j, rows, cols, flag, str, k+1) ||
                judge(matrix, i-1, j, rows, cols, flag, str, k+1) ||
                judge(matrix, i, j+1, rows, cols, flag, str, k+1) ||
                judge(matrix, i, j-1, rows, cols, flag, str, k+1)){
            return true;
        }
        flag[index]=false;
        return false;
    }

    public static boolean hasPath1(char[] matrix, int rows, int cols, char[] str)
    {
        if (matrix==null||str==null){
            return false;
        }
        if (matrix.length==1&&str.length==1){
            return matrix[0]==str[0];
        }
        char[][] chars =new char[rows][cols];
        for (int i = 0; i <rows ; i++) {
            for (int j = 0; j <cols ; j++) {
                if (i==0){
                    chars[i][j]=matrix[j];//0 0 1 2 3
                }else {
                    chars[i][j]=matrix[j+i*cols];//0 0 1 2 3
                }
            }
        }
        int[] dx= {1,0,-1,0};
        int[] dy= {0,-1,0,1};
        boolean[][] booleans =new boolean[rows][cols];//将走过的位置设置为true
        //matrix的坐标等于  rows*cols
        char start = str[0];  // a b c e s f c s a d e e   b c c e d
        Queue<int[]> queue =new LinkedList<>();
        //将所有 起点一样的入队
        for (int i = 0; i <rows; i++) {
            for (int j = 0; j <cols; j++) {
                if (i<rows&&j<cols&&chars[i][j]==start){
                    ((LinkedList<int[]>) queue).add(new int[]{i,j});
                }
            }
        }
        int max =0;
/*
这个方法是错误的 ，有几种案例跑不过 ，只适用于第2个及以后元素周围没有重复的测试案例
 */
        //进行 宽搜 bfs
        while (!queue.isEmpty()){
            int[] temp =((LinkedList<int[]>) queue).pollFirst(); //第一个入队的起点出队
            //以它为起点进行查找,同时将它设置为true
            booleans[temp[0]][temp[1]]= true;
            int px = temp[0];
            int py = temp[1];
            int number =1;


            for (int k = 1; k <str.length ; k++) {
                //同时将这个坐标
                for (int i = 0; i <4 ; i++) {
                    int   x = px+dx[i];
                    int   y = py+dy[i];
                    if (x>=0&&y>=0&&x<rows&&y<cols&&booleans[x][y]==false&&chars[x][y]==str[k]){
                        booleans[x][y]=true;
                        number++;
                        px=x;
                        py=y;
                    }
                    max= Math.max(number,max);
                }

            }
            for (int i = 0; i <rows ; i++) {
                Arrays.fill(booleans[i],false);
            }

        }
        return max==str.length;
    }

    public boolean hasPath(char[][] chars, String s) {
        if (chars==null||s==null||chars.length<1||s.length()<1){
            return false;
        }
        int rows = chars.length;
        int cols = chars[0].length;
        char[] str = s.toCharArray();
        boolean flag[][] = new boolean[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(judge(chars,i,j,rows,cols,flag,str,0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean judge(char[][] chars, int i, int j, int rows, int cols, boolean[][] flag, char[] str, int k) {
        if (i<0||j<0||i>=rows||j>=cols||flag[i][j]==true||chars[i][j]!=str[k]){
            return false;
        }
        if (k==str.length-1){
            return true;
        }
        flag[i][j]=true;
        if (    judge(chars, i+1, j, rows, cols, flag, str, k+1)||
                judge(chars, i-1, j, rows, cols, flag, str, k+1)||
                judge(chars, i, j-1, rows, cols, flag, str, k+1)||
                judge(chars, i, j+1, rows, cols, flag, str, k+1)){
         return true;
        }
        flag[i][j]=false;
        return false;
    }


    private static void infect1(int[][] arrar, int i, int j, int n, int m,int k) {
        if (i<0||i>=n||j<0||j>=m||flag(i,j,k)||arrar[i][j]==1){
            return;
        }
        arrar[i][j]=1;
        infect1(arrar,i+1,j,n,m,k);
        infect1(arrar,i-1,j,n,m,k);
        infect1(arrar,i,j+1,n,m,k);
        infect1(arrar,i,j-1,n,m,k);
    }

    private static boolean flag(int i, int j,int k) {
        String s = i+""+j;
        int[] ints = new int[s.length()];
        int sum=0;
        for (int l = 0; l <s.length() ; l++) {
            ints[l]=s.charAt(l)-'0';
            sum+=ints[l];
        }
        return sum>k;
    }


    public static int movingCount(int k, int rows, int cols)
    {
        int res =0;
        int[][] arr = new int[rows][cols];
        infect1(arr,0,0,rows,cols,k);   //先让他自成体系
        for (int i = 0; i <rows ; i++) {
            for (int j = 0; j <cols ; j++) {
                if (arr[i][j]==1){
                    res++;
                }
            }
        }

        return res;
    }

    // 生成小根堆的比较器
    public static class MinHeapComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    }

    // 生成大根堆的比较器
    public static class MaxHeapComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }

    // PriorityQueue结构就是堆
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    public Solution() {
        maxHeap = new PriorityQueue<Integer>(new MaxHeapComparator());
        minHeap = new PriorityQueue<Integer>(new MinHeapComparator());
    }

    public void insert(Integer num) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {  //最大堆放小元素
            maxHeap.add(num);
        } else {
            minHeap.add(num);      //最小堆放大元素
        }
        modifyTwoHeaps();
    }

    public Double getMedian() {
        if (maxHeap.isEmpty()) {
            return null;
        }
        if (maxHeap.size() == minHeap.size()) {
            return Double.valueOf((maxHeap.peek() + minHeap.peek()) / 2.0);
        } else {
            return Double.valueOf(maxHeap.size() > minHeap.size() ? maxHeap.peek()
                    : minHeap.peek());
        }
    }

    private void modifyTwoHeaps() {
        if (maxHeap.size() == minHeap.size() + 2) {
            minHeap.add(maxHeap.poll());
        }
        if (minHeap.size() == maxHeap.size() + 2) {
            maxHeap.add(minHeap.poll());
        }
    }




}