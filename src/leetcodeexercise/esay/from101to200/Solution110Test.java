package leetcodeexercise.esay.from101to200;

import org.junit.Test;

/**
 * @author Jay
 * @description 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * @date Created in 2020/3/5 11:50 上午
 */
public class Solution110Test {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    @Test
    public void test() {

        TreeNode t1 = new TreeNode(1);
        TreeNode t4 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        t2.left = t1;
        t2.right = t4;
        System.out.println(isBalanced(t2));
        System.out.println(isBalanced1(t2));

    }

    public boolean isBalanced(TreeNode root) {

        return depth(root) != -1;
    }

    /**
     * 从底至顶（提前阻断法）
     * 深度遍历优先。
     * <p>
     * 中止条件：返回子叶子节点话则返回0。
     * <p>
     * 从底至顶，返回以每个节点root为根节点的子树最大高度(左右子树中最大的高度值加1max(left,right) + 1)；
     * 当发现不是平衡树时，后面的高度计算都没有意义了，因此一路返回-1，避免后续多余计算。
     * <p>
     * 时间复杂度： O(N)
     *
     * @param root
     * @return
     */
    private int depth(TreeNode root) {
        // 回归条件，子叶子节点为0.
        if (root == null) {
            return 0;
        }
        int left = depth(root.left);
        if (left == -1) {
            return -1;
        }
        int right = depth(root.right);
        if (right == -1) {
            return -1;
        }

        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;

    }

    public boolean isBalanced1(TreeNode root) {

        if (root == null) return true;
        return Math.abs(depth(root.left) - depth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    /**
     * 从顶至底（暴力法）
     *
     * 构造一个获取当前节点最大深度的方法 depth() ，
     * 通过比较左右子树最大高度差abs(self.depth(root.left) - self.depth(root.right))，来判断以此节点为根节点下是否是二叉平衡树；
     *
     *若所有根节点都满足平衡二叉树性质，则返回 True ；
     *若其中任何一个节点作为根节点时，不满足平衡二叉树性质，则返回False。
     *
     *
     * @param root
     * @return
     */
    private int depth1(TreeNode root) {
        if (root == null) return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;

    }
}
