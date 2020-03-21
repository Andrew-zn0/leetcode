package leetcodeexercise.normal;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Jay
 * @description 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * <p>
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * @date Created in 2020/3/20 11:44 上午
 */
public class Solution31Test {
    @Test
    public void test() {
        int[] arr = {3,1,2};
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 1) {
            return;
        }

        int i = 0;
        int pot = nums.length - 1;
        int max = nums[pot];
        while (max != nums[0]) {
            for (i = pot; i >= 0; i--) {
                if (max > nums[i]) {
                    nums[pot] = nums[i];
                    nums[i] = max;
                    pot=1;
                    break;

                }
            }
            max = nums[--pot];
        }


        for (int j = i + 1; j < nums.length - 1; j++) {
            for (int k = i + 1; k < nums.length - 1; k++) {
                if (nums[k] > nums[k + 1]) {
                    max = nums[k];
                    nums[k] = nums[k + 1];
                    nums[k + 1] = max;
                }
            }
        }
    }
}
