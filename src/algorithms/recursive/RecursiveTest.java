package algorithms.recursive;

import org.junit.Test;

/**
 * @author Jay
 * @description 递归测试
 * @date Created in 2019/5/29 10:28
 */
public class RecursiveTest {
    @Test
    public void test() {
        int factorial = factorial(6);
        System.out.println(factorial);
    }

    public int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}
