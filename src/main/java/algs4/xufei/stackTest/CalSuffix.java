package algs4.xufei.stackTest;/*
    @Author  87814   algs4.xufei
    @Date  2018/10/4    16:20
*//*
    @Author  87814   algs4.xufei
    @Date  2018/10/4    16:20
*/


public class CalSuffix {
    private MyIntStack stack;
    private String input;
    public CalSuffix(String input){
        this.input=input;
        int length=input.length();
        stack=new MyIntStack(length);
    }

    public int doCalc(){
        int num1,num2,result;
        for (int i = 0; i <input.length() ; i++) {
            char c=input.charAt(i);
            if (c>='0'&&c<='9'){
                stack.push(c-'0');  //如果是数字 直接压入栈中
            }else {
                num2=stack.pop();  //  先弹出第二个操作数
                num1=stack.pop();  // 第一个操作数
            switch (c){
                case '+':
                    result=num1+num2;
                    break;
                case '-':
                    result=num1-num2;
                    break;
                case '*':
                    result=num1*num2;
                    break;
                case '/':
                    if (num2==0) {
                        result=0;
                          break;}
                    result=num1 / num2;
                    break;
                default:
                    result=0;
                    break;
            }//end switch
                stack.push(result);
            }// end else
        } // end for
        result = stack.pop();
        return result;
    }

    public static void main(String[] args) {
        InfixToSuffix in=new InfixToSuffix("1*(2+3)-5/(2+3)");
        MyCharStack my=in.doTransfer();
        my.displayStack();
        String s="";
        while (!my.isEmpty()){
            s=my.pop()+s;
        }

        System.out.println(s);
        CalSuffix cs=new CalSuffix(s);  //"123+*523+/-"
        System.out.println("结果");
        System.out.println(cs.doCalc());
    }
}
