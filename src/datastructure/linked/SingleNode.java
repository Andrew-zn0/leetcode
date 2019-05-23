package datastructure.linked;

/**
 * @author Jay
 * @description 单链表
 * @date Created in 2019/5/23 15:43
 */
public class SingleNode implements Node {

    private Object element;
    private SingleNode next;

    public SingleNode() {
        this(null, null);
    }

    public SingleNode(Object ele, SingleNode next) {
        this.element = ele;
        this.next = next;
    }

    public SingleNode getNext() {
        return next;
    }

    public void setNext(SingleNode next) {
        this.next = next;
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
