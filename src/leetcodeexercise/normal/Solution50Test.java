package leetcodeexercise.normal;

import org.junit.Test;

/**
 * @author Jay
 * @description
 * @date Created in 2020/3/29 1:40 下午
 */
public class Solution50Test {
    @Test
    public void test() {


        System.out.println(myPow(2.0, -2));

    }

    /**
     * 循环
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {

        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double ans = 1;
        double current_product = x;

        // 每次减半，计算出需要迭代多少次
        for (long i = N; i > 0; i /= 2) {
            // 奇数的话多乘一次
            if ((i % 2) == 1) {
                ans = ans * current_product;
            }
            current_product = current_product * current_product;
        }
        return ans;

    }

    /**
     * 递归
     * <p>
     * 将 n 二分，拆分然后再相乘
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow1(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        return fastPow(x, N);
    }

    private double fastPow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            // 偶数的话 x(n) = x(n/2)*x(n/2)
            return half * half;
        } else {
            // 奇数的话 x(n) = x(n/2)*x(n/2)*x
            return half * half * x;
        }
    }

}
