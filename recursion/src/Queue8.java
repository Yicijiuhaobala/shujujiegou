import java.util.Queue;

/**
 * @author Zah
 * @create 2022-12-05 15:34
 * @Description
 */

public class Queue8 {
    int max = 8; // 定义max为皇后个数
    int[] array = new int[max]; // 保存皇后放置的方法
    static int a = 0;
    static int count = 0;
    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.println(a);
        System.out.println(count);
    }
    private void check(int n){
        if(n == max){  //此时8个皇后放好了
            print();
            return;
        }
        for (int i = 0; i < max; i++) {
            array[n] = i;
            if(judge(n)){
                check(n+1);
            }
//            如果冲突 就将皇后放在后移的一个位置
        }
    }

    /**
     *  判断是否满足不在同一行 同一列 同一斜线的条件
     * array[n] == array[i] 判断是否在同一列
     * Math.abs(n-i) == Math.abs(array[n] - array[i]) 判断是否在同一斜线
     * @param n  输入第n个皇后
     * @return
     */
    private boolean judge(int n){
        count++;
        for (int i = 0; i < n; i++) {
            if(array[n] == array[i] ||  Math.abs(n-i) == Math.abs(array[n] - array[i])){
                return false;
            }
        }
        return true;
    }
    private void print() {
        a++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
