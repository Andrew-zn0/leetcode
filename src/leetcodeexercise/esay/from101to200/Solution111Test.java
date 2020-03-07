package leetcodeexercise.esay.from101to200;

import org.junit.Test;

/**
 * @author Jay
 * @description 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量
 *
 * @date Created in 2020/3/7 12:59 下午
 */
public class Solution111Test {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    @Test
    public void test() {

        TreeNode t1 = new TreeNode(1);
        TreeNode t4 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(2);
        t2.left = t1;

        System.out.println(minDepth(t2));
       // System.out.println(isBalanced1(t2));

    }

    public int minDepth(TreeNode root) {

        if(root ==null){
            return 0;
        }
        int m1 = minDepth(root.left);
        int m2 = minDepth(root.right);
        //1.如果左孩子和右孩子有为空的情况，直接返回m1+m2+1
        //2.如果都不为空，返回较小深度+1
        return root.left == null || root.right == null ? m1 + m2 + 1 : Math.min(m1,m2) + 1;


    }
}
