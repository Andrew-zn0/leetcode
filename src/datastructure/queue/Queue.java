package datastructure.queue;

/**
 * @author Jay
 * @description 队列接口
 * @date Created in 2019/5/24 11:06
 */
public interface Queue {
    /**
     * 返回队列大小
     *
     * @return
     */
    int getSize();

    /**
     * 判断队列是否为空
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 数据元素入队
     *
     * @param e
     */
    void enqueue(Object e);

    /**
     * 队首元素出队
     *
     * @return
     * @throws QueueEmptyException
     */
    Object dequeue() throws QueueEmptyException;


    /**
     * 取队首元素
     *
     * @return
     * @throws QueueEmptyException
     */
    Object peek() throws QueueEmptyException;

}
