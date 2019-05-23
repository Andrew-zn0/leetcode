package datastructure.linked;

/**
 * @author Jay
 * @description 迭代器接口
 * @date Created in 2019/5/23 19:52
 */
public interface Iterator {

    /**
     * 移动到第一个元素
     */
    void first();

    /**
     * 移动到下一个元素
     */
    void next();

    /**
     * 检查迭代器是否还有剩余元素
     *
     * @return
     */
    boolean isDone();

    /**
     * 返回当前元素
     *
     * @return
     */
    Object currentItem();
}
