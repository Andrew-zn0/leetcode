package leetcodeexercise.normal;

import org.junit.Test;

/**
 * @author Jay
 * @description 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
 * @date Created in 2020/3/13 3:47 下午
 */
public class Solution12Test {


    @Test
    public void test() {

        System.out.println(intToRoman(300));
    }

    /**
     * 贪心算法
     *
     * 找出对应的数字，然后循环每一次都去找最大值
     *
     * @param num
     * @return
     */
    public String intToRoman(int num) {
        // 把阿拉伯数字与罗马数字可能出现的所有情况和对应关系，放在两个数组中
        // 并且按照阿拉伯数字的大小降序排列，这是贪心选择思想
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;
        while (index < 13) {
            // 特别注意：这里是等号
            while (num >= nums[index]) {
                // 注意：这里是等于号，表示尽量使用大的"面值"
                stringBuilder.append(romans[index]);
                num -= nums[index];
            }
            index++;
        }
        return stringBuilder.toString();

    }
}
