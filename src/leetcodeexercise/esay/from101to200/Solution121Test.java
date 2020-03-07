package leetcodeexercise.esay.from101to200;

import org.junit.Test;

/**
 * @author Jay
 * @description 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * @date Created in 2020/3/7 9:41 下午
 */
public class Solution121Test {

    @Test
    public void test() {

        int[] arr = {2, 7, 3, 4};
        maxProfit(arr);

    }


    /**
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > max)
                    max = profit;
            }


        }
        return max;


    }

    /**
     * 先找出最低点，然后寻找最大值
     */
    public int maxProfit1(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }


}
