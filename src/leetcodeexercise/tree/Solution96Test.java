package leetcodeexercise.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jay
 * @description 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 * @date Created in 2020/4/10 2:00 下午
 */
public class Solution96Test {

    @Test
    public void test() {

        System.out.println(numTrees1(3));
    }

    /**
     * 递归
     *
     * @param n
     * @return
     */
    public int numTrees(int n) {

        if (n == 0) {
            return 0;
        }

        return getAns(1, n).size();
    }

    private List<TreeNode> getAns(int start, int end) {

        List<TreeNode> ans = new ArrayList<TreeNode>();
        if (start > end) {
            ans.add(null);
            return ans;
        }

        if (end == start) {
            TreeNode tree = new TreeNode(start);
            ans.add(tree);
            return ans;
        }


        for (int i = start; i <= end; i++) {
            // 得到所有左子树
            List<TreeNode> leftTrees = getAns(start, i - 1);
            // 得到所有右子树
            List<TreeNode> rightTrees = getAns(i + 1, end);
            // 左子树右子树两两组合
            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftTree;
                    root.right = rightTree;
                    //加入到最终结果中
                    ans.add(root);
                }
            }

        }
        return ans;
    }

    /**
     * 动态规划
     *
     * @param n
     * @return
     */
    public int numTrees1(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                // 可以将数组每一个元素作为根，可以组成数目为左右子树的笛卡尔积
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }




}
