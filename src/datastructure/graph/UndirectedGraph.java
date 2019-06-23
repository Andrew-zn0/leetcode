package datastructure.graph;

import datastructure.linked.Iterator;
import datastructure.linked.LinkedList;
import datastructure.linked.MyDoubleNodeLinkedList;
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

    /**
     * 取或设置顶点 v 的当前最短距离
     *
     * @param v
     * @return
     */
    protected int getDistance(Vertex v) {
        return ((Path) v.getAppObj()).getDistance();
    }

    protected void setDistance(Vertex v, int dis) {
        ((Path) v.getAppObj()).setDistance(dis);
    }

    /**
     * 取或设置顶点 v 的当前最短路径
     *
     * @param v
     * @return
     */
    protected Path getPath(Vertex v) {
        return (Path) v.getAppObj();
    }

    protected void setPath(Vertex v, Path p) {
        v.setAppObj(p);
    }

    /**
     * Dijkstra 算法
     * 有权图的单源最短路径
     * 输入：顶点 v
     * 输出：v 到其他顶点的最短路径
     * 到其他顶点的最短路径包括到各顶点的最短距离
     * <p>
     * Floyd
     * 任意顶点间的最短路径
     *
     * @param v
     * @return
     */
    @Override
    public Iterator shortestPath(Vertex v) {
        // 所有的最短路径序列
        LinkedList sPath = new MyDoubleNodeLinkedList();
        // 重置图中所有顶点的信息
        resetVexStatus();
        // 初始化，将 v 到各顶点的最短距离初始化为由 v 直接可达的距离
        Iterator it = getVertex();
        for (it.first(); !it.isDone(); it.next()) {
            Vertex u = (Vertex) it.currentItem();
            int weight = Integer.MAX_VALUE;
            Edge e = edgeFromTo(v, u);
            if (e != null) {
                weight = e.getWeight();
            }
            if (u == v) {
                weight = 0;
            }
            Path p = new Path(weight, v, u);
            setPath(u, p);
        }
        // 顶点 v 进入集合 S
        v.setToVisited();
        // 求得顶点V的最短路径进入链接表
        sPath.insertLast(getPath(v));
        // 进行|V|-1 次循环找到|V|-1 条最短路径
        for (int t = 1; t < getVexNum(); t++) {
            // 找 V-S 中 distance 最小的点 k
            Vertex k = selectMin(it);
            // 顶点路径加入S
            k.setToVisited();
            // 求得的最短路径加入连接表
            sPath.insertLast(getPath(k));
            // 修正V-S中顶点当前最短路径
            int distK = getDistance(k);
            // 取出k的所有邻接点
            Iterator adjIt = adjVertexs(k);
            for (adjIt.first(); !adjIt.isDone(); adjIt.next()) {
                //k 的邻接点 adjV
                Vertex adjV = (Vertex) adjIt.currentItem();
                Edge e = edgeFromTo(k, adjV);
                // 发现更短的路径
                if ((long) distK + (long) e.getWeight() < (long) getDistance(adjV)) {
                    setDistance(adjV, distK + e.getWeight());
                    // 以 k 的路径信息修改 adjV 的路径信息
                    amendPathInfo(k, adjV);

                }
            }

        }
        return sPath.elements();

    }

    private void amendPathInfo(Vertex k, Vertex adjV) {


    }

    private Vertex selectMin(Iterator it) {
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
            if (!v.isVisited() && getDistance(v) < getDistance(min)) {
                min = v;
            }
        }
        return min;
    }

    /**
     * Prim 算法
     * 输入：无向连通带权图
     * 输出：构造最小生成树
     * <p>
     * 算法原理:
     * 依次找到每个顶点权值最小的邻接点
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
     * 查找轻边在 V-S 中的顶点
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
