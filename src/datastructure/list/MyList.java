package datastructure.list;

/**
 * @author Jay
 * @description list接口
 * @date Created in 2019/5/23 14:27
 */
public interface MyList {
    /**
     * 返回线性表的大小，即数据元素的个数。
     *
     * @return
     */
    int getSize();

    /**
     * 如果线性表为空返回 true，否则返回 false。
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 判断线性表是否包含数据元素 e
     *
     * @param e
     * @return
     */
    boolean contains(Object e);

    /**
     * 返回数据元素 e 在线性表中的序号
     *
     * @param e
     * @return
     */
    int indexOf(Object e);

    /**
     * 将数据元素 e 插入到线性表中 i 号位置
     *
     * @param i
     * @param e
     * @throws OutOfBoundaryException
     */
    void insert(int i, Object e) throws OutOfBoundaryException;

    /**
     * 将数据元素 e 插入到元素 obj 之前
     *
     * @param obj
     * @param e
     * @return
     */
    boolean insertBefore(Object obj, Object e);


    /**
     * 将数据元素 e 插入到元素 obj 之后
     *
     * @param obj
     * @param e
     * @return
     */
    boolean insertAfter(Object obj, Object e);

    /**
     * 删除线性表中序号为 i 的元素,并返回之
     *
     * @param i
     * @return
     * @throws OutOfBoundaryException
     */
    Object remove(int i) throws OutOfBoundaryException;

    /**
     * 删除线性表中第一个与 e 相同的元素
     *
     * @param e
     * @return
     */
    boolean remove(Object e);

    /**
     * 替换线性表中序号为 i 的数据元素为 e，返回原数据元素
     *
     * @param i
     * @param e
     * @return
     * @throws OutOfBoundaryException
     */
    Object replace(int i, Object e) throws OutOfBoundaryException;

    /**
     * 返回线性表中序号为 i 的数据元素
     *
     * @param i
     * @return
     * @throws OutOfBoundaryException
     */
    Object get(int i) throws OutOfBoundaryException;
}
