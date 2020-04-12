package leetcodeexercise.tree;

import org.junit.Test;

import java.util.HashMap;

/**
 * @author Jay
 * @description 根据一棵树的前序遍历与中序遍历构造二叉树。
 * @date Created in 2020/4/12 9:17 下午
 */
public class Solution105Test {
    int pre_idx = 0;
    int[] preorder;
    int[] inorder;
    HashMap<Integer, Integer> idx_map = new HashMap<>();


    @Test
    public void test() {
        int[] a = {3, 9, 20, 15, 7};

        int[] b = {9, 3, 15, 20, 7};

        buildTree(a, b);


    }

    /**
     * 递归
     * <p>
     * preorder 中的第一个元素一定是树的根，这个根又将 inorder 序列分成了左右两棵子树”，
     * <p>
     * 即前序定Root，中序根据Root定左右，按此逻辑递归处理即可。
     *
     *
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;

        int idx = 0;
        for (Integer val : inorder) {
            // 用map将中序遍历放入
            idx_map.put(val, idx++);
        }
        return helper(0, inorder.length);


    }

    public TreeNode helper(int in_left, int in_right) {

        if (in_left == in_right) {
            return null;
        }

        // 根节点为前序遍历的第一个值
        int root_val = preorder[pre_idx];

        TreeNode root = new TreeNode(root_val);
        // 拿到中序遍历根节点的下标
        int index = idx_map.get(root_val);

        pre_idx++;

        // 根据根节点区分左右子树
        root.left = helper(in_left, index);
        root.right = helper(index + 1, in_right);
        return root;

    }
}
