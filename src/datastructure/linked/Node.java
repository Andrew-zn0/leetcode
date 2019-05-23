package datastructure.linked;

/**
 * @author Jay
 * @description 节点接口
 * @date Created in 2019/5/23 15:40
 */
public interface Node {
    /**
     * 获取节点的数据域
     *
     * @return
     */
    Object getData();

    /**
     * 设置节点的数据域
     *
     * @param data
     */
    void setData(Object data);
}
