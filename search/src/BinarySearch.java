import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Zah
 * @create 2022-11-30 16:06
 * @Description
 */


public class BinarySearch {
    public static void main(String[] args) {
        int[] array = new int[]{1, 8, 10, 10, 10, 89, 1000, 1234};
        System.out.println("原本的数组为：" + Arrays.toString(array));
        System.out.println("测试递归二分法查找数字1000：" + searchRecursive(array, 0, array.length - 1, 1000));
        System.out.println("测试循环二分法查找数字1000：" + searchLoop(array, 1000));
        System.out.println("测试批量查找数字10：" + searchBatchRecursive(array, 10));
    }
    /**
     * 执行递归二分查找，返回第一次出现该值的位置
     *
     * @param array     已排序的数组
     * @param start     开始位置，如：0
     * @param end       结束位置，如：array.length-1
     * @param findValue 需要找的值
     * @return 值在数组中的位置，从0开始。找不到返回-1
     */
    public static int searchRecursive(int[] array, int start, int end, int findValue) {
        // 如果数组为空，直接返回-1，即查找失败
        if (array == null) {
            return -1;
        }

        if (start <= end) {
            // 中间位置
            int middle = (start + end) / 2;
            // 中值
            int middleValue = array[middle];
            if (findValue == middleValue) {
                // 等于中值直接返回
                return middle;
            } else if (findValue < middleValue) {
                // 小于中值时在中值前面找
                return searchRecursive(array, start, middle - 1, findValue);
            } else {
                // 大于中值在中值后面找
                return searchRecursive(array, middle + 1, end, findValue);
            }
        } else {
            // 返回-1，即查找失败
            return -1;
        }
    }
    /**
     * 循环二分查找，返回第一次出现该值的位置
     *
     * @param arr     已排序的数组
     * @param value 需要找的值
     * @return 值在数组中的位置，从0开始。找不到返回-1
     */
    public static int searchLoop(int arr[], int value){
        if(arr.length == 0){
            System.out.println("查找的列表为空");
        }
        int start = 0;
        int end = arr.length - 1;
        boolean isFind = false;
        while(start <= end){
            int mid = (start + end)/2;
            if(value > arr[mid]){
                start = mid+1;
            }else if(value < arr[mid]){
                end = mid - 1;
            }else if(value == arr[mid]){
                isFind = true;
                System.out.println("找到该数，index为" + mid);
                return mid;
            }
        }
        System.out.println("未找到该数字");
        return -1;
    }
    public static List<Integer> searchBatchRecursive(int arr[], int value){
        int index = searchLoop(arr, value);
        int left = index - 1;
        int right = index + 1;
        List<Integer> list = new ArrayList<>();
        while(left >= 0 && arr[left] == value) {
            left--;
        }
        while(right <= arr.length-1 && arr[right] == value){
            right++;
        }
        for (int i = left + 1; i < right; i++) {
            list.add(i);
        }
        return list;
    }
    public static int searchLoopBatchSize(int arr[], int value){
        if(arr.length == 0){
            System.out.println("查找的列表为空");
        }
        int start = 0;
        int end = arr.length - 1;
        boolean isFind = false;
        int arr1[] = new int[arr.length-1];
        while(start <= end){
            int mid = (start + end)/2;
            if(value > arr[mid]){
                start = mid+1;
            }else if(value < arr[mid]){
                end = mid - 1;
            }else if(value == arr[mid]){
                System.out.println(mid);
                int a[] = arr;
                searchLoop(Arrays.copyOfRange(arr, 0, mid), value);
                searchLoop(Arrays.copyOfRange(a, mid, arr.length-1), value);
                isFind = true;
//                System.out.println("找到该数，index为" + mid);
//                return mid;
            }
        }
        System.out.println("未找到该数字");
        return -1;
    }
}
