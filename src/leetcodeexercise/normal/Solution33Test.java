package leetcodeexercise.normal;

import org.junit.Test;


/**
 * @author Jay
 * @description 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * @date Created in 2020/3/21 12:32 下午
 */
public class Solution33Test {

    @Test
    public void test() {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(search(arr, 0));
    }

    /**
     * 顺序查找
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }


    /**
     * 二分法
     *
     * @param nums
     * @param target
     * @return
     */
    public int search1(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return -1;
        }
        int left = 0;
        int right = len - 1;
        while (left < right) {

            int mid = (left + right + 1) >>> 1;

            if (nums[mid] < nums[right]) {

                // 使用上取整的中间数，必须在上面的 mid 表达式的括号里 + 1
                if (nums[mid] <= target && target <= nums[right]) {
                    // 下一轮搜索区间是 [mid, right]
                    left = mid;
                } else {
                    // 只要上面对了，这里不用思考，可以一下子写出来
                    right = mid - 1;
                }

            } else {

                // [left, mid] 有序，但是为了和上一个 if 有同样的收缩行为，
                // 我们故意只认为 [left, mid - 1] 有序
                // 当区间只有 2 个元素的时候 int mid = (left + right + 1) >>> 1; 一定会取到右边
                // 此时 mid - 1 不会越界，就是这么刚刚好

                if (nums[left] <= target && target <= nums[mid - 1]) {
                    // 下一轮搜索区间是 [left, mid - 1]
                    right = mid - 1;
                } else {
                    left = mid;
                }
            }
        }

        // 有可能区间内不存在目标元素，因此还需做一次判断
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }
}

