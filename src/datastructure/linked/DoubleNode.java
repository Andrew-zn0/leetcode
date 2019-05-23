package datastructure.linked;

/**
 * @author Jay
 * @description 双向链表
 * @date Created in 2019/5/23 15:52
 */
public class DoubleNode implements Node {
    private Object element;
    private DoubleNode pre;
    private DoubleNode next;

    public DoubleNode() {
        this(null, null, null);
    }

    public DoubleNode(Object ele, DoubleNode pre, DoubleNode next) {
        this.element = ele;
        this.pre = pre;
        this.next = next;
    }

    public DoubleNode getNext() {
        return next;
    }

    public void setNext(DoubleNode next) {
        this.next = next;
    }

    public DoubleNode getPre() {
        return pre;
    }

    public void setPre(DoubleNode pre) {
        this.pre = pre;
    }

    @Override
    public Object getData() {
        return element;
    }

    @Override
    public void setData(Object data) {
        element = data;
    }
}
