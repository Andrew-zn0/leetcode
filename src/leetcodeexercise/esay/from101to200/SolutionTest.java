package leetcodeexercise.esay.from101to200;


import datastructure.stack.Stack;
import datastructure.stack.StackSingleLinked;
import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class SolutionTest {


}

/**
 * 101.对称二叉树
 */
class Solution101Test {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

        TreeNode t1 = new TreeNode(1);
        TreeNode t4 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        t2.left = t1;
        t2.right = t4;
        System.out.println(isSymmetric(t2));

    }

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public static boolean isSymmetric1(TreeNode root) {
        return isMirror(root.left, root.right);

    }

    private static boolean isMirror(TreeNode root, TreeNode root1) {
        if (root1 == null && root == null) {
            return true;

        }
        if (root == null || root1 == null) {
            return false;

        }
        return (root.val == root1.val) &&
                isMirror(root.right, root1.left) &&
                isMirror(root.left, root1.right);
    }

    /**
     * 迭代
     * <p>
     * 队列实现,按层遍历,广度优先
     *
     * @param root
     * @return
     */
    public static boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) {
                continue;
            }
            if (t1 == null || t2 == null) {
                return false;
            }
            if (t1.val != t2.val) {
                return false;
            }
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }
}

/**
 * 104. 二叉树的最大深度
 */
class Solution104Test {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t4 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        t2.left = t1;
        t2.right = t4;

        System.out.println(maxDepth(t2));

    }

    /**
     * 递归,每次遍历一层则返回值加1
     *
     * @param root
     * @return
     */
    public static int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    /**
     * 迭代
     * 利用栈,深度优先
     *
     * @param root
     * @return
     */
    public static int maxDepth(TreeNode root) {
        Queue<Pair<TreeNode, Integer>> stack = new LinkedList<>();
        if (root != null) {
            stack.add(new Pair(root, 1));
        }
        int depth = 0;
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> current = stack.poll();
            root = current.getKey();
            int currentDepth = current.getValue();
            if (root != null) {
                depth = Math.max(depth, currentDepth);
                stack.add(new Pair(root.left, currentDepth + 1));
                stack.add(new Pair(root.right, currentDepth + 1));
            }
        }
        return depth;
    }
}
