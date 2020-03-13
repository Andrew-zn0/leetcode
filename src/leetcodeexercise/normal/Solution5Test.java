package leetcodeexercise.normal;

import org.junit.Test;

/**
 * @author Jay
 * @description 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * @date Created in 2020/3/10 3:56 下午
 */
public class Solution5Test {


    @Test
    public void test() {


        boolean[][] dp = new boolean[1][0];

        System.out.println(longestPalindrome2("cbbd"));
    }

    /**
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        String str = "";

        int i = 0;
        int j = 0;
        int n = s.length();
        int length = 0;
        while ((i + length / 2) < n - 1) {

            int max = 0;
            String str1 = "";
            while (i - j >= -1 && (i + j) < n) {

                if ((i - j > -1) && s.charAt(i - j) == s.charAt(i + j)) {
                    j++;

                } else {
                    str1 = s.substring(i - j + 1, i + j);
                    max = str1.length();
                    i = i + j;
                    j = 0;
                    break;
                }
            }
            if (max >= length) {
                length = max;
                str = str1;
            }
        }
        return str;
    }

    /**
     * 暴力破解
     * <p>
     * 列举所有子串，然后判断是否为回文串。
     *
     * @param s
     * @return
     */
    public String longestPalindrome1(String s) {
        String ans = "";
        int max = 0;
        int len = s.length();
        // 双循环遍历所有字符串
        for (int i = 0; i < len; i++)
            for (int j = i + 1; j <= len; j++) {
                String test = s.substring(i, j);
                if (isPalindromic(test) && test.length() > max) {
                    ans = s.substring(i, j);
                    max = Math.max(max, ans.length());
                }
            }
        return ans;
    }

    public boolean isPalindromic(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 最大公共字符串
     * <p>
     * 根据回文串的定义，正着和反着读一样，那我们是不是把原来的字符串倒置了，
     * 然后找最长的公共子串就可以了。例如 S = "caba" ，S = "abac"，最长公共子串是 "aba"，所以原字符串的最长回文串就是 "aba"。
     * <p>
     * 使用动态规划
     *
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        if (" ".equals(s)) {
            return " ";
        }
        String origin = s;
        // 字符串倒置
        String reverse = new StringBuffer(s).reverse().toString();
        int length = s.length();
        int[][] arr = new int[length][length];
        int maxLen = 0;
        int maxEnd = 0;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (origin.charAt(i) == reverse.charAt(j)) {
                    if (i == 0 || j == 0) {
                        arr[i][j] = 1;

                    } else {
                        arr[i][j] = arr[i - 1][j - 1] - 1;
                    }

                }
                if (arr[i][j] > maxLen) {
                    int beforeRev = length - 1 - j;
                    // 判断下标是否对应
                    if (beforeRev + arr[i][j] - 1 == i) {
                        maxLen = arr[i][j];
                        maxEnd = i;
                    }

                }
            }

        }
        return s.substring(maxEnd - maxLen + 1, maxEnd + 1);
    }

    /**
     * 动态规划
     * <p>
     * 1.如果一个字符串的头尾两个字符都不相等，那么这个字符串一定不是回文串；
     * 2.如果一个字符串的头尾两个字符相等，才有必要继续判断下去。
     *
     * @param s
     * @return
     */
    public String longestPalindrome3(String s) {

        int len = s.length();

        if (s.length() < 2) {
            return s;
        }
        boolean[][] dp = new boolean[len][len];

        // 初始化
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        int maxLen = 1;
        int start = 0;
        for (int j = 0; j < len; j++) {
            for (int i = 0; i < j; i++) {

                if (s.charAt(i) == s.charAt(j)) {
                    // 边界条件：j-i=2 三位的最小回文串--> "aba"
                    if (j - i < 3) {

                        dp[i][j] = true;
                    } else {
                        // 状态转移方程：从俩边开始判断其中是否也是回文串
                        dp[i][j] = dp[i + 1][j - 1];
                    }

                } else {

                    dp[i][j] = false;
                }
                // 只要 dp[i][j] == true 成立，就表示子串 s[i, j] 是回文，此时记录回文长度和起始位置
                if (dp[i][j]) {
                    int curLen = j - i + 1;
                    if (curLen > maxLen) {
                        maxLen = curLen;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start, start + maxLen);
    }

    /**
     * 1. 中心扩散法
     * <p>
     * 2. Manacher 算法 ---> 效率比较高
     *
     * @param s
     * @return
     */
    public String longestPalindrome4(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        String res = s.substring(0, 1);

        // 中心位置枚举到 len - 2 即可
        for (int i = 0; i < len - 1; i++) {

            // 回文数为奇数
            String oddStr = centerSpread(s, i, i);
            // 回文数为偶数
            String evenStr = centerSpread(s, i, i + 1);
            String maxLenStr = oddStr.length() > evenStr.length() ? oddStr : evenStr;
            if (maxLenStr.length() > maxLen) {
                maxLen = maxLenStr.length();
                res = maxLenStr;
            }
        }
        return res;
    }

    private String centerSpread(String s, int left, int right) {
        // left = right 的时候，此时回文中心是一个字符，回文串的长度是奇数
        // right = left + 1 的时候，此时回文中心是一个空隙，回文串的长度是偶数
        int len = s.length();
        int i = left;
        int j = right;
        // 双指针从俩边进行
        while (i >= 0 && j < len) {
            if (s.charAt(i) == s.charAt(j)) {
                i--;
                j++;
            } else {
                break;
            }
        }
        // 这里要小心，跳出 while 循环时，恰好满足 s.charAt(i) != s.charAt(j)，因此不能取 i，不能取 j
        return s.substring(i + 1, j);
    }

}
