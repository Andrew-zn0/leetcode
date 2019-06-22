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

    }

    private int getTopInDe(Vertex v) {
        return 0;
    }

    @Override
    public void criticalPath() throws UnsupportedOperation {

    }
}
