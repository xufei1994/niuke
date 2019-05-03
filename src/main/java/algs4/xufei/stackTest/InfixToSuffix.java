package algs4.xufei.stackTest;/*
    @Author  87814   algs4.xufei
    @Date  2018/10/4    13:12
*//*
    @Author  87814   algs4.xufei
    @Date  2018/10/4    13:12
*/

// 前缀表达式转换为后缀表达式
public class InfixToSuffix {
    private MyCharStack s1;   //定义运算符栈
    private MyCharStack s2;   //定义存储结果栈
    private String input;

    //默认构造方法，参数为输入的中缀表达式
   public InfixToSuffix(String in){
        input=in;
        s1=new MyCharStack(input.length());
        s2=new MyCharStack(input.length());
    }



    //中缀表达式转换为后缀表达式，将结果存储在栈中返回，逆序显示后缀表达式
    public MyCharStack doTransfer(){
        for (int i = 0; i <input.length() ; i++) {
            System.out.print("s1栈元素为：");
            s1.displayStack();
            System.out.print("s2栈元素为：");
            s2.displayStack();

            char ch=input.charAt(i);
            System.out.println("当前解析字符："+ch);
            switch (ch){
                case '+':
                case '-':
                    gotOper(ch,1);
                    break;
                case '*':
                case '/':
                    gotOper(ch,2);
                    break;
                case '(':
                    s1.push(ch); //如果当前字符是‘（’，则将其入栈
                    break;
                case ')':
                    gotParen(ch);
                    break;
                default:   //  如果是操作数，则直接压入s2
                    s2.push(ch);
                    break;
            }  //end switch
        } // end for
        while (!s1.isEmpty()){
            s2.push(s1.pop());
        }
        return s2;
    }

    private void gotOper(char ch, int i) {
        while(!s1.isEmpty()){
            char optop=s1.pop();
            if (optop=='('){//  如果栈顶是（，直接将操作符压入栈s1
                s1.push(optop);
                break;
            }else {
                int j;
                if (optop=='+'||optop=='-'){
                    j = 1;
                }else {
                    j =2;
                }
                if (j<i){ //如果当前运算符比S1栈顶运算符优先级高，则将运算符压入s1
                    s1.push(optop);
                    break;
                }else {//如果当前运算符与栈顶运算符相同或者小于优先级别，那么僵s1栈顶元素的运算符弹出并压入到s2中
                    //并且要再次转到while循环中与s1中新的栈顶元素相比较
                    s2.push(optop);

                }
            }// else
        } // end while
        //如果s1为空，将当前解析的运算符直接压入s1
        s1.push(ch);
    }

    //如果字符是‘）’时，如果栈顶‘（’，则将这一对括号丢弃，否则依次弹出s1栈顶的字符，压入s2，知道遇到‘（’
    public void gotParen(char ch){
        while (!s1.isEmpty()){
            char chx=s1.pop();
            if (chx=='('){
                break;

            }else {
                s2.push(chx);

            }
        }
    }


}
