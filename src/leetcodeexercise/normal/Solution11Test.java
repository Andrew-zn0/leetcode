package leetcodeexercise.normal;

import org.junit.Test;

/**
 * @author Jay
 * @description 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水
 * @date Created in 2020/3/13 3:01 下午
 */
public class Solution11Test {

    @Test
    public void test() {
        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea1(arr));
    }

    /**
     * 暴力破解
     * <p>
     * 双循环
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < height.length; i++) {

            for (int j = i; j < height.length; j++) {

                int area = height[i] > height[j] ? height[j] * (j - i) : height[i] * (j - i);
                if (area > max) {
                    max = area;
                }
            }
        }
        return max;
    }

    /**
     * 双指针法
     * <p>
     * 每次都将较短的那段移动
     *
     * @param height
     * @return
     */
    public int maxArea1(int[] height) {

        int maxArea = 0;
        int max = height.length-1;
        int min = 0;

        while (max > min) {

            int min1 = Math.min(height[max], height[min]);
            maxArea = Math.max(maxArea, min1 * (max - min));
            if (height[max] > height[min]) {
                min++;
            } else {
                max--;
            }
        }
        return maxArea;
    }
}
