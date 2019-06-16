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

    @Override
    public Iterator toplogicalSort() throws UnsupportedOperation {
        return null;
    }

    @Override
    public void criticalPath() throws UnsupportedOperation {

    }



}
