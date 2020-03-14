package leetcodeexercise.normal;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Jay
 * @description 给定一个包含 n 个整数的数组 nums 和一个目标值 target，
 * 判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target
 */
public class Solution18Test {

    @Test
    public void test() {
        int[] arr = {1, 0, -1, 0, -2, 2};
        System.out.println(fourSum(arr, 0));
    }

    /**
     * 排序+三指针
     * <p>
     * 同16进阶
     *
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        if (nums.length < 4) {
            return lists;
        }
        int a, b, c, d;
        for (a = 0; a < nums.length - 3; a++) {

            if (a >= 1 && nums[a] == nums[a - 1]) {
                continue;
            }

            for (b = a + 1; b < nums.length - 2; b++) {
                if (b >= a + 2 && nums[b] == nums[b - 1]) {
                    continue;
                }
                c = b + 1;
                d = nums.length - 1;

                while (c < d) {
                    if (nums[a] + nums[b] + nums[c] + nums[d] < target) {
                        c++;
                    } else if (nums[a] + nums[b] + nums[c] + nums[d] > target) {
                        d--;
                    } else {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[a]);
                        list.add(nums[b]);
                        list.add(nums[c]);
                        list.add(nums[d]);
                        lists.add(list);
                        // 确保nums[c] 改变了
                        while (c < d && nums[c + 1] == nums[c]) {
                            c++;
                        }
                        // 确保nums[d] 改变了
                        while (c < d && nums[d - 1] == nums[d]) {
                            d--;
                        }
                        c++;
                        d--;
                    }
                }
            }

        }
        return lists;
    }
}
