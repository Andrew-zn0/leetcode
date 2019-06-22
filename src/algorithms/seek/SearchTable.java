package algorithms.seek;


import datastructure.linked.Iterator;
import datastructure.linked.Node;

/**
 * @author Jay
 * @description 查找表接口
 * @date Created in 2019/6/22 14:13
 */
public interface SearchTable {

    /**
     * 查询表当前规模
     *
     * @return int
     */
    int getSize();

    /**
     * 判断查找表是否为空
     *
     * @return boolean
     */
    boolean isEmpty();

    /**
     * 返回查找表中与元素 ele 关键字相同的元素位置；否则，返回 null
     *
     * @param ele
     * @return Node
     */
    Node search(Object ele);

    /**
     * 返回所有关键字与元素 ele 相同的元素位置
     *
     * @param ele
     * @return Iterator
     */
    Iterator searchAll(Object ele);

    /**
     * 按关键字插入元素 ele
     *
     * @param ele
     */
    void insert(Object ele);

    /**
     * 若查找表中存在与元素 ele 关键字相同元素，则删除一个并返回；否则，返回 null
     *
     * @param ele
     * @return Object
     */
    Object remove(Object ele);

}
