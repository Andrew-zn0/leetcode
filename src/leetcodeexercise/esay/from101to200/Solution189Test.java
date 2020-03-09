package leetcodeexercise.esay.from101to200;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Jay
 * @description 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * @date Created in 2020/3/9 11:01 上午
 */
public class Solution189Test {

    @Test
    public void test() {
        int[] arr = {2, 7, 3, 4};

        //System.out.println(Arrays.toString(rotate(arr, 2)));
        rotate1(arr, 2);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 辅助数组法
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] rotate(int[] nums, int k) {
        int[] ints = new int[nums.length];

        if (nums.length == 0 || k == 0) {
            return nums;
        }
        for (int i = 0; i < nums.length; i++) {

            int temp = nums[i];
            int point = (i + k) % nums.length;
            ints[i] = nums[point];

        }
        return ints;
    }

    /**
     * 选转数组
     * <p>
     * 旋转k次
     *
     * @param nums
     * @param k
     */
    public void rotate1(int[] nums, int k) {
        int temp, previous;
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }

    }

    /**
     * 环形数组
     *
     * @param nums
     * @param k
     */
    public void rotate3(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }

    /**
     * 反转数组
     * <p>
     * 这个方法基于这个事实：当我们旋转数组 k 次， k%n 个尾部元素会被移动到头部，剩下的元素会被向后移动。
     * <p>
     * 在这个方法中，我们首先将所有元素反转。然后反转前 k 个元素，再反转后面 n-kn−k 个元素，就能得到想要的结果。
     */
    public void rotate4(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

}
