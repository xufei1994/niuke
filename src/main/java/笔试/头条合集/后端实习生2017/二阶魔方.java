package 笔试.头条合集.后端实习生2017;/*
    @Author  87814   xufei
    @Date  2019/7/2    12:51
*//*
    @Author  87814   xufei
    @Date  2019/7/2    12:51
*/


import java.util.Arrays;
import java.util.Scanner;

public class 二阶魔方 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[]arr=new int[24];
        for(int i=0;i<24;i++)
            arr[i]=sc.nextInt();
        sc.close();

        int[]res=new int[1];
        getMaxBeauty(arr,res,5);
        System.out.println(res[0]);

    }

    private static void getMaxBeauty(int[] arr, int[] res, int times) {
        res[0]=Math.max(res[0],beautyCal(arr));
        if(times==0)
            return;
        //下面四个水平顺时针转动
        int[]tempL=Arrays.copyOf(arr,24);
        tempL[0]=arr[10];tempL[1]=arr[4];tempL[10]=arr[19];tempL[4]=arr[18];
        tempL[18]=arr[15];tempL[19]=arr[9];tempL[15]=arr[1];tempL[9]=arr[0];
        tempL[20]=arr[21];tempL[21]=arr[23];tempL[23]=arr[22];tempL[22]=arr[20];
        getMaxBeauty(tempL,res,times-1);
        //下面四个水平逆时针转动
        int[]tempR=Arrays.copyOf(arr,24);
        tempR[0]=arr[9];tempR[1]=arr[15];tempR[10]=arr[0];tempR[4]=arr[1];
        tempR[18]=arr[4];tempR[19]=arr[10];tempR[15]=arr[18];tempR[9]=arr[19];
        tempR[20]=arr[22];tempR[21]=arr[20];tempR[23]=arr[21];tempR[22]=arr[23];
        getMaxBeauty(tempR,res,times-1);
        //右边四个垂直上转
        int[]tempU=Arrays.copyOf(arr,24);
        tempU[7]=arr[17];tempU[13]=arr[19];tempU[17]=arr[21];tempU[19]=arr[23];
        tempU[21]=arr[1];tempU[23]=arr[3];tempU[1]=arr[7];tempU[3]=arr[13];
        tempU[14]=arr[15];tempU[15]=arr[9];tempU[9]=arr[8];tempU[8]=arr[14];
        getMaxBeauty(tempU,res,times-1);
        //右边四个垂直下转
        int[]tempD=Arrays.copyOf(arr,24);
        tempD[7]=arr[1];tempD[13]=arr[3];tempD[17]=arr[7];tempD[19]=arr[13];
        tempD[21]=arr[17];tempD[23]=arr[19];tempD[1]=arr[21];tempD[3]=arr[23];
        tempD[14]=arr[8];tempD[15]=arr[14];tempD[9]=arr[15];tempD[8]=arr[9];
        getMaxBeauty(tempD,res,times-1);
        //前面四个逆时针旋转
        int[]tempF=Arrays.copyOf(arr,24);
        tempF[12]=arr[14];tempF[13]=arr[15];tempF[14]=arr[21];tempF[15]=arr[20];
        tempF[21]=arr[10];tempF[20]=arr[11];tempF[10]=arr[12];tempF[11]=arr[13];
        tempF[16]=arr[17];tempF[17]=arr[19];tempF[19]=arr[18];tempF[18]=arr[16];
        getMaxBeauty(tempF,res,times-1);
        //前面四个顺时针旋转
        int[]tempB=Arrays.copyOf(arr,24);
        tempB[12]=arr[10];tempB[13]=arr[11];tempB[14]=arr[12];tempB[15]=arr[13];
        tempB[21]=arr[14];tempB[20]=arr[15];tempB[10]=arr[21];tempB[11]=arr[20];
        tempB[16]=arr[18];tempB[17]=arr[16];tempB[19]=arr[17];tempB[18]=arr[19];
        getMaxBeauty(tempB,res,times-1);

    }

    private static int beautyCal(int[] arr) {
        return (arr[0]*arr[1]*arr[2]*arr[3] + arr[4]*arr[5]*arr[10]*arr[11] + arr[6]*arr[7]*arr[12]*arr[13]
                +arr[8]*arr[9]*arr[14]*arr[15] + arr[16]*arr[17]*arr[18]*arr[19] + arr[20]*arr[21]*arr[22]*arr[23]);
    }

}