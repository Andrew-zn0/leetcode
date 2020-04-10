package leetcodeexercise.tree;

import org.junit.Test;

/**
 * @author Jay
 * @description 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * @date Created in 2020/4/10 3:37 下午
 */
public class Solution98Test {

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


    public boolean isValidBST(TreeNode root) {

        if (root == null) {
            return true;
        }

        if (root.right != null &&root.right.val <= root.val ) {
            return false;
        }


        if (root.left != null && root.left.val >=root.val) {
            return false;
        }


        boolean validBST = isValidBST(root.right);

        boolean validBST1 = isValidBST(root.left);

        return validBST && validBST1;


    }

}
