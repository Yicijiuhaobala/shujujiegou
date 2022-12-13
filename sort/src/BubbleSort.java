import java.util.ArrayList;
import java.util.Random;

/**
 * @author Zah
 * @create 2022-12-07 10:42
 * @Description 冒泡排序 时间复杂度为O(n^2)
 */

public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = {3, 9, -1, 10, -2};

        ArrayList<Integer> ints = new ArrayList<Integer>();
        for (int array:
             bubbleSort(arr)) {
            ints.add(array);

        }
        System.out.println(ints);

        // 测试一下冒泡排序的速度O(n^2)，给80000个数据，测试
        // 创建80000个随机的数组
        Random random = new Random();
        int[] array3 = new int[80000];
        for (int i = 0; i < array3.length; i++) {
            array3[i] = random.nextInt(800000);
        }
        // 测试
        System.out.println("\n测试80000条数据使用冒泡法进行排序：\n");

        // 测试没有加上flag的冒泡排序
        long startTime1 = System.currentTimeMillis();
        bubbleSort(array3);
        long endTime1 = System.currentTimeMillis();
        System.out.println("优化的冒泡法array3花费时间为：【" + (endTime1 - startTime1) + "】毫秒");

    }
    public static int[] bubbleSort(int[] arr){
        int temp = 0;
        int change_numbers; // 冒泡排序优化
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.println("第" + i + "趟排序");
            change_numbers = 0;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if(arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    change_numbers++;
                }
            }
            /* 如果一次交换没有发生，代表排序结束 提前退出循环 */
            if(change_numbers==0){
                break;
            }
        }
        return arr;
    }
}
