package datastructure.queue;

/**
 * @author Jay
 * @description
 * @date Created in 2019/5/24 11:37
 */
public class QueueArray implements Queue {
    /**
     * 队列默认大小
     */
    private static final int CAP = 7;
    /**
     * 数据元素数组
     */
    private Object[] elements;

    /**
     * 数组的大小 elements.length
     */
    private int capacity;

    /**
     * 队首指针,指向队首
     */
    private int front;

    /**
     * 队尾指针,指向队尾后一个位置
     */
    private int rear;

    public QueueArray() {
        this(CAP);
    }

    public QueueArray(int cap) {
        capacity = cap + 1;
        elements = new Object[capacity];
        front = rear = 0;
    }

    @Override
    public int getSize() {
        //模运算保证队列长度
        return (rear - front + capacity) % capacity;
    }

    @Override
    public boolean isEmpty() {
        return rear == front;
    }

    @Override
    public void enqueue(Object e) {

        if (getSize() == capacity - 1) {
            expandSpace();
        }
        elements[rear] = e;
        rear = (rear + 1) % capacity;

    }

    private void expandSpace() {
        Object[] a = new Object[elements.length * 2];
        int i = front;
        int j = 0;
        while (i != rear) {
            a[j++] = elements[i];
            i = (i + 1) % capacity;
        }
    }

    @Override
    public Object dequeue() throws QueueEmptyException {
        if (isEmpty()) {
            throw new QueueEmptyException("错误,队列为空");
        }
        Object obj = elements[front];
        front = (front + 1) % capacity;
        elements[front] = null;
        return obj;
    }

    @Override
    public Object peek() throws QueueEmptyException {
        if (isEmpty()) {
            throw new QueueEmptyException("错误,队列为空");
        }
        return elements[front];
    }
}
