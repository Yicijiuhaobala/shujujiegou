import java.util.Arrays;
import java.util.Random;

/**
 * @author Zah
 * @create 2022-12-07 15:31
 * @Description
 */

public class SelectSort {
    public static void main(String[] args) {
        int arr[] = {3, 9, -1, 10, -2};
        System.out.println(Arrays.toString(selectSort(arr)));


        // 测试一下冒泡排序的速度O(n^2)，给80000个数据，测试
        // 创建80000个随机的数组
        Random random = new Random();
        int[] array3 = new int[80000];
        for (int i = 0; i < array3.length; i++) {
            array3[i] = random.nextInt(800000);
        }
        // 测试
        System.out.println("\n测试80000条数据使用选择排序法 进行排序：\n");

        // 测试没有加上flag的冒泡排序
        long startTime1 = System.currentTimeMillis();
        selectSort(array3);
        long endTime1 = System.currentTimeMillis();
        System.out.println("选择排序法array3花费时间为：【" + (endTime1 - startTime1) + "】毫秒");

    }
    public static int[] selectSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.println("第" + i + "趟排序");
            int temp = arr[i];
            int index = i; // 初始一轮中最小数的索引
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j] < temp){
                    temp = arr[j];
                    index = j; // 找出一轮排序中最小的一个数的索引
                }
            }
            arr[index] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }
}
