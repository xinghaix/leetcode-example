package leetcode.example.sort;

import java.util.Arrays;

/**
 * 快速排序
 * 采用分区和递归的思想
 * 原地排序算法、非稳定排序算法【由于存在数据交换】
 *
 * @author luxin
 */
@SuppressWarnings("WeakerAccess")
public class QuickSort {

    public static void sort(int[] value) {
        if (value == null || value.length <= 1) {
            return;
        }

        quickSort(value, 0, value.length-1);
    }

    private static void quickSort(int[] value, int left, int right) {
        if (left >= right) {
            return;
        }

        int index = partition(value, left, right);
        quickSort(value, left, index-1);
        quickSort(value, index+1, right);
    }

    private static int partition(int[] value, int left, int right) {
        // 选取最后一个元素作为分区点
        int pivot = value[right], i = left, j = left;
        while (j < right) {
            if (value[j] < pivot) {
                // 数据交换
                int tmp = value[i];
                value[i++] = value[j];
                value[j] = tmp;
            }
            j++;
        }

        // 数据交换。将pivot加到左侧已经分好区的后面
        int tmp = value[i];
        value[i] = pivot;
        value[right] = tmp;

        return i;
    }

    public static void main(String[] args) {
        int[] test = {1, 2, 5, 2, 1, 6, 3, 7};
        System.out.println(Arrays.toString(test));
        sort(test);
        System.out.println(Arrays.toString(test));
    }

}
