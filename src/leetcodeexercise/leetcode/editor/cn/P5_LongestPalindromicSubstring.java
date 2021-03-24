//给你一个字符串 s，找到 s 中最长的回文子串。
//
//
//
// 示例 1：
//
//
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
//
//
// 示例 2：
//
//
//输入：s = "cbbd"
//输出："bb"
//
//
// 示例 3：
//
//
//输入：s = "a"
//输出："a"
//
//
// 示例 4：
//
//
//输入：s = "ac"
//输出："a"
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 1000
// s 仅由数字和英文字母（大写和/或小写）组成
//
// Related Topics 字符串 动态规划
// 👍 3405 👎 0


package leetcodeexercise.leetcode.editor.cn;

//最长回文子串

public class P5_LongestPalindromicSubstring {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P5_LongestPalindromicSubstring().new Solution();

        System.out.println(solution.longestPalindrome("aba"));
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		/**
		 * 动态规划
		 * @param s
		 * @return
		 */
		public String longestPalindrome(String s) {
			int n = s.length();
			boolean[][] dp = new boolean[n][n];
			String ans = "";
			for (int l = 0; l < n; ++l) {
				for (int i = 0; i + l < n; ++i) {
					int j = i + l;
					if (l == 0) {
						dp[i][j] = true;
					} else if (l == 1) {
						dp[i][j] = (s.charAt(i) == s.charAt(j));
					} else {
						dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
					}
					if (dp[i][j] && l + 1 > ans.length()) {
						ans = s.substring(i, i + l + 1);
					}
				}
			}
			return ans;
		}
	}

    //leetcode submit region end(Prohibit modification and deletion)

}
