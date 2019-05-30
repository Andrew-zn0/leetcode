package datastructure.stack;

import datastructure.linked.SingleNode;

/**
 * @author Jay
 * @description 栈的链表实现方式
 * @date Created in 2019/5/24 10:44
 */
public class StackSingleLinked implements Stack {
    /**
     * 链表首节点引用
     */
    private SingleNode top;
    /**
     * 栈的大小
     */
    private int size;

    public StackSingleLinked() {
        top = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void push(Object e) {
        SingleNode node = new SingleNode(e, top);
        top = node;
        size++;
    }

    @Override
    public Object pop() throws StackEmptyException {
        if (getSize() < 1) {
            throw new StackEmptyException("错误，堆栈为空。");
        }
        Object obj = top.getData();
        top = top.getNext();
        size--;
        return obj;
    }

    @Override
    public Object peek() throws StackEmptyException {
        if (getSize() < 1) {
            throw new StackEmptyException("错误，堆栈为空。");
        }

        return top.getData();
    }
}
