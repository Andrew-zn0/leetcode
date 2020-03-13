package leetcodeexercise.normal;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jay
 * @description 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * @date Created in 2020/3/11 2:36 下午
 */
public class Solution6Test {

    @Test
    public void test() {

        System.out.println(convert("LEETCODEISHIRING", 3));
    }

    /**
     * 按行排序
     * <p>
     * 每一次为的行坐标变换为s1-->sn 再从 sn-->s1 n为字符串长度
     * <p>
     * 按照规则循环遍历即可
     *
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if (numRows < 2) return s;
        List<StringBuilder> rows = new ArrayList<StringBuilder>();
        for (int i = 0; i < numRows; i++) rows.add(new StringBuilder());
        int i = 0, flag = -1;
        for (char c : s.toCharArray()) {
            rows.get(i).append(c);
            if (i == 0 || i == numRows - 1) flag = -flag;
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows) res.append(row);
        return res.toString();
    }


}
