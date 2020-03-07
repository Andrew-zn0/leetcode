package leetcodeexercise.esay.from101to200;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @author Jay
 * @description 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * @date Created in 2020/3/7 1:29 下午
 */
public class Solution112Test {
    @Test
    public void test() {

        TreeNode t1 = new TreeNode(1);
        TreeNode t4 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(2);
        t2.left = t1;
        t1.left = t4;
        t2.right = t3;

        System.out.println(hasPathSum(t2, 3));
        System.out.println(hasPathSum1(t2, 3));


    }

    /**
     * 从根节点遍历每一条路径，减去每个节点值，最后叶子节点等于0则为符合路径
     * <p>
     * 递归实现
     * <p>
     * 时间复杂度：
     * <p>
     * 我们访问每个节点一次，时间复杂度为 O(N)O(N) ，其中 NN 是节点个数。
     * <p>
     * 空间复杂度：
     * <p>
     * 最坏情况下，整棵树是非平衡的，例如每个节点都只有一个孩子，递归会调用 NN 次（树的高度），
     * 因此栈的空间开销是 O(N)O(N) 。但在最好情况下，树是完全平衡的，高度只有 \log(N)log(N)，
     * 因此在这种情况下空间复杂度只有 O(\log(N))O(log(N)) 。
     *
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {

        if (root == null) {
            return false;
        }
        sum -= root.val;
        if ((root.left == null) && (root.right == null)) {
            return sum == 0;
        }

        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);

    }

    /**
     * 迭代
     * <p>
     * 深度优先搜索在除了最坏情况下都比广度优先搜索更快。
     *
     * 二叉树深度遍历借助stack
     *
     * 时间复杂度：和递归方法相同是 O(N)O(N)。
     * 空间复杂度：当树不平衡的最坏情况下是 O(N)O(N) 。在最好情况（树是平衡的）下是 O(\log N)O(logN)。
     *
     *
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum1(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        LinkedList<TreeNode> nodeStack = new LinkedList<>();
        LinkedList<Integer> sumStack = new LinkedList<>();

        // 根节点入栈
        nodeStack.add(root);
        sumStack.add(sum - root.val);
        TreeNode node;
        int currSum;
        while (!nodeStack.isEmpty()) {
            node = nodeStack.pollLast();
            currSum = sumStack.pollLast();
            if (node.right == null && node.left == null && currSum == 0) {
                return true;
            }
            if (node.right != null) {
                nodeStack.add(node.right);
                sumStack.add(currSum - node.right.val);
            }
            if (node.left != null) {
                nodeStack.add(node.left);
                sumStack.add(currSum - node.left.val);
            }


        }
        return false;

    }

}
