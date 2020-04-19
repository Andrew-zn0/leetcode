package leetcodeexercise.tree;

import org.junit.Test;

/**
 * @author Jay
 * @description 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 * @date Created in 2020/4/19 3:30 下午
 */
public class Solution129Test {

    @Test
    public void test() {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        t1.right = t2;
        t1.left = t3;

        System.out.println(sumNumbers(t1));

    }

    /**
     * 前序遍历
     *
     * @param root
     * @return
     */
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    /**
     * 将上层的节点传递给下层，每多一层则为10位
     *
     * @param root
     * @param i
     * @return
     */
    public int helper(TreeNode root, int i) {
        if (root == null) {
            return 0;
        }

        int temp = i * 10 + root.val;
        // 此时表示到达叶子节点，将计算所得值返回，递归结束点
        if (root.left == null && root.right == null) {
            return temp;
        }
        // 将根节点值加入，然后计算左右子节点的分支的路径值，然后将其相加。
        return helper(root.left, temp) + helper(root.right, temp);
    }


}
