package 笔试.day414.头条;/*
    @Author  87814   xufei
    @Date  2019/4/14    17:19
*//*
    @Author  87814   xufei
    @Date  2019/4/14    17:19
*/

import java.util.Scanner;

/*
1.三个同样的字母连在一起，一定是拼写错误，去掉一个的就好啦：比如 helllo -> hello

2.两对一样的字母（AABB型）连在一起，一定是拼写错误，去掉第二对的一个字母就好啦：比如 helloo -> hello

3.上面的规则优先“从左到右”匹配，即如果是AABBCC，虽然AABB和BBCC都是错误拼写，应该优先考虑修复AABB，结果为AABCC
 */
public class Main02 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        String[] strings=new String[n];
        for (int i = 0; i <n ; i++) {
            strings[i]=new String( scanner.nextLine());
        }
        for (int i = 0; i <n ; i++) {
            System.out.println(ff(strings[i]).toString());
        }
    }

    private static StringBuilder f(StringBuilder string) {
        int i0=0;
        int i1=1;
        int i2=2;
        int i3=3;
        while (i2<string.length()){
            if (string.charAt(i2)==string.charAt(i1)&&string.charAt(i1)==string.charAt(i0)){
                string.delete(i0,i1);
            }else if (i3<string.length()&&string.charAt(i2)==string.charAt(i3)&&string.charAt(i1)==string.charAt(i0)){
                string.delete(i2,i3);
            }else {
                i0++;
                i1++;
                i2++;
                i3++;
            }
        }
        return string;
    }

    private static String ff(String string) {
        char[] chars = string.toCharArray();

       int k=0;
        for (int i = 0; i <chars.length ; i++) {
            if (i>1&&chars[i]==chars[k-1]&&chars[k-1]==chars[k-2]){
                chars[i]='\0';
            }else if (i>2&&chars[i]==chars[k-1]&&chars[k-3]==chars[k-2]){
                chars[i]='\0';
            }else {
                chars[k++]=chars[i];
            }
        }
        System.out.println(k);
        return new String(chars,0,k);
        }


}
