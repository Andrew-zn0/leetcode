package leetcodeexercise.tree;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Jay
 * @description 二叉搜索树中的两个节点被错误地交换。
 * 请在不改变其结构的情况下，恢复这棵树。
 * @date Created in 2020/4/12 1:33 下午
 */
public class Solution99Test {
    TreeNode x = null, y = null, pred = null;

    @Test
    public void test() {


        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(1);
        TreeNode t4 = new TreeNode(4);
        t1.right = t2;
        t1.left = t3;
        t3.right = t4;

        recoverTree(t1);
    }

    /**
     * 方法1：
     * 1.对树进行中序遍历，然后得到数组
     * 2.该数组应该是升序排列，找出其中俩个错误元素
     * 3.遍历树将这俩个节点做对换
     *
     * @param root
     */
    public void recoverTree(TreeNode root) {
        List<Integer> nums = new ArrayList();
        // 中序遍历得到数组
        inorder(root, nums);
        // 找到交换之后的俩个数据
        int[] swapped = findTwoSwapped(nums);
        // 交换节点
        recover(root, 2, swapped[0], swapped[1]);


    }

    public void inorder(TreeNode root, List<Integer> nums) {
        if (root == null) {
            return;
        }
        inorder(root.left, nums);
        nums.add(root.val);
        inorder(root.right, nums);
    }

    public int[] findTwoSwapped(List<Integer> nums) {
        int n = nums.size();
        int x = -1, y = -1;
        for (int i = 0; i < n - 1; ++i) {
            if (nums.get(i + 1) < nums.get(i)) {
                y = nums.get(i + 1);
                if (x == -1) {
                    x = nums.get(i);
                } else {
                    break;
                }
            }
        }
        return new int[]{x, y};
    }

    public void recover(TreeNode r, int count, int x, int y) {
        if (r != null) {
            if (r.val == x || r.val == y) {
                // 只需要修改值便可，不需要交换元素地址
                r.val = r.val == x ? y : x;
                if (--count == 0) {
                    return;
                }
            }
            recover(r.left, count, x, y);
            recover(r.right, count, x, y);
        }
    }

    /**
     * 中序迭代遍历
     * <p>
     * 找到俩个错误节点，然后交换
     *
     * @param root
     */
    public void recoverTree1(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque();
        TreeNode x = null, y = null, pred = null;

        while (!stack.isEmpty() || root != null) {
            // 一直向左
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            // 取出当前元素
            root = stack.removeLast();
            // 与上一个元素对比，若小于前置节点，则说明该节点有问题
            if (pred != null && root.val < pred.val) {
                y = root;
                if (x == null) {
                    // 将元素放入
                    x = pred;
                } else {
                    // 若找到第二个元素则说明已经找到
                    break;
                }
            }
            pred = root;
            root = root.right;
        }
        // 交换值
        swap(x, y);

    }

    public void swap(TreeNode a, TreeNode b) {
        int tmp = a.val;
        a.val = b.val;
        b.val = tmp;
    }


    /**
     * 递归遍历
     * <p>
     * 找到俩个错误节点，然后交换
     *
     * @param root
     */
    public void recoverTree2(TreeNode root) {
        findTwoSwapped1(root);
        swap(x, y);
    }

    public void findTwoSwapped1(TreeNode root) {
        if (root == null) {
            return;
        }
        findTwoSwapped1(root.left);
        if (pred != null && root.val < pred.val) {
            y = root;
            if (x == null) {
                x = pred;
            } else {
                return;
            }
        }
        pred = root;
        findTwoSwapped1(root.right);
    }





}
