package leetcodeexercise.normal;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Jay
 * @description 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
 * 请你找出所有满足条件且不重复的三元组。
 */
public class Solution15Test {
    @Test
    public void test() {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(arr));
    }

    /**
     * 1.将数组排序
     * 2.设定俩个指针，一个最小，一个最大
     * 3.遍历数组，将三个值相加，若小于0，则左指针右移，若大于0则右指针左移
     * 4.等于0则将其放入数组
     * 5.去重：若该指针与前一位置指针相同，则跳过。
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> lists = new ArrayList<>();
        if (nums.length < 3) {
            return lists;
        }

        Arrays.sort(nums);


        for (int i = 1; i < nums.length - 1; i++) {
            int right = nums.length - 1;
            int left = 0;
            if (nums[i] == nums[i + 1]) {
                i++;
                continue;
            }

            while (left < i && right > i) {

                int a = nums[right] + nums[left] + nums[i];
                List<Integer> list = new ArrayList<>();
                if (a == 0) {

                    list.add(nums[left]);
                    list.add(nums[i]);
                    list.add(nums[right]);
                    lists.add(list);
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    break;
                } else if (a > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return lists;
    }
}
