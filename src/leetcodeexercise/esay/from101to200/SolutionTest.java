package leetcodeexercise.esay.from101to200;


import datastructure.stack.Stack;
import datastructure.stack.StackSingleLinked;
import javafx.util.Pair;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

/**
 * 107. 二叉树的层级遍历
 */
class Solution107Test {
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
        TreeNode t4 = new TreeNode(3);
        TreeNode t2 = new TreeNode(2);
        TreeNode t5 = new TreeNode(6);
        TreeNode t3 = new TreeNode(0);
        t2.left = t4;
        t2.right = t1;
        t4.left = t3;
        t4.right = t5;

        System.out.println(levelOrderBottom(t2));
    }

    /**
     * 队列法
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrderBottom1(TreeNode root) {
        List<List<Integer>> trees = new ArrayList<>();
        if (root == null) {
            return trees;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> lists = new ArrayList<>();
            // 取出所有队列中元素子节点
            for (int i = 0; i < size; i++) {
                TreeNode t1 = q.poll();
                lists.add(t1.val);
                if (t1.left != null) {
                    q.add(t1.left);

                }
                if (t1.right != null) {

                    q.add(t1.right);
                }
            }
            trees.add(lists);
        }
        Collections.reverse(trees);
        return trees;
    }

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, 0, res);
        Collections.reverse(res);
        return res;


    }

    private static void helper(TreeNode root, int height, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        if (height + 1 > res.size()) {
            res.add(new ArrayList());
        }
        res.get(height).add(root.val);
        if (root.left != null) {
            helper(root.left, height + 1, res);
        }
        if (root.right != null) {
            helper(root.right, height + 1, res);
        }
    }

}

/**
 * 108. 将有序数组转换为二叉搜索树
 */
class Solution108Test {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        TreeNode treeNode = sortedArrayToBST(nums);
        System.out.println(treeNode);

    }


    public static TreeNode sortedArrayToBST1(int[] nums) {

        if (nums == null) {
            return null;
        }
        return handler(nums, 0, nums.length - 1);
    }

    /**
     * 二分查找,递归,分治
     *
     * @param nums
     * @param left
     * @param right
     * @return
     */
    public static TreeNode handler(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) >>> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = handler(nums, left, mid - 1);
        root.right = handler(nums, mid + 1, right);
        return root;

    }

    /**
     * 非递归
     * <p>
     * 思路:
     * <p>
     * 1.构造一棵空平衡树
     * 2. 中序遍历,给二叉树赋值
     *
     * @param nums
     * @return
     */
    public static TreeNode sortedArrayToBST(int[] nums) {

        if (nums == null) {
            return null;
        }
        int len = nums.length;
        int count = 0;
        TreeNode root = new TreeNode(count++);

        Stack s = new StackSingleLinked();
        Queue<TreeNode> q = new LinkedList<>();

        // 构造空二叉树
        TreeNode t;
        q.add(root);
        while (!q.isEmpty()) {
            t = q.poll();
            if (count >= len) {
                break;
            }
            t.left = new TreeNode(count++);
            q.offer(t.left);
            if (count >= len) {
                break;
            }
            t.right = new TreeNode(count++);
            q.offer(t.right);

        }
        // 中序遍历,为二叉树赋值
        count = 0;
        t = root;

        while (t != null || !s.isEmpty()) {
            // 一直拿到左节点,先左后右,栈实现.
            while (t != null) {
                s.push(t);
                t = t.left;
            }
            t = (TreeNode) s.pop();
            if (count < len) {
                t.val = nums[count++];
                t = t.right;
            }
        }
        return root;
    }

}
