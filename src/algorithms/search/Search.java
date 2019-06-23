package algorithms.search;

import datastructure.linked.Node;
import datastructure.list.Strategy;
import datastructure.tree.BinTreeNode;

/**
 * @author Jay
 * @description 查找方法
 * @date Created in 2019/6/22 14:30
 */
public class Search {


    /**
     * 折半查找
     * 适用于有序表
     *
     * @param s
     * @param low
     * @param high
     * @param key
     * @return
     */
    public int binSearch(int[] s, int low, int high, int key) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (s[mid] == key) {
                return mid;
            } else if (s[mid] > key) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
