package datastructure.linked;

/**
 * @author Jay
 * @description 参数节点不合法
 * @date Created in 2019/5/23 15:52
 */
public class InvalidNodeException extends RuntimeException {
    public InvalidNodeException(String err) {
        super(err);
    }
}
