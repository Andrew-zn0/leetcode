package datastructure.linked;

import datastructure.list.OutOfBoundaryException;


/**
 * @author Jay
 * @description 基于双链表的链接表实现
 * @date Created in 2019/5/23 19:16
 */
public class MyDoubleNodeLinkedList implements LinkedList {
    /**
     * 链表规模
     */
    private int size;
    /**
     * 头节点
     */
    private DoubleNode head;
    /**
     * 尾节点
     */
    private DoubleNode tail;

    public MyDoubleNodeLinkedList() {
        size = 0;
        //构建只有头尾结点的链表
        head = new DoubleNode();
        tail = new DoubleNode();
        head.setNext(tail);
        tail.setPre(head);
    }

    /**
     * 判断p是否合法,如合法则替换为DoubleNode
     *
     * @param p
     * @return
     * @throws InvalidNodeException
     */
    protected DoubleNode checkPosition(Node p) throws InvalidNodeException {
        if (p == null) {
            throw new InvalidNodeException("错误：p 为空。");
        }
        if (p == head) {
            throw new InvalidNodeException("错误：p 指向头节点，非法。");
        }
        if (p == tail) {
            throw new InvalidNodeException("错误：p 指向尾结点，非法。");
        }
        DoubleNode doubleNode = (DoubleNode) p;
        return doubleNode;

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
    public Node first() throws OutOfBoundaryException {
        if (isEmpty()) {
            throw new OutOfBoundaryException("错误：链接表为空。");
        }
        return head.getNext();
    }

    @Override
    public Node last() throws OutOfBoundaryException {

        if (isEmpty()) {
            throw new OutOfBoundaryException("错误：链接表为空。");
        }

        return tail.getPre();
    }

    @Override
    public Node getNext(Node p) throws InvalidNodeException, OutOfBoundaryException {

        DoubleNode node = checkPosition(p);
        node = node.getNext();

        if (node == tail) {
            throw new OutOfBoundaryException("错误：已经是链接表尾端。");
        }
        return node;
    }

    @Override
    public Node getPre(Node p) throws InvalidNodeException, OutOfBoundaryException {

        DoubleNode node = checkPosition(p);
        node = node.getPre();
        if (node == head) {
            throw new OutOfBoundaryException("错误：是链接表头部。");
        }

        return node;
    }

    @Override
    public Node insertFirst(Object e) {
        DoubleNode node = new DoubleNode(e, head, head.getNext());
        head.getNext().setPre(node);
        head.setNext(node);
        size++;
        return node;
    }

    @Override
    public Node insertLast(Object e) {
        DoubleNode node = new DoubleNode(e, tail.getPre(), tail);
        tail.getPre().setNext(node);
        tail.setPre(node);
        size++;
        return node;
    }

    @Override
    public Node insertAfter(Node p, Object e) throws InvalidNodeException {
        DoubleNode node = checkPosition(p);
        DoubleNode doubleNode = new DoubleNode(e, node, node.getNext());
        node.getNext().setPre(doubleNode);
        node.setNext(doubleNode);
        size++;
        return doubleNode;
    }

    @Override
    public Node insertBefore(Node p, Object e) throws InvalidNodeException {
        DoubleNode node = checkPosition(p);
        DoubleNode doubleNode = new DoubleNode(e, node.getPre(), node);
        node.getPre().setNext(doubleNode);
        node.setPre(doubleNode);
        size++;
        return doubleNode;
    }

    @Override
    public Object remove(Node p) throws InvalidNodeException {
        DoubleNode node = checkPosition(p);
        node.getPre().setNext(node.getNext());
        node.getNext().setPre(node.getPre());
        size--;
        return node.getData();
    }

    @Override
    public Object removeFirst() throws OutOfBoundaryException {
        return remove(head.getNext());
    }

    @Override
    public Object removeLast() throws OutOfBoundaryException {
        return remove(tail.getPre());
    }

    @Override
    public Object replace(Node p, Object e) throws InvalidNodeException {
        DoubleNode node = checkPosition(p);
        Object data = node.getData();
        node.setData(e);
        return data;
    }

    @Override
    public Iterator elements() {
        return new LinkedListIterator(this);
    }
}
