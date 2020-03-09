package leetcodeexercise.esay.from101to200;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Jay
 * @description 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
 * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * @date Created in 2020/3/9 5:09 下午
 */
public class Solution198Test {
    @Test
    public void test() {
        int[] arr = {2, 7, 3, 4};
        System.out.println(rob(arr));
    }

    /**
     * 动态规划
     *
     * 状态转移方程
     *
     * f(k) = max(f(k – 2) + Ak, f(k – 1))
     *
     * 
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int prevMax = 0;
        int currMax = 0;
        for (int num : nums) {
            int temp = currMax;
            // 状态转移方程
            currMax = Math.max(prevMax+num,currMax);

            prevMax =temp;
        }
        return currMax;
    }
}
