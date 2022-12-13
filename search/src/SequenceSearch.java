import java.util.ArrayList;

/**
 * @author Zah
 * @create 2022-11-30 15:39
 * @Description 线性查找
 */

public class SequenceSearch {
    public static void main(String[] args) {
        int arr[] = {-1, 43, 56, 4, 53, 543, 54, 34, 43, 43};
        sequenceSearch(arr, 43);
    }
//    实现的线性查找，找到一个数据就返回
    public static int sequenceSearch(int arr[], int value) {
        int arr1[] = new int[arr.length];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                System.out.println("找到该数据，index为" + Integer.toString(i));
                arr1[index] = i;
                index++;
//                return i;
            }
        }
        if (index > 0) {
            return arr1.length;
        } else {
            System.out.println("未找到该数据");
            return -1;
        }
    }
}
