package leetcodeexercise.normal;

import org.junit.Test;

import java.util.*;

/**
 * @author Jay
 * @description 给定一个无重复元素的数组 candidates 和一个目标数 target ，
 * 找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 * @date Created in 2020/3/22 1:50 下午
 */
public class Solution39Test {
    @Test
    public void test() {

        int[] arr = {2, 3, 6, 7};

        System.out.println(combinationSum(arr, 7));

    }

    /**
     * 递归回溯
     * <p>
     * 根节点为目标值，每个子节点开始减，直到小于0，开始剪枝。
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();
        int len = candidates.length;

        // 排序是为了提前终止搜索，即若是小数不满足，则后边更大的数也不满足
        Arrays.sort(candidates);

        dfs(candidates, len, target, 0, new ArrayDeque<>(), res);
        return res;


    }

    private void dfs(int[] candidates,
                     int len,
                     int residue,
                     int begin,
                     Deque<Integer> path,
                     List<List<Integer>> res) {
        if (residue == 0) {
            // 由于 path 全局只使用一份，到叶子结点的时候需要做一个拷贝
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < len; i++) {

            // 在数组有序的前提下，剪枝
            if (residue - candidates[i] < 0) {
                break;
            }

            path.addLast(candidates[i]);

            // begin 是为了去重，不会搜索比自己小的元素，把当前节点传入下级，作为开始节点
            dfs(candidates, len, residue - candidates[i], i, path, res);

            // path
            path.removeLast();

        }
    }

}
