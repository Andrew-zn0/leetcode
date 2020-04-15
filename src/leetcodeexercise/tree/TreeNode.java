package leetcodeexercise.tree;

/**
 * @author Jay
 * @description
 * @date Created in 2020/4/2 6:54 下午
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode next;


    TreeNode(int x) {
        val = x;
    }

    public TreeNode(int val, TreeNode left, TreeNode right, TreeNode next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }
}
