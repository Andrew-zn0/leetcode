package leetcodeexercise.tree;

import org.junit.Test;

/**
 * @author Jay
 * @description 给定一个二叉树，原地将它展开为链表。
 * @date Created in 2020/4/14 10:19 下午
 */
public class Solution114Test {
    @Test
    public void test() {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        t1.right = t2;
        t1.left = t3;
        t3.right = t4;
        flatten(t1);
    }

    /**
     * 每次将左子树填到右子树
     *
     * @param root
     */
    public void flatten(TreeNode root) {
        while (root != null) {
            //左子树为 null，直接考虑下一个节点
            if (root.left == null) {
                root = root.right;
            } else {
                // 找左子树最右边的节点
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                //将原来的右子树接到左子树的最右边节点
                pre.right = root.right;
                // 将左子树插入到右子树的地方
                root.right = root.left;
                root.left = null;
                // 考虑下一个节点
                root = root.right;
            }
        }
    }

    /**
     * 先序遍历的顺序
     *
     * @param root
     */
    public void flatten1(TreeNode root) {
        helper(root);
    }

    /**
     * 辅助节点
     */
    TreeNode pre = null;

    void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        //右节点-左节点-根节点 这种顺序正好跟前序遍历相反
        //用pre节点作为媒介，将遍历到的节点前后串联起来
        helper(root.right);
        helper(root.left);
        root.left = null;
        root.right = pre;
        pre = root;
    }


}
