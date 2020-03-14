package leetcodeexercise.normal;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jay
 * @description 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * @date Created in 2020/3/14 2:57 下午
 */
public class Solution17Test {
    @Test
    public void test() {

        System.out.println(letterCombinations("23"));
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        backtrack(result, "", digits);
        return result;
    }

    public void backtrack(List<String> result, String condition, String next_digits) {
        Map<String, String> map = new HashMap<>();
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
        if (next_digits.length() == 0) {
            result.add(condition);
        } else {
            String digit = next_digits.substring(0, 1);
            String letters = map.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = letters.substring(i, i + 1);
                // 截取从1开始的以后字符
                backtrack(result, condition + letter, next_digits.substring(1));
            }
        }
    }

}
