package datastructure.graph;

/**
 * @author Jay
 * @description 调用图不支持的操作时抛出的异常
 * @date Created in 2019/6/6 10:46
 */
public class UnsupportedOperation extends RuntimeException {
    public UnsupportedOperation(String err) {
        super(err);
    }
}
