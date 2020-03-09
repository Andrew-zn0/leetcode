package leetcodeexercise.esay.from101to200;

import org.junit.Test;

/**
 * @author Jay
 * @description 给定一个整数 n，返回 n! 结果尾数中零的数量。
 * @date Created in 2020/3/9 10:21 上午
 */
public class Solution172Test {

    @Test
    public void test() {

        //System.out.println(trailingZeroes(13));
        System.out.println(trailingZeroes1(30));

    }

    /**
     * 暴力破解会超时或者越界
     *
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {

        long sum = 1;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            sum *= i;
        }
        for (int i = 1; i <= n; i++) {

            long tail = 0;
            tail = sum % 10;
            sum /= 10;
            if (tail != 0) {
                return count;
            }
            count++;
        }
        return count;
    }

    /**
     * 数学归纳
     * <p>
     * 找出所有的5
     * <p>
     * 5，10，15，20，25
     * <p>
     * 其中25中是有俩个5，也就是说会产生俩个0；
     *
     * @param n
     * @return
     */
    public int trailingZeroes1(int n) {

        int count = 0;
        while (n > 0) {
            n /= 5;
            count += n;
        }
        return count;

    }
}
