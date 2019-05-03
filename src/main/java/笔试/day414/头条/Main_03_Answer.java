package 笔试.day414.头条;/*
    @Author  87814   xufei
    @Date  2019/4/15    16:54
*//*
    @Author  87814   xufei
    @Date  2019/4/15    16:54
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main_03_Answer {
        private static int[] stringToIntegerArray(String input) {
            input = input.trim();
            if (input.length() == 0) {
                return new int[0];
            }
            String[] parts = input.split(" ");
            int[] output = new int[parts.length];
            for (int index = 0; index < parts.length; index++) {
                String part = parts[index].trim();
                output[index] = Integer.parseInt(part);
            }
            return output;
        }

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(br.readLine().trim());
            while (T-- > 0) {
                int n = Integer.parseInt(br.readLine().trim());
                int[] scores = stringToIntegerArray(br.readLine());
                List<int[]> personList = new ArrayList<>();
                // 记录每个人的分数和位置
                for (int i = 0; i < n; ++i) {
                    personList.add(new int[]{scores[i], i});
                }
                //按分数从低到高排序
                Collections.sort(personList, Comparator.comparingInt(o -> o[0]));

                int[] rewards = new int[n];
                for (int i = 0; i < n; ++i) {
                    int[] person = personList.get(i);
                    // s代表第i+1个人的分数,p是他所在位置
                    int s = person[0], p = person[1];
                    // left 是这个人左边人的位置,right 是右边人的位置
                    int left = (p - 1 + n) % n, right = (p + 1) % n;
                    int leftVal = 1, rightVal = 1;
                    // 如果这个人分数比左边高,那就比左边人分到的奖品多一个
                    if (scores[left] < s)
                        leftVal = rewards[left] + 1;
                    // 如果这个人分数比右边高,那就比右边人分到的奖品多一个
                    if (scores[right] < s)
                        rightVal = rewards[right] + 1;
                    // 某个人的分数比左右的人高,那么奖品数量也要比左右的人多
                    // 这个人最终分到的奖品数是较大值
                    rewards[p] = Math.max(leftVal, rightVal);
                }

                int res = 0;
                for (int reward : rewards)
                    res += reward;
                System.out.println(res);
            }

            br.close();

        }


}
