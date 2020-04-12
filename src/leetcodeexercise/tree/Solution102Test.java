package leetcodeexercise.tree;


import org.junit.Test;

import java.util.*;

/**
 * @author Jay
 * @description 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * @date Created in 2020/4/12 2:28 下午
 */
public class Solution102Test {
    List<List<Integer>> levels = new ArrayList<List<Integer>>();

    @Test
    public void test() {


        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(1);
        TreeNode t4 = new TreeNode(4);
        t1.right = t2;
        t1.left = t3;
        t3.right = t4;

        levelOrder(t1);
    }

    /**
     * 迭代
     * <p>
     * 1.设定标记当前层数
     * 2.将本层所有节点放入队列，让后添加
     * 3.取出本层所有元素，并且全部添加下层元素。
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> levels = new ArrayList<>();

        if (root == null) {
            return levels;

        }
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {

            levels.add(new ArrayList<Integer>());
            // 每次队列里边存储的都为当前层数所有节点
            int level_length = queue.size();
            for (int i = 0; i < level_length; ++i) {
                // 取出元素，然后加入
                TreeNode node = queue.remove();
                levels.get(level).add(node.val);
                // 将其左右节点入队列
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }

            }
            level++;
        }
        return levels;

    }

    /**
     * 递归
     *
     * 本质是先序遍历，加入层级标签。
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder1(TreeNode root) {

        if (root == null) {
            return levels;
        }
        helper(root, 0);
        return levels;

    }

    public void helper(TreeNode node, int level) {
        // 判断当前数组大小是否等于层数，相等则说明当前层数数列还没有被创建
        if (levels.size() == level) {
            levels.add(new ArrayList<Integer>());
        }


        levels.get(level).add(node.val);


        if (node.left != null) {
            helper(node.left, level + 1);
        }
        if (node.right != null) {
            helper(node.right, level + 1);
        }
    }
}
