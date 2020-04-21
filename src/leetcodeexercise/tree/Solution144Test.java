package leetcodeexercise.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/**
 * @author Jay
 * @description 二叉树的前序遍历
 * @date Created in 2020/4/20 9:34 上午
 */
public class Solution144Test {

    @Test
    public void test() {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        t1.right = t2;
        t1.left = t3;

        System.out.println(preorderTraversal1(t1));

    }

    /**
     * 递归实现
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ls = new ArrayList<>();
        if (root == null) {
            return ls;
        }
        preSort(root, ls);

        return ls;
    }

    private void preSort(TreeNode root, List<Integer> list) {
        if (root == null) {

            return;
        }
        list.add(root.val);
        preSort(root.left, list);
        preSort(root.right, list);

    }

    /**
     * 迭代实现
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal1(TreeNode root) {

        List<Integer> ls = new ArrayList<>();

        if (root == null) {
            return ls;
        }

        Stack s = new Stack<TreeNode>();

        while (root != null) {


            while (root != null) {
                // 先序遍历首先找到根节点然后加入队列
                ls.add(root.val);

                // 右子树入栈，先入后出。
                // 先序遍历先左后右
                if (root.right != null) {
                    s.push(root.right);
                }
                // 一直走到左子树叶子节点
                root = root.left;

            }

            if (!s.isEmpty()) {
                // 从栈中取出，从最左边叶子节点根节点右子树开始遍历
                root = (TreeNode) s.pop();

            }
        }
        return ls;
    }
}
