package datastructure.graph;

import com.sun.javafx.geom.Edge;
import datastructure.linked.Iterator;
import datastructure.linked.Node;
import sun.security.provider.certpath.Vertex;


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

    /**
     * 返回图所有的顶点
     *
     * @return
     */
    Iterator getVertex();

    /**
     * 删除一个顶点
     *
     * @param v
     */
    void remove(Vertex v);

    /**
     * 删除一条边
     *
     * @param e
     */
    void remove(Edge e);

    /**
     * 添加一个顶点
     *
     * @param v
     * @return
     */
    Node insert(Vertex v);

    /**
     * 添加一条边
     *
     * @param e
     * @return
     */
    Node insert(Edge e);

    /**
     * 判断顶点 u、v 是否邻接，即是否有边从 u 到 v
     *
     * @param u
     * @param v
     * @return
     */
    boolean areAdjacent(Vertex u, Vertex v);

    /**
     * 返回从 u 出发可以直接到达的邻接顶点
     *
     * @param u
     * @param v
     * @return
     */
    Edge edgeFromTo(Vertex u, Vertex v);

    /**
     * 对图进行深度优先遍历
     *
     * @param v
     * @return
     */
    Iterator DFSTraverse(Vertex v);

    /**
     * 对图进行广度优先遍历
     *
     * @param v
     * @return
     */
    Iterator BFSTraverse(Vertex v);

    /**
     * 求顶点v到其他顶点的最短路径
     *
     * @param v
     * @return
     */
    Iterator shortestPath(Vertex v);

    /**
     * 求无向图的最小生成树,如果是有向图不支持此操作
     *
     * @throws UnsupportedOperation
     */
    void generateMST() throws UnsupportedOperation;


    /**
     * 求有向图的拓扑序列,无向图不支持此操作
     *
     * @return
     * @throws UnsupportedOperation
     */
    Iterator toplogicalSort() throws UnsupportedOperation;


    /**
     * 求有向无环图的关键路径,无向图不支持此操作
     *
     * @throws UnsupportedOperation
     */
    void criticalPath() throws UnsupportedOperation;

}
