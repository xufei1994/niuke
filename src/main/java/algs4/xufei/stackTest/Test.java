package algs4.xufei.stackTest;/*
    @Author  87814   algs4.xufei
    @Date  2018/10/4    16:01
*//*
    @Author  87814   algs4.xufei
    @Date  2018/10/4    16:01
*/


public class Test {
    public static void main(String[] args) {

        InfixToSuffix in=new InfixToSuffix("1*(2+3)-5/(2+3)");
        MyCharStack my=in.doTransfer();
        my.displayStack();
    }
}
