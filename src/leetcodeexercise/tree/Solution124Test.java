package leetcodeexercise.tree;

import org.junit.Test;

/**
 * @author Jay
 * @description 给定一个非空二叉树，返回其最大路径和。
 * @date Created in 2020/4/19 12:38 下午
 */
public class Solution124Test {

    int maxSum = Integer.MAX_VALUE;

    @Test
    public void test() {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        t1.right = t2;
        t1.left = t3;

        System.out.println(maxPathSum(t1));

    }

    /**
     * 递归
     * 后序遍历
     *
     * @param root
     * @return
     */
    public int maxPathSum(TreeNode root) {
        maxGain(root);

        return maxSum;

    }

    private int maxGain(TreeNode root) {

        if (root == null) {
            return 0;
        }
        // 左右子节点最大值，若为负则作为0
        int leftGain = Math.max(maxGain(root.left), 0);
        int rightGain = Math.max(maxGain(root.right), 0);
        // 保存当前节点为根节点树的最大值
        int a = leftGain + rightGain + root.val;
        maxSum = Math.max(maxSum, a);
        // 给上一节点返回本节点的最大值
        return root.val + Math.max(leftGain, rightGain);


    }
}
