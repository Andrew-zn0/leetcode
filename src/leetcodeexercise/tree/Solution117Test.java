package leetcodeexercise.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Jay
 * @description 填充每个节点的下一个右侧节点指针 II
 * @date Created in 2020/4/15 9:41 下午
 */
public class Solution117Test {

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
     * 迭代层级遍历
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

            levels.add(new ArrayList<>());
            int size = queue.size();

            for (int i = 0; i < size; ++i) {

                TreeNode node = queue.remove();

                levels.get(level).add(node);
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
     * 递归
     *
     * @param root
     * @return
     */
    public TreeNode connect1(TreeNode root) {
        if (root == null || (root.right == null && root.left == null)) {
            return root;
        }
        if (root.left != null && root.right != null) {
            root.left.next = root.right;
            root.right.next = getNextNoNullChild(root);
        }
        if (root.left == null) {
            root.right.next = getNextNoNullChild(root);
        }
        if (root.right == null) {
            root.left.next = getNextNoNullChild(root);
        }

        // 这里要注意：先递归右子树，否则右子树根节点next关系没建立好，左子树到右子树子节点无法正确挂载
        root.right = connect(root.right);
        root.left = connect(root.left);

        return root;
    }

    /**
     * 一路向右找到有子节点的根节点
     */
    private static TreeNode getNextNoNullChild(TreeNode root) {
        while (root.next != null) {
            if (root.next.left != null) {
                return root.next.left;
            }
            if (root.next.right != null) {
                return root.next.right;
            }
            root = root.next;
        }
        return null;
    }

}
