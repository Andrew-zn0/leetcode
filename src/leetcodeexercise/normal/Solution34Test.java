package leetcodeexercise.normal;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Jay
 * @description 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * @date Created in 2020/3/21 1:19 下午
 */
public class Solution34Test {

    @Test
    public void test() {

        int[] arr = {1, 4};
        int[] ints = searchRange1(arr, 4);

        System.out.println(Arrays.toString(ints));
    }

    /**
     * 顺序查找
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {

        int[] ints = new int[2];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == target) {

                count++;
                if (count == 1) {
                    ints[0] = i;
                } else {
                    ints[1] = i;
                }
            }
        }
        if (count == 1) {
            ints[1] = ints[0];
        } else if (count == 0) {
            ints[0] = ints[1] = -1;
        }

        return ints;
    }

    /**
     * 二分查找
     * <p>
     * 递归
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange1(int[] nums, int target) {
        // 初始化
        int[] targetRange = {-1, -1};
        // 左侧边界
        int leftIdx = extremeInsertionIndex(nums, target, true);

        if (leftIdx == nums.length || nums[leftIdx] != target) {
            return targetRange;
        }

        targetRange[0] = leftIdx;
        // 右侧边界
        targetRange[1] = extremeInsertionIndex(nums, target, false) - 1;

        return targetRange;

    }

    /**
     * @param nums
     * @param target
     * @param left
     * @return
     */
    private int extremeInsertionIndex(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            // 若相等，则寻找左侧边界的话 右侧边界应该收缩，也就是hi变动，所以标记为true
            // 若是寻找右侧边界，在相等情况下左侧边界收缩，即lo=mid+1
            if (nums[mid] > target || (left && target == nums[mid])) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }
}
