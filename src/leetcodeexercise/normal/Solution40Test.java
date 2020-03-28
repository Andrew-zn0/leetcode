package leetcodeexercise.normal;

import org.junit.Test;

import java.util.*;

/**
 * @author Jay
 * @description 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用一次。
 * @date Created in 2020/3/23 1:42 下午
 */
public class Solution40Test {
    @Test
    public void test() {

        int[] arr = {10, 1, 2, 7, 6, 1, 5};

        System.out.println(combinationSum2(arr, 8));

    }

    /**
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> list = new ArrayList<>();

        int length = candidates.length;

        Arrays.sort(candidates);
        select(candidates, target, 0, length, new ArrayDeque<>(), list);
        return list;

    }

    private void select(int[] candidates, int target, int begin, int length, Deque<Integer> path,
                        List<List<Integer>> list) {

        if (target == 0) {
            list.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < length; i++) {


            if (target - candidates[i] < 0) {
                break;
            }

            // 发现有与前边分支相同元素则减枝
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }
            path.addLast(candidates[i]);

            select(candidates, target - candidates[i], i + 1, length, path, list);

            // path全局只用一份，所以等某个递归结束，需要把之前元素移除。
            path.removeLast();
        }
    }
}
