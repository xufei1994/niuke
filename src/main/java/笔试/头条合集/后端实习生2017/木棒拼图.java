package 笔试.头条合集.后端实习生2017;/*
    @Author  87814   xufei
    @Date  2019/7/1    22:53
*//*
    @Author  87814   xufei
    @Date  2019/7/1    22:53
*/


import org.omg.CORBA.MARSHAL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 木棒拼图 {

    public static boolean canForm (ArrayList<Integer> l)
    {
        Collections.sort(l); //给 l 排序
        int sum = 0;
        for (int i=0; i<l.size()-1; i++)
        {
            sum += l.get(i);
        }
        if (sum >  l.get(l.size()-1))
        {
            return true;
        }
        return false;
    }
    public static void save (int[][] arr, int n)
    {
        ArrayList<Integer> l = new ArrayList<>();
        for (int i=0; i<n; i++)
        {
            // 二维数组中第一列存放的是对应操作，如果等于一，就加一根木棍，否则减一根木棍
            if (arr[i][0] == 1)
            {
                l.add(arr[i][1]);
            }
            else
            {
                l.remove(new Integer(arr[i][1]));
            }

            if(canForm (l))
            {
                System.out.println("Yes");
            }
            else
            {
                System.out.println("No");
            }
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext())
        {
            int n = s.nextInt();
            int[][] arr = new int[n][2];
            for (int i=0; i<n; i++)
            {
                arr[i][0] = s.nextInt();
                arr[i][1] = s.nextInt();
            }
            save(arr, n);
        }
    }
}
