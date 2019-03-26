package com.basic.part1;/*
    @Author  87814   xufei
    @Date  2019/3/17    22:44
*//*
    @Author  87814   xufei
    @Date  2019/3/17    22:44
*/

import java.util.Scanner;


public class HomeWork1 {
    static StringBuffer stringBuffer =new StringBuffer();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("m= ");
        int m = Integer.parseInt(scanner.nextLine());
        System.out.println("n= ");
        int n = Integer.parseInt(scanner.nextLine());

        if (m<0){
        change(Math.abs(m),n);
        stringBuffer.append('-');
        }else {
            change(m,n);
        }
        System.out.println("sb  ="   +stringBuffer.reverse().toString());

        System.out.print("ans=  "+Integer.toString(m, n).toUpperCase());
    }

    //给定一个十进制数M，以及需要转换的进制数N。将十进制数M转化为N进制数
    private static void change(int m, int n) {
        if (m%n>=0){//

            if (m%n==10){
                stringBuffer.append('A');
            }else if(m%n==11){
                stringBuffer.append('B');
            }else if(m%n==12){
                stringBuffer.append('C');
            }else if(m%n==13){
                stringBuffer.append('D');
            }else if(m%n==14){
                stringBuffer.append('E');
            }else if(m%n==15){
                stringBuffer.append('F');
            }else {
                stringBuffer.append(m%n);
            }

            if (m/n!=0){
                change((m/n),n);
            }

        }else {//
            return;
        }
    }

}