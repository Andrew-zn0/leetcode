package leetcodeexercise.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Jay
 * @description 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * @date Created in 2020/4/12 3:47 下午
 */
public class Solution103Test {

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

        zigzagLevelOrder(t1);


    }

    /**
     * 迭代
     *
     *
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> levels = new ArrayList<>();

        if (root == null) {
            return levels;

        }
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            LinkedList<Integer> q = new LinkedList<>();
            levels.add(q);

            // 每次队列里边存储的都为当前层数所有节点
            int level_length = queue.size();
            for (int i = 0; i < level_length; ++i) {
                // 取出元素，然后加入
                TreeNode node = queue.remove();
                LinkedList integers = (LinkedList) levels.get(level);
                // 根据层数来决定入库方向。
                if (level % 2 == 0) {
                    integers.addLast(node.val);
                } else {
                    integers.addFirst(node.val);
                }

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
     * 先序遍历，记录当前层数进行控制。
     *
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {

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

        LinkedList integers = (LinkedList) levels.get(level);
        // 根据层数来决定入库方向。
        if (level % 2 == 0) {
            integers.addLast(node.val);
        } else {
            integers.addFirst(node.val);
        }

        if (node.left != null) {
            helper(node.left, level + 1);
        }
        if (node.right != null) {
            helper(node.right, level + 1);
        }
    }

}
