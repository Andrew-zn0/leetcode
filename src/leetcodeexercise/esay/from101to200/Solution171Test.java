package leetcodeexercise.esay.from101to200;

import org.junit.Test;

/**
 * @author Jay
 * @description 给定一个Excel表格中的列名称，返回其相应的列序号。
 * @date Created in 2020/3/9 10:07 上午
 */
public class Solution171Test {
    @Test
    public void test() {

        System.out.println(titleToNumber("AB"));

    }

    /**
     * 进制转换
     * 26->10
     *
     * @param s
     * @return
     */
    public int titleToNumber(String s) {
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int a = c - 'A' + 1;

            num += a * Math.pow(26.0, (double) (s.length() - i - 1));
        }
        return num;
    }
}
