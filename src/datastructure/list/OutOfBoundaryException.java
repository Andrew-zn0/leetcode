package datastructure.list;

/**
 * @author Jay
 * @description 异常类
 * @date Created in 2019/5/23 14:27
 */
public class OutOfBoundaryException extends RuntimeException {
    public OutOfBoundaryException(String err) {
        super(err);
    }
}
