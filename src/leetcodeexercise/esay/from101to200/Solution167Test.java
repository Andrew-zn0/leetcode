package leetcodeexercise.esay.from101to200;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Jay
 * @description 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * <p>
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * @date Created in 2020/3/8 7:55 下午
 */
public class Solution167Test {

    @Test
    public void test() {
        int[] numbers = {5, 25, 75};
        int target = 100;
        System.out.println(Arrays.toString(twoSum(numbers, target)));
    }

    /**
     * 暴力破解
     * <p>
     * 还可以二分查找小于target最大元素
     * <p>
     * 然后再遍历
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {

        for (int i = 0; i < numbers.length; i++) {

            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {

                    int[] ints = {i + 1, j + 1};
                    return ints;

                }
            }
        }
        return null;
    }

    /**
     * 双指针法：利用已排好序条件
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum1(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int sum = numbers[low] + numbers[high];
            if (sum == target) {

                return new int[]{low, high};
                // 由于排序好，当最小值加最大值小于目标值时，最小值前移
                //反之最大值后移，从俩边遍历。
            } else if (sum < target) {
                ++low;
            } else {
                --high;
            }

        }
        return null;
    }
}
