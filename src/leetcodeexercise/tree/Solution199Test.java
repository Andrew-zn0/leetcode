package leetcodeexercise.tree;


import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Jay
 * @description 二叉树的右视图
 * @date Created in 2020/4/21 1:23 下午
 */
public class Solution199Test {

    @Test
    public void test() {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        t1.right = t2;
        t1.left = t3;

        System.out.println(rightSideView(t1));

    }

    List<Integer> ans = new ArrayList<>();
    int deepest = 0;

    /**
     * 深度优先
     *
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        helper(root, 0);
        return ans;


    }

    private void helper(TreeNode root, int now) {
        if (root == null) {
            return;
        }
        // 找出最大深度，优先右子树说明若左右同层则右子树值
        if (now == deepest) {
            ans.add(root.val);
            deepest++;
        }
        // 优先右子树
        helper(root.right, now + 1);
        helper(root.left, now + 1);
    }

    /**
     * 广度优先
     * <p>
     * 1.层级遍历找到每一层最右边元素
     * 2,然后添加
     *
     * @param root
     * @return
     */
    public List<Integer> rightSideView1(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<Integer> levels = new ArrayList<>();
        if (root == null) {
            return levels;
        }
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; ++i) {
                TreeNode node = queue.remove();
                levels.set(level, node.val);
                // 遍历将每一层元素放入
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
