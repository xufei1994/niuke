package algs4.xufei.stackTest;/*
    @Author  87814   algs4.xufei
    @Date  2018/10/4    11:40
*//*
    @Author  87814   algs4.xufei
    @Date  2018/10/4    11:40
*/

//定义一个栈
public class MyCharStack {
    private char[] array;
    private int maxSize;
    private int top;

    public MyCharStack() {
    }

    public MyCharStack(int size) {
        array = new char[size];
        this.maxSize = size;
        top =-1 ;
    }
    //压入数据
    public void push(char value){
        if (top<maxSize-1){
            array[++top]=value;
        }
    }

    //弹出栈顶数据
    public char pop(){
        return array[top--];
    }

    //访问栈顶数据
    public char peek(){
        return array[top];
    }

    //查看指定位置的元素
    public char peekN(int n){
        return array[n];
    }

    // 为了便于后面分解展示栈中的内容，我们增加了一个遍历栈的方法（实际上栈只能访问栈顶元素）
    public void displayStack(){
        System.out.println("Stack(bottom-->top):");
        for (int i = 0; i <top+1 ; i++) {
            System.out.print(peekN(i));
            System.out.print(" ");
        }
        System.out.println();
    }

    //判断栈是否为空
    public boolean isEmpty(){
        return top==-1;
    }

    //判断栈是否满了
    public boolean isFull(){
        return top==(maxSize-1);
    }

}
