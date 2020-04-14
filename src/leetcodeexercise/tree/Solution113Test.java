package leetcodeexercise.tree;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Jay
 * @description 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * @date Created in 2020/4/13 2:58 下午
 */
public class Solution113Test {
    @Test
    public void test() {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        t1.right = t2;
        t1.left = t3;
        t3.right = t4;
        System.out.println(pathSum(t1, 5));
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> l = new ArrayList<>();

        if (root == null) {
            return l;
        }

        // Java 文档中 Stack 类建议使用 Deque 代替 Stack，注意：只使用栈的相关接口
        Deque<Integer> path = new ArrayDeque<>();
        pathSum(root, sum, path, l);

        return l;

    }


    private void pathSum(TreeNode node, int sum, Deque<Integer> path, List<List<Integer>> res) {
        // 递归终止条件
        if (node == null) {
            return;
        }

        // 沿途结点必须选择，这个时候要做两件事：1、sum 减去这个结点的值；2、添加到 path 里
        sum -= node.val;
        path.addLast(node.val);
        if (sum == 0 && node.left == null && node.right == null) {
            // path 全局只有一份，必须做拷贝
            res.add(new ArrayList<>(path));
            // 注意：这里 return 之前必须重置
            path.removeLast();
            return;
        }

        pathSum(node.left, sum, path, res);
        pathSum(node.right, sum, path, res);
        // 递归完成以后，必须重置变量
        path.removeLast();


    }

}
