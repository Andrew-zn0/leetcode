package leetcodeexercise.normal;

import org.junit.Test;

import java.math.BigInteger;

/**
 * @author Jay
 * @description 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * @date Created in 2020/3/28 1:38 下午
 */
public class Solution43Test {

    @Test
    public void test() {


        System.out.println(multiply("123", "456"));

    }

    /**
     * 普通竖式
     *
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {

        int[] arr = new int[num1.length() + num2.length()];


        for (int i = 0; i < num1.length(); i++) {
            char c = num1.charAt(num1.length() - i - 1);
            int a = Integer.parseInt(c + "");
            if (a == 0) {
                continue;
            }

            for (int j = 0; j < num2.length(); j++) {

                char c1 = num2.charAt(num2.length() - j - 1);
                int b = Integer.parseInt(c1 + "");
                if (b == 0) {
                    continue;
                }
                int sum = a * b;

                if (sum >= 10) {
                    arr[i + j + 1] = sum / 10;

                }

                arr[i + j] = arr[i + j] + sum % 10;
                if (arr[i + j] > 10) {
                    arr[i + j + 1] = arr[i + j] / 10;
                    arr[i + j] = arr[i + j] % 10;
                }
            }

        }
        String A = "";
        for (int i = arr.length - 1; i >= 0; i--) {

            if (A.length() == 0 && arr[i] == 0) {
                continue;
            }
            A = A + arr[i];
        }
        return A;
    }

    /**
     * 优化
     * <p>
     * 该算法是通过两数相乘时，乘数某位与被乘数某位相乘，与产生结果的位置的规律来完成。
     *
     * @param num1
     * @param num2
     * @return
     */
    public String multiply1(String num1, String num2) {

        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int[] res = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            // char 类型转 int
            int n1 = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                // 位置为i j 的俩数相乘，位置在 i+j 与 j+j+1 上
                int sum = (res[i + j + 1] + n1 * n2);
                res[i + j + 1] = sum % 10;
                res[i + j] += sum / 10;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (i == 0 && res[i] == 0) {
                continue;
            }
            result.append(res[i]);
        }
        return result.toString();

    }

}
