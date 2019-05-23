package datastructure.list;


/**
 * @author Jay
 * @description 线性表的数组实现
 * @date Created in 2019/5/23 14:39
 */
public class MyArrayList implements MyList {
    /**
     * 数组的默认大小
     */
    private final int LEN = 8;
    /**
     * 数据元素的比较策略
     */
    private Strategy strategy;
    /**
     * 线性表的中数据元素的个数
     */
    private int size;
    /**
     * 数据元素数组
     */
    private Object[] elements;


    /**
     * 构造方法
     */
    public MyArrayList() {
        size = 0;
        elements = new Object[LEN];
    }

    public MyArrayList(Strategy strategy) {
        this.strategy = strategy;
        size = 0;
        elements = new Object[LEN];
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
        for (int i = 0; i < size; i++) {
            if (strategy.equal(elements[i], e)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < size; i++) {
            if (strategy.equal(elements[i], e)) {
                return i;
            }
        }
        // 不存在返回-1
        return -1;
    }

    @Override
    public void insert(int i, Object e) throws OutOfBoundaryException {

        if (i < 0 || i > size) {
            throw new OutOfBoundaryException("插入序号越界");
        }
        if (size >= elements.length) {
            expandSpace();
        }
        for (int j = size; j > i; j--) {
            elements[j] = elements[j - 1];
        }
        elements[i] = e;
        size++;
    }

    private void expandSpace() {

        Object[] a = new Object[elements.length * 2];
        for (int i = 0; i < elements.length; i++) {
            a[i] = elements[i];
        }
        elements = a;
    }

    @Override
    public boolean insertBefore(Object obj, Object e) {
        int i = indexOf(obj);
        if (i < 0) {
            return false;
        }
        insert(i, e);
        return true;
    }

    @Override
    public boolean insertAfter(Object obj, Object e) {
        int i = indexOf(obj);
        if (i < 0) {
            return false;
        }
        insert(i + 1, e);
        return true;
    }

    @Override
    public Object remove(int i) throws OutOfBoundaryException {
        if (i < 0 || i > size) {
            throw new OutOfBoundaryException("插入序号越界");
        }
        Object obj = elements[i];
        for (int j = i; j < size - 1; j--) {
            elements[j] = elements[j - 1];
        }
        elements[--size] = null;
        return obj;
    }

    @Override
    public boolean remove(Object e) {
        int i = indexOf(e);
        if (i < 0) {
            return false;
        }
        remove(i);
        return false;
    }

    @Override
    public Object replace(int i, Object e) throws OutOfBoundaryException {
        if (i < 0 || i > size) {
            throw new OutOfBoundaryException("插入序号越界");
        }
        Object obj = elements[i];
        elements[i] = e;
        return obj;
    }

    @Override
    public Object get(int i) throws OutOfBoundaryException {
        if (i < 0 || i > size) {
            throw new OutOfBoundaryException("插入序号越界");
        }
        return elements[i];
    }
}
