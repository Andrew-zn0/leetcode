package leetcodeexercise.esay.from101to200;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jay
 * @description 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * @date Created in 2020/3/7 2:54 下午
 */
public class Solution119Test {

    @Test
    public void test() {

        //System.out.println(getRow(3));
        System.out.println(getRow1(3));

    }

    /**
     * 动态规划
     *
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow(int rowIndex) {

        rowIndex++;
        List<List<Integer>> triangle = new ArrayList<>();

        if (rowIndex == 0) {
            return null;
        }
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> row = new ArrayList<>();
            // 每次从放好的表中取出上层，然后计算
            List<Integer> prevRow = triangle.get(i - 1);

            row.add(1);
            for (int j = 1; j < i; j++) {
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }
            row.add(1);

            triangle.add(row);
        }

        return triangle.get(rowIndex);

    }

    /**
     * 使用公式
     *
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow1(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        int N = rowIndex;
        long pre = 1;
        ans.add(1);
        for (int k = 1; k <= N; k++) {
            long cur = pre * (N - k + 1) / k;
            ans.add((int) cur);
            pre = cur;
        }
        return ans;
    }

    /**
     * 算法1优化
     *
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow2(int rowIndex) {
        int pre = 1;
        List<Integer> cur = new ArrayList<>();
        cur.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            // 从最大开始倒着进行，不会造成覆盖
            for (int j = i - 1; j > 0; j--) {
                cur.set(j, cur.get(j - 1) + cur.get(j));
            }
            cur.add(1);//补上每层的最后一个 1
        }
        return cur;
    }


}
