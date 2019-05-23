package datastructure.list;


import datastructure.linked.SingleNode;

/**
 * @author Jay
 * @description 基于单链表的线性表实现
 * @date Created in 2019/5/23 15:55
 */
public class MySingleNodeList implements MyList {
    /**
     * 数据元素比较策略
     */
    private Strategy strategy;
    /**
     * 单链表首结点引用
     */
    private SingleNode head;
    private int size;

    public MySingleNodeList() {
        head = new SingleNode();
        size = 0;
    }

    public MySingleNodeList(Strategy strategy) {
        this.strategy = strategy;
        head = new SingleNode();
        size = 0;
    }

    /**
     * 获取数据元素 e 所在结点的前驱结点
     *
     * @param e
     * @return
     */
    private SingleNode getPreNode(Object e) {
        SingleNode p = head;
        while (p != null) {
            if (strategy.equal(p.getNext().getData(), e)) {
                return p;
            } else {
                p = p.getNext();
            }
        }
        return null;
    }

    /**
     * 获取序号为 0<=i<size 的元素所在结点的前驱结点
     *
     * @param i
     * @return
     */
    private SingleNode getPreNode(int i) {
        SingleNode p = head;
        for (; i > 0; i--) {
            p = p.getNext();
        }
        return p;
    }

    /**
     * 获取序号为 0<=i<size 的元素所在结点
     *
     * @param i
     * @return
     */
    private SingleNode getNode(int i) {
        SingleNode p = head.getNext();
        for (; i > 0; i--) {
            p = p.getNext();
        }
        return p;
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
    public boolean contains(Object e) {
        SingleNode p = head.getNext();
        while (p != null) {
            if (strategy.equal(p.getData(), e)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(Object e) {
        SingleNode p = head.getNext();
        int index = 0;
        while (p != null) {
            if (strategy.equal(p.getData(), e)) {
                index++;
            }
        }
        return index;
    }


    @Override
    public void insert(int i, Object e) throws OutOfBoundaryException {
        if (i < 0 || i > size) {
            throw new OutOfBoundaryException("插入序列越界");
        }
        SingleNode p = getPreNode(i);
        SingleNode singleNode = new SingleNode(e, p.getNext());
        p.setNext(singleNode);
        size++;
    }

    @Override
    public boolean insertBefore(Object obj, Object e) {
        SingleNode p = getPreNode(obj);
        if (p != null) {
            SingleNode singleNode = new SingleNode(e, p.getNext());
            p.setNext(singleNode);
            size++;
            return true;
        }
        return false;
    }

    @Override
    public boolean insertAfter(Object obj, Object e) {
        SingleNode p = head.getNext();
        while (p != null) {
            if (strategy.equal(p.getNext(), e)) {
                SingleNode singleNode = new SingleNode(e, p.getNext());
                p.setNext(singleNode);
                size++;
                return true;
            }
        }
        return false;
    }


    @Override
    public Object remove(int i) throws OutOfBoundaryException {
        if (i < 0 || i > size) {
            throw new OutOfBoundaryException("删除序列越界");
        }
        SingleNode p = getPreNode(i);
        p.setNext(p.getNext().getNext());
        return p.getNext();
    }

    @Override
    public boolean remove(Object e) {

        SingleNode preNode = getPreNode(e);
        if (preNode != null) {
            preNode.setNext(preNode.getNext().getNext());
            return true;
        }

        return false;
    }

    @Override
    public Object replace(int i, Object e) throws OutOfBoundaryException {
        if (i < 0 || i > size) {
            throw new OutOfBoundaryException("删除序列越界");
        }
        SingleNode preNode = getPreNode(i);
        preNode.setData(e);
        return preNode.getData();
    }

    @Override
    public Object get(int i) throws OutOfBoundaryException {
        if (i < 0 || i > size) {
            throw new OutOfBoundaryException("删除序列越界");
        }
        return getNode(i).getData();
    }
}
