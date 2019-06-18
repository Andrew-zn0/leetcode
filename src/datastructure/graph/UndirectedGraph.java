package datastructure.graph;

import datastructure.linked.Iterator;
import datastructure.linked.Node;

/**
 * @author Jay
 * @date 2019/6/16 22:01
 * @description 无向图
 */
public class UndirectedGraph extends AbstractGraph {
    @Override
    public int getType() {
        return 0;
    }

    @Override
    public int getVexNum() {
        return 0;
    }

    @Override
    public int getEdgeNum() {
        return 0;
    }

    @Override
    public Iterator getVertex() {
        return null;
    }

    @Override
    public void remove(Vertex v) {

    }

    @Override
    public void remove(Edge e) {

    }

    @Override
    public Node insert(Vertex v) {
        return null;
    }

    @Override
    public Node insert(Edge e) {
        return null;
    }

    @Override
    public boolean areAdjacent(Vertex u, Vertex v) {
        return false;
    }

    /**
     * 返回从顶点 u 到顶点 v 的边，如果不存在返回空
     *
     * @param u
     * @param v
     * @return
     */
    @Override
    public Edge edgeFromTo(Vertex u, Vertex v) {
        return null;
    }

    @Override
    public Iterator DFSTraverse(Vertex v) {
        return null;
    }

    @Override
    public Iterator BFSTraverse(Vertex v) {
        return null;
    }

    @Override
    public Iterator shortestPath(Vertex v) {
        return null;
    }

    /**
     * Prim 算法
     * 输入：无向连通带权图
     * 输出：构造最小生成树
     *
     * @throws UnsupportedOperation
     */
    @Override
    public void generateMST() throws UnsupportedOperation {
        // 重置图中各顶点的信息
        resetVexStatus();
        //重置图中各边的类型信息
        resetEdgeType();
        Iterator it = getVertex();
        // 选择第一个作为顶点
        Vertex v = (Vertex) it.currentItem();
        // 顶点v进入顶点s
        v.setToVisited();
        // 初始化顶点集合 S 到 V-S 各顶点的最短横切边
        for (it.first(); !it.isDone(); it.next()) {
            Vertex u = (Vertex) it.currentItem();

            Edge e = edgeFromTo(v, u);
            // 设置到达 V-S 中顶点 u 的最短横切边
            setCrossEdge(u, e);

        }
        // 进行|V|-1 次循环找到|V|-1 条边
        for (int t = 1; t < getVexNum(); t++) {
            // 选择轻边在 V-S 中的顶点 k
            Vertex k = selectMinVertex(it);
            // 顶点 k 加入 S
            k.setToVisited();
            // 割(S , V - S) 的轻边
            Edge mst = getCrossEdge(k);
            if (mst != null) {
                mst.setToMST();
            }
            //以 k 为中间顶点修改 S 到 V-S 中顶点的最短横切边
            // 取出 k 的所有邻接点
            Iterator adjIt = adjVertexs(k);
            for (adjIt.first(); !adjIt.isDone(); adjIt.next()) {
                Vertex adjV = (Vertex) adjIt.currentItem();
                Edge e = edgeFromTo(k, adjV);
                //发现到达 adjV 更短的横切边
                if (e.getWeight() < getCrossWeight(adjV)) {
                    setCrossEdge(adjV, e);
                }
            }
        }


    }

    private int getCrossWeight(Vertex v) {

        if (getCrossEdge(v) != null) {
            return getCrossEdge(v).getWeight();
        } else {
            return Integer.MAX_VALUE;
        }
    }

    /**
     *  查找轻边在 V-S 中的顶点
     */
    private Vertex selectMinVertex(Iterator it) {

        Vertex min = null;
        for (it.first(); !it.isDone(); it.next()) {
            Vertex v = (Vertex) it.currentItem();
            if (!v.isVisited()) {
                min = v;
                break;
            }
        }
        for (; !it.isDone(); it.next()) {
            Vertex v = (Vertex) it.currentItem();
            if (!v.isVisited() && getCrossWeight(v) < getCrossWeight(min)) {
                min = v;
            }
        }
        return min;
    }

    private Edge getCrossEdge(Vertex v) {
        return (Edge) v.getAppObj();
    }

    private void setCrossEdge(Vertex v, Edge e) {

        v.setAppObj(e);

    }

    @Override
    public Iterator toplogicalSort() throws UnsupportedOperation {
        return null;
    }

    @Override
    public void criticalPath() throws UnsupportedOperation {

    }


}
