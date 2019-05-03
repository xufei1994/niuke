package dd.dp;/*
    @Author  87814   xufei
    @Date  2019/4/25    23:04
*//*
    @Author  87814   xufei
    @Date  2019/4/25    23:04
*/


public class Solution {
    public int GetUglyNumber_Solution(int index) {

      if (index <=0){
          return 0;
      }
      int[] result =new int[index];
      int count = 0;
      int i2=0;
      int i3=0;
      int i5=0;
      result[0] = 1;
      int temp = 0;
      while (count<index-1){
          temp =Math.min(result[i2]*2,Math.min(result[i3]*3,result[i5]*5));
          if (temp ==result[i2]*2) i2++;
          if (temp ==result[i3]*3) i3++;
          if (temp ==result[i5]*5) i5++;
          result[++count] =temp;
      }

        return result[index-1];
    }
}