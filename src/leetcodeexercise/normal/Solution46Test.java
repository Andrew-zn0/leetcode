package leetcodeexercise.normal;

import org.junit.Test;

import java.util.*;

/**
 * @author Jay
 * @description 定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * @date Created in 2020/3/28 3:05 下午
 */
public class Solution46Test {
    @Test
    public void test() {

        int[] arr = {1, 2, 3};
        System.out.println(permute(arr));

    }

    /**
     * 回溯
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();

        int length = nums.length;
        select(nums, length, new ArrayDeque<>(), list);
        return list;
    }


    private void select(int[] nums, int length, Deque<Integer> path,
                        List<List<Integer>> list) {

        if (path.size() == length) {
            list.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < length; i++) {

            if (path.contains(nums[i])) {
                continue;
            }

            path.addLast(nums[i]);


            select(nums, length, path, list);
            path.removeLast();

        }

    }


}
