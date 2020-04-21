package leetcodeexercise.tree;

import datastructure.tree.BinTreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Jay
 * @description 给定一个二叉树，返回它的 后序遍历。
 * @date Created in 2020/4/20 10:08 上午
 */
public class Solution145Test {

    @Test
    public void test() {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        t1.right = t2;
        t1.left = t3;

        System.out.println(postorderTraversal1(t1));

    }

    /**
     * 后序遍历
     * <p>
     * 递归实现
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> ls = new ArrayList<>();
        if (root == null) {
            return ls;
        }
        postSort(root, ls);

        return ls;

    }


    private void postSort(TreeNode root, List<Integer> ls) {

        if (root == null) {
            return;
        }
        postSort(root.left, ls);
        postSort(root.right, ls);
        ls.add(root.val);

    }


    /**
     * 迭代实现
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> ls = new ArrayList<>();
        if (root == null) {
            return ls;
        }
        Stack<TreeNode> s = new Stack<>();
        TreeNode last = null;

        while (root != null || !s.isEmpty()) {

            while (root != null) {
                // 根节点入栈，一直往左
                s.push(root);
                root = root.left;

            }
            root = s.peek();
            // 判断该节点为叶子节点或者已经参与过
            // LAST 记录上次已经入库的节点
            // 此时说明右节点已经经过遍历，可以将根节点遍历
            if (root.right == null || root.right == last) {

                ls.add(root.val);
                s.pop();
                last = root;
                // 表示左节点已经遍历，可以开始上一层遍历
                root = null;

            } else {

                root = root.right;
            }


        }
        return ls;

    }
}
