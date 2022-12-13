import java.util.Scanner;

/**
 * @author Zah
 * @create 2022-11-29 15:39
 * @Description
 */

public class ArrayStackDemo1 {
    public static void main(String[] args) {
        // 测试
        // 先创建一个ArrayStack ——> 表示栈
        ArrayStack stack = new ArrayStack(4);
        String key = "";
        // 控制是否退出菜单
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);System.out.println("show：表示显示栈");
        System.out.println("exit：表示退出程序");
        System.out.println("push：表示添加数据到栈（入栈）");
        System.out.println("pop：表示从栈取出数据（出栈）");
        while (loop) {
            System.out.println("请输入你的选择：");
            key = scanner.next();
            switch (key) {
                case "show":
                    stack.showStack();
                    break;
                case "push":
                    System.out.println("请输入一个数字：");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        int res = stack.pop();
                        System.out.printf("出栈的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出~~");
    }
}
class ArrayStack{
    private int maxSize;
    private int[] stack; // 数组模拟栈， 数据存在数组中
    private int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[this.maxSize];
    }
    // 判断栈满
    public boolean isFull(){
        return this.top == this.maxSize-1;
    }
    public boolean isEmpty(){
        return this.top == -1;
    }
    public void push(int value){
        if(isFull()){
            System.out.println("栈满，无法添加数据入栈");
        }else {
            this.top ++;
            this.stack[top] = value;
        }
    }
    public int pop() {
        if (isEmpty()) {
//            System.out.println("栈为空，无法删除数据出栈");
//            return -1;
            throw new RuntimeException("栈空，没有数据");
        } else {
            int temp = this.stack[top];
            this.top --;
            return temp;
        }
    }
    public void showStack(){
        if (isEmpty()) {
//            System.out.println("栈为空，无法删除数据出栈");
//            return -1;
            throw new RuntimeException("栈空，没有数据");
        }else {
            for (int i = top; i >= 0; i--) {
                System.out.println(this.stack[i]);
            }

        }
    }
}
