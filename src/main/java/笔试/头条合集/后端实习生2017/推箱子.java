package 笔试.头条合集.后端实习生2017;/*
    @Author  87814   xufei
    @Date  2019/7/2    12:45
*//*
    @Author  87814   xufei
    @Date  2019/7/2    12:45
*/


import java.util.*;
public class 推箱子 {
    //建立一个节点类，用于存储当前人和箱子的位置，以及已经走过的步数
    public static class Node{
        int px,py,bx,by;
        int step;
        public Node(int px,int py,int bx,int by){
            this.px=px;
            this.py=py;
            this.bx=bx;
            this.by=by;
        }
    }
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        char[][]map=new char[n][m];
        int px=0,py=0,bx=0,by=0;
        for(int i=0;i<n;i++){
            String str=sc.next();
            for(int j=0;j<m;j++){
                map[i][j]=str.charAt(j);
                if(str.charAt(j)=='S'){         //人的初始位置
                    px=i;py=j;
                }
                if(str.charAt(j)=='0'){         //箱子的初始位置
                    bx=i;by=j;
                }
            }
        }
        sc.close();

        Node node=new Node(px,py,bx,by);
        node.step=0;
        Queue<Node> rute=new LinkedList<>();
        rute.add(node);
        //方向矩阵，每一行分别代表上，右，下，左
        int[][]direction=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        //存储当前位置是否已经访问过,由于唯一性是由人和箱子的位置决定的，所以需要开一个四维矩阵
        boolean[][][][]isVisited=new boolean[n][m][n][m];
        //使用广度搜索寻找最短路径
        int step=bfs(map,rute, direction, isVisited);
        System.out.println(step);
    }

    public static int bfs(char[][]map,Queue<Node> rute,int[][]direction,boolean[][][][]isVisited){
        int n=map.length;
        int m=map[0].length;
        while(!rute.isEmpty()){
            Node cur=rute.poll();        //取出当前人和箱子的位置
            int newPx;
            int newPy;
            int newBx=cur.bx;
            int newBy=cur.by;
            //对每个方向进行搜索
            for(int i=0;i<4;i++){
                //如果当前时刻人在箱子的左边或右边
                if(cur.py==cur.by)
                    //如果人与箱子相邻，那么下一步箱子才会移动，否则箱子位置还是不变
                    newBx=(cur.px+direction[i][1])==cur.bx?(cur.bx+direction[i][1]):cur.bx;
                //如果当前时刻人在箱子的上边或下边
                if(cur.px==cur.bx)
                    //如果人与箱子相邻，那么下一步箱子才会移动，否则箱子位置还是不变
                    newBy=(cur.py+direction[i][0])==cur.by?(cur.by+direction[i][0]):cur.by;
                newPx=cur.px+direction[i][1];
                newPy=cur.py+direction[i][0];
                //如果往当前方向移动出了边界或移动到了‘#’上，则直接跳过此次移动
                if(newPx<0||newPx>=n||newPy<0||newPy>=m||map[newPx][newPy]=='#'
                        ||newBx<0||newBx>=n||newBy<0||newBy>=m||map[newBx][newBy]=='#')
                    continue;
                //如果当前位置此前没有访问过
                if(!isVisited[newPx][newPy][newBx][newBy]){
                    isVisited[newPx][newPy][newBx][newBy]=true;    //将其修改为已访问过
                    int newStep=cur.step+1;
                    if(map[newBx][newBy]=='E')
                        return newStep;
                    Node next=new Node(newPx,newPy,newBx,newBy);
                    next.step=newStep;
                    rute.add(next);
                }
            }
        }
        return -1;
    }

}
