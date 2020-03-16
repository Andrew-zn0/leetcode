package leetcodeexercise.normal;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    /**
     * 当前得到的字符串
     */
    String res;
    /**
     * 剩余左括号数量
     */
    int left;
    /**
     * 剩余右括号数量
     */
    int right;

    public Node(String str, int left, int right) {
        this.res = str;
        this.left = left;
        this.right = right;
    }
}

/**
 * @author Jay
 * @description 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * @date Created in 2020/3/16 10:43 上午
 */
public class Solution22Test {
    @Test
    public void test() {


        System.out.println(generateParenthesis3(3));
    }

    /**
     * 深度遍历优先
     * <p>
     * 1.当前左右括号都有大于 0 个可以使用的时候，才产生分支；
     * 2.产生左分支的时候，只看当前是否还有左括号可以使用；
     * 3.产生右分支的时候，还受到左分支的限制，右边剩余可以使用的括号数量一定得在严格大于左边剩余的数量的时候，才可以产生分支；
     * 4.左边和右边剩余的括号数都等于 0 的时候结算。
     * <p>
     * 做减法
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {

        List<String> res = new ArrayList<>();
        // 特判
        if (n == 0) {
            return res;
        }

        // 执行深度优先遍历，搜索可能的结果
        dfs("", n, n, res);
        return res;

    }

    /**
     * @param curStr
     * @param left
     * @param right
     * @param res
     */
    private void dfs(String curStr, int left, int right, List<String> res) {
        // 因为每一次尝试，都使用新的字符串变量，所以无需回溯
        // 递归回归条件，直接添加回结果集
        if (left == 0 && right == 0) {
            res.add(curStr);
            return;
        }
        // 剪枝：每当左边可使用括号大于右边括号才使用
        // 即字符串中左括号必须多余右括号，所以 剩余括号left必须小于right才是有效排列
        if (left > right) {
            return;
        }

        if (left > 0) {
            dfs(curStr + "(", left - 1, right, res);
        }

        if (right > 0) {
            dfs(curStr + ")", left, right - 1, res);
        }
    }

    /**
     * 使用加法
     * <p>
     * left 与 right 表示字符串中已经使用了多少个括号。
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis1(int n) {
        List<String> res = new ArrayList<>();
        // 特判
        if (n == 0) {
            return res;
        }

        dfs1("", 0, 0, n, res);
        return res;
    }

    private void dfs1(String curStr, int left, int right, int n, List<String> res) {
        if (left == n && right == n) {
            res.add(curStr);
            return;
        }

        // 剪枝
        if (left < right) {
            return;
        }

        if (left < n) {
            dfs1(curStr + "(", left + 1, right, n, res);
        }
        if (right < n) {
            dfs1(curStr + ")", left, right + 1, n, res);
        }
    }

    /**
     * 广度遍历优先:使用队列
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis2(int n) {

        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node("", n, n));

        while (!queue.isEmpty()) {

            Node curNode = queue.poll();
            if (curNode.left == 0 && curNode.right == 0) {
                res.add(curNode.res);
            }
            if (curNode.left > 0) {
                queue.offer(new Node(curNode.res + "(", curNode.left - 1, curNode.right));
            }
            // 判断剪枝条件
            if (curNode.right > 0 && curNode.left < curNode.right) {
                queue.offer(new Node(curNode.res + ")", curNode.left, curNode.right - 1));
            }

        }
        return res;
    }

    /**
     * 动态规划
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis3(int n) {

        if (n == 0) {
            return new ArrayList<>();
        }
        // 这里 dp 数组我们把它变成列表的样子，方便调用而已
        List<List<String>> dp = new ArrayList<>(n);

        List<String> dp0 = new ArrayList<>();
        dp0.add("");
        dp.add(dp0);
        for (int i = 1; i <= n; i++) {
            List<String> cur = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                List<String> str1 = dp.get(j);
                List<String> str2 = dp.get(i - 1 - j);
                for (String s1 : str1) {
                    for (String s2 : str2) {
                        // 枚举右括号的位置
                        cur.add("(" + s1 + ")" + s2);
                    }
                }
            }
            dp.add(cur);
        }
        return dp.get(n);
    }

}
