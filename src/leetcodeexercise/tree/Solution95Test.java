package leetcodeexercise.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jay
 * @description 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
 * @date Created in 2020/4/3 3:39 下午
 */
public class Solution95Test {

    @Test
    public void test() {

        System.out.println(generateTrees(2));
    }

    /**
     * 递归实现
     *
     * @param n
     * @return
     */
    public List<TreeNode> generateTrees(int n) {

        List<TreeNode> ans = new ArrayList<TreeNode>();

        if (n == 0) {
            return ans;
        }

        return getAns(1, n);
    }

    /**
     * 1.可以按照中序遍历，将每一个元素当成根节点
     * 2.找到根节点的左子树与右子树，进行递归
     * @param start
     * @param end
     * @return
     */
    private List<TreeNode> getAns(int start, int end) {

        List<TreeNode> ans = new ArrayList<TreeNode>();
        // 此时没有数据将null加入结果集
        if (start > end) {
            ans.add(null);
            return ans;
        }
        // 若只有一个数字，则将该数字以单独树存入
        if (end == start) {
            TreeNode tree = new TreeNode(start);
            ans.add(tree);
            return ans;
        }
        // 将每一个数字作为根节点尝试
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


}

