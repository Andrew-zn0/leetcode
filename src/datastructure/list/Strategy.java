package datastructure.list;

/**
 * @author Jay
 * @description 比较大小的策略
 * @date Created in 2019/5/23 14:39
 */
public interface Strategy {
    /**
     * 判断两个数据元素是否相等
     *
     * @param obj1
     * @param obj2
     * @return
     */
    boolean equal(Object obj1, Object obj2);

    /**

     */
    /**
     * 比较两个数据元素的大小
     * 如果 obj1 < obj2 返回-1
     * 如果 obj1 = obj2 返回 0
     * 如果 obj1 > obj2 返回 1
     *
     * @param obj1
     * @param obj2
     * @return
     */
    int compare(Object obj1, Object obj2);
}
