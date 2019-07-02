package 笔试.头条合集.后端实习生2017;/*
    @Author  87814   xufei
    @Date  2019/7/1    23:24
*//*
    @Author  87814   xufei
    @Date  2019/7/1    23:24
*/

import java.util.Scanner;
public class 或与加 {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int x = scanner.nextInt();
            int k = scanner.nextInt();
            long n = 1;
            long result = 0;
            //目标是把k的各位依次填在x中是0的位上
            //bitNum用来移动到x中零的位置，然后把k的最低位放在x的零位上,
            // k左移，将下一位变成最低位,bitNum一直左移，知道x中的下一个为0的位上。
            while(k!=0){
                if ((x&n)==0){ //x中当前bitNUM为0的话,把k的最低位放在这儿
                    //k&1是将k的最低位取出来, n*(k&1)的结果就是得到n位和当前k的最低位一样的一个数,而其它位都是0
                    result+=(n*(k&1));
                    //而ans原来的n为肯定为0，ans+(n*(k&1)) 就将k的最低位放在x的这个零上了。
                    k>>=1;
                }
                n<<=1; //n的1一直左移到x中第k个零的位置
            }
            System.out.println(result);
        }

}
