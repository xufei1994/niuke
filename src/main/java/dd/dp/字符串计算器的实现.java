package dd.dp;/*
    @Author  87814   xufei
    @Date  2019/4/25    21:30
*//*
    @Author  87814   xufei
    @Date  2019/4/25    21:30
*/


import java.util.LinkedList;

public class 字符串计算器的实现 {
    public static int getValue(String str){
        return value(str.toCharArray(),0)[0]; }

    //当前是从哪个位置开始的   返回值为数组 长度为2 arr[0]=计算结果 arr[1] 计算到那个位置
        public static int[] value(char[] str,int i){
            LinkedList<String> que =new LinkedList<>();
            int pre =0 ;
            int[] bra = null;
            while(i<str.length&&str[i]!=')'){ //什么时候停止
                if (str[i]>='0'&&str[i]<='9'){
                    pre = pre*10+str[i++]-'0';
                }else if (str[i]!='('){  //那么你遇到了减价乘除 收集出来 黑盒，同时下一个收集过程开始
                    addNum(que,pre);
                    que.addLast(String.valueOf(str[i++]));
                    pre = 0;
                }else {//你遇到了左括号 i+1位置开始处理
                    bra = value(str,i+1);
                    pre=bra[0];  //值放入bra0
                    i=bra[1]+1;  //计算位置向前走一位
                }
            }
            addNum(que,pre);
            return  new int[] {getNum(que),i};
        }
        public static void addNum(LinkedList<String> que,int num){
        if (!que.isEmpty()){
            int cur = 0;
            String top =que.pollLast();
            if (top.equals("+")||top.equals("-")){
                que.addLast(top);
            }else {
                cur = Integer.valueOf(que.pollLast());
                num = top.equals("*")?(cur*num):(cur/num);
            }
        }
        que.addLast(String.valueOf(num));
        }

        public static int getNum(LinkedList<String> que){
        int  res = 0;
        boolean add =true;
        String cur =null;
        int num = 0;
        while (!que.isEmpty()){
            cur =que.pollFirst();
            if (cur.equals("+")){
                add=true;
            }else if (cur.equals("-")){
                add =false;
            }else {
                num =Integer.valueOf(cur);
                res += add?num:(-num);
            }
        }
        return res;
        }
}
