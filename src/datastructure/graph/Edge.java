package datastructure.graph;

import datastructure.linked.Node;

/**
 * @author Jay
 * @date 2019/6/16 21:27
 * @description 双链式存储结构的边定义
 */
public class Edge {
    public static final int NORMAL = 0;
    /**
     * MST 边
     */
    public static final int MST = 1;
    /**
     * 关键路径的边
     */
    public static final int CRITICAL = 2;
    /**
     * 权值
     */
    private int weight;
    /**
     * 边的信息
     */
    private Object info;
    /**
     * 边在边表中的位置
     */
    private Node edgePosition;

    /**
     * 边的第一顶点与第二顶点
     */
    private Node firstVexPosition;

    /**
     * 在顶点表中的位置
     */
    private Node secondVexPosition;

    /**
     * 边在第一(二)顶点的邻接(逆邻接)边表中的位置
     */
    private Node edgeFirstPosition;

    /**
     * 在无向图中就是在两个顶点的邻接边表中的位置
     */
    private Node egdeSecondPosition;

    /**
     * 边的类型
     */
    private int type;

    /**
     * 所在图的类型
     */
    private int graphType;

    /**
     * 构造方法:在图 G 中引入一条新边,其顶点为 u、v
     *
     * @param g
     * @param u
     * @param v
     * @param info
     */
    public Edge(Graph g, Vertex u, Vertex v, Object info) {
        this(g, u, v, info, 1);
    }

    public Edge(Graph g, Vertex u, Vertex v, Object info, int weight) {
        this.info = info;
        this.weight = weight;
        edgePosition = g.insert(this);
        firstVexPosition = u.getVexPosition();
        secondVexPosition = v.getVexPosition();
        type = Edge.NORMAL;
        graphType = g.getType();
        if (graphType == Graph.UNDIRECTED_GRAPH) {
            // 如果是无向图,边应当加入其两个顶点的邻接边表
            edgeFirstPosition = u.getAdjacentEdges().insertLast(this);
            egdeSecondPosition = v.getAdjacentEdges().insertLast(this);
        } else {
            // 如果是有向图,边加入起始点的邻接边表,终止点的逆邻接边表
            edgeFirstPosition = u.getAdjacentEdges().insertLast(this);
            egdeSecondPosition = v.getReAdjacentEdges().insertLast(this);
        }
    }

    public Object getInfo() {
        return info;
    }

    public void setInfo(Object obj) {
        this.info = obj;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Vertex getFirstVex() {
        return (Vertex) firstVexPosition.getData();
    }

    public Vertex getSecondVex() {
        return (Vertex) secondVexPosition.getData();
    }

    public Node getFirstVexPosition() {
        return firstVexPosition;
    }

    public Node getSecondVexPosition() {
        return secondVexPosition;
    }

    public Node getEdgeFirstPosition() {
        return edgeFirstPosition;
    }

    public Node getEdgeSecondPosition() {
        return egdeSecondPosition;
    }

    public Node getEdgePosition() {
        return edgePosition;
    }

    /**
     * 与边的类型相关的方法
     */
    public void setToMST() {
        type = Edge.MST;
    }

    public void setToCritical() {
        type = Edge.CRITICAL;
    }

    public void resetType() {
        type = Edge.NORMAL;
    }

    public boolean isMSTEdge() {
        return type == Edge.MST;
    }

    public boolean isCritical() {
        return type == Edge.CRITICAL;
    }

}
