package leetcodeexercise.normal;

import org.junit.Test;

/**
 * @author Jay
 * @description 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * <p>
 * 返回被除数 dividend 除以除数 divisor 得到的商
 * @date Created in 2020/3/20 10:44 上午
 */
public class Solution29Test {

    @Test
    public void test() {

        System.out.println(divide(-2147483648, -1));
    }

    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        long count = 0;
        long tmp = divisor;
        long tmp1 = dividend;
        long a = divisor ^ dividend;
        if (tmp < 0) {
            tmp = -tmp;
        }
        if (tmp1 < 0) {
            tmp1 = -tmp1;
        }
        while (tmp1 >= tmp) {
            int i = 0;
            // 累加法，减去被减数一定的倍数，相应的计数乘一定的倍数，则可以减少循环次数
            while (tmp1 - (tmp << i) > 0) {
                ++i;
            }
            --i;
            tmp1 = tmp1 - (tmp << i);
            count += 1 << i;
        }
        if (a < 0) {
            count = -count;
        }
        if (count > Integer.MAX_VALUE) {
            count--;
        }
        if (count < Integer.MIN_VALUE) {
            count++;
        }
        return (int) count;
    }
}
