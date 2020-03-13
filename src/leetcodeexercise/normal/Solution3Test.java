package leetcodeexercise.normal;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Jay
 * @description 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * @date Created in 2020/3/10 2:04 下午
 */
public class Solution3Test {
    @Test
    public void test() {

        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    /**
     * 暴力破解
     * <p>
     * 1.建立一个判断字符串唯一的方法。
     * <p>
     * 2.循环遍历，取出每一段字符串判断，找出最长的。
     * <p>
     * O(n3)
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j <= n; j++)
                if (allUnique(s, i, j)) ans = Math.max(ans, j - i);
        return ans;
    }

    public boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) return false;
            set.add(ch);
        }
        return true;
    }

    /**
     * 滑动窗口
     * <p>
     * 1.维护一个窗口
     * <p>
     * 2.每次判断下个元素是否已经包含在窗口中，若包含，则头指针后移，
     * 再次判断，否则放入窗口，尾指针后移。
     * <p>
     * 3.结束条件为走完整个长度。
     * O(n2)
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring1(String s) {

        int n = s.length();

        Set<Character> set = new HashSet<>();
        int ans = 0, head = 0, tail = 0;

        while (head < n && tail < n) {
            if (!set.contains(s.charAt(tail))) {
                // 若不包含改元素，则将元素添加进窗口，并且尾指针后移
                set.add(s.charAt(tail++));
                // 取最大长度
                ans = Math.max(ans, tail - head);
            } else {
                // 若已包含，将窗口头指针后移
                set.remove(s.charAt(head++));
            }
        }
        return ans;
    }

    /**
     * 滑动窗口优化
     * <p>
     * 优化思路：减少头元素移动次数。
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {

        int n = s.length(), ans = 0;
        // map是为了记录字符索引，方便位移
        Map<Character, Integer> map = new HashMap<>();
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                // 若第 j 个元素在[i，j）中已包含，则 i 不需要移动 j-i 次
                // i直接从 j-1 开始
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            // 每一个字符在字符串对应的位置
            map.put(s.charAt(j), j + 1);
        }
        return ans;

    }

}
