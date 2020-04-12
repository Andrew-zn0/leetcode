package leetcodeexercise.tree;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Jay
 * @description 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * @date Created in 2020/4/10 3:37 下午
 */
public class Solution98Test {
    LinkedList<TreeNode> stack = new LinkedList();
    LinkedList<Integer> uppers = new LinkedList(),
            lowers = new LinkedList();


    @Test
    public void test() {


        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(1);
        TreeNode t4 = new TreeNode(4);
        t1.right = t2;
        t1.left = t3;
        t3.right = t4;

        System.out.println(isValidBST(t1));
    }

    /**
     * 不光需要判断左右子节点是否相同，而且还需要解决左右子树所有问题。
     * <p>
     * 所以需要记录左子树最大值和右子树最小值来进行判断。
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {

        if (root == null) {
            return true;
        }

        if (root.right != null && root.right.val <= root.val) {
            return false;
        }


        if (root.left != null && root.left.val >= root.val) {
            return false;
        }


        boolean validBST = isValidBST(root.right);

        boolean validBST1 = isValidBST(root.left);

        return validBST && validBST1;


    }

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public boolean isValidBST1(TreeNode root) {

        return helper(root, null, null);
    }

    public boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null) {
            return true;
        }

        int val = node.val;
        // 根节点判断
        if (lower != null && val <= lower) {
            return false;
        }
        if (upper != null && val >= upper) {
            return false;
        }
        // 左右树进行判断
        if (!helper(node.right, val, upper)) {
            return false;
        }
        if (!helper(node.left, lower, val)) {
            return false;
        }
        return true;
    }

    /**
     * 迭代
     *
     * @param root
     * @return
     */
    public boolean isValidBST2(TreeNode root) {
        Integer lower = null, upper = null, val;
        update(root, lower, upper);

        while (!stack.isEmpty()) {
            root = stack.poll();
            lower = lowers.poll();
            upper = uppers.poll();

            if (root == null) {
                continue;
            }
            val = root.val;
            if (lower != null && val <= lower) {
                return false;
            }
            if (upper != null && val >= upper) {
                return false;
            }
            update(root.right, val, upper);
            update(root.left, lower, val);
        }
        return true;

    }


    public void update(TreeNode root, Integer lower, Integer upper) {
        stack.add(root);
        lowers.add(lower);
        uppers.add(upper);
    }

    /**
     * 中序遍历的话每一个有效搜索树应该为有序数列
     *
     * @param root
     * @return
     */
    public boolean isValidBST3(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        double inorder = -Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();

            if (root.val <= inorder) {
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }


}
