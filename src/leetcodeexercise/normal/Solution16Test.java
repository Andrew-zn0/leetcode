package leetcodeexercise.normal;

import org.junit.Test;

import java.util.Arrays;


/**
 * @author Jay
 * @description 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，
 * 使得它们的和与 target 最接近。
 * 返回这三个数的和。假定每组输入只存在唯一答案。
 * @date Created in 2020/3/14 1:09 下午
 */
public class Solution16Test {

    @Test
    public void test() {
        int[] arr = {1, 1, 1, 0};
        System.out.println(threeSumClosest(arr, -100));
    }

    /**
     * 暴力破解
     *
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int min = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int a = nums[i] + nums[j] + nums[k];
                    int b = a - target;
                    if (b < 0) {
                        if (a > min) {
                            min = a;
                        }
                    } else if (b > 0) {
                        if (a < min1) {
                            min1 = a;
                        }
                    } else {
                        return a;
                    }
                }
            }
        }

        int a = target - min;
        int b = target - min1;
        return (a + b) > 0 ? min1 : min;
    }

    /**
     * 排序+双指针
     *
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest1(int[] nums, int target) {

        Arrays.sort(nums);

        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                int sum = nums[start] + nums[end] + nums[i];
                if (Math.abs(target - sum) < Math.abs(target - ans)) {
                    ans = sum;
                }
                if (sum > target) {
                    end--;
                } else if (sum < target) {
                    start++;
                } else {
                    return ans;
                }
            }
        }
        return ans;
    }
}
