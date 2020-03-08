package leetcodeexercise.esay.from101to200;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Jay
 * @description 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * @date Created in 2020/3/8 9:06 下午
 */
public class Solution169Test {

    @Test
    public void test() {

        int[] numbers = {3, 3, 4};
        System.out.println(majorityElement(numbers));

    }

    /**
     * 暴力法或者哈希表
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            if (map.get(nums[i]) != null) {
                Integer integer = map.get(nums[i]);
                map.put(nums[i], integer + 1);
            } else {
                map.put(nums[i], 1);
            }

        }
        AtomicInteger max = new AtomicInteger();
        AtomicInteger sum = new AtomicInteger();
        map.forEach((x, y) -> {

            if (y > max.get()) {
                sum.set(x);
                max.set(y);
            }

            if (y > nums.length / 2) {
                sum.set(x);
            }
        });

        return sum.get();
    }

    /**
     * 排序法
     * 1.先把数列排序
     * 2.因为最多元素大于n/2,所以中点返回元素为最多元素。
     *
     * @param nums
     * @return
     */
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }


}
