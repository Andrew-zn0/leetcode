package datastructure.graph;

/**
 * @author Jay
 * @description 图的接口定义
 * @date Created in 2019/6/5 17:27
 */
public interface Graph {
    /**
     * 无向图
     */
    int UNDIRECTED_GRAPH = 0;
    /**
     *  有向图
     */
    int DIRECTED_GRAPH = 1;

    /**
     * 返回图的类型
     *
     * @return
     */
    int getType();

    /**
     * 返回图的顶点数
     *
     * @return
     */
    int getVexNum();

    /**
     * 返回图的边数
     *
     * @return
     */
    int getEdgeNum();
}
