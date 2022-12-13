import java.util.Arrays;
import java.util.Random;

/**
 * @author Zah
 * @create 2022-12-07 16:17
 * @Description
 */

public class InsertSort {
    public static void main(String[] args) {
        int arr[] = {3, 9, -1, 10, -2};
        System.out.println(Arrays.toString(insertSort(arr)));


        // 测试一下冒泡排序的速度O(n^2)，给80000个数据，测试
        // 创建80000个随机的数组
        Random random = new Random();
        int[] array3 = new int[80000];
        for (int i = 0; i < array3.length; i++) {
            array3[i] = random.nextInt(800000);
        }
        // 测试
        System.out.println("\n测试80000条数据使用选择插入法进行排序：\n");

        // 测试没有加上flag的冒泡排序
        long startTime1 = System.currentTimeMillis();
        insertSort(array3);
        long endTime1 = System.currentTimeMillis();
        System.out.println("插入排序法array3花费时间为：【" + (endTime1 - startTime1) + "】毫秒");
    }
    public static int[] insertSort(int[] arr){
        for (int i = 1; i < arr.length ; i++) {
            System.out.println("第" + i + "趟排序");
            int insertVal = arr[i]; // 定义插入的数据
            int insertIndex = i-1; // 有序的数组的最后一个数的索引
            while(insertIndex >=0 && insertVal < arr[insertIndex]){
                arr[insertIndex + 1] = arr[insertIndex]; // 将大于插入的数据往后移动一位
                insertIndex--;
            }
            arr[insertIndex + 1] = insertVal;
        }
        return arr;
    }
}
