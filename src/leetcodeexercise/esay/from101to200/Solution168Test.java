package leetcodeexercise.esay.from101to200;

import org.junit.Test;


/**
 * @author Jay
 * @description 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 * @date Created in 2020/3/8 8:37 下午
 */
public class Solution168Test {
    @Test
    public void test() {

        System.out.println(convertToTitle(1111111111));

    }

    /**
     * 进制转换
     *
     * @param n
     * @return
     */
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            // 进制转换10->26
            int c = n % 26;
            if (c == 0) {
                c = 26;
                n -= 1;
            }
            // char 转换
            sb.insert(0, (char) ('A' + c - 1));
            n /= 26;
        }

        return sb.toString();

    }

}
