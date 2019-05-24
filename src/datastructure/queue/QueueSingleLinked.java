package datastructure.queue;

import datastructure.linked.SingleNode;

/**
 * @author Jay
 * @description
 * @date Created in 2019/5/24 14:39
 */
public class QueueSingleLinked implements Queue {
    private SingleNode front;
    private SingleNode rear;
    private int size;

    public QueueSingleLinked() {
        front = new SingleNode();
        rear = front;
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
    public void enqueue(Object e) {
        SingleNode node = new SingleNode(e, null);
        rear.setNext(node);
        rear = node;
        size++;
    }

    @Override
    public Object dequeue() throws QueueEmptyException {
        if (size < 1) {
            throw new QueueEmptyException("错误,队列为空");
        }
        SingleNode node = front.getNext();
        front.setNext(node.getNext());
        size--;
        //如果队列为空,rear 指向头结点
        if (size < 1) {
            rear = front;
        }
        return node.getData();
    }

    @Override
    public Object peek() throws QueueEmptyException {
        if (size < 1) {
            throw new QueueEmptyException("错误,队列为空");
        }
        return front.getNext().getData();
    }
}
