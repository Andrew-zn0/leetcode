package datastructure.graph;

import datastructure.linked.Iterator;
import datastructure.linked.LinkedList;
import datastructure.linked.MyDoubleNodeLinkedList;
import datastructure.linked.Node;
import datastructure.stack.Stack;
import datastructure.stack.StackSingleLinked;

/**
 * @author Jay
 * @date 2019/6/16 22:00
 * @description 有向图
 */
public class DirectGraph extends AbstractGraph {
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

    @Override
    public void generateMST() throws UnsupportedOperation {

    }

    /**
     * 输入：AOV 网络
     * 输出：拓扑序列
     * <p>
     * 算法原理:找到每一个入度为0的顶点入队列
     * <p>
     * 特性:排序不唯一
     *
     * @return
     * @throws UnsupportedOperation
     */
    @Override
    public Iterator toplogicalSort() throws UnsupportedOperation {
        // 拓扑序列
        LinkedList topSeq = new MyDoubleNodeLinkedList();
        Stack s = new StackSingleLinked();
        Iterator it = getVertex();
        // 初始化顶点集应用信息
        for (it.first(); !it.isDone(); it.next()) {
            Vertex v = (Vertex) it.currentItem();
            v.setAppObj(Integer.valueOf(v.getInDeg()));
            if (v.getInDeg() == 0) {
                s.push(v);
            }
        }
        while (!s.isEmpty()) {
            Vertex v = (Vertex) s.pop();
            // 生成拓扑排序
            topSeq.insertLast(v);
            // 对于 v 的每个邻接点入度减 1
            Iterator adjIt = adjVertexs(v);
            for (adjIt.first(); !adjIt.isDone(); adjIt.next()) {
                Vertex adjV = (Vertex) adjIt.currentItem();
                int in = getTopInDe(adjV) - 1;
                setTopInDe(adjV, in);
                // 入度为0的顶点入栈
                if (in == 0) {
                    s.push(adjV);
                }
            }
        }
        if (topSeq.getSize() < getVexNum()) {
            return null;
        } else {
            return topSeq.elements();
        }
    }

    /**
     * @param v
     * @param in
     */
    private void setTopInDe(Vertex v, int in) {
        v.setAppObj(Integer.valueOf(in));
    }

    private int getTopInDe(Vertex v) {
        return ((Integer) v.getAppObj()).intValue();
    }

    /**
     * AOE 关键路径
     * 输入：AOE 网络
     * 输出：标记关键路径
     * <p>
     * 算法原理:
     * 1.正向拓扑排序找到每一个顶点的最早时间VE
     * 2.逆向拓扑排序找到每一个顶点的最晚时间VL
     * 3.经过VE-VL=0的路径则为关键路径
     * <p>
     * 关键路径:完成整个图的最长路径
     * <p>
     * 用于工程时间统计
     *
     * @throws UnsupportedOperation
     */
    @Override
    public void criticalPath() throws UnsupportedOperation {

        Iterator it = toplogicalSort();
        // 重置图中各边的类型消息
        resetEdgeType();
        if (it == null) {
            return;
        }
        // 逆拓扑序列
        LinkedList reTopSeq = new MyDoubleNodeLinkedList();
        // 初始化各点 ve 与 vl，并生成逆拓扑序列
        for (it.first(); !it.isDone(); it.next()) {
            Vertex v = (Vertex) it.currentItem();
            // ve=0,vl=∞
            Vtime time = new Vtime(0, Integer.MAX_VALUE);
            v.setAppObj(time);
            reTopSeq.insertFirst(v);
        }
        // 正向拓扑序列求各点 ve
        for (it.first(); !it.isDone(); it.next()) {
            Vertex v = (Vertex) it.currentItem();
            Iterator adjIt = adjVertexs(v);

            for (adjIt.first(); !adjIt.isDone(); adjIt.next()) {
                Vertex adjV = (Vertex) adjIt.currentItem();
                Edge e = edgeFromTo(v, adjV);
                // 更新最早开始时间
                if (getVE(v) + e.getWeight() > getVE(adjV)) {

                    setVE(adjV, getVE(v) + e.getWeight());
                }
            }

        }
        Vertex dest = (Vertex) reTopSeq.first().getData();
        // 设置汇点 vl=ve
        setVL(dest, getVE(dest));
        Iterator reIt = reTopSeq.elements();
        // 逆向拓扑序列求各点 vl
        for (reIt.first(); !reIt.isDone(); reIt.next()) {
            Vertex v = (Vertex) reIt.currentItem();
            Iterator adjIt = adjVertexs(v);
            for (adjIt.first(); !adjIt.isDone(); adjIt.next()) {
                Vertex adjV = (Vertex) adjIt.currentItem();
                Edge e = edgeFromTo(v, adjV);
                // 更新最迟开始时间
                if (getVL(v) > getVL(adjV) - e.getWeight()) {
                    setVL(v, getVL(adjV) - e.getWeight());
                }
            }
        }
        // 该图的所有边数
        LinkedList edges = getEdges();
        Iterator edIt = edges.elements();
        // 求关键活动
        for (edIt.first(); !edIt.isDone(); edIt.next()) {
            Edge e = (Edge) edIt.currentItem();
            Vertex u = e.getFirstVex();
            Vertex v = e.getSecondVex();
            if (getVE(u) == getVL(v) - e.getWeight()) {
                e.setToCritical();
            }
        }


    }

    private LinkedList getEdges() {
        return null;
    }

    /**
     * 取顶点 v 的最早开始时间与最迟开始时间
     *
     * @param v
     * @return
     */
    private int getVE(Vertex v) {
        return ((Vtime) v.getAppObj()).getVE();
    }

    private int getVL(Vertex v) {
        return ((Vtime) v.getAppObj()).getVL();
    }

    /**
     * 设置顶点 v 的最早开始时间与最迟开始时间
     *
     * @param v
     * @param ve
     */
    private void setVE(Vertex v, int ve) {
        ((Vtime) v.getAppObj()).setVE(ve);
    }

    private void setVL(Vertex v, int vl) {
        ((Vtime) v.getAppObj()).setVL(vl);
    }

}
