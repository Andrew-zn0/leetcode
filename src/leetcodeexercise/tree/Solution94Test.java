package leetcodeexercise.tree;

import datastructure.stack.StackSingleLinked;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Jay
 * @description 二叉树的中序遍历
 * @date Created in 2020/4/2 6:54 下午
 */
public class Solution94Test {

    @Test
    public void test() {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        t1.right = t2;
        t1.left = t3;
        t3.right = t4;
        System.out.println(inorderTraversal(t1));
    }

    /**
     * 递归实现
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        //inorder(root, list);
        inorder1(root, list);

        return list;

    }

    /**
     * 二叉树中序遍历递归实现
     *
     * @param root
     * @param list
     */
    public void inorder(TreeNode root, List<Integer> list) {

        if (root != null) {
            // 先从左节点遍历
            if (root.left != null) {

                inorder(root.left, list);
            }
            // 将数据添加
            list.add(root.val);

            // 再从右节点
            if (root.right != null) {
                inorder(root.right, list);
            }
        }


    }


    /**
     * 迭代实现
     * <p>
     * 1.从左节点开始依次入栈
     * 2.中序遍历首先从左叶子节点入列表，然后根节点入列表，再去找右节点
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        TreeNode p = root;
        // 深度遍历，使用栈
        Stack<TreeNode> s = new Stack<>();
        while (p != null || !s.isEmpty()) {
            while (p != null) {
                // 一直到最左叶子节点
                s.push(p);
                p = p.left;
            }
            if (!s.isEmpty()) {
                // 取出元素
                p = s.pop();
                list.add(p.val);
                p = p.right;
            }
        }
        return list;
    }

    /**
     * 二叉树后序遍历递归实现
     *
     * @param root
     * @param list
     */
    public void inorder1(TreeNode root, List<Integer> list) {

        if (root != null) {
            // 先从左节点遍历
            if (root.left != null) {

                inorder1(root.left, list);
            }
            // 再从右节点
            if (root.right != null) {
                inorder1(root.right, list);
            }
            // 将数据添加
            list.add(root.val);
        }

    }
}
