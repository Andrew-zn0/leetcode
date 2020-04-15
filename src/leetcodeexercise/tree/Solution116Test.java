package leetcodeexercise.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Jay
 * @description 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * <p>
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * @date Created in 2020/4/15 10:48 上午
 */
public class Solution116Test {

    @Test
    public void test() {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        t1.right = t2;
        t1.left = t3;

        System.out.println(connect(t1));

    }

    /**
     * 迭代，层级遍历，然后将每层进行链接
     *
     * @param root
     * @return
     */
    public TreeNode connect(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<TreeNode>> levels = new ArrayList<>();
        if (root == null) {
            return root;
        }
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            levels.add(new ArrayList<TreeNode>());
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode node = queue.remove();
                levels.get(level).add(node);
                // 将同层数据组成链表
                if (i > 0) {
                    levels.get(level).get(i - 1).next = levels.get(level).get(i);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            level++;
        }
        return root;
    }

    /**
     * 使用已建立的 next 指针
     *
     * @param root
     * @return
     */
    public TreeNode connect1(TreeNode root) {




    }
}
