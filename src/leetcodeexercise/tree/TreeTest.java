package leetcodeexercise.tree;

import org.junit.Test;

import java.util.*;

/**
 * @author Jay
 * @description
 * @date Created in 2020/7/14 1:47 下午
 */
public class TreeTest {

    @Test
    public void test() {


        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;

        List<List<Integer>> integers = levelOrder(t1);
        System.out.println(1);
    }

    /**
     * 层级遍历
     *
     * @param
     */
    private List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> levels = new ArrayList<>();
        if (root == null) {
            return levels;
        }
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            levels.add(new ArrayList<Integer>());
            int length = queue.size();
            for (int i = 0; i < length; i++) {
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
}
