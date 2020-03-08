package leetcodeexercise.esay.from101to200;

import org.junit.Test;


/**
 * @author Jay
 * @description 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * @date Created in 2020/3/8 1:24 下午
 */
public class Solution136Test {

    @Test
    public void test() {

        int[] arr = {2, 2, 1};


        System.out.println(singleNumber(arr));
    }


    public int singleNumber(int[] nums) {
        if (nums.length < 2) {
            return nums[0];
        }
        int a = nums[0] ^ nums[1];
        for (int i = 2; i < nums.length; i++) {
            a = a ^ nums[i];
        }
        return a;
    }


}
