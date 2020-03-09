package leetcodeexercise.esay.from101to200;

import org.junit.Test;


/**
 * @author Jay
 * @description 颠倒给定的 32 位无符号整数的二进制位。
 * @date Created in 2020/3/9 4:26 下午
 */
public class Solution190Test {
    @Test
    public void test() {
        System.out.println(reverseBits(11));
    }

    /**
     * 类似反转字符串，得到每一bit位然后交换
     *
     * 使用位运算
     *
     * @param n
     * @return
     */
    public int reverseBits(int n) {
        int ans = 0;
        for (int bitsSize = 31; n != 0; n = n >>> 1, bitsSize--) {
            // 每次左移动后，用0补充
            // 1010 ->0000+0100+0000+0001
            ans += (n & 1) << bitsSize;
        }
        return ans;
    }

}
