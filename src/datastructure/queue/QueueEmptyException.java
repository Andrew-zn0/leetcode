package datastructure.queue;

/**
 * @author Jay
 * @description
 * @date Created in 2019/5/24 11:10
 */
public class QueueEmptyException extends RuntimeException {
    public QueueEmptyException(String err) {
        super(err);
    }
}
