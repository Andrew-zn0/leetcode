package datastructure.linked;

import datastructure.list.OutOfBoundaryException;

/**
 * @author Jay
 * @descriptionr 基于LinkedList聚集对象的迭代器实现
 * @date Created in 2019/5/23 20:05
 */
public class LinkedListIterator implements Iterator {
    /**
     * 链接表
     */
    private LinkedList list;
    /**
     * 当前结点
     */
    private Node current;

    /**
     * 构造方法
     *
     * @param list
     */
    public LinkedListIterator(LinkedList list) {
        this.list = list;
        //若列表为空
        if (list.isEmpty()) {
            current = null;
        } //则当前元素置空
        else {
            current = list.first();
        }//否则从第一个元素开始
    }

    @Override
    public void first() {
        //若列表为空
        if (list.isEmpty()) {
            current = null;
        } //则当前元素置空
        else {
            current = list.first();
        }//否则从第一个元素开始
    }

    @Override
    public void next() {
        if (isDone()) {
            throw new OutOfBoundaryException("错误：已经没有元素。");
        }
        if (current == list.last()) {
            current = null;
        } //当前元素后面没有更多元素
        else {
            current = list.getNext(current);
        }
    }

    @Override
    public boolean isDone() {
        return current == null;

    }

    @Override
    public Object currentItem() {
        if (isDone()) {
            throw new OutOfBoundaryException("错误：已经没有元素。");
        }
        return current.getData();
    }
}
