package leetcodeexercise.esay.from101to200;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jay
 * @description 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * @date Created in 2020/3/7 2:18 下午
 */
public class Solution118Test {

    @Test
    public void test() {

        List<List<Integer>> generate = generate(3);
        generate.forEach(System.out::println);
    }

    /**
     * 动态规划思路
     *
     *
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> triangle = new ArrayList<>();

        if(numRows==0){
            return triangle;
        }

        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
           // 每次从放好的表中取出上层，然后计算
            List<Integer> prevRow = triangle.get(i-1);

            row.add(1);
            for (int j = 1; j < i; j++) {
                row.add(prevRow.get(j-1) + prevRow.get(j));
            }
            row.add(1);

            triangle.add(row);
        }

        return triangle;

    }
}
