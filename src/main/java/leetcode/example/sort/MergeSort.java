package leetcode.example.sort;

import java.util.Arrays;

/**
 * 归并排序
 * 适合大规模的数据排序
 * 采用分而治之和递归的思想
 * 稳定排序算法、非原地排序算法【合并函数无法在原地执行】
 *
 * 最好与最坏情况下时间复杂度都为 O(nlogn)
 * 空间复杂度 O(nlogn)
 * 示意图：images/MergeSort1.jpg、images/MergeSort1.jpg
 *
 * @author luxin
 */
@SuppressWarnings("WeakerAccess")
public class MergeSort {

    public static void sort(int[] value) {
        if (value == null || value.length <= 1) {
            return;
        }

        mergeSort(value, 0, value.length-1);
    }

    private static void mergeSort(int[] value, int left, int right) {
        if (left >= right) {
            return;
        }

        int middle = (left + right) / 2;
        mergeSort(value, left, middle);
        mergeSort(value, middle + 1, right);
        merge(value, left, middle, right);
    }

    private static void merge(int[] value, int left, int middle, int right) {
        int[] tmp = new int[right-left+1];
        int k = 0, i = left, j = middle+1;
        while (i <= middle && j <= right) {
            if (value[i] <= value[j]) {
                tmp[k++] = value[i++];
            } else {
                tmp[k++] = value[j++];
            }
        }

        // 如果总的大小为奇数，那么一定会有个不为空的子数组
        // 假设左边数组不为空
        int start = i, end = middle;
        // 判断是否右边数组是否为空
        if (j <= right) {
            start = j;
            end = right;
        }
        // 将剩余元素添加到tmp
        while (start <= end) {
            tmp[k++] = value[start++];
        }

        // 拷贝
        for (i = 0; i < tmp.length; i++) {
            value[left+i] = tmp[i];
        }
    }

    public static void main(String[] args) {
        int[] test = new int[] {1, 4, 1, 2, 7, 8, 6, 1};
        System.out.println(Arrays.toString(test));
        sort(test);
        System.out.println(Arrays.toString(test));
    }

}
