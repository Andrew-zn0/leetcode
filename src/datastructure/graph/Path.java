package datastructure.graph;

import datastructure.linked.Iterator;
import datastructure.linked.LinkedList;
import datastructure.linked.MyDoubleNodeLinkedList;

/**
 * @author Jay
 * @description 最短路径
 * @date Created in 2019/6/19 14:16
 */
public class Path {
    /**
     * 起点与终点距离
     */
    private int distance;
    /**
     * 起点信息
     */
    private Vertex start;
    /**
     * 终点信息
     */
    private Vertex end;
    /**
     * 起点到终点途经的顶点序列
     */
    private LinkedList pathInfo;

    /**
     * 构造方法
     */
    public Path() {
        this(Integer.MAX_VALUE, null, null);
    }

    public Path(int distance, Vertex start, Vertex end) {
        this.distance = distance;
        this.start = start;
        this.end = end;
        pathInfo = new MyDoubleNodeLinkedList();
    }

    /**
     * 判断起点与终点之间是否存在路径
     *
     * @return
     */
    public boolean hasPath() {
        return distance != Integer.MAX_VALUE && start != null && end != null;
    }

    /**
     * 求路径长度
     *
     * @return
     */
    public int pathLength() {

        if (!hasPath()) {
            return -1;
        } else if (start == end) {
            return 0;
        } else {

            return pathInfo.getSize() + 1;
        }


    }

    public void setDistance(int dis) {
        distance = dis;
    }

    public void setStart(Vertex v) {
        start = v;
    }

    public void setEnd(Vertex v) {
        end = v;
    }

    public int getDistance() {
        return distance;
    }

    public Vertex getStart() {
        return start;
    }

    public Vertex getEnd() {
        return end;
    }

    public Iterator getPathInfo() {
        return pathInfo.elements();
    }

    /**
     * 清空路径信息
     */
    public void clearPathInfo() {
        pathInfo = new MyDoubleNodeLinkedList();
    }

    /**
     * 添加路径信息
     *
     * @param info
     */
    public void addPathInfo(Object info) {
        pathInfo.insertLast(info);
    }



}
