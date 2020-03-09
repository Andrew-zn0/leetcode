package leetcodeexercise.esay.from101to200;

import org.junit.Test;

/**
 * @author Jay
 * @description 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
 * @date Created in 2020/3/9 4:44 下午
 */
public class Solution191Test {

    @Test
    public void test() {
        System.out.println(hammingWeight(2));
    }
    /**
     * 循环和位移动
     *
     * @param n
     * @return
     */
    public int hammingWeight(int n) {

        int bits = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            // 1100 & 0001 按位与，跟1与判断当前位是否为1
            // 有的话则加1
            if ((n & mask) != 0) {
                bits++;
            }
            mask <<= 1;
        }
        return bits;
    }

    /**
     * 可以把前面的算法进行优化。我们不再检查数字的每一个位，
     * 而是不断把数字最后一个 1 反转，并把答案加一。当数字变成 0的时候偶，我们就知道它没有 1 的位了，此时返回答案。
     *
     * 在二进制表示中，数字 n 中最低位的 1 总是对应 n - 1 中的 0 。
     * 因此，将 n 和 n - 1 与运算总是能把 n 中最低位的 1 变成 0 ，并保持其他位不变。
     *
     * @param n
     * @return
     */
    public int hammingWeight1(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }

}
