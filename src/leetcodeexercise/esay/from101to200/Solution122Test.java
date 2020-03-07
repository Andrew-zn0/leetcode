package leetcodeexercise.esay.from101to200;

import org.junit.Test;

/**
 * @author Jay
 * @description 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * @date Created in 2020/3/7 11:06 下午
 */
public class Solution122Test {
    @Test
    public void test() {

        int[] arr = {1, 7, 1, 9,9};
        System.out.println(maxProfit(arr));


    }

    public int maxProfit(int[] prices) {
        if(prices.length==0){
            return 0;
        }
        int min = prices[0];
        int max = prices[0];
        int sum = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[i - 1]) {
                max = prices[i - 1];
                sum += (prices[i - 1] - min);
                min = prices[i];
            }
            if (prices[i] < min) {
                min = prices[i];
            }
            if (i == prices.length-1 && prices[i] >= prices[i - 1]) {
                sum += (prices[i] - min);
            }
        }
        return sum;
    }
}
