package algorithms.search;

import org.junit.Test;


/**
 * @author Jay
 * @description 二分查找常见问题
 * @date Created in 2020/3/21 2:31 下午
 */
public class BinSearch {


    @Test
    public void test() {

        int[] arr = {1, 4};

        System.out.println(normal(arr, 1));
    }

    /**
     * 普通二分法
     * <p>
     * 因为我们初始化 right = nums.length - 1
     * 所以决定了我们的「搜索区间」是 [left, right]
     * 所以决定了 while (left <= right)
     * 同时也决定了 left = mid+1 和 right = mid-1
     * <p>
     * 因为我们只需找到一个 target 的索引即可
     * 所以当 nums[mid] == target 时可以立即返回
     *
     * @param nums
     * @param target
     * @return
     */
    private int normal(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            // 防止越界
            int mid = left + (left - right) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {

                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }

        }
        return -1;
    }

    /**
     * 因为我们初始化 right = nums.length
     * 所以决定了我们的「搜索区间」是 [left, right)
     * 所以决定了 while (left < right)
     * 同时也决定了 left = mid + 1 和 right = mid
     * <p>
     * 因为我们需找到 target 的最左侧索引
     * 所以当 nums[mid] == target 时不要立即返回
     * 而要收紧右侧边界以锁定左侧边界
     *
     * @param nums
     * @param target
     * @return
     */
    private int leftMargin(int[] nums, int target) {


        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            // 防止越界
            int mid = left + (left - right) / 2;
            // 收缩右边界
            if (nums[mid] == target) {
                right = mid;

            } else if (nums[mid] > target) {

                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
            if (left >= nums.length || nums[left] != target) {
                return -1;
            }
        }
        return left;

    }

    /**
     * 因为我们初始化 right = nums.length
     * 所以决定了我们的「搜索区间」是 [left, right)
     * 所以决定了 while (left < right)
     * 同时也决定了 left = mid + 1 和 right = mid
     * <p>
     * 因为我们需找到 target 的最右侧索引
     * 所以当 nums[mid] == target 时不要立即返回
     * 而要收紧左侧边界以锁定右侧边界
     * <p>
     * 又因为收紧左侧边界时必须 left = mid + 1
     * 所以最后无论返回 left 还是 right，必须减一
     *
     * @param nums
     * @param target
     * @return
     */
    private int rightMargin(int[] nums, int target) {


        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            // 防止越界
            int mid = left + (left - right) / 2;
            // 收缩左边界
            if (nums[mid] == target) {
                left = mid + 1;

            } else if (nums[mid] > target) {

                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        // 结束循环后right==left
        return right - 1;

    }
}
