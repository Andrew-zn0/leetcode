package datastructure.linked;

import datastructure.list.OutOfBoundaryException;

/**
 * @author Jay
 * @description 链表接口
 * @date Created in 2019/5/23 19:01
 */
public interface LinkedList {
    /**
     * 查询当前链表的规模
     *
     * @return
     */
    int getSize();

    /**
     * 判断列表是否为空
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 返回第一个节点
     *
     * @return
     * @throws OutOfBoundaryException
     */
    Node first() throws OutOfBoundaryException;

    /**
     * 返回最后一个节点
     *
     * @return
     * @throws OutOfBoundaryException
     */
    Node last() throws OutOfBoundaryException;

    /**
     * 返回p之后的节点
     *
     * @param p
     * @return
     * @throws InvalidNodeException
     * @throws OutOfBoundaryException
     */
    Node getNext(Node p) throws InvalidNodeException, OutOfBoundaryException;

    /**
     * 返回p之前的节点
     *
     * @param p
     * @return
     * @throws InvalidNodeException
     * @throws OutOfBoundaryException
     */
    Node getPre(Node p) throws InvalidNodeException, OutOfBoundaryException;

    /**
     * 将 e 作为第一个元素插入链接表,并返回 e 所在结点
     *
     * @param e
     * @return
     */
    Node insertFirst(Object e);

    /**
     * 作为最后一个元素插入列表,并返回 e 所在结点
     *
     * @param e
     * @return
     */
    Node insertLast(Object e);

    /**
     * 将 e 插入至 p 之后的位置,并返回 e 所在结点
     *
     * @param p
     * @param e
     * @return
     * @throws InvalidNodeException
     */
    Node insertAfter(Node p, Object e) throws InvalidNodeException;

    /**
     * 将 e 插入至 p 之前的位置,并返回 e 所在结点
     *
     * @param p
     * @param e
     * @return
     * @throws InvalidNodeException
     */
    Node insertBefore(Node p, Object e) throws InvalidNodeException;

    /**
     * 删除给定位置处的元素，并返回之
     *
     * @param p
     * @return
     * @throws InvalidNodeException
     */
    Object remove(Node p) throws InvalidNodeException;

    /**
     * 删除首元素，并返回之
     *
     * @return
     * @throws OutOfBoundaryException
     */
    Object removeFirst() throws OutOfBoundaryException;

    /**
     * 删除末元素，并返回之
     *
     * @return
     * @throws OutOfBoundaryException
     */
    Object removeLast() throws OutOfBoundaryException;

    /**
     * 将处于给定位置的元素替换为新元素，并返回被替换的元素
     *
     * @param p
     * @param e
     * @return
     * @throws InvalidNodeException
     */
    Object replace(Node p, Object e) throws InvalidNodeException;

    /**
     * 迭代器
     *
     * @return
     */
    Iterator elements();
}
