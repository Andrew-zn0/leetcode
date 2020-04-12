package leetcodeexercise.tree;

import org.junit.Test;

import java.util.HashMap;

/**
 * @author Jay
 * @description 根据一棵树的中序遍历与后序遍历构造二叉树。
 * @date Created in 2020/4/12 10:41 下午
 */
public class Solution106Test {
    int post_idx;
    int[] postorder;
    int[] inorder;
    HashMap<Integer, Integer> idx_map = new HashMap<Integer, Integer>();

    @Test
    public void test() {
        int[] a = {9, 3, 15, 20, 7};

        int[] b = {9, 15, 7, 20, 3};

        buildTree(a, b);


    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        this.postorder = postorder;
        this.inorder = inorder;
        // 后序遍历最后一个为根节点
        post_idx = postorder.length - 1;


        int idx = 0;
        for (Integer val : inorder) {
            idx_map.put(val, idx++);
        }
        return helper(0, inorder.length - 1);

    }

    public TreeNode helper(int in_left, int in_right) {

        if (in_left > in_right) {
            return null;
        }


        int root_val = postorder[post_idx];
        TreeNode root = new TreeNode(root_val);


        int index = idx_map.get(root_val);

        // 从后往前遍历
        post_idx--;

        root.right = helper(index + 1, in_right);

        root.left = helper(in_left, index - 1);
        return root;
    }
}
